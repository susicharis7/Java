package Abstraction_And_Polymorphism;

import java.util.ArrayList;

class ListOperations {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Haris",20));
        personList.add(new Person("Becir",30));

        for(Person o : personList) {
            System.out.println(o);
        }
    }


}
