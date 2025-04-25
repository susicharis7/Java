# 🛒 Marketplace Inventory and Order Management System

## Task Description

You are tasked with developing a basic inventory and order management system for a marketplace. This system should:
- Handle various types of items,
- Organize them into customer orders,
- Support customer profile management.

The design should allow flexibility for future expansion, and you are encouraged to use **interfaces** and **generics** where appropriate.

---

## 📋 Requirements

### `Enum: HoneyType`

Define an `enum` representing types of honey:

```java
public enum HoneyType {
    BAGREMOV,
    LIVADSKI
}
```

---

### `Interface: Sellable`

Create an interface `Sellable` to define essential behaviors for all sellable items:

```java
public interface Sellable {
    double calculateDiscount(double discountRate);
    String getDescription();
}
```

---

### `Class: Item`

An abstract class `Item` that implements `Sellable`. Users cannot instantiate this class.

#### Attributes:
- `private String barcode`
- `private String name`
- `private double price`

#### Features:
- Implements `calculateDiscount` and `getDescription` as default behavior
- Getters and setters for all attributes

---

### `Class: Milk`

Extends `Item`, adds one extra attribute.

#### Attributes:
- `private double fat` – represents fat content

#### Features:
- Constructor initializing `barcode`, `name`, `price`, `fat`
- Override `getDescription` to include fat content
- Getters and setters for `fat`

---

### `Class: Honey`

Also extends `Item`, adds one extra attribute.

#### Attributes:
- `private HoneyType honeyType`

#### Features:
- Constructor initializing `barcode`, `name`, `price`, `honeyType`
- Override `getDescription` to include honey type
- Getters and setters for `honeyType`

---

### `Generic Class: Order<T>`

A generic class `Order<T>` where `T` must extend `Item` and implement `Sellable`.

#### Attributes:
- `private String orderNo`
- `private Date createAt`
- `private HashMap<T, Integer> items` – items and their quantities

#### Features:
- Constructor initializing `orderNo`, `createAt`, `items`
- `addItem(T item, int quantity)` – adds or updates item in the order
- `calculateTotalAmount()` – calculates total price of the order
- Getters and setters for all attributes

---

### `Class: Person`

Represents a customer profile.

#### Attributes:
- `private String name`
- `private int age`
- `private List<Order<? extends Item>> orders`

#### Features:
- Constructor to initialize `name` and `age`
- `addOrder(Order<? extends Item> order)`
- Getters and setters

---

### `Class: MainRun`

Demonstrates system functionality:

- Create instances of `Milk` and `Honey` with various attributes
- Create `Order<Milk>` and `Order<Honey>` and add items
- Create a `Person` and add both orders
- Iterate through order history and display:
    - Item names, prices, and quantities
    - Total amount per order

---

## 🧪 Example Scenario

1. Create two items: `Milk` and `Honey` with unique attributes (e.g., 3.2% fat, BAGREMOV honey)
2. Create two orders: one for milk, one for honey
3. Create a customer who orders both
4. Display:
    - Item descriptions (`getDescription`)
    - Total order amounts
