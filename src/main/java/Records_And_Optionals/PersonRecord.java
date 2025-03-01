package Records_And_Optionals;

import java.util.Objects;

/*
While this accomplishes our goal, there are two problems with it:
    There’s a lot of boilerplate code
    We obscure the purpose of our class: to represent a person with a name and address

    In this case, we have to repeat the same tedious process for each data class,
    monotonously creating a new field for each piece of data; creating equals, hashCode,
    and toString methods; and creating a constructor that accepts each field.
 */

class Person {
    private String name;
    private int age;
    private int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
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
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "PersonC class -> name: " + this.name + ", age: " + this.age + ", height: " + this.height;
    }

    @Override
    public boolean equals(Object obj) {
        Person compared = (Person) obj;

        if (this.name.equals(compared.getName()) && this.age == compared.getAge() && this.height == compared.getHeight())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height);
    }
}


