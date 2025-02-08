package QuestionBank.Conditional_And_Loops;

import java.util.Scanner;

/*
Write a program that asks the user to enter 2 numbers: first number is integer and second
number is number of numbers that will be included in the multiplication table.
Program should output a multiplication table.
 */
class TenthTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first Number: ");
        int firstNum = sc.nextInt(); // 15

        System.out.print("Enter second Number: ");
        int secondNum = sc.nextInt(); // 10

        int multiplier = 0;

        for(int i = 0; i <= secondNum; i++) {
            multiplier = firstNum * i;
            System.out.println(firstNum + " X " + i + " = " + multiplier);
        }


    }
}
