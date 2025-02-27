package Encapsulation_And_Inheritance;

import java.util.ArrayList;
import java.util.List;



class Persons {
    private String name;
    private String address;

    public Persons(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address;
    }
}

class Student extends Persons {
    private int credit = 0;

    public Student(String name, String address) {
        super(name,address);
    }

    public void heStudied() {
        this.credit++;
    }

    public int getCredit() {
        return this.credit;
    }
}

class Teacher extends Persons {
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name,address);
        this.salary = salary;
    }

    public String toString() {
        return super.toString() + "\nSalary: " + this.salary;
    }
}

class Main01 {

    public static void printDepartment(List<Persons> people) {
        for(Persons p : people) {
            System.out.println(p + "\n");
        }
    }


    public static void main(String[] args) {
        Persons pekka = new Persons("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Persons esko = new Persons("Esko Ukkoken", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);
        System.out.println();

        Student olli = new Student("Olli","Izacic BB");
        System.out.println(olli);
        System.out.println("Credits: " + olli.getCredit());
        olli.heStudied();
        System.out.println("Credits now: " + olli.getCredit());
        System.out.println();

        Teacher pekko = new Teacher("Pekko Mikkolo","Bihac 77208",4000);
        Teacher eska = new Teacher("Eska Ukkokan","Franc. Revolucije BB",2500);
        System.out.println(pekko);
        System.out.println(eska);
        System.out.println();

        List<Persons> people = new ArrayList<>();
        people.add(new Teacher("Pekzi Molly","Trg Heroja Izacica",1200));
        people.add(new Student("Magomedov","Ida Ida 44506"));
        printDepartment(people);

    }
}