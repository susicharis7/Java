package Abstraction_And_Polymorphism;

/*
Upcasting is a type of object typecasting in which a child object is typecasted to a parent class object.
By using the Upcasting, we can easily access the variables and methods of the parent class to the child class.
Java allows you to treat an object of subclass as an object of its parent type.
Let us say we have an Animal base class and two classes that inherits this base class Turtle and Tiger
*/

/*
In the method declared previously we have the parameter animal of type Animal,
but since both the Tiger and Turtle are the animals both of these are allowed to be passed as a parameter
The type of the variable determines the methods you can call but the specific type of the object that the
variable is referring to is determined which specific implementation of the method will be used when called
*/

class Animal {
    public static void eat() {
        System.out.println("Animal is eating");
    }
}

class Turtle extends Animal { }

class Tiger extends Animal { }

class Main {
    public static void main(String[] args) {
        Animal animal = new Tiger();
        Tiger tiger = new Tiger();
        doSomeAnimalStuff(tiger);
        doSomeAnimalStuff(animal);
    }

    public static void doSomeAnimalStuff(Animal animal) {
        animal.eat();
    }
}

