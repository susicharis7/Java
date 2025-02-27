package Encapsulation_And_Inheritance;
// Practice Task Two

enum FillType {
    FILLED, NOT_FILLED;
}

class Shape {
    private String color;
    private FillType filled;

    public Shape(String color, FillType filled) {
        this.color = color;
        this.filled = filled;
    }

    public void displayInfo() {
        System.out.println("Color: " + color + "\nFill Type: " + filled);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, FillType filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Radius: " + radius);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference(double PI, double r) {
        return 2 * PI * r;
    }

    public double calculateCircumference(double r) {
        return 2 * Math.PI * r;
    }

    public double getRadius() {
        return this.radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, FillType filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Width: " + width + "\nHeight: " + height);
    }

    public double getArea() {
        return width * height;
    }
}

class Main02 {
    public static void main(String[] args) {

        Circle circle = new Circle("Red", FillType.FILLED, 5.0);
        System.out.println("Circle Info:");
        circle.displayInfo();
        System.out.println("Area: " + circle.getArea());
        System.out.println("Circumference: " + circle.calculateCircumference(circle.getRadius()));
        System.out.println();


        Rectangle rectangle = new Rectangle("Blue", FillType.NOT_FILLED, 4.0, 6.0);
        System.out.println("Rectangle Info:");
        rectangle.displayInfo();
        System.out.println("Area: " + rectangle.getArea());
    }
}
