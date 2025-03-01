package Reading_and_Writing_CSV_Files;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
enum BookCategory {
    FICTION,NON_FICTION,SCIENCE,ARTS,HISTORY,TECHNOLOGY
}
enum AvailabilityStatus {
    AVAILABLE,CHECKED_OUT,RESERVED,LOST
}


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldValidation {
    BookCategory category() default BookCategory.FICTION;
    AvailabilityStatus status() default AvailabilityStatus.AVAILABLE;
}

class Books {
    @FieldValidation
    private String isbn;

    @FieldValidation
    private String title;

    @FieldValidation
    private String author;

    private Date publicationDate;

    @FieldValidation
    private BookCategory category;

    @FieldValidation
    private double price;

    @FieldValidation
    private AvailabilityStatus availability;

    public Books(String isbn, String title, String author, Date publicationDate, BookCategory category, double price, AvailabilityStatus availability) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.publicationDate = publicationDate;
            this.category = category;
            this.price = price;
            this.availability = availability;
    }

    public String getIsbn() {
        return this.isbn;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public Date getPublicationDate() {
        return this.publicationDate;
    }
    public BookCategory getCategory() {
        return this.category;
    }
    public double getPrice() {
        return this.price;
    }
    public AvailabilityStatus getAvailability() {
        return this.availability;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    public void setCategory(BookCategory category) {
        this.category = category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setAvailabilityStatus(AvailabilityStatus availability) {
        this.availability = availability;
    }

}

class InvalidBookException extends RuntimeException {
    public InvalidBookException(String message) {
        super(message);
    }
    public InvalidBookException(String message, Throwable cause) {
        super(message,cause);
    }
}


interface BookFactory {
    Books createBook(String isbn, String title, String author, Date publicationDate,
                    BookCategory bookCategory, double price, AvailabilityStatus availability) throws InvalidBookException;
}

class FictionBookFactory implements BookFactory {
    @Override
    public Books createBook(String isbn, String title, String author, Date publicationDate,
                           BookCategory bookCategory, double price, AvailabilityStatus availability) throws InvalidBookException {
        return new Books(isbn,title,author,publicationDate, BookCategory.FICTION,price,availability);
    }
}

class NonFictionBookFactory implements BookFactory {
    @Override
    public Books createBook(String isbn, String title, String author, Date publicationDate, BookCategory bookCategory, double price,
                            AvailabilityStatus availability) throws InvalidBookException {
        return new Books(isbn,title,author,publicationDate,BookCategory.NON_FICTION,price,availability);
    }
}

class ScienceBookFactory implements BookFactory {
    @Override
    public Books createBook(String isbn, String title, String author, Date publicationDate, BookCategory bookCategory, double price,
                            AvailabilityStatus availability) throws InvalidBookException {
        return new Books(isbn,title,author,publicationDate,BookCategory.SCIENCE,price,availability);
    }
}

class ArtsBookFactory implements BookFactory {
    @Override
    public Books createBook(String isbn, String title, String author, Date publicationDate, BookCategory bookCategory, double price,
                            AvailabilityStatus availability) throws InvalidBookException {
        return new Books(isbn,title,author,publicationDate,BookCategory.ARTS,price,availability);
    }
}

class HistoryBookFactory implements BookFactory {
    @Override
    public Books createBook(String isbn, String title, String author, Date publicationDate, BookCategory bookCategory, double price,
                            AvailabilityStatus availability) throws InvalidBookException {
        return new Books(isbn,title,author,publicationDate,BookCategory.HISTORY,price,availability);
    }
}

class TechnologyBookFactory implements BookFactory {
    @Override
    public Books createBook(String isbn, String title, String author, Date publicationDate, BookCategory bookCategory, double price,
                            AvailabilityStatus availability) throws InvalidBookException {
        return new Books(isbn,title,author,publicationDate,BookCategory.TECHNOLOGY,price,availability);
    }
}


class LibraryLoader {
    List<Books> libraryBooks = new ArrayList<>();

    public LibraryLoader(String filename) {
        this.libraryBooks = loadBooks(filename);
    }

    public List<Books> getLibraryBooks() {
        return libraryBooks;
    }

    public List<Books> loadBooks(String fileName) {
        List<Books> insideList = new ArrayList<>();
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int lineNumber = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            line = reader.readLine();
            if(line == null) {
                throw new InvalidBookException("CSV File is empty.");
            }

            while((line = reader.readLine()) != null) {
                lineNumber++;
                String[] fields = line.split(",");

                if(fields.length != 7) {
                    throw new InvalidBookException("Invalid number of fields at line " + lineNumber);
                }

                String isbn = fields[0].trim();
                String title = fields[1].trim();
                String author = fields[2].trim();
                String publicationDateStr = fields[3].trim();
                String categoryStr = fields[4].trim().toUpperCase();
                String priceStr = fields[5].trim();
                String availabilityStr = fields[6].trim().toUpperCase();

                if(isbn.isEmpty() || title.isEmpty() || author.isEmpty()) {
                    throw new InvalidBookException("Missing mandatory fields at line " + lineNumber, new ClassCastException());
                }



                Date publicationDate;
                try {
                    publicationDate = sdf.parse(publicationDateStr);
                } catch (Exception e) {
                    throw new InvalidBookException("Invalid publication date ate line " + lineNumber,e);
                }

                if(publicationDate.after(new Date())) {
                    throw new InvalidBookException("Publication date is in the future at line " + lineNumber, new ClassCastException());
                }





                BookCategory category;
                if(!categoryStr.isEmpty()) {
                    try {
                        category = BookCategory.valueOf(categoryStr);
                    } catch(IllegalArgumentException e) {
                        throw new InvalidBookException("Invalid book category at line " + lineNumber,e);
                    }
                } else {
                    category = BookCategory.FICTION;
                }





                double price;
                try {
                    price = Double.parseDouble(priceStr);
                    if(price < 0) {
                        throw new InvalidBookException("Negative price at line " + lineNumber, new ClassCastException());
                    }
                } catch(NumberFormatException e) {
                    throw new InvalidBookException("Invalid price format at line " + lineNumber, e);
                }





                AvailabilityStatus availability;
                if(!availabilityStr.isEmpty()) {
                    try {
                        availability = AvailabilityStatus.valueOf(availabilityStr);
                    } catch(IllegalArgumentException e) {
                        throw new InvalidBookException("Invalid availability status at line " + lineNumber,e);
                    }
                } else {
                    availability = AvailabilityStatus.AVAILABLE;
                }



                BookFactory factory;
                switch(category) {
                    case FICTION:
                        factory = new FictionBookFactory();
                        break;
                    case NON_FICTION:
                        factory = new NonFictionBookFactory();
                        break;
                    case SCIENCE:
                        factory = new ScienceBookFactory();
                        break;
                    case ARTS:
                        factory = new ArtsBookFactory();
                        break;
                    case HISTORY:
                        factory = new HistoryBookFactory();
                        break;
                    case TECHNOLOGY:
                        factory = new TechnologyBookFactory();
                        break;
                    default:
                        factory = new FictionBookFactory();
                        break;
                }


                Books book = factory.createBook(isbn,title,author,publicationDate,category,price,availability);
                insideList.add(book);






            }




        } catch(Exception e) {
            System.out.println(e.getMessage());
        }




        return insideList;
    }
}



class LibraryReportGenerator {

    public static void generateReport(String outputFileName, List<Book> books2) {
        if (books2 == null || books2.isEmpty()) {
            System.out.println("No books to generate report.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            Field[] fields = Books.class.getDeclaredFields();
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < fields.length; i++) {
                header.append(fields[i].getName().toUpperCase());
                if (i < fields.length - 1) {
                    header.append(",");
                }
            }
            bw.write(header.toString());
            bw.newLine();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            for (Book book : books2) {
                StringBuilder row = new StringBuilder();
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true);
                    Object value = field.get(book);
                    String transformedValue = "";

                    if (field.isAnnotationPresent(FieldValidation.class)) {
                        FieldValidation annotation = field.getAnnotation(FieldValidation.class);
                        BookCategory category = book.getCategory();

                        if (value instanceof String) {
                            String str = (String) value;
                            if (category == BookCategory.FICTION) {
                                transformedValue = str.toUpperCase();
                            } else if (category == BookCategory.NON_FICTION) {
                                transformedValue = str.toLowerCase();
                            } else if (category == BookCategory.SCIENCE || category == BookCategory.ARTS) {
                                transformedValue = capitalizeEachWord(str);
                            } else {
                                transformedValue = str;
                            }
                        } else if (value instanceof Double || value instanceof Integer || value instanceof Float) {
                            double num = ((Number) value).doubleValue();
                            if (field.getName().equalsIgnoreCase("price") && category == BookCategory.TECHNOLOGY) {
                                num = num * 0.9; // Apply 10% discount
                            }
                            transformedValue = String.format("%.2f", num);
                        } else if (value instanceof Date) {
                            transformedValue = sdf.format((Date) value);
                        } else if (value instanceof AvailabilityStatus) {
                            AvailabilityStatus status = (AvailabilityStatus) value;
                            switch (status) {
                                case AVAILABLE:
                                    transformedValue = "A";
                                    break;
                                case CHECKED_OUT:
                                    transformedValue = "C";
                                    break;
                                case RESERVED:
                                    transformedValue = "R";
                                    break;
                                case LOST:
                                    transformedValue = "L";
                                    break;
                                default:
                                    transformedValue = "";
                            }
                        } else {
                            transformedValue = value.toString();
                        }
                    } else {
                        transformedValue = value.toString();
                    }

                    row.append(transformedValue);
                    if (i < fields.length - 1) {
                        row.append(",");
                    }
                }
                bw.write(row.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file: " + outputFileName, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing book fields during report generation", e);
        }
    }

    private static String capitalizeEachWord(String str) {
        if (str == null || str.isEmpty()) return str;
        String[] words = str.split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            if(word.length() > 0){
                capitalized.append(Character.toUpperCase(word.charAt(0)));
                if(word.length() > 1){
                    capitalized.append(word.substring(1).toLowerCase());
                }
                if(i < words.length -1){
                    capitalized.append(" ");
                }
            }
        }
        return capitalized.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            List<Book> books = LibraryLoader.loadBooks("books.csv");
            LibraryReportGenerator.generateReport("library_report.csv", books);

            System.out.println("Library report generated successfully.");
        } catch (InvalidBookException e) {
            System.err.println("Error processing books: " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

*/