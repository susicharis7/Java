package Abstraction_And_Polymorphism;

/*
Downcasting is an opposite process of upcasting and we have to be extra careful as it does not happen automatically.
We are saying to Java, this animal passed as the parameter is the Tiger and threat it as it is the Tiger.
WE HAVE TO BE CAREFUL AS IT WILL THROW AN EXCEPTION IF WE PASS DIFFERENT OBJECT
You can add the instanceof check
*/

class SecondAnimal {
    public static void eat() {
        System.out.println("Animal is eating");
    }
}

class SecondTurtle extends SecondAnimal { }

class SecondTiger extends SecondAnimal {
    public static void eatMyLittleTiger() {
        System.out.println("My little tiger is eating");
    }
}

class Main05 {
    public static void main(String[] args) {
        SecondAnimal animal = new SecondTiger();
        SecondTiger tiger = new SecondTiger();
        SecondTurtle turtle = new SecondTurtle();

        doSomeAnimalStuffDowncasting(animal);
        doSomeAnimalStuffDowncasting(turtle);
    }

    public static void doSomeAnimalStuffDowncasting(SecondAnimal animal) {
        if(animal instanceof SecondTiger) {
            SecondTiger myLocalTiger = (SecondTiger) animal;
            myLocalTiger.eatMyLittleTiger();
        }
    }
}

