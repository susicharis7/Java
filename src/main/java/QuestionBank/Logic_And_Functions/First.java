package QuestionBank.Logic_And_Functions;

/*
Write a program with a loop that repeatedly asks the user to enter a word.
The user should enter nothing (press Enter without typing anything) to signal the end of the loop.
 Once the loop ends, the program should display the average length of the words entered, rounded to the nearest whole number.
 */

import java.util.Scanner;

class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = 0;
        int wordCount = 0;


        while(true) {
            System.out.println("Enter a word: ");
            String inputWord = sc.nextLine();
            length += inputWord.length();
            wordCount++;

            if(inputWord.equals("")) {
                break;
            }
        }

        System.out.println("Length of words: " + length);
        System.out.println("Word count: " + (wordCount - 1));

    }
}