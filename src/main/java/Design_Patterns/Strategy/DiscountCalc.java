package Design_Patterns.Strategy;

interface DiscountStrategy {
    double applyDiscount(double amount);
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount;
    }
}

class StudentDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.85; // 15% popusta
    }
}

class BlackFridayDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.60; // 40% popusta
    }
}

class Checkout {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void pay(double amount) {
        double discounted = discountStrategy.applyDiscount(amount);
        System.out.println("Final price after discount: " + discounted);
    }
}

class Main007 {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.setDiscountStrategy(new StudentDiscount());
        checkout.pay(100);

        checkout.setDiscountStrategy(new BlackFridayDiscount());
        checkout.pay(100);
    }
}
