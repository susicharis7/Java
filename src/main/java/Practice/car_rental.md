#  Advanced Car Rental Management System

You are tasked with developing an advanced car rental management system. This system should handle various types of vehicles, manage customer rentals, organize vehicle inventory, and allow for promotions and discounts.

## Requirements

### Enum: CarType
Define an enum `CarType` that specifies various car types:
- SEDAN
- SUV
- TRUCK
- VAN
- SPORTS

This enum will be used to categorize cars by their type.

### Interface: Rentable
Create an interface `Rentable` to represent items that can be rented. The interface should include:
- `double applyDiscount(double discountRate)`: Calculates the discounted price using the provided discount rate.
- `String getDescription()`: Returns a formatted description of the item, including name, rental rate, and other relevant details.

### Abstract Class: Vehicle
Create an abstract class `Vehicle` that:
- Implements the `Rentable` interface.
- Has the attributes:
    - `String vehicleId`
    - `String name`
    - `double rentalRate`
- Implements `applyDiscount` and `getDescription` with default behaviors.
- Provides an all-attribute constructor and getter/setter methods.

#### Kilometers Tracking in Vehicle
Add:
- `HashMap<Date, Integer> kilometersRecord`
- Method `void addKilometers(Date rentalDate, int kilometers)`
- Method `int getTotalKilometers()`

### Class: Car
Inherits `Vehicle` and has additional attributes:
- `CarType carType`
- `String engineType`

Provide:
- Constructor to initialize all attributes.
- Override `getDescription()`.
- Getter and setter methods.

### Class: Motorcycle
Inherits `Vehicle` and has additional attribute:
- `double engineCapacity`

Provide:
- Constructor to initialize all attributes.
- Override `getDescription()`.
- Getter and setter methods.

### Generic Class: RentalTransaction<T extends Vehicle & Rentable>
Attributes:
- `String transactionId`
- `Date rentalDate`
- `HashMap<T, Integer> rentedVehicles`
- `int customerId`

Provide:
- Constructor to initialize transactionId, rentalDate, and customerId.
- Method `addVehicleToRental(T vehicle, int days)`.
- Method `double calculateTotalAmount()`.
- Getter and setter methods.

### Class: Customer
Attributes:
- `String customerId`
- `String name`
- `String phoneNumber`
- `List<RentalTransaction<? extends Vehicle>> rentalHistory`

Provide:
- Constructor for all attributes except rental history.
- Method `addRentalTransaction(...)`.
- Getter and setter methods.

### Class: RentalCompany
Attributes:
- `String companyName`
- `List<Customer> customers`
- `Map<String, Vehicle> vehicleInventory`

Provide methods:
- `void addCustomer(Customer customer)`
- `void addVehicle(Vehicle vehicle)`
- `Customer getCustomer(String customerId)`
- `void displayInventory()`
- `double calculateTotalRevenue()`
- Constructor for company name and appropriate getters/setters.

### Class: MainApplication
Demonstrates:
- Creating instances of `Car` and `Motorcycle`
- Adding them to inventory
- Creating `RentalTransaction<Car>` and `RentalTransaction<Motorcycle>`
- Creating a `Customer` and adding transactions
- Adding customer to company
- Displaying rental history
- Calculating total revenue

## Example Scenario
1. Create `Car` and `Motorcycle` instances with unique attributes.
2. Add to company inventory.
3. Create rental transactions for each type.
4. Create a customer with multiple rentals.
5. Add customer to the system and display rental history.
6. Calculate total revenue.