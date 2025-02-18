package QuestionBank.Conditional_And_Loops;

/*
Write a program that finds the number and sum of all numbers between x and y which are divisible by z.
 */


import java.util.Scanner;

class FindIt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter first number: ");
        int x = sc.nextInt();

        System.out.print("Please enter second number: ");
        int y = sc.nextInt();

        System.out.print("Write a number that every number must be divisible with this number: ");
        int z = sc.nextInt();

        int sum = 0;
        int count = 0;

        for(int i = x; i <= y; i++) {
            if(i % z == 0) {
                sum += i;
                count++;
            }
        }

        System.out.println("Sum between " + x + " and " + y + " is: " + sum);
        System.out.println("Count: " + count);


    }
}