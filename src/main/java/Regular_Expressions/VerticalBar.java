package Regular_Expressions;

import java.util.Scanner;

class VerticalBar {
    public static void main(String[] args) {
        String string = "00";

        if (string.matches("00|111|0000")) {
            System.out.println("The string was matched by some of the alternatives!");
        } else {
            System.out.println("The string was not matched by any of the alternatives!");
        }

        String secString = "1111";

        if(secString.matches("00|111|0000")) {
            System.out.println("The string was matched by some of the alternatives!");
        } else {
            System.out.println("The string was not matched by any of the alternatives!");
        }


        Scanner sc = new Scanner(System.in);
        System.out.print("Write a form of the verb to look: ");
        String word = sc.nextLine();

        if(word.matches("look(|s|ed||ing|er)")) {
            System.out.println("Well done!");
        } else {
            System.out.println("Check again please, not good!");
        }
    }
}
