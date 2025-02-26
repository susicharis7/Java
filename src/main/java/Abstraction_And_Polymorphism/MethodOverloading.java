package Abstraction_And_Polymorphism;

/*
Just like constructors, methods can also be overloaded and multiple versions of a method can exist.
Again, the parameter types of different versions have to be different.
The method that is chosen to be run depends on the amount of parameters entered in to the method call
*/

class Osoba {
    private String name;
    private int age;
    private int weight;
    private int height;

    public Osoba(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 0;
        this.height = 0;
    }

    public void becomeOlder() {
        this.age = this.age + 1;
    }
    public void becomeOlder(int years) {
        this.age += years;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return "Name: " + this.name + "\nAge: " + this.age;
    }

    public static void main(String[] args) {
        Osoba osoba = new Osoba("Haris",20);
        osoba.becomeOlder();
        System.out.println(osoba);

        osoba.becomeOlder(10);
        System.out.println(osoba);

        Osoba nedim = new Osoba("Nedim",30);
        Osoba becir = new Osoba("Becir",35);

        if(becir.getAge() > nedim.getAge()) {
            System.out.println(becir.getName() + " is older than " + nedim.getName());
        } else {
            System.out.println(nedim.getName() + " is actually older than " + becir.getName());
        }


    }

    public boolean olderThan(Osoba comparedPerson) {
        if(this.age > comparedPerson.getAge()) {
            return true;
        }
        return false;
    }
}
