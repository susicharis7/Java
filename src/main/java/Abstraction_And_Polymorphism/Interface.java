package Abstraction_And_Polymorphism;

/*
The interfaces influence class behaviour by defining the method names and
return values, but they do not contain method implementation.
The access modifier is not specified, because it is always public.
*/

import java.util.ArrayList;
import java.util.List;

interface MyReadable {
    String read();
}

class SMS implements MyReadable {
    private String sender;
    private String content;

    public SMS(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return this.sender;
    }


    @Override
    public String read() {
        return this.content;
    }
}

class EBook implements MyReadable {
    private String name;
    private ArrayList<String> pages;
    private int pageNumber;

    public EBook(String name,ArrayList<String> pages,int pageNumber) {
        this.name = name;
        this.pages = pages;
        this.pageNumber = 0;
    }

    public String getName() {
        return this.name;
    }
    public int numOfPages() {
        return this.pages.size();
    }

    @Override
    public String read() {
        String page = this.pages.get(this.pageNumber);
        nextPage();
        return page;
    }

    public void nextPage() {
        this.pageNumber = this.pageNumber + 1;
        if(this.pageNumber % this.pages.size() == 0) {
            this.pageNumber = 0;
        }
    }
}

class Main04 {
    public static void main(String[] args) {
        SMS sms = new SMS("Haris","Hello guys!");
        System.out.println(sms.read());

        ArrayList<SMS> messages = new ArrayList<>();
        messages.add(new SMS("Becir","Im the professor here!"));

        ArrayList<String> pages = new ArrayList<>();
        pages.add("Split your method into short clear chunks.");
        pages.add("Devide the user interface logic from the application logic.");
        pages.add("At first, always code only a small program which solves only a part of the problem.");
        pages.add("Practice makes perfect. Make up your own fun project.");

        EBook book = new EBook("Programming Hints.", pages,0);
        for(int page = 0; page < book.numOfPages(); page++) {
            System.out.println(book.read());
        }

        // Interface vs Variable Type
        String string = "string-object";
        SMS message = new SMS("teacher", "Something crazy is going to happen");

        SMS secondMessage = new SMS("teacher", "Awesome stuff!");
        MyReadable readable = new SMS("teacher", "The SMS is Readable!");
        Object ob = new SMS("teacher", "Awesome stuff!");


        ArrayList<MyReadable> numberList = new ArrayList<MyReadable>();
        numberList.add(new SMS("teacher", "never been programming before..."));
        numberList.add(new SMS("teacher", "gonna love it i think!"));
        numberList.add(new SMS("teacher", "give me something more challenging! :)"));
        numberList.add(new SMS("teacher", "you think i can do it?"));
        numberList.add(new SMS("teacher", "up here we send several messages each day"));

        ArrayList<String> bookPages = new ArrayList<>();
        bookPages.add("this is the first page");
        bookPages.add("this is the second page");

        numberList.add(new EBook("name", bookPages,0));

        for (MyReadable r: numberList) {
            System.out.println(r.read());
        }

        /*
        MyReadable readable = new SMS("teacher", "The SMS is Readable!"); // works
        SMS message = readable; // not possible

        SMS transformedMessage = (SMS) readable; // works
         */

    }
}
