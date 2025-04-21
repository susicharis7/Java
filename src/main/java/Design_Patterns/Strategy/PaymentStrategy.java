package Design_Patterns.Strategy;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayments implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayments(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " with credit card! - Credit card number: " + cardNumber);
    }
}

class PaypalPayments implements PaymentStrategy {
    private String email;

    public PaypalPayments(String email) {
        this.email = email;
    }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " Using paypal! - Email: " + email);
    }
}

class ShoppingCartMain {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkOut(int amount) {
        paymentStrategy.pay(amount);
    }
}


class Main01 {
    public static void main(String[] args) {
        CreditCardPayments payments = new CreditCardPayments("1050440213");
        payments.pay(500);

        ShoppingCartMain scm = new ShoppingCartMain();
        scm.setPaymentStrategy(payments);
        scm.checkOut(200);

    }
}