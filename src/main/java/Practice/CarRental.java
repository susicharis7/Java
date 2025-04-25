package Practice;

import java.util.*;

enum CarType {
    SEDAN,
    SUV,
    TRUCK,
    VAN,
    SPORTS
}

interface Rentable {
    double applyDiscount(double discountRate);
    String getDescription();
}

abstract class Vehicle implements Rentable {
    String vehicleId;
    String name;
    double rentalRate;
    HashMap<Date, Integer> kilometersRecord;

    public Vehicle(String vehicleId, String name, double rentalRate) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.rentalRate = rentalRate;
        this.kilometersRecord = new HashMap<>();
    }

    public String getVehicleId() {
        return this.vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getRentalRate() {
        return this.rentalRate;
    }
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public double applyDiscount(double discountRate) {
        return this.rentalRate - (this.rentalRate * discountRate);
    }

    public String getDescription() {
        return "Vehicle ID: " + this.vehicleId + ", name: " + this.name + ", rental rate: " + this.rentalRate;
    }

    public void addKilometers(Date rentalDate, int kilometers) {
        this.kilometersRecord.put(rentalDate, kilometers);
    }

    public int getTotalKilometers() {
        int totalKilometers = 0;
        Collection<Integer> kilometers = this.kilometersRecord.values();
        for (Integer sumKM : kilometers) {
            totalKilometers += sumKM;
        } return totalKilometers;
    }
}

class Car extends Vehicle {
    CarType carType;
    String engineType;

    public Car(String vehicleId, String name, double rentalRate, CarType carType, String engineType) {
        super(vehicleId,name,rentalRate);
        this.carType = carType;
        this.engineType = engineType;
    }

    public CarType getCarType() {
        return this.carType;
    }
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getEngineType() {
        return this.engineType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " , Car Type: " + this.carType + ", Engine Type : " + this.engineType;
    }
}

class Motorcycle extends Vehicle {
    double engineCapacity;

    public Motorcycle(String vehicleId, String name, double rentalRate, double engineCapacity) {
        super(vehicleId,name,rentalRate);
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() {
        return this.engineCapacity;
    }
    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Engine capacity: " + this.engineCapacity;
    }
}

class RentalTransaction<T extends Vehicle> {
    String transactionId;
    Date rentalDate;
    HashMap<T, Integer> rentedVehicles;
    int customerId;

    public RentalTransaction(String transactionId, Date rentalDate, int customerId) {
        this.transactionId = transactionId;
        this.rentalDate = rentalDate;
        this.customerId = customerId;
        this.rentedVehicles = new HashMap<T,Integer>();
    }

    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public HashMap<T, Integer> getRentedVehicles() {
        return rentedVehicles;
    }
    public void setRentedVehicles(HashMap<T, Integer> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void addVehicleToRental(T vehicle, int days) {
        if(rentedVehicles.containsKey(vehicle)) {
            int existingDays = rentedVehicles.get(vehicle);
            rentedVehicles.put(vehicle, existingDays + days);
        } else {
            rentedVehicles.put(vehicle, days);
        }
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;

        for(T vehicle : rentedVehicles.keySet()) {
            totalAmount += this.rentedVehicles.get(vehicle) * vehicle.getRentalRate();
        } return totalAmount;
    }
}

class Customer2 {
    String customerId;
    String name;
    String phoneNumber;
    List<RentalTransaction<? extends Vehicle>> rentalHistory;

    public Customer2(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rentalHistory = new ArrayList<RentalTransaction<? extends Vehicle>>();
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<RentalTransaction<? extends Vehicle>> getRentalHistory() {
        return rentalHistory;
    }
    public void setRentalHistory(List<RentalTransaction<? extends Vehicle>> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }


    public void addRentalTransaction(RentalTransaction<? extends Vehicle> transaction) {
        this.rentalHistory.add(transaction);
    }

}

class RentalCompany {
    String companyName;
    List<Customer2> customers;
    Map<String,Vehicle> vehicleInventory;

    public RentalCompany(String companyName) {
        this.companyName = companyName;
        this.customers = new ArrayList<>();
        this.vehicleInventory = new HashMap<>();
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Customer2> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer2> customers) {
        this.customers = customers;
    }

    public Map<String, Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }
    public void setVehicleInventory(Map<String, Vehicle> vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }


    public void addCustomer(Customer2 customer) {
        this.customers.add(customer);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleInventory.put(vehicle.getVehicleId(), vehicle);
    }

    // Nece biti Collections !!!
    public void displayInventory() {
        Collection<Vehicle> vehiclesInInventory = vehicleInventory.values();
        for(Vehicle v : vehiclesInInventory){
            System.out.println(v.getDescription());
        }
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;

        for(Customer2 customer : customers) {
            for(RentalTransaction<? extends Vehicle> transactionAll : customer.getRentalHistory()) {
                totalRevenue += transactionAll.calculateTotalAmount();
            }
        } return totalRevenue;
    }


    /*
    public Customer getCustomer(String customerId) {
        // example of streams implementation or basic below
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);

        for(Customer c : customers){
            if(c.getCustomerId() == customerId){
                return c;
            }
        }
        return null;
    }

    */




}



