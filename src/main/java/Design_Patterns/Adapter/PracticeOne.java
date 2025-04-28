package Design_Patterns.Adapter;

interface OldPaymentSystem {
    void processPayment(double amount);
}

interface NewPaymentSystem {
    void makePayment(double amount, String currency);
}

class OldPaymentSystemImpl implements OldPaymentSystem {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " using old system.");
    }
}

class PaymentAdapter implements NewPaymentSystem {
    private OldPaymentSystem oldPaymentSystem;

    public PaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }

    public void makePayment(double amount, String currency) {
        System.out.println("Converting currency to USD...");
        oldPaymentSystem.processPayment(amount);
    }
}
