package Interface;

// An interface with a single abstract method is called a functional interface or a Single Abstract Method interface (SAM)

@FunctionalInterface
interface FPrintable {
    // Abstract method
    String print(String suffix);
}

class Run {
    public static void printThing(FPrintable thing) {
        System.out.println(thing.print("Hello boys!"));
    }

    public static void main(String[] args) {
        // lambda expression that implements the functional interface
        FPrintable fprintable = (suffix) -> "I'm something printable. " + suffix;
        printThing(fprintable);
    }
}
