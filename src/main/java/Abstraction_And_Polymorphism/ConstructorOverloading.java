package Abstraction_And_Polymorphism;
// The technique in which a class has two or more constructors is called constructor overloading.

class Person {
    private String name;
    private int age;
    private int weight;
    private int height;

    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.weight = 0;
        this.height = 0;
    }

    public Person(String name,int age) {
        this.name = name;
        this.age =  age;
        this.weight = 0;
        this.height = 0;
    }

    public static void main(String[] args) {
        Person person = new Person("Haris");
        Person person2 = new Person("Becir",30);
    }
}