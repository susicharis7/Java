package Reading_and_Writing_CSV_Files;

/*
enum CaseFormatter {
    ORDINARY,UPPER_CASE,LOWER_CASE
}
enum NumberFormatter {
    COMMA,PERCENTAGE
}
enum Quarter {
    Q1,Q2,Q3,Q4,UNKNOWN
}

@interface WriteConcerns {
    CaseFormatter case_format() default CaseFormatter.ORDINARY;
    NumberFormatter number_format() default NumberFormatter.COMMA;
}

class Book {
    private Date date;
    @WriteConcerns(case_format = CaseFormatter.ORDINARY)
    private Quarter quarter;
    private int qtr;
    private int year;
    @WriteConcerns(case_format = CaseFormatter.UPPER_CASE)
    private String customerId;
    @WriteConcerns(number_format = NumberFormatter.COMMA)
    private double totalAmount;
    @WriteConcerns(number_format = NumberFormatter.PERCENTAGE)
    private double profitPercentage;
    private double profitInr;
    private double costPrice;

    public Book(BookBuilder builder) {
        this.date = builder.date;
        this.quarter = builder.quarter;
        this.qtr = builder.qtr;
        this.year = builder.year;
        this.customerId = builder.customerId;
        this.totalAmount = builder.totalAmount;
        this.profitPercentage = builder.profitPercentage;
        this.profitInr = builder.profitInr;
        this.costPrice = builder.costPrice;
    }


    static class BookBuilder {
        private Date date;
        private Quarter quarter;
        private int qtr;
        private int year;
        private String customerId;
        private double totalAmount;
        private double profitPercentage;
        private double profitInr;
        private double costPrice;

        public BookBuilder setDate(Date date) {
            this.date = date;
            return this;
        }
        public BookBuilder setQuarter(Quarter quarter) {
            this.quarter = quarter;
            return this;
        }
        public BookBuilder setQtr(int qtr) {
            this.qtr = qtr;
            return this;
        }
        public BookBuilder setYear(int year) {
            this.year = year;
            return this;
        }
        public BookBuilder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        public BookBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
        public BookBuilder setProfitPercentage(double profitPercentage) {
            this.profitPercentage = profitPercentage;
            return this;
        }
        public BookBuilder setProfitInr(double profitInr) {
            this.profitInr = profitInr;
            return this;
        }
        public BookBuilder setCostPrice(double costPrice) {
            this.costPrice = costPrice;
            return this;
        }
        public Book build() {
            return new Book(this);
        }
    }
}

class WrongFormatException extends RuntimeException {
    public WrongFormatException(String message) {
        super(message);
    }
    public WrongFormatException(String message, Throwable cause) {
        super(message,cause);
    }
}

class DataLoading {
    List<Book> bookList = new ArrayList<>();

    public DataLoading(String filename) {
        this.bookList = loadBooks(filename);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> loadBooks(String fileName) {
        List<Book> insideList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = reader.lines().collect(Collectors.toList());

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");

                if (parts[0].isEmpty() || parts[4].isEmpty() || parts[5].isEmpty()) {
                    throw new WrongFormatException("Values are empty", new ClassCastException());
                }

                insideList.add(
                        new Book.BookBuilder()
                                .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(parts[0]))
                                .setQuarter(Quarter.valueOf(validateQuarter(parts[1])))
                                .setQtr(Integer.parseInt(parts[2]))
                                .setYear(Integer.parseInt(parts[3]))
                                .setCustomerId(parts[4])
                                .setTotalAmount(parseDouble(parts[5]))
                                .setProfitPercentage(parseDouble(parts[6]))
                                .setProfitInr(parseDouble(parts[7]))
                                .setCostPrice(parseDouble(parts[8]))
                                .build()
                );
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error loading books: " + e.getMessage());
        }

        return insideList;
    }


    private static String validateQuarter(String value) {
        try {
            if (value == null || value.isEmpty()) {
                return "UNKNOWN";
            }
            return value.toUpperCase();
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }

    private static double parseDouble(String value) {
        try {
            return (value == null || value.isEmpty()) ? 0.0 : Double.parseDouble(value);
        } catch (Exception e) {
            return 0.0;
        }
    }
}

class ReportWriter {
    public static void writeReport(String outputFileName, List<Book> books) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            Class clazz = Book.class;
            Field[] field = clazz.getDeclaredFields();

            for(int i = 0; i < field.length; i++) {
                writer.write(
                        field.length - 1 == i ?
                                field[i].getName().concat("\n") :
                                field[i].getName().concat(";")
                );
            }


            for(Book book : books) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);

                    if(field[i].isAnnotationPresent(WriteConcerns.class)) {
                        if(field[i].get(book) instanceof String) {

                            CaseFormatter caseFormat = field[i].getAnnotation(WriteConcerns.class).case_format();

                            switch(caseFormat) {
                                case LOWER_CASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(book).toString().toLowerCase().concat("\n") :
                                                field[i].get(book).toString().toLowerCase().concat(";")
                                );

                                case UPPER_CASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(book).toString().toUpperCase().concat("\n") :
                                                field[i].get(book).toString().toUpperCase().concat(";")
                                );

                                case ORDINARY -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(book).toString().concat("\n") :
                                                field[i].get(book).toString().concat(";")
                                );
                            }


                        } else {

                            NumberFormatter numFormat = field[i].getAnnotation(WriteConcerns.class).number_format();

                            if (numFormat == NumberFormatter.COMMA) {
                                DecimalFormat df = new DecimalFormat("#,###.##");
                                writer.write(
                                        field.length - 1 == i ?
                                                df.format(field[i].get(book)).concat("\n") :
                                                df.format(field[i].get(book)).concat(";")
                                );
                            } else {
                                writer.write(
                                        field.length - 1 == i ?
                                                "%".concat(field[i].get(book).toString()).concat("\n") :
                                                "%".concat(field[i].get(book).toString()).concat(";")
                                );
                            }





                        }


                    } else {
                        writer.write(
                                field.length - 1 == i ?
                                        field[i].get(book).toString().concat("\n") :
                                        field[i].get(book).toString().concat(";")
                        );
                    }


                }
            }

            writer.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class BookDataTransformation {
    public static void main(String[] args) {
        DataLoading prep = new DataLoading("C:\\Users\\Haris\\Desktop\\sample_books.csv");
        ReportWriter writer = new ReportWriter();
        writer.writeReport("C:\\Users\\Haris\\Desktop\\temporary.csv", prep.getBookList());
    }
}

 */