package Generics;

import java.util.HashMap;

class Book {
    private String name;
    private String contents;
    private int publishingYear;

    public Book(String name, int publishingYear, String contents) {
        this.name = name;
        this.publishingYear = publishingYear;
        this.contents = contents;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishingYear() {
        return this.publishingYear;
    }
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String toString() {
        return "Name: " + this.name + " (" + this.publishingYear + ")\n" + "Contents: " + this.contents;
    }
}
class RunBookStore {
    public static void main(String[] args) {
        Book senseAndSensibility = new Book("Sense and Sensibility", 1811, "...");
        Book prideAndPrejudice = new Book("Pride and Prejudice", 1813, "....");

        HashMap<String, Book> bookCollection = new HashMap<String, Book>();
        bookCollection.put(senseAndSensibility.getName(), senseAndSensibility);
        bookCollection.put(prideAndPrejudice.getName(), prideAndPrejudice);

        Book book = bookCollection.get("Persuasion");
        System.out.println(book);
        System.out.println();
        book = bookCollection.get("Pride and Prejudice");
        System.out.println(book);
    }
}



class Predefined {
    public static void main(String[] args) {
        HashMap<String, String> numbers = new HashMap<String, String>();
        numbers.put("One", "Yksi");
        numbers.put("Two", "Kaksi");

        String translation = numbers.get("One");
        System.out.println(translation);

        System.out.println(numbers.get("Two"));
        System.out.println(numbers.get("Three"));
        System.out.println(numbers.get("Yksi"));
    }
}

