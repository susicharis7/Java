package Abstraction_And_Polymorphism;

import java.util.Scanner;

// Example: consider the following abstract class Operation, which provides a framework for operations, and their executions.
abstract class Operation {

    private String name;

    public Operation(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void execute(Scanner reader);
}

class Addition extends Operation {

    public Addition() {
        super("Addition");
    }

    @Override
    public void execute(Scanner reader) {
        System.out.print("Give the first number: ");
        int first = Integer.parseInt(reader.nextLine());
        System.out.print("Give the second number: ");
        int second = Integer.parseInt(reader.nextLine());

        System.out.println("The sum is " + (first + second));
    }
}

class Multiplication extends Operation {

    public Multiplication() {
        super("Multiplication");
    }

    @Override
    public void execute(Scanner reader) {
        System.out.print("Give the first number: ");
        int first = Integer.parseInt(reader.nextLine());
        System.out.print("Give the second number: ");
        int second = Integer.parseInt(reader.nextLine());

        System.out.println("The result is " + (first * second));
    }
}

class UserUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operation operation = new Addition();
        operation.execute(scanner);

        Operation operation2 = new Multiplication();
        operation2.execute(scanner);
    }
}






