package Annotations;

// We use the @Override annotation to mark a method that exists in a parent class, but that we want to override in a child class.

class Parent {
    public String getName() {
        return "Parent";
    }
}

class Child extends Parent {
    @Override
    public String getName() {
        return "Child";
    }
}
