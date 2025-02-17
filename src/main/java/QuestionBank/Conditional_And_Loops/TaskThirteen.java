package QuestionBank.Conditional_And_Loops;

/*
Write a program that asks the user to enter one number and then display the fibonacci sequence for that number.
 */

import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Please enter a number: ");
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();
        int a = 0, b = 1;
        int c;
        System.out.print(a + " " + b + " ");

        for(int i = 2; i <= inputNum; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }



    }
}