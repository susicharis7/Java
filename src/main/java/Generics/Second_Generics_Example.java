package Generics;

// We can also restrict the bound the type so it can only be of certain kind

class Animal {
    private int numOfLegs;

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public void eat() {
        System.out.println("Animal Eating");
    }
}

// class SpecificAndInterfacePrinter<T extends Animal & Comparable>

class SpecificPrinter <T extends Animal> {
    private T thingToPrint; // Totally unaware what T will become

    // Generic type, anything we want
    public SpecificPrinter(T thingToPrint) {
        thingToPrint.eat();
        this.thingToPrint = thingToPrint;
    }

    public T getThingToPrint() {
        return thingToPrint;
    }

    public void setThingToPrint(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(this.thingToPrint);
    }
}


// In Java, generics can be used on the methods, the only thing we have to do is that we have to specify which generics will be used in a method
/*
static <T, E> E printAndReturnAGeneric(T someGeneric, E anotherGeneric) {
    System.out.println(someGeneric);
    return anotherGeneric;
}
*/
