package Design_Patterns;

class Car {
    private int id;
    private String brand;
    private String model;
    private String color;

    Car(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car: " + brand + " , " + model + " , " + color;
    }
}

interface CarInterface {
    CarInterface setId(int id);
    CarInterface setBrand(String brand);
    CarInterface setModel(String model);
    CarInterface setColor(String color);
    Car getResults();
}

interface CarInterface2 {
    void setId(int id);
    void setBrand(String brand);
    void setModel(String model);
    void setColor(String color);
    Car getResults();
}

class OldCarBuilder implements CarInterface {
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
        this.model = "Old " + model;
        return this;
    }
    public CarInterface setColor(String color) {
        this.color = "Dusty " + color;
        return this;
    }
    public Car getResults() {
        return new Car(id,brand,model,color);
    }
}

class LuxuryCarBuilder implements CarInterface {
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
        this.model = "2024 " + model;
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

class VoidCarBuilder implements CarInterface2 {
    private int id;
    private String brand;
    private String model;
    private String color;

    public void setId(int id) {
        this.id = id;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Car getResults() {
        return new Car(id,brand,model,color);
    }
}

// Already done in Director
class CarDirector {
    void buildBugatti(CarInterface builder) {
        builder.setId(1)
                .setBrand("Bugatti")
                .setModel("Chiron")
                .setColor("Black")
                .getResults();
    }

    void buildGolf(CarInterface builder) {
        builder.setId(2)
                .setBrand("Golf")
                .setModel("4")
                .setColor("Grey")
                .getResults();
    }
}

/*
Have to put it in main
- Na ovaj drugi nacin, proslijedimo ostatak stvari iz konstruktora, tako da kad proslijedimo u tu metodu,
  ovdje stavi i proslijedi CarInterface koji ce buildati i staviti u Car.
 */
class Director {
    public Car makeCar(CarInterface builder,int id, String brand, String model, String color) {
        builder.setId(id);
        builder.setBrand(brand);
        builder.setModel(model);
        builder.setColor(color);
        return builder.getResults();
    }
}

class MainPlsYo {
    public static void main(String[] args) {
        Director director = new Director();
        CarInterface firstBuilder = new OldCarBuilder();
        director.makeCar(firstBuilder,1,"Golf","3","White");
        Car firstOldCar = firstBuilder.getResults();


        CarInterface secondBuilder = new LuxuryCarBuilder();
        director.makeCar(secondBuilder,2,"BMW","M5 CS", "Green");
        Car firstLuxuryCar = secondBuilder.getResults();

        CarDirector carDirector = new CarDirector();
        carDirector.buildBugatti(secondBuilder);
        Car secondLuxuryCar = secondBuilder.getResults();

        carDirector.buildGolf(firstBuilder);
        Car secondOldCar = firstBuilder.getResults();

        System.out.println(firstOldCar);
        System.out.println(firstLuxuryCar);
        System.out.println(secondOldCar);
        System.out.println(secondLuxuryCar);


        System.out.println("\n Other ways to do this");

        // Kad imamo "CarInterface" u metodi sa return typeom umjesto "void + bez return"
        CarInterface thirdBuilder = new OldCarBuilder();
        thirdBuilder.setId(1)
                .setBrand("Yugo")
                .setModel("CetrdesetPet'ca")
                .setColor("Red")
                .getResults();

        Car returnTypeCI = thirdBuilder.getResults();
        System.out.println(returnTypeCI);

        // Kad nemamo u Director/nemamo Directora uopste : i imamo void return type
        CarInterface2 builder = new VoidCarBuilder();
        builder.setId(25);
        builder.setBrand("Void Brand");
        builder.setModel("Void Model");
        builder.setColor("Void Cyan");

        Car voidCar = builder.getResults();
        System.out.println(voidCar);








    }
}

