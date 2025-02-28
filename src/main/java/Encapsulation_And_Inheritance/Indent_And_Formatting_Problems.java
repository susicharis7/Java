package Encapsulation_And_Inheritance;

import java.util.ArrayList;

class IndentAndFormattingProblems {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(3);

        System.out.println("The numbers in the beginning:");

        // here we print numbers
        for(int number : numbers) {
            System.out.println(number);
        }

        // checks if the list contains the number 3
        while(numbers.contains(Integer.valueOf(3))) {
            numbers.remove(Integer.valueOf(3));
            // if it contains, then remove it
        } // we use while loop to remove all the threes that are available!

        System.out.println("Numbers after removal : ");
        for(int number : numbers) {
            System.out.println(number);
        }
    }


}
