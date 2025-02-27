package Generics.More_Into_Arrays;

class SecArr {

    public static boolean isInArray(int[] array, int searchingFor) {
        for ( int value : array ) {
            if ( value == searchingFor )
                return true;
        }
        return false;
    }

    public static boolean isWordInArray(String[] array, String searchingFor) {
        for ( String word: array ) {
            if ( word.equals(searchingFor) )
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] numbers = {10,20,30,40,50};
        int specificNum = 20;

        System.out.println(isInArray(numbers,specificNum));

        String[] words = {"Haris","Sumea","Lejla"};
        String specificWord = "Love";

        System.out.println(isWordInArray(words,specificWord));
    }
}
