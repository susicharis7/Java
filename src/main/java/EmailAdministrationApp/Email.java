package EmailAdministrationApp;

import java.util.Scanner;

class Email {
   private String firstName;
   private String lastName;
   private String password;
   private String department;
   private String email;
   private String alternateEmail;
   private int mailboxCapacity = 500;
   private int passwordLength = 10;
   private String emailSuffix = "gmail.com";


    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


        this.department = setDepartment();


        this.password = randomPassword(passwordLength);
        System.out.println("Your password: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.substring(0).toLowerCase()+ "." + emailSuffix;
        // email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + getDepartmentDomain();
        System.out.println("Your email: " + email);

    }

    private String setDepartment() {

        Scanner sc = new Scanner(System.in);
        int departmentChoice = -1;

       while(true) {
           System.out.println("Enter the department: ");
           System.out.println("1 - Sales");
           System.out.println("2 - Development");
           System.out.println("3 - Accounting");
           System.out.println("0 - None");
           System.out.print("Your choice: ");


           if(sc.hasNextInt()) {
               departmentChoice = sc.nextInt();

               if(departmentChoice >= 0 && departmentChoice <= 3) {
                   break;
               } else {
                   System.out.println("Invalid choice. Please enter 0,1,2,3");
               }
           } else {
               System.out.println("Invalid input.. Please enter a number! : ");
               sc.next();
           }
       }


       return switch(departmentChoice) {
        case 0 -> "None";
        case 1 -> "Sales";
        case 2 -> "Development";
        case 3 -> "Accounting";
        default -> "You chose nothing.";
       };

    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];

        for(int i = 0; i < length; i++) {
            int value = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(value);
        }
        return new String (password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }
    public String getAlternateEmail() {
        return this.alternateEmail;
    }
    public String getPassword() {
        return this.password;
    }

    public String capitalizeFirstLetter(String firstLetter) {
        if(firstLetter == null || firstLetter.isEmpty()) {
            return firstLetter;
        }

        return firstLetter.substring(0,1).toUpperCase() + firstLetter.substring(1).toLowerCase();
    }

    private String getDepartmentDomain() {
        return switch(department) {
            case "Sales" -> "salescompany.com";
            case "Development" -> "developmentcompany.com";
            case "Accounting" -> "accountingcompany.com";
            default -> "company.com";
        };
    }



    public String showInfo() {
        return "Display Name: " + capitalizeFirstLetter(firstName) + "\nLast Name: " + capitalizeFirstLetter(lastName) + "\nCompany Email: " + email + "\nMailbox Capacity: " + mailboxCapacity;
    }

}