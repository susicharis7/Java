package QuestionBank.Conditional_And_Loops;

/*
Write a program that asks the user to enter a number of rows and then the program should output Floyd’s triangle.
 */

import java.util.Scanner;

import java.util.Scanner;

class FloydsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            int num;

            if (i % 2 == 0) {
                num = 1;
            } else {
                num = 0;
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(num);
                num = 1 - num;
            }
            System.out.println();
        }
    }
}
