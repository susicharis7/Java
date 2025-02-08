package QuestionBank.Conditional_And_Loops;

import java.util.Scanner;

// Write a Java program to check if a triangle is equilateral, isosceles or scalene.
class EighthTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first side: ");
        int a = sc.nextInt();

        System.out.println("Enter second side: ");
        int b = sc.nextInt();

        System.out.println("Enter third side: ");
        int c = sc.nextInt();

        if(a == b && a == c && b == c) {
            System.out.println("Triangle is equilateral (All sides are equal!)");
        } else if (a == b || b == c || a == c) {
            System.out.println("Triangle is isosceles(Atleast 2 Sides are equal)");
        } else {
            System.out.println("Triangle is scalene! (none are equal)");
        }

        sc.close();
    }
}
