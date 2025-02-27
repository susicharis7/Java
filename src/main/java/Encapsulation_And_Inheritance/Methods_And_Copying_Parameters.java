package Encapsulation_And_Inheritance;
import java.util.ArrayList;

class W4Lecture {
    public static void main(String[] args) {
        int number = 1;
        addThree(number);
        System.out.println("Before:" + number);
        // it will write out 1 because there is ZERO change

        number = addThree2(number);
        // for it to function, "number" has to take value that the method will make

        System.out.println("After: " + number);

        listOperations();


    }

    public static void addThree(int number) {
        number += 3;
        System.out.println(number);
        // we forwarded the main number, it makes copy inside parameter, this will write out 4

    }

    public static int addThree2(int number) {
        number += 3;
        return number;
    }



    public static void removeFirst(ArrayList<Integer> list) {
        list.remove(0);
    }

    public static void listOperations() {
        ArrayList<Integer> numbers = new ArrayList<>();
        // numbers - reference that refers to the place where the ArrayList is
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Before removing: " + numbers);

        removeFirst(numbers);

        System.out.println("After: " + numbers);
    }

}
