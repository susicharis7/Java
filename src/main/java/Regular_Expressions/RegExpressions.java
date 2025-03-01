package Regular_Expressions;

import java.util.Scanner;

// Exercise : Student numbers start with the string "01" which is followed by seven numerical digits from 0 to 9

class RegExpressions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Give student number: ");
        String num = sc.nextLine();

        if(num.matches("01[0-9]{7}")) {
            System.out.println("The form is valid.");
        } else {
            System.out.println("The form is not valid.");
        }
    }
}
