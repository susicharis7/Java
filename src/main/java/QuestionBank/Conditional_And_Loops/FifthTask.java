package QuestionBank.Conditional_And_Loops;

// Write a Java program that accepts a string and calculate the number of digits and letters.

import java.util.Scanner;

class FifthTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word(with some digits also): ");
        String word = sc.nextLine();

        int letterCount = 0;
        int digitCount = 0;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(Character.isLetter(ch)) {
                letterCount++;
            } else if(Character.isDigit(ch)) {
                digitCount++;
            }
        }


        System.out.println("Letter Count: " + letterCount);
        System.out.println("Digit Count: " + digitCount);
    }
}