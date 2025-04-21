package Design_Patterns.Builder;

// From Youtube Example
class Car {
    private int id;
    private String brand;
    private String model;
    private String color;

    public Car(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString(){
        return "Car: " + id + ", " + brand + ", " + model + ", " + color;
    }
}

interface CarInterface {
    CarInterface setId(int id);
    CarInterface setBrand(String brand);
    CarInterface setModel(String model);
    CarInterface setColor(String color);
    Car getResults();
}


class CarBuilder implements CarInterface {
    private int id;
    private String brand;
    private String model;
    private String color;

    public CarInterface setId(int id) {
        this.id = id;
        return this;
    }
    public CarInterface setBrand(String brand) {
        this.brand = brand;
        return this;
    }
    public CarInterface setModel(String model) {
        this.model = model;
        return this;
    }
    public CarInterface setColor(String color) {
        this.color = color;
        return this;
    }

    public Car getResults() {
        return new Car(id,brand,model,color);
    }
}

class LuxuryCar implements CarInterface {
    private int id;
    private String brand;
    private String model;
    private String color;

    public CarInterface setId(int id) {
        this.id = id;
        return this;
    }
    public CarInterface setBrand(String brand) {
        this.brand = "Luxury " + brand;
        return this;
    }
    public CarInterface setModel(String model) {
        this.model = model + " Pro";
        return this;
    }
    public CarInterface setColor(String color) {
        this.color = "Carbon " + color;
        return this;
    }

    public Car getResults() {
        return new Car(id,brand,model,color);
    }


}


class Director {
    void buildBugatti(CarInterface builder) {
        builder.setId(1)
                .setBrand("Bugatti")
                .setModel("Chiron")
                .setColor("Orange");
    }

    void buildBMW(CarInterface builder) {
        builder.setId(2)
                .setBrand("BMW")
                .setModel("Chiron")
                .setColor("Orange");
    }
}

class RealMadrid {
    public static void main(String[] args) {
        Director director = new Director();
        CarInterface builder = new CarBuilder();

        director.buildBugatti(builder);
        Car firstCar = builder.getResults();
        System.out.println(firstCar);

        CarInterface luxuryBuilder = new LuxuryCar();
        director.buildBMW(luxuryBuilder);
        Car secondCar = luxuryBuilder.getResults();
        System.out.println(secondCar);


    }
}
