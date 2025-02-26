package Abstraction_And_Polymorphism;

// there will be a method that will create a new object from the current object

class Counter {
    private int value;

    public Counter() {
        this(0);
    }
    public Counter(int initialValue) {
        this.value = initialValue;
    }

    public void grow() {
        this.value++;
    }
    public String toString() {
        return "Value: " + this.value;
    }

    public Counter clone() {
        Counter clone = new Counter(this.value);


        return clone;
    }
}
