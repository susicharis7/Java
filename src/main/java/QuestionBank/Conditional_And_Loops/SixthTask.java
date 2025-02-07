package QuestionBank.Conditional_And_Loops;

// Write a Python program to check the validity of password input by users.

import java.util.Scanner;

class SixthTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;


        int minLength = 6;
        int maxLength = 16;

        while(true) {
            System.out.println("Input password: ");
            password = sc.nextLine();

            if(password.length() < minLength && password.length() > maxLength) {
                System.out.println("Try again! It has to be between 6-16 characters!");
                continue;
            }

            if(!password.matches(".*[a-z].*")) {
                System.out.println("Try again! Password must contain atleast one letter!");
                continue;
            }

            if(!password.matches(".*[A-Z].*")) {
                System.out.println("Try again! Password must contain atleast one uppercase letter!");
                continue;
            }

            if (!password.matches(".*\\d.*")) {
                System.out.println("Try again! Password must contain at least one number (0-9).");
                continue;
            }


            if (!password.matches(".*[$#@].*")) {
                System.out.println("Try again! Password must contain at least one special character ($, #, or @).");
                continue;
            }


            break;


        }

        System.out.println("password Accepted!");
        sc.close();

    }
}
