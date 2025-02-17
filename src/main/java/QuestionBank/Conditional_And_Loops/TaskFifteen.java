package QuestionBank.Conditional_And_Loops;

/*
Write a program that asks the user to enter one number and then display the sum of all even/odd numbers from 0 to the number that user entered.
 */

import java.util.Scanner;

class All {
    public static void main(String[] args) {
        System.out.print("Please enter a number: ");
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        int evenSum = 0;
        int oddSum = 0;

        for(int i = 0; i < inputNum; i++) {
            if(i % 2 == 0) {
                evenSum += i;
            } else {
                oddSum += i;
            }
        }

        System.out.println("Even numbers sum: " + evenSum);
        System.out.print("Odd numbers sum: " + oddSum);


    }
}

