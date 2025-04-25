package Practice;

import java.util.*;

enum CuisineType {
    ITALIAN,
    CHINESE,
    MEXICAN,
    INDIAN,
    FRENCH
}

interface Billable {
    double applyDiscount(double discountRate);
    String getDescription();
}

abstract class MenuItem implements Billable {
    String code;
    String name;
    double price;

    public MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double applyDiscount(double discountRate) {
        return this.price * (1 - discountRate);
    }

    @Override
    public String getDescription() {
        return "Code: " + this.code + " , name: " + this.name + " , price: " + this.price;
    }
}

class Dish extends MenuItem {
    CuisineType cuisineType;
    String mainIngredient;

    public Dish(String code, String name, double price, CuisineType cuisineType, String mainIngredient) {
        super(code,name,price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    public CuisineType getCuisineType() {
        return this.cuisineType;
    }
    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }
    public String getMainIngredient() {
        return this.mainIngredient;
    }
    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " , Cuisine Type: " + this.cuisineType + ", main Ingredient: " + this.mainIngredient;
    }
}

class Drink extends MenuItem {
    double volume;

    public Drink(String code, String name, double price, double volume) {
        super(code,name,price);
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " , volume: " + this.volume;
    }
}

class TableReservation<T extends MenuItem> {
    String reservationId;
    Date reservationDate;
    HashMap<T, Integer> orderedItems;
    int tableNumber;

    public TableReservation(String reservationId, Date reservationDate, int tableNumber) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        this.orderedItems = new HashMap<>();
    }

    public String getReservationId() {
        return this.reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public Date getReservationDate() {
        return this.reservationDate;
    }
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    public HashMap<T,Integer> getOrderedItems() {
        return this.orderedItems;
    }
    public void setOrderedItems(HashMap<T,Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public void addItemToOrder(T item, int quantity) {
        orderedItems.put(item,quantity);
    }

    double calculateTotalAmount() {
        double total = 0;
        for(Map.Entry<T, Integer> entry : orderedItems.entrySet()) {
            double itemPrice = entry.getKey().applyDiscount(0.1);
            total += itemPrice * entry.getValue();
        } return total;
    }

}

class Customer {
    String customerID;
    String name;
    String phoneNumber;
    List<TableReservation<? extends MenuItem>> reservations;

    public Customer(String customerID, String name, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<>();
    }

    public String getCustomerID() {
        return this.customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<TableReservation<? extends MenuItem>> getReservation() {
        return this.reservations;
    }
    public void setReservations(List<TableReservation<? extends MenuItem>> reservation) {
        this.reservations = reservations;
    }

    public void addReservation(TableReservation<? extends MenuItem> reservation) {
        reservations.add(reservation);
    }
}

class Restaurant {
    String restaurantName;
    List<Customer> customers;
    Map<String, MenuItem> menuItems;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
        this.customers = new ArrayList<>();
        this.menuItems = new HashMap<>();
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public List<Customer> getCustomers() {
        return this.customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public Map<String,MenuItem> getMenuItems() {
        return this.menuItems;
    }
    public void setMenuItems(Map<String,MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addMenuItem(MenuItem item) {
        menuItems.put(item.getCode(),item);
    }

    public Customer getCustomer(String customerID) {
        for (Customer allCustomers : customers) {
            if(allCustomers.getCustomerID().equals(customerID)) {
                return allCustomers;
            }
        } return null;
    }

    public void displayMenu() {
        for(MenuItem allItems : menuItems.values()) {
            System.out.println(allItems.getDescription());
        }
    }



    public double calculateTotalSales() {
        double totalSales = 0;
        for (Customer allCustomers : customers) {
            for (TableReservation<? extends MenuItem> reservation : allCustomers.getReservation()) {
                totalSales += reservation.calculateTotalAmount();
            }
        } return totalSales;
    }


}