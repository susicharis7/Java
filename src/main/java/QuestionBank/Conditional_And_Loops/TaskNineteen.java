package QuestionBank.Conditional_And_Loops;


/*
Write a program to Check Whether a Number can be Express as Sum of Two Prime Numbers.
 */

import java.util.Scanner;

class Prime {
    public static void main(String[] args) {

        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();

        boolean primeNum = true;

        if(firstNum < 2) {
            System.out.println("That number is NOT Prime!");
        } else {
            for(int i = 2; i <= Math.sqrt(firstNum); i++) {
                if(firstNum % i == 0) {
                    primeNum = false;
                    break;
                }
            }
        }

        if(primeNum) {
            System.out.println(firstNum + " is a prime number!");
        } else {
            System.out.println(firstNum + " is not a prime number!");
        }



    }
}