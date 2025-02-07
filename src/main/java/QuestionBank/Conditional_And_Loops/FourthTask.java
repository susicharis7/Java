package QuestionBank.Conditional_And_Loops;

import java.util.Scanner;
/*
Write a Java program which takes two digits m (row) and n (column) as input and generates a two-dimensional array.
The element value in the i-th row and j-th column of the array should be i*j.
 */
class FourthTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows(m): ");
        int m = sc.nextInt();

        System.out.println("Enter columns(n): ");
        int n = sc.nextInt();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(i*j + " ");
            }
            System.out.println();
        }



    }
}
