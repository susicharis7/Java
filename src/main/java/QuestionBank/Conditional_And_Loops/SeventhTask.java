package QuestionBank.Conditional_And_Loops;

/*
Write a Java program to find numbers between 100 and 400 (both included) where each digit of a number is an even number.
The numbers obtained should be printed in a comma-separated sequence.

 */

class SeventhTask {
    public static void main(String[] args) {

        int firstNumber = 100;
        int secondNumber = 400;
        boolean first = true;



        for(int i = firstNumber; i <= secondNumber; i++) {
            if(evenDigits(i)) {
                if(!first) {
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
            }
        }


    }


    public static boolean evenDigits(int number) {
        while(number > 0) {
            int digit = number % 10;
            if(digit % 2 != 0) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}