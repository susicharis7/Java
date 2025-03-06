package Custom_Exceptions;

// customException
class AgeLessThanZeroException extends Exception {
    public AgeLessThanZeroException(String message) {
        super(message);
    }
}

class CustomExceptions {
    /*
    public static void validateAgeFirst(int age) {
        if(age < 0)
            throw new InvalidParameterException();
            // throw new Exception("Age is less than 0!");
    }     */

    public static void validateAge(int age) throws AgeLessThanZeroException {
        if (age < 0) {
            throw new AgeLessThanZeroException("Hey man, what are you doing?");
        }
    }


    public static void main(String[] args)  {
        try {
            validateAge(-1);
        } catch (AgeLessThanZeroException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }


}





