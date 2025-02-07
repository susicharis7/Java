package EmailAdministrationApp;

import java.util.Scanner;

class EmailApp {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String firstName = sc1.nextLine().trim();

        System.out.println("Enter your last name: ");
        String lastName = sc1.nextLine().trim();

        Email email1 = new Email(firstName,lastName);




        System.out.println("\nAll Information: \n"+email1.showInfo());




        while(true) {
            System.out.println("Do you want to change the password to your liking? (y/n): ");
            String choice = sc1.nextLine().trim().toLowerCase();

            if(choice.equals("y")) {
                System.out.println("Enter your new password: ");
                String newPass = sc1.nextLine().trim();
                email1.changePassword(newPass);

                System.out.println("Your password has been updated!\nYour new password is: " + email1.getPassword());
                break;
            } else if(choice.equals("n")) {
                System.out.println("Password change is cancelled.");
                break;
            } else {
                System.out.println("That is not a valid choice! Please enter (y/n) : ");
            }
        }




    sc1.close();
    }
}
