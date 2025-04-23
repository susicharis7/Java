package Optionals_Final_Record;

record Person(String name, int age, int height) {
    public static String UNKNOWN_ADDRESS = "Unknown";

    public Person(String name) {
        this(name, 0, 0);
    }

    public Person(String name, int age) {
        this(name, age, 0);
    }

    public static Person unnamed(String name) {
        return new Person(name);
    }

    public int a() {
        return 1;
    }

    public static void main(String[] args) {
        Person person = new Person("Amar", 20, 180);
        System.out.println(person);

        Person shortPerson = new Person("Lejla", 22);
        System.out.println(shortPerson);

        Person unnamed = Person.unnamed("Neko");
        System.out.println(unnamed);
    }
}
