package QuestionBank.Conditional_And_Loops;

/*
Write a program that asks the user to enter one number and then display the factorial of that number.
 */

import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        System.out.println("Please enter a number: ");
        Scanner sc = new Scanner(System.in);

        int faktorielNum = sc.nextInt();
        int theNumber = faktorielNum;
        int factorial = 1;

        while(faktorielNum > 1) {
            factorial *= faktorielNum;
            faktorielNum--;
        }

        System.out.println("The Factorial of number "+ theNumber + " is: " + factorial);



    }
}