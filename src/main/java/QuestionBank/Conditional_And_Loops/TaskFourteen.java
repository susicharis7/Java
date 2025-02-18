package QuestionBank.Conditional_And_Loops;

/*
Write a program that receives 10 integers and then display their sum and average value on the screen.
 */

import java.util.Scanner;

class SumAndAvg {
    public static void main(String[] args) {
        System.out.println("Please enter 10 numbers: ");
        Scanner sc = new Scanner(System.in);
        int inputNum = 0;
        int sum = 0;
        int average;

        for(int i = 0; i < 10; i++) {
            inputNum = sc.nextInt();
            sum += inputNum;

        }

        System.out.println("Sum: " + sum);
        average = sum / 10;
        System.out.println("Average: " + average);



    }
}