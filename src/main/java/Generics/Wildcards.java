package Generics;

// What if we want to create a method that can accept the List of any kind of objects and prints that List

import java.util.List;

import java.util.Arrays;
import java.util.List;

class AnimalSecond {
    private String name;

    public AnimalSecond(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Dog extends AnimalSecond {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends AnimalSecond {
    public Cat(String name) {
        super(name);
    }
}

public class Wildcards {

    public static void printList(List<?> objectList) {
        System.out.println("General list: " + objectList);
    }


    public static void printListWildcard(List<? extends AnimalSecond> objectList) {
        System.out.println("Animal list: " + objectList);
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("King", "Queen");
        List<AnimalSecond> animals = Arrays.asList(new Dog("Tarik"), new Cat("Zvironja"));


        printList(numbers);
        printList(words);
        printList(animals);


        printListWildcard(animals);

    }
}
