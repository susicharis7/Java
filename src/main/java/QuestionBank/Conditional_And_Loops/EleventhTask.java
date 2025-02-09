package QuestionBank.Conditional_And_Loops;

import java.util.Scanner;

class EleventhTask {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while(true) {
            System.out.println("Enter a number (or type done when you are finished) :");
            String input = sc.next();

            if(input.equals("done")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                sum += number;
            } catch(NumberFormatException nfe) {
                System.out.println("Invalid input ! : " + nfe);
            }

        }


        System.out.println("Total sun is: " + sum);
        sc.close();
    }
}