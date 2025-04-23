package Optionals_Final_Record;

final class FinalClass {
    public void showMessage() {
        System.out.println("Final class method.");
    }
}

// class AnotherClass extends FinalClass {} // Ovo će izazvati grešku

class Demo {
    final int constantValue = 42;

    final void printMessage() {
        System.out.println("This is a final method.");
    }

    // void printMessage() {} // Ne može se override-ati jer je final
}

class FinalKeywordExample {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.printMessage();
        System.out.println("Final variable: " + demo.constantValue);

        FinalClass obj = new FinalClass();
        obj.showMessage();
    }
}
