package QuestionBank.Conditional_And_Loops;

/*
Write a program that asks the user to enter a number and then print all perfect numbers from 0
all the way to the entered number (Perfect number is a positive number whose sum of all positive divisors
excluding that number is equal to that number. For example 6 is the perfect number since divisors of 6 are 1, 2 and 3.  Sum of its divisor is 1 + 2+ 3 = 6)
 */

import java.util.Scanner;

class PerfectNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a positive number: ");
        int inputNum = sc.nextInt();

        if (inputNum <= 0) {
            System.out.println("The number is not positive!");
        } else {
            int sum = 0;
            for (int i = 1; i <= inputNum / 2; i++) {
                if (inputNum % i == 0) {
                    sum += i;
                }
            }

            if (sum == inputNum) {
                System.out.println(inputNum + " is a perfect number!");
            } else {
                System.out.println(inputNum + " is not a perfect number.");
            }
        }
    }
}
