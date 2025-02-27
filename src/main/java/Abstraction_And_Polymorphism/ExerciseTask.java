package Abstraction_And_Polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    private String modelName;
    private int mileage;
    private int health;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
    }

    public Vehicle(String modelName, int mileage, int health) {
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
    }

    public String getModelName() {
        return this.modelName;
    }
    public int getMileage() {
        return this.mileage;
    }
    public int getHealth() {
        return this.health;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public boolean needsMaintenance() {
        return health < 70;
    }

    public int calculateRemainingLifespan() {
        int remaining = expectedLifespan() - mileage;
        if (health < 50) {
            remaining -= (expectedLifespan() * (100 - health) / 100);
        }
        return Math.max(remaining, 0);
    }

    public void simulateYear() {
        if (mileage > expectedLifespan() / 2) {
            setHealth(getHealth() - 5);
        }
    }

    abstract String service();
    abstract int expectedLifespan();

    public static void performMaintenance(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println(car.repair());
            car.drive(500);
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            System.out.println(truck.repair());
            truck.haul(6000);
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle moto = (Motorcycle) vehicle;
            moto.race(100);
        }
    }
}

interface Repairable {
    String repair();
}

class Car extends Vehicle implements Repairable {
    public Car(String modelName) {
        super(modelName);
    }

    public Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine tuned and oil changed for " + getModelName();
    }

    @Override
    public String service() {
        return "Checking engine: " + getModelName() + ", Changing oil because mileage is " + getMileage() + ", and its health is " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 150000;
    }

    public void drive(int miles) {
        setMileage(getMileage() + miles);
        setHealth(getHealth() - miles / 1000);

        if (getHealth() < 30) {
            setMileage(getMileage() - 10000);
        }
    }
}

class Truck extends Vehicle implements Repairable {
    public Truck(String modelName) {
        super(modelName);
    }

    public Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public String service() {
        return "Truck " + getModelName() + " service: Checking suspension, brakes, and engine, Mileage: " + getMileage() + ", Health: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 300000;
    }

    public void haul(int loadWeight) {
        if (loadWeight > 5000) {
            setHealth(getHealth() - 10);
        } else {
            setHealth(getHealth() - 5);
        }

        if (getHealth() < 40) {
            setMileage(getMileage() - 20000);
        }
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String modelName) {
        super(modelName);
    }

    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String service() {
        return "Motorcycle " + getModelName() + " service: Lubricating chain, tuning engine, Mileage: " + getMileage() + ", Health: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 50000;
    }

    public void race(int raceMiles) {
        setMileage(getMileage() + raceMiles);
        setHealth(getHealth() - (raceMiles / 500));

        if (getHealth() < 40) {
            setMileage(getMileage() - 5000);
        }
    }
}


class Main06 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("BMW M4 Competition", 60000, 85));
        vehicles.add(new Truck("BMW M4F82", 120000, 70));
        vehicles.add(new Motorcycle("Mercedes E220d", 20000, 90));

        System.out.println("Initial Vehicle States:");
        for (Vehicle v : vehicles) {
            System.out.println(v.service());
        }

        System.out.println("\nSimulating a year...");
        for (Vehicle v : vehicles) {
            v.simulateYear();
        }

        System.out.println("\nUpdated Vehicle States:");
        for (Vehicle v : vehicles) {
            System.out.println(v.service());
        }

        System.out.println("\nPerforming maintenance...");
        for (Vehicle v : vehicles) {
            Vehicle.performMaintenance(v);
        }

        System.out.println("\nFinal Vehicle States:");
        for (Vehicle v : vehicles) {
            System.out.println(v.service());
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose a vehicle for maintenance (1: Car, 2: Truck, 3: Motorcycle): ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= 3) {
            Vehicle.performMaintenance(vehicles.get(choice - 1));
        } else {
            System.out.println("Invalid choice!");
        }
        scanner.close();
    }
}
