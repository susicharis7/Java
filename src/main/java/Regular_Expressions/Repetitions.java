package Regular_Expressions;

class Repetitions {

    public static void main(String[] args) {
        String string = "trolololololo";
        if(string.matches("trolo(lo)*")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is not right.");
        }

        if(string.matches("tro(lo)+")) {
            System.out.println("The form is right.");
        } else
            System.out.println("The form is not right.");

        String secString = "You have accidentally the whole name";

        if(secString.matches("You have accidentally (deleted )?the whole name")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        String thString = "1010";
        if(thString.matches("(10){2}")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        String fourthString = "1";
        if(fourthString.matches("1{2,4}")) {
            System.out.println("Its good.");
        } else
            System.out.println("Not good.");

        String fifthString = "11111";
        if(fifthString.matches("1{2,}")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }



    }

}
