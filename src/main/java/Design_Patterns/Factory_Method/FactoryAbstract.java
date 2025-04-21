package Design_Patterns.Factory_Method;

abstract class Payment {
    abstract void processPayment();

    void commonPaymentLogic() {
        System.out.println("Initiating payment process...");
    }
}


class CreditCardPayment extends Payment {
    void processPayment() {
        commonPaymentLogic();
        System.out.println("Using credit card...");
    }
}

class PayPalPayment extends Payment {
    void processPayment() {
        commonPaymentLogic();
        System.out.println("Using Paypal...");
    }
}

abstract class PaymentFactory {
    abstract Payment createPayment(String paymentType);
}

class ConcretePaymentFactory extends PaymentFactory {
    public Payment createPayment(String paymentType) {
        if(paymentType.equals("credit")) {
            return new CreditCardPayment();
        } else if (paymentType.equals("paypal")) {
            return new PayPalPayment();
        } else
            throw new IllegalArgumentException();
    }
}

class Main03 {
    public static void main(String[] args) {
        ConcretePaymentFactory factory = new ConcretePaymentFactory();
        Payment first = factory.createPayment("credit");
        first.processPayment();
    }
}
