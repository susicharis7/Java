package Interface;

// An interface serves as a contract that defines method signatures, which must be implemented by any class that implement the interface.

interface Printable {
    public void print();
}

class Cat implements Printable {
    public String name;
    public int age;

    public Cat() {}

    @Override
    public void print() {
        System.out.println("I'm a cat!");
    }
}

class Main07 {

    public static void printThing(Printable thing) {
        thing.print();
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.print();

        printThing(cat);
    }
}