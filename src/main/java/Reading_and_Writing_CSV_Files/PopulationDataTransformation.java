package Reading_and_Writing_CSV_Files;


import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum CaseFormatterEnum {
    ORDINARY,UPPER_CASE,LOWER_CASE
}
enum NumberFormatterEnum {
    COMMA,PERCENTAGE
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WriteConcernsInterface {
    CaseFormatterEnum case_format() default CaseFormatterEnum.ORDINARY;
    NumberFormatterEnum number_format() default NumberFormatterEnum.COMMA;
}

class Population {
    private int rank;
    @WriteConcernsInterface(case_format = CaseFormatterEnum.UPPER_CASE)
    private String code;
    private String country;
    @WriteConcernsInterface(case_format = CaseFormatterEnum.LOWER_CASE)
    private String continent;
    @WriteConcernsInterface(number_format = NumberFormatterEnum.COMMA)
    private int population2023;
    @WriteConcernsInterface(number_format = NumberFormatterEnum.COMMA)
    private int population2022;
    private int population2020;
    private double area;
    private int density;
    @WriteConcernsInterface(number_format = NumberFormatterEnum.PERCENTAGE)
    private double growthRate;
    @WriteConcernsInterface(number_format = NumberFormatterEnum.PERCENTAGE)
    private double worldPercentage;

    public Population(PopulationBuilder builder) {
        this.rank = builder.rank;
        this.code = builder.code;
        this.country = builder.country;
        this.continent = builder.continent;
        this.population2023 = builder.population2023;
        this.population2022 = builder.population2022;
        this.population2020 = builder.population2020;
        this.area = builder.area;
        this.density = builder.density;
        this.growthRate = builder.growthRate;
        this.worldPercentage = builder.worldPercentage;
    }

    static class PopulationBuilder {
        private int rank;
        private String code;
        private String country;
        private String continent;
        private int population2023;
        private int population2022;
        private int population2020;
        private double area;
        private int density;
        private double growthRate;
        private double worldPercentage;

        public PopulationBuilder setRank(int rank) {
            this.rank = rank;
            return this;
        }
        public PopulationBuilder setCode(String code) {
            this.code = code;
            return this;
        }
        public PopulationBuilder setCountry(String country) {
            this.country = country;
            return this;
        }
        public PopulationBuilder setContinent(String continent) {
            this.continent = continent;
            return this;
        }
        public PopulationBuilder setPopulation2023(int population2023) {
            this.population2023 = population2023;
            return this;
        }
        public PopulationBuilder setPopulation2022(int population2022) {
            this.population2022 = population2022;
            return this;
        }
        public PopulationBuilder setPopulation2020(int population2020) {
            this.population2020 = population2020;
            return this;
        }
        public PopulationBuilder setArea(double area) {
            this.area = area;
            return this;
        }
        public PopulationBuilder setDensity(int density) {
            this.density = density;
            return this;
        }
        public PopulationBuilder setGrowthRate(double growthRate) {
            this.growthRate = growthRate;
            return this;
        }
        public PopulationBuilder setWorldPercentage(double worldPercentage) {
            this.worldPercentage = worldPercentage;
            return this;
        }
        public Population build() {
            return new Population(this);
        }

    }
}

class WrongFormatExceptions extends RuntimeException {
    public WrongFormatExceptions(String message) {
        super(message);
    }
    public WrongFormatExceptions(String message, Throwable cause) {
        super(message,cause);
    }
}

class ThirdFinal {
    List<Population>  populationList = new ArrayList<>();

    public ThirdFinal(String ipAddress, int port) {
        this.populationList = loadPopulations(ipAddress,port);
    }

    public List<Population> getPopulationList() {
        return populationList;
    }

    public List<Population> loadPopulations(String ipAddress, int port) {
        List<Population> insideList = new ArrayList<>();

        try(Socket socket = new Socket(ipAddress,port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)) {

                String message = reader.readLine();
                if(message == null || message.isEmpty()) {
                    throw new InvalidCastException("Recieved empty data from server.");
                }

                List<String> lines = message.lines().collect(Collectors.toList());

                for(String line : lines) {
                    String[] parts = line.split(";");

                    if(parts[0].isEmpty() || parts[1].isEmpty() || parts[2].isEmpty()) {
                        throw new InvalidCastException("Values are empty", new ClassCastException());
                    }


                    insideList.add(
                            new Population.PopulationBuilder()
                                    .setRank(Integer.parseInt(parts[0]))
                                    .setCode(parts[1])
                                    .setCountry(parts[2])
                                    .setContinent(parts[3])
                                    .setPopulation2023(Integer.parseInt(parts[4]))
                                    .setPopulation2022(Integer.parseInt(parts[5]))
                                    .setPopulation2020(Integer.parseInt(parts[6]))
                                    .setArea(Double.parseDouble(parts[7]))
                                    .setDensity(Integer.parseInt(parts[8]))
                                    .setGrowthRate(Double.parseDouble(parts[9]))
                                    .setWorldPercentage(Double.parseDouble(parts[10]))
                                    .build()
                    );
                }





        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return insideList;
    }
}


class CustomFileWriterSecond {
    public static void writeReport(String outputFileName, List<Population> populations) {
            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
                Class clazz = Population.class;
                Field[] field = clazz.getDeclaredFields();

                for(int i = 0; i < field.length; i++) {
                    writer.write(
                            field.length - 1 == i ?
                                    field[i].getName().toUpperCase().concat("\n") :
                                    field[i].getName().toUpperCase().concat(";")
                    );
                }

                for(Population population : populations) {
                    for(int i = 0; i < field.length; i++) {
                        field[i].setAccessible(true);

                        if(field[i].isAnnotationPresent(WriteConcernsInterface.class)) {
                            if(field[i].get(population) instanceof String) {
                                CaseFormatterEnum caseFormat = field[i].getAnnotation(WriteConcernsInterface.class).case_format();

                                switch(caseFormat) {
                                    case LOWER_CASE -> writer.write(
                                            field.length - 1 == i ?
                                                    field[i].get(population).toString().toLowerCase().concat("\n") :
                                                    field[i].get(population).toString().toLowerCase().concat(";")
                                    );

                                    case UPPER_CASE -> writer.write(
                                            field.length - 1 == i ?
                                                    field[i].get(population).toString().toUpperCase().concat("\n") :
                                                    field[i].get(population).toString().toUpperCase().concat(";")
                                    );

                                    case ORDINARY -> writer.write(
                                            field.length - 1 == i ?
                                                    field[i].get(population).toString().concat("\n") :
                                                    field[i].get(population).toString().concat(";")
                                    );
                                }


                            } else if(field[i].get(population) instanceof Number && field[i].get(population) != null) {
                                NumberFormatterEnum numFormat = field[i].getAnnotation(WriteConcernsInterface.class).number_format();

                                if(numFormat == NumberFormatterEnum.COMMA) {
                                    DecimalFormat df = new DecimalFormat("#,###.##");
                                    writer.write(
                                            field.length - 1 == i ?
                                                    df.format(field[i].get(population)).concat("\n") :
                                                    df.format(field[i].get(population)).concat(";")
                                    );
                                } else if (numFormat == NumberFormatterEnum.PERCENTAGE) {
                                    writer.write(
                                            field.length - 1 == i ?
                                                    "%".concat(field[i].get(population).toString()).concat("\n") :
                                                    "%".concat(field[i].get(population).toString()).concat(";")
                                    );
                                }

                            }
                        } else {
                            writer.write(
                                    field.length - 1 == i ?
                                            field[i].get(population).toString().concat("\n") :
                                            field[i].get(population).toString().concat(";")
                            );
                        }


                    }
                }


            writer.close();
            } catch(Exception e) {
                throw new RuntimeException(e);
            }


    }
}

class MainRun {
    public static void main(String[] args) {

        ThirdFinal thirdFinal = new ThirdFinal("127.0.0.1", 8080);
        List<Population> populations = thirdFinal.getPopulationList();

        if (populations.isEmpty()) {
            System.out.println("No population data received.");
            return;
        }

        System.out.println("Successfully loaded " + populations.size() + " population records.");
        String outputFileName = "temporary.csv";
        CustomFileWriterSecond.writeReport(outputFileName, populations);

        System.out.println("Report successfully generated: " + outputFileName);
    }
}
