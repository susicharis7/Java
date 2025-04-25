# Advanced Restaurant Management and Ordering System

You are tasked with developing an advanced management and ordering system for a restaurant. This system should handle various types of food and drink items, organize customer orders, manage table reservations, and allow for promotions and discounts.

## Requirements

### Enum: `CuisineType`
Define an enum `CuisineType` that specifies various cuisine types:
- ITALIAN
- CHINESE
- MEXICAN
- INDIAN
- FRENCH

This enum will be used to categorize dishes by their cuisine type.

### Interface: `Billable`
Create an interface `Billable` to represent items that can be added to a bill. The `Billable` interface should include:
- `double applyDiscount(double discountRate)`: Calculates the discounted price using the provided discount rate.
- `String getDescription()`: Returns a formatted description of the item, including name, price, and other relevant details.

### Abstract Class: `MenuItem`
Create an abstract class `MenuItem` that represents a menu item in the restaurant. It should:
- Implement the `Billable` interface.
- Include the following attributes:
    - `String code`: Unique identifier for each item.
    - `String name`: Name of the menu item.
    - `double price`: Price of the item.
- Implement `applyDiscount` and `getDescription` as default behaviors for any menu item.
- Provide getter and setter methods for all attributes.

### Class: `Dish`
Create a class `Dish` that inherits `MenuItem`. This class should:
- Have additional attributes:
    - `CuisineType cuisineType`: The type of cuisine.
    - `String mainIngredient`: Main ingredient of the dish.
- Provide a constructor to initialize `code`, `name`, `price`, `cuisineType`, and `mainIngredient`.
- Override `getDescription` to include details about cuisine type and main ingredient.
- Provide getter and setter methods for all attributes.

### Class: `Drink`
Create another class `Drink` that inherits `MenuItem`. This class should:
- Include additional attributes:
    - `double volume`: Volume in milliliters (ml).
- Provide a constructor to initialize `code`, `name`, `price`, and `volume`.
- Override `getDescription` to include information about volume.
- Provide getter and setter methods for all attributes.

### Generic Class: `TableReservation<T extends MenuItem & Billable>`
Define a generic `TableReservation` class to represent a table reservation for customers, where `T` can be any type that extends `MenuItem` and implements `Billable`. This class should:
- Include the following attributes:
    - `String reservationId`: Unique identifier for the reservation.
    - `Date reservationDate`: The date and time of the reservation.
    - `HashMap<T, Integer> orderedItems`: A map of items and their quantities ordered during the reservation.
    - `int tableNumber`: Table number assigned to the reservation.
- Include a constructor to initialize `reservationId`, `reservationDate`, and `tableNumber`.
- Provide a method `addItemToOrder(T item, int quantity)` to add an item to the reservation’s order.
- Implement `double calculateTotalAmount()`, which calculates the total price of all items in the reservation based on their price, quantity, and any applied discounts.
- Provide getter and setter methods for all attributes.

### Class: `Customer`
Define a `Customer` class to represent customer profiles. This class should:
- Include the following attributes:
    - `String customerId`: Unique identifier for the customer.
    - `String name`: Customer’s name.
    - `String phoneNumber`: Customer’s contact number.
    - `List<TableReservation<? extends MenuItem>> reservations`: List of table reservations associated with the customer.
- Provide a constructor to initialize `customerId`, `name`, and `phoneNumber`.
- Include a method `addReservation(TableReservation<? extends MenuItem> reservation)` to add a reservation to the customer’s reservation history.
- Provide getter and setter methods for all attributes.

### Class: `Restaurant`
Create a `Restaurant` class to represent the restaurant itself. This class should:
- Include the following attributes:
    - `String restaurantName`: Name of the restaurant.
    - `List<Customer> customers`: List of customers who have made reservations.
    - `Map<String, MenuItem> menuItems`: A map of menu items (both `Dish` and `Drink`) available in the restaurant.
- Provide methods:
    - `void addCustomer(Customer customer)`: Adds a new customer to the restaurant.
    - `void addMenuItem(MenuItem item)`: Adds a new item (`Dish` or `Drink`) to the menu.
    - `Customer getCustomer(String customerId)`: Retrieves a customer by ID.
    - `void displayMenu()`: Prints all available menu items with descriptions.
    - `double calculateTotalSales()`: Calculates the total sales revenue from all reservations.

### Class: `MainApplication`
In the `MainApplication` class, demonstrate the functionality of the restaurant management system by:
- Creating instances of `Dish` and `Drink` with various attributes.
- Adding these items to the restaurant’s menu.
- Creating a `TableReservation<Dish>` and a `TableReservation<Drink>`, adding items to each reservation.
- Creating a `Customer`, adding both dish and drink reservations to this customer.
- Adding the customer to the restaurant and displaying their reservation history.
- Calculating and displaying total sales for the restaurant.

## Example Scenario
- Create instances of `Dish` and `Drink` with unique attributes (e.g., cuisine type and main ingredient for `Dish`, volume for `Drink`).
- Add the items to the restaurant’s menu.
- Create reservations for both `Dish` and `Drink` items.
- Create a `Customer` who makes multiple reservations with both dish and drink items.
- Add the customer to the restaurant’s system, and display their reservation history.
- Calculate total sales for the restaurant, considering all reservations.