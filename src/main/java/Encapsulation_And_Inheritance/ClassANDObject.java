package Encapsulation_And_Inheritance;
/*
We defined that all instances created from the Person class have a name and an age.
Defining attributes is done in a quite similar fashion as with normal variables.
In this case though, there is the keyword private in front.
This keyword means that name and age will not show outside of the object, but are instead hidden within it.
HIDING THINGS WITHIN AN OBJECT IS CALLED ENCAPSULATION.
*/
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }



    public void becomeOlder() {
        this.age++;
    }

    public boolean isAdult() {
        if (this.age < 18) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Person first = new Person("Haris", 24);
        Person second = new Person("Becir", 30);

        System.out.println("Becirove godine prije rodjendana: " + second.getAge());
        second.becomeOlder();
        System.out.println("Becirove godine poslije rodjendana: " + second.getAge());

        System.out.println("Age of becir: " + second.getAge());
        System.out.println("Age of Haris: " + first.getAge());

        int total = first.getAge() + second.getAge();
        System.out.println("Total age: " + total);

        System.out.println(first.isAdult());




    }
}

