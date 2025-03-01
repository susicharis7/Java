package Interfaces;

// An interface with a single abstract method is called a functional interface or a Single Abstract Method interface (SAM)

@FunctionalInterface
interface FPrintable {
    // Abstract method
    String print(String suffix);
}

interface OperationInterface {
    int operation(int a, int b);
}
interface MessageInterface {
    String sayMessage(String message);
}

class Run {
    public static void printThing(FPrintable thing) {
        System.out.println(thing.print("Hello boys!"));
    }

    private static int operate(int a, int b, OperationInterface object) {
        return object.operation(a,b);
    }

    public static void main(String[] args) {
        // lambda expression that implements the functional interface
        FPrintable fprintable = (suffix) -> "I'm something printable. " + suffix;
        printThing(fprintable);


        OperationInterface add = (int x, int y) -> x + y;
        OperationInterface multiply = (int x, int y) -> x * y;

        System.out.println("Addition is: " + operate(6,3,add));
        System.out.println("Multiplication is: " + operate(6,3,multiply));

    }
}
