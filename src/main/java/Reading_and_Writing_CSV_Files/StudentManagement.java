package Reading_and_Writing_CSV_Files;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

enum TextStyle {
    PLAIN,UPPERCASE,LOWERCASE
}
enum NumberFormat {
    DECIMAL,PERCENTAGE,GPA_SCALE
}
enum Major {
    ENGINEERING,MEDICINE,LAW,BUSINESS,ARTS,UNKNOWN
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldSettings {
    TextStyle text_style() default TextStyle.PLAIN;
    NumberFormat number_format() default NumberFormat.DECIMAL;
}

class Student {
    @FieldSettings(text_style = TextStyle.UPPERCASE)
    private String studentId;
    @FieldSettings(text_style = TextStyle.PLAIN)
    private String name;
    private Major major;
    @FieldSettings(number_format = NumberFormat.GPA_SCALE)
    private double averageGrade;
    @FieldSettings(number_format = NumberFormat.PERCENTAGE)
    private double attendancePercentage;
    private double finalScore;

    public Student(StudentBuilder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.major = builder.major;
        this.averageGrade = builder.averageGrade;
        this.attendancePercentage = builder.attendancePercentage;
        this.finalScore = builder.finalScore;
    }


    static class StudentBuilder {
        private String studentId;
        private String name;
        private Major major;
        private double averageGrade;
        private double attendancePercentage;
        private double finalScore;

        public StudentBuilder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }
        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public StudentBuilder setMajor(Major major) {
            this.major = major;
            return this;
        }
        public StudentBuilder setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
            return this;
        }
        public StudentBuilder setAttendancePercentage(double attendancePercentage) {
            this.attendancePercentage = attendancePercentage;
            return this;
        }
        public StudentBuilder setFinalScore(double finalScore) {
            this.finalScore = finalScore;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
}

class DataValidationException extends RuntimeException {
    public DataValidationException(String message) {
        super(message);
    }
    public DataValidationException(String message,Throwable cause) {
        super(message,cause);
    }
}

class AcademicDataProcessor {
    private List<Student> studentList = new ArrayList<>();

    public AcademicDataProcessor(String fileName) {
        this.studentList = loadStudents(fileName);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Student> loadStudents(String filename) {
        List<Student> insideList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = reader.lines().toList();
            for(int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");

                if(parts[0].isEmpty() || parts[1].isEmpty()) {
                    throw new DataValidationException("Values are empty", new ClassCastException());
                }

                insideList.add(
                        new Student.StudentBuilder()
                                .setStudentId(parts[0])
                                .setName(parts[1])
                                .setMajor(Major.valueOf(setMajorValidation(parts[2])))
                                .setAverageGrade(!parts[3].isEmpty() ? Double.parseDouble(parts[3]) : 0.0)
                                .setAttendancePercentage(Double.parseDouble(parts[4]))
                                .setFinalScore(Double.parseDouble(parts[5]))
                                .build()
                );
            }


            reader.close();
        } catch (IOException ioe) {
            throw new DataValidationException("File not valid.", ioe);
        }



        return insideList;
    }

    private static String setMajorValidation(String value) {
        if(value.isEmpty() || value == null) {
            return "UNKNOWN";
        }
        return value.trim().toUpperCase();
    }

    private static double setDoubleValidation(String value) {
        return (value == null || value.isEmpty() ? 0.0 : Double.parseDouble(value));
    }
}

class PerformanceReport {
    public static void generateReport(String outputFilename, List<Student> students) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
            Class clazz = Student.class;
            Field[] field = clazz.getDeclaredFields();

            for(int i = 0; i < field.length; i++) {
                writer.write(
                        field.length - 1 == i ?
                                field[i].getName().concat("\n") :
                                field[i].getName().concat(";")
                );
            }


            for(Student student : students) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);

                    if(field[i].isAnnotationPresent(FieldSettings.class)) {
                        if(field[i].get(student) instanceof String) {
                            TextStyle ts = field[i].getAnnotation(FieldSettings.class).text_style();

                            switch(ts) {
                                case UPPERCASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(student).toString().toUpperCase().concat("\n") :
                                                field[i].get(student).toString().toUpperCase().concat(";")
                                );

                                case LOWERCASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(student).toString().toLowerCase().concat("\n") :
                                                field[i].get(student).toString().toLowerCase().concat(";")
                                );

                                case PLAIN -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(student).toString().concat("\n") :
                                                field[i].get(student).toString().concat(";")
                                );
                            }

                        } else if(field[i].get(student) instanceof Number) {
                            NumberFormat nf = field[i].getAnnotation(FieldSettings.class).number_format();

                            if(nf == NumberFormat.PERCENTAGE) {
                                writer.write(
                                        field.length - 1 == i ?
                                                "%".concat(field[i].get(student).toString()).concat("\n") :
                                                "%".concat(field[i].get(student).toString()).concat(";")
                                );
                            } else if (nf == NumberFormat.GPA_SCALE) {
                                DecimalFormat df = new DecimalFormat("#,#");

                                writer.write(
                                        field.length - 1 == i ?
                                                df.format(field[i].get(student)).concat("\n") :
                                                df.format(field[i].get(student)).concat(";")
                                );
                            } else {
                                DecimalFormat df2 = new DecimalFormat("#,###.##");
                                writer.write(
                                        field.length - 1 == i ?
                                                df2.format(field[i].get(student)).concat("\n") :
                                                df2.format(field[i].get(student)).concat(";")
                                );
                            }


                        }
                    } else {
                        writer.write(
                                field.length - 1 == i ?
                                        field[i].get(student).toString().concat("\n") :
                                        field[i].get(student).toString().concat(";")
                        );
                    }


                }
            }
            writer.close();
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (IllegalAccessException iae) {
            System.out.println(iae.getMessage());
        }


    }
}

class StudentsManagement {
    public static void main(String[] args) {
        AcademicDataProcessor adp = new AcademicDataProcessor("C:\\Users\\Haris\\PersonalWork\\Java\\src\\main\\resources\\students.csv");
        PerformanceReport pr = new PerformanceReport();
        pr.generateReport("C:\\Users\\Haris\\Desktop\\temporary.csv",adp.getStudentList());
    }
}