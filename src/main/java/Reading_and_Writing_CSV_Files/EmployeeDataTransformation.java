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
import java.util.stream.Collectors;

enum TextCase {
    NORMAL,UPPERCASE,LOWERCASE
}
enum NumericFormat {
    COMMA_SEPERATED,PERCENTAGE,CURRENCY
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FormatSpec {
    TextCase text_case() default TextCase.NORMAL;
    NumericFormat numeric_format() default NumericFormat.COMMA_SEPERATED;
}

class Employee {
    @FormatSpec(text_case = TextCase.UPPERCASE)
    private String id;
    @FormatSpec(text_case = TextCase.NORMAL)
    private String fullName;
    @FormatSpec(text_case = TextCase.LOWERCASE)
    private String department;
    @FormatSpec(numeric_format = NumericFormat.CURRENCY)
    private double salary;
    @FormatSpec(numeric_format = NumericFormat.PERCENTAGE)
    private double bonusRate;
    private double totalCompensation;

    public Employee(EmployeeBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.department = builder.department;
        this.salary = builder.salary;
        this.bonusRate = builder.bonusRate;
        this.totalCompensation = builder.totalCompensation;
    }

    static class EmployeeBuilder {
        private String id;
        private String fullName;
        private String department;
        private double salary;
        private double bonusRate;
        private double totalCompensation;

        public EmployeeBuilder setId(String id) {
            this.id = id;
            return this;
        }
        public EmployeeBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public EmployeeBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }
        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }
        public EmployeeBuilder setBonusRate(double bonusRate) {
            this.bonusRate = bonusRate;
            return this;
        }
        public EmployeeBuilder setTotalCompensation(double totalCompensation) {
            this.totalCompensation = totalCompensation;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
    }
}


class MalformedEmployeeDataException extends RuntimeException {
    public MalformedEmployeeDataException(String message) {
        super(message);
    }
    public MalformedEmployeeDataException(String message, Throwable cause) {
        super(message,cause);
    }
}


class DataProcessor {
    private List<Employee> employeeList = new ArrayList<>();

    public DataProcessor(String filename) {
        this.employeeList = readEmployees(filename);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static List<Employee> readEmployees(String fileName) {
        List<Employee> insideList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = reader.lines().collect(Collectors.toList());

            for(int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");


                if(parts[0].isEmpty() || parts[1].isEmpty() || parts[3].isEmpty()) {
                    throw new MalformedEmployeeDataException("Relevant error message", new ClassCastException());
                }


                insideList.add(
                        new Employee.EmployeeBuilder()
                                .setId(parts[0])
                                .setFullName(parts[1])
                                .setDepartment(parts[2])
                                .setSalary(Double.parseDouble(parts[3]))
                                .setBonusRate(Double.parseDouble(parts[4]))
                                .setTotalCompensation(Double.parseDouble(parts[5]))
                                .build()
                );
            }





        reader.close();
        } catch(IOException ioe) {
            throw new MalformedEmployeeDataException("File is not valid.", ioe);
        }






        return insideList;
    }
}


class ReportGenerator {
    public static void generateReport(String outputFileName, List<Employee> employees) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            Class clazz = Employee.class;
            Field[] field = clazz.getDeclaredFields();

            for(int i = 0; i < field.length; i++) {
                writer.write(
                        field.length - 1 == i ?
                                field[i].getName().concat("\n") :
                                field[i].getName().concat(";")
                );
            }


            for(Employee employee : employees) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);

                    if(field[i].isAnnotationPresent(FormatSpec.class)) {
                        if(field[i].get(employee) instanceof String) {
                            TextCase textCase = field[i].getAnnotation(FormatSpec.class).text_case();

                            if(textCase == TextCase.LOWERCASE) {
                                writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(employee).toString().toLowerCase().concat("\n") :
                                                field[i].get(employee).toString().toLowerCase().concat(";")
                                );
                            } else if (textCase == TextCase.UPPERCASE) {
                                writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(employee).toString().toUpperCase().concat("\n") :
                                                field[i].get(employee).toString().toUpperCase().concat(";")
                                );
                            } else if(textCase == TextCase.NORMAL) {
                                writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(employee).toString().concat("\n") :
                                                field[i].get(employee).toString().concat(";")
                                );
                            }


                        } else if (field[i].get(employee) instanceof Number && field[i].get(employee) != null) {
                            NumericFormat numFormat = field[i].getAnnotation(FormatSpec.class).numeric_format();

                            if(numFormat == NumericFormat.PERCENTAGE) {
                                writer.write(
                                        field.length - 1 == i ?
                                                "%".concat(field[i].get(employee).toString()).concat("\n") :
                                                "%".concat(field[i].get(employee).toString()).concat(";")
                                );
                            } else if(numFormat == NumericFormat.CURRENCY) {
                                DecimalFormat df = new DecimalFormat("$#,###.##");
                                writer.write(
                                        field.length - 1 == i ?
                                                df.format(field[i].get(employee)).concat("\n") :
                                                df.format(field[i].get(employee)).concat(";")
                                );
                            } else if (numFormat == NumericFormat.COMMA_SEPERATED) {
                                DecimalFormat df2 = new DecimalFormat("#,###.##");
                                writer.write(
                                        field.length - 1 == i ?
                                                df2.format(field[i].get(employee)).concat("\n") :
                                                df2.format(field[i].get(employee)).concat(";")
                                );
                            }

                        }


                    } else {
                        writer.write(
                                field.length - 1 == i ?
                                        field[i].get(employee).toString().concat("\n") :
                                        field[i].get(employee).toString().concat(";")
                        );
                    }


                }
            }




        writer.close();
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class EmployeeDataTransformation {
    public static void main(String[] args) {
        DataProcessor dp = new DataProcessor("C:\\Users\\Haris\\Desktop\\employee_data.csv");
        ReportGenerator rg = new ReportGenerator();
        rg.generateReport("C:\\Users\\Haris\\Desktop\\temporary.csv",dp.getEmployeeList());
    }
}