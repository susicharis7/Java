package QuestionBank.Conditional_And_Loops;

// Write a Java program that accepts a word from the user and reverse it.

import java.util.Scanner;

class ThirdTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = sc.nextLine();

        String reversedWord = "";

        for(int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        System.out.println("Reversed Word: " + reversedWord);

        sc.close();
    }
}
