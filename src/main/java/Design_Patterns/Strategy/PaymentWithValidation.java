package Design_Patterns.Strategy;

interface PaymentStrategyS {
    boolean pay(int amount);
}

class CardPayment implements PaymentStrategyS {
    public boolean pay(int amount) {
        System.out.println("Trying card payment...");
        return false; // Simuliraj neuspjeh
    }
}

class BackupPaypalPayment implements PaymentStrategyS {
    public boolean pay(int amount) {
        System.out.println("Using backup PayPal payment!");
        return true;
    }
}

class SafeCheckout {
    private PaymentStrategyS primary;
    private PaymentStrategyS backup;

    public SafeCheckout(PaymentStrategyS primary, PaymentStrategyS backup) {
        this.primary = primary;
        this.backup = backup;
    }

    public void checkOut(int amount) {
        if (!primary.pay(amount)) {
            System.out.println("Primary failed, switching to backup...");
            backup.pay(amount);
        }
    }
}

class Main001 {
    public static void main(String[] args) {
        SafeCheckout checkout = new SafeCheckout(
                new CardPayment(),
                new BackupPaypalPayment()
        );

        checkout.checkOut(250);
    }
}
