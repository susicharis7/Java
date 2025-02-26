package Abstraction_And_Polymorphism;


import java.util.ArrayList;

class Printer {
    public void print(MyReadable readable) {
        System.out.println(readable.read());
    }

    public static void main(String[] args) {
        SMS message = new SMS("Haris", "Wow, this printer is able to print them, actually!");
        ArrayList<String> pages = new ArrayList<String>();
        pages.add("{3, 5} are the numbers in common between {1, 3, 5} and {2, 3, 4, 5}.");

        EBook ebook = new EBook("Introduction to my portfolio :)",pages,0);
        Printer printer = new Printer();
        printer.print(message);
        printer.print(ebook);

        System.out.println("\n");

        NumberList joelList = new NumberList();
        joelList.add(new SMS(
                "matti",
                "have you already written the tests?")
        );
        joelList.add(new SMS(
                "matti",
                "did you have a look at the submissions?")
        );

        System.out.println("Joel has " + joelList.howManyReadables() + " messages to read");
    }
}



// Example: Implement another numberList class, where we can add interesting readable stuff.

class NumberList implements MyReadable {
    private ArrayList<MyReadable> readables;

    public NumberList() {
        this.readables = new ArrayList<MyReadable>();
    }

    public void add(MyReadable readable) {
        this.readables.add(readable);
    }

    @Override
    public String read() {
        String read = "";
        for(MyReadable r : this.readables) {
            read += r.read() + "\n";
        }

        this.readables.clear();
        return read;
    }

    public int howManyReadables() {
        return this.readables.size();
    }


}
