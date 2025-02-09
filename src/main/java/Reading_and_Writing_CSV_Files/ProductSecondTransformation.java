package Reading_and_Writing_CSV_Files;

// If the double values are empty, it will replace them with 0.0
// If the CategoryType enum values are empty/null, it will replace them with UNKNOWN, but returned as a String type

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

enum TextFormat {
    NORMAL,UPPERCASE,LOWERCASE
}
enum NumericFormat {
    THOUSANDS,PERCENTAGE,CURRENCY
}
enum CategoryType {
    ELECTRONICS,CLOTHING,FURNITURE,UNKNOWN
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFormat {
    TextFormat text_case() default TextFormat.NORMAL;
    NumericFormat numeric_format() default NumericFormat.THOUSANDS;
}

class Products {
    @FieldFormat(text_case = TextFormat.UPPERCASE)
    private String productId;
    @FieldFormat(text_case = TextFormat.NORMAL)
    private String name;
    private CategoryType categoryType;
    @FieldFormat(numeric_format = NumericFormat.CURRENCY)
    private double price;
    @FieldFormat(numeric_format = NumericFormat.PERCENTAGE)
    private double discount;
    private double finalPrice;

    public Products(ProductsBuilder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.categoryType = builder.categoryType;
        this.price = builder.price;
        this.discount = builder.discount;
        this.finalPrice = builder.finalPrice;
    }

    static class ProductsBuilder {
        private String productId;
        private String name;
        private CategoryType categoryType;
        private double price;
        private double discount;
        private double finalPrice;

        public ProductsBuilder setProductId(String productId) {
            this.productId = productId;
            return this;
        }
        public ProductsBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public ProductsBuilder setCategoryType(CategoryType categoryType) {
            this.categoryType = categoryType;
            return this;
        }
        public ProductsBuilder setPrice(double price) {
            this.price = price;
            return this;
        }
        public ProductsBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }
        public ProductsBuilder setFinalPrice(double finalPrice) {
            this.finalPrice = finalPrice;
            return this;
        }
        public Products build() {
            return new Products(this);
        }
    }
}

class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
    public InvalidDataException(String message,Throwable cause) {
        super(message,cause);
    }
}

class DataProcessor {
    private List<Products> productsList = new ArrayList<>();

    public DataProcessor(String filename) {
        this.productsList = loadProducts(filename);
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public List<Products> loadProducts(String fileName) {
        List<Products> insideList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = reader.lines().collect(Collectors.toList());
            for(int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");

                if(parts[0].isEmpty() || parts[1].isEmpty()) {
                    throw new InvalidDataException("Values are empty",new ClassCastException());
                }

                if (parts.length < 6) {
                    throw new InvalidDataException("Row has missing columns: " + lines.get(i));
                }


                insideList.add(
                        new Products.ProductsBuilder()
                                .setProductId(parts[0])
                                .setName(parts[1])
                                .setCategoryType(CategoryType.valueOf(validateCategory(parts[2])))
                                .setPrice(parseDouble(parts[3]))
                                .setDiscount(parseDouble(parts[4]))
                                .setFinalPrice(parseDouble(parts[5]))
                                .build()
                );
            }



        } catch(Exception e) {
            throw new InvalidDataException("File is not valid.",e);
        }



        return insideList;
    }

    private static String validateCategory(String value) {
        try {
            if (value == null || value.trim().isEmpty()) {
                return "UNKNOWN";
            }
            return value.trim().toUpperCase();
        } catch(Exception e) {
            return "UNKNOWN";
        }
    }

    private static double parseDouble(String value) {
        try {
            return (value == null || value.isEmpty()) ? 0.0 : Double.parseDouble(value);
        } catch(Exception e) {
            return 0.0;
        }
    }

}

class ReportGenerator {
    public static void writeReport(String outputFileName, List<Products> products) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            Class clazz = Products.class;
            Field[] field = clazz.getDeclaredFields();

            for(int i = 0; i < field.length; i++) {
                writer.write(
                        field.length - 1 == i ?
                                field[i].getName().concat("\n") :
                                field[i].getName().concat(";")
                );
            }

            for(Products product : products) {
                for(int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);

                    if(field[i].isAnnotationPresent(FieldFormat.class)) {
                        if(field[i].get(product) instanceof String) {
                            TextFormat tf = field[i].getAnnotation(FieldFormat.class).text_case();

                            switch(tf) {
                                case LOWERCASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(product).toString().toLowerCase().concat("\n") :
                                                field[i].get(product).toString().toLowerCase().concat(";")
                                );

                                case UPPERCASE -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(product).toString().toUpperCase().concat("\n") :
                                                field[i].get(product).toString().toUpperCase().concat(";")
                                );

                                case NORMAL -> writer.write(
                                        field.length - 1 == i ?
                                                field[i].get(product).toString().concat("\n") :
                                                field[i].get(product).toString().concat(";")
                                );
                            }



                        } else if (field[i].get(product) instanceof Number) {
                            NumericFormat nf = field[i].getAnnotation(FieldFormat.class).numeric_format();

                            if(nf == NumericFormat.PERCENTAGE) {
                                writer.write(
                                        field.length - 1 == i ?
                                                "%".concat(field[i].get(product).toString()).concat("\n") :
                                                "%".concat(field[i].get(product).toString()).concat(";")
                                );
                            } else if (nf == NumericFormat.CURRENCY) {
                                DecimalFormat df = new DecimalFormat("$#,###.##");
                                writer.write(
                                        field.length - 1 == i ?
                                                df.format(field[i].get(product)).concat("\n") :
                                                df.format(field[i].get(product)).concat(";")
                                );
                            } else if (nf == NumericFormat.THOUSANDS) {
                                DecimalFormat df2 = new DecimalFormat("#,###.##");
                                writer.write(
                                        field.length - 1 == i ?
                                                df2.format(field[i].get(product)).concat("\n") :
                                                df2.format(field[i].get(product)).concat(";")
                                );
                            }


                        }


                    } else {
                        writer.write(
                                field.length - 1 == i ?
                                        field[i].get(product).toString().concat("\n") :
                                        field[i].get(product).toString().concat(";")
                        );
                    }
                }

            }

            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }





    }
}


class EP2 {
    public static void main(String[] args) {
        DataProcessor dp = new DataProcessor("C:\\Users\\Haris\\Desktop\\productsys.csv");
        ReportGenerator rg = new ReportGenerator();
        rg.writeReport("C:\\Users\\Haris\\Desktop\\temporary.csv", dp.getProductsList());

    }
}