package Design_Patterns.Factory_Method;

abstract class PaymentF {
    abstract void processPayment(double amount);

    void commonPaymentLogic() {
        System.out.println("[INFO] Validating user and initializing gateway...");
    }
}

class CreditCardPaymentF extends PaymentF {
    void processPayment(double amount) {
        commonPaymentLogic();
        System.out.println("Charged $" + amount + " using Credit Card.");
    }
}

class PayPalPaymentF extends PaymentF {
    void processPayment(double amount) {
        commonPaymentLogic();
        System.out.println("Charged $" + amount + " using PayPal.");
    }
}

class CryptoPaymentF extends PaymentF {
    void processPayment(double amount) {
        commonPaymentLogic();
        System.out.println("Transferred $" + amount + " using Cryptocurrency.");
    }
}

abstract class PaymentFactoryF {
    abstract PaymentF createPayment(String paymentType, boolean isUserVerified);
}

class SecurePaymentFactoryF extends PaymentFactoryF {
    public PaymentF createPayment(String paymentType, boolean isUserVerified) {
        if (!isUserVerified) {
            throw new SecurityException("User is not verified!");
        }

        switch (paymentType.toLowerCase()) {
            case "credit": return new CreditCardPaymentF();
            case "paypal": return new PayPalPaymentF();
            case "crypto": return new CryptoPaymentF();
            default: throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}

class MainSecure {
    public static void main(String[] args) {
        PaymentFactoryF factory = new SecurePaymentFactoryF();
        PaymentF p1 = factory.createPayment("paypal", true);
        p1.processPayment(150.75);

        PaymentF p2 = factory.createPayment("crypto", true);
        p2.processPayment(999.99);
    }
}
