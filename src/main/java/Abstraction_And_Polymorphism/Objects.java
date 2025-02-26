package Abstraction_And_Polymorphism;

import java.util.ArrayList;

/*
The equals method is defined in the Object class, and it makes sure that both the parameter
object and the compared object have the same reference.
By default the method makes sure that we are dealing with one unique object.
If the reference is the same, the method returns true, otherwise false.
*/
class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String toString() {
        return this.author + " , " + this.title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    // Various different Java made-up methods make use of the equals method to implement their search functionality.
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof Book) {
            Book otherBook = (Book) obj;

            if(this.author.equals(otherBook.getAuthor()) && this.title.equals(otherBook.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Book book = new Book("J. K. Rowling", "Harry Potter and the Philosopher's Stone");
        Book book2 = new Book("Ivica Maric","Pinokio");

        if(book.getTitle().equals(book2.getTitle())) {
            System.out.println("The titles are the same!");
        } else {
            System.out.println("The titles are NOT the same!");
        }

        // False, because they are not pointing to the same memory location
        if(book.equals(book2)) {
            System.out.println("Same!");
        } else {
            System.out.println("Not Same!");
        }

        Book book3 = new Book("J. K. Rowling", "Harry Potter and the Philosopher's Stone");
        Book book4 = new Book("J. K. Rowling", "Harry Potter and the Philosopher's Stone");

        ArrayList<Book> books = new ArrayList<>();
        books.add(book3);
        books.add(book4);

        if(books.contains(book4)) {
            System.out.println(book4);
        }
    }
}