package Generics.More_Into_Arrays;

import java.util.Scanner;

class Arrays {
    // The size of array cannot be changed, growing an array always requires creating a new array and copying the cells of the old array to the new one.
    public static void main(String[] args) {
        int[] numbers = {100, 1, 42};
        String[] charStringArray = {"Haris Susic", "Sumea Majser"};
        double[] floatingNumberArray = {1.20, 3.14, 100.0, 0.666667};

        numbers[0] = 19;
        for(int n : numbers) {
            System.out.println(n);
        }

        System.out.println(numbers.length);

        /*
        If the size of the array isn't always the same, that is,
        if its size depends on user input for example, the previously introduced way of creating arrays will not do.
        It is also possible to create a table so that its size is defined with the help of a variable
        */
        Scanner reader = new Scanner(System.in);
        System.out.print("How many values? ");
        int amountOfValues = Integer.parseInt(reader.nextLine());

        int[] values = new int[amountOfValues];

        System.out.println("Enter values:");
        for(int i = 0; i < amountOfValues; i++) {
            values[i] = Integer.parseInt(reader.nextLine());
        }

        System.out.println("Values again:");
        for(int i = 0; i < amountOfValues; i++) {
            System.out.println(values[i]);
        }

    }
}

