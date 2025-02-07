package Reading_and_Writing_CSV_Files;


import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum CaseFormat {
    ORDINARY,UPPER_CASE,LOWER_CASE
}
enum Currency {
    AUD,BRL,CAD,CHF,DKK,EUR,GBP,PLN,SGD,TRY,USD
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WriteFormat {
    CaseFormat format() default CaseFormat.ORDINARY;
}

class Job {
    private int year;
    @WriteFormat(format = CaseFormat.UPPER_CASE)
    private String jobTitle;
    private String category;
    private Currency currency;
    private int salary;
    @WriteFormat(format = CaseFormat.UPPER_CASE)
    private String residence;
    @WriteFormat(format = CaseFormat.LOWER_CASE)
    private String experienceLevel;
    private String companyLocation;
    private String companySize;

    public Job(JobBuilder builder) {
        this.year = builder.year;
        this.jobTitle = builder.jobTitle;
        this.category = builder.category;
        this.currency = builder.currency;
        this.salary = builder.salary;
        this.residence = builder.residence;
        this.experienceLevel = builder.experienceLevel;
        this.companyLocation = builder.companyLocation;
        this.companySize = builder.companySize;
    }

    static class JobBuilder {
        private int year;
        private String jobTitle;
        private String category;
        private Currency currency;
        private int salary;
        private String residence;
        private String experienceLevel;
        private String companyLocation;
        private String companySize;

        public JobBuilder setYear(int year) {
            this.year = year;
            return this;
        }
        public JobBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }
        public JobBuilder setCategory(String category) {
            this.category = category;
            return this;
        }
        public JobBuilder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }
        public JobBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }
        public JobBuilder setResidence(String residence) {
            this.residence = residence;
            return this;
        }
        public JobBuilder setExperienceLevel(String experienceLevel) {
            this.experienceLevel = experienceLevel;
            return this;
        }
        public JobBuilder setCompanyLocation(String companyLocation) {
            this.companyLocation = companyLocation;
            return this;
        }
        public JobBuilder setCompanySize(String companySize) {
            this.companySize = companySize;
            return this;
        }
        public Job build() {
            return new Job(this);
        }
    }
}

class InvalidCastException extends RuntimeException {
    public InvalidCastException(String message) {
        super(message);
    }
    public InvalidCastException(String message, Throwable cause) {
        super(message,cause);
    }
}

class Final {
    private List<Job> jobList = new ArrayList<>();

    public Final(String fileName) {
        this.jobList = loadJobs(fileName);
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public List<Job> loadJobs(String filename) {
        List<Job> insideList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = reader.lines().collect(Collectors.toList());

            for(int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");


                if(parts[0].isEmpty() || parts[1].isEmpty() || parts[2].isEmpty()) {
                    throw new InvalidCastException("Values are empty", new ClassCastException());
                }


                insideList.add(
                        new Job.JobBuilder()
                                .setYear(Integer.parseInt(parts[0]))
                                .setJobTitle(parts[1])
                                .setCategory(parts[2])
                                .setCurrency(Currency.valueOf(parts[3].toUpperCase()))
                                .setSalary(Integer.parseInt(parts[4]))
                                .setResidence(parts[5])
                                .setExperienceLevel(parts[6])
                                .setCompanyLocation(parts[7])
                                .setCompanySize(parts[8])
                                .build()
                );
            }


        } catch(IOException ioe) {
            throw new InvalidCastException("Not good",ioe);
        }

        return insideList;
    }
}

class CustomFileWriter {
    public static void writeReport(String outputFilename, List<Job> jobs) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
            Class clazz = Job.class;
            Field[] field = clazz.getDeclaredFields();

            for(int i = 0; i < field.length; i++) {
                writer.write(
                        field.length - 1 == i ?
                                field[i].getName().toUpperCase().concat("\n") :
                                field[i].getName().toUpperCase().concat(";")
                );
            }

            for(Job job : jobs) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);

                    if(field[i].isAnnotationPresent(WriteFormat.class)) {
                        if(field[i].get(job) instanceof String) {

                            CaseFormat caseFormat = field[i].getAnnotation(WriteFormat.class).format();

                            switch(caseFormat) {
                                case UPPER_CASE -> writer.write(
                                   field.length - 1 == i ?
                                           field[i].get(job).toString().toUpperCase().concat("\n") :
                                           field[i].get(job).toString().toUpperCase().concat(";")
                                );

                                case LOWER_CASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(job).toString().toLowerCase().concat("\n") :
                                                field[i].get(job).toString().toLowerCase().concat(";")
                                );

                                case ORDINARY -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(job).toString().concat("\n") :
                                                field[i].get(job).toString().concat(";")
                                );
                            }


                        }


                    } else {
                        writer.write(
                                field.length - 1 == i ?
                                        field[i].get(job).toString().concat("\n") :
                                        field[i].get(job).toString().concat(";")
                        );
                    }


                }
            }



        writer.close();
        } catch(IOException ioe) {
            throw new InvalidCastException("File not good",ioe);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}

class JobDataTransformation {
    public static void main(String[] args) {
        Final first = new Final("C:\\Users\\Haris\\Desktop\\first-group.csv");
        CustomFileWriter writer = new CustomFileWriter();
        writer.writeReport("C:\\Users\\Haris\\Desktop\\temporary.csv", first.getJobList());
    }
}


