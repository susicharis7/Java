package QuestionBank.Logic_And_Functions;

/*
When squirrels get together for a party, they like to have cigars.
A squirrel party is successful when the number of cigars is between 40 and 60, inclusive.
Unless it is the weekend, in which case there is no upper bound on the number of cigars.
Write a function to return True if the party with the given values is successful, or False otherwise.
cigar_party(30, False) → False
cigar_party(50, False) → True
cigar_party(70, True) → True
cigar_party(70, False) → False
*/

import java.util.Scanner;

class Second {
    public static boolean cigar_party(int numOfCigars, boolean isWeekend) {
        if (isWeekend) {
            return numOfCigars >= 40;
        } else {
            return numOfCigars >= 40 && numOfCigars <= 60;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isWeekend = false;

        System.out.print("Enter a number of cigars: ");
        int cigars = sc.nextInt();
        sc.nextLine();

        System.out.print("Is it weekend? (yes/no) : ");
        String decision = sc.nextLine().trim().toLowerCase();

        if(decision.equals("yes")) {
            isWeekend = true;
        }  else if (!decision.equals("no")){
            System.out.println("Not good input! Try again!");
            return;
        }

        boolean result = cigar_party(cigars, isWeekend);
        System.out.println("Party successful: " + result);

    }
}
