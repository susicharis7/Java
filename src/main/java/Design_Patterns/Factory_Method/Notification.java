package Design_Patterns.Factory_Method;

interface Notification {
    void sendNotification();
}

class EmailNotification implements Notification {
    public void sendNotification() {
        System.out.println("Sending by email...");
    }
}

class SMSNotification implements Notification {
    public void sendNotification() {
        System.out.println("Sending by SMS...");
    }
}

class NotificationFactory {
    public Notification notificationType(String type) {
        if(type.equals("SMS")) {
            return new SMSNotification();
        } else if(type.equals("Email")) {
            return new EmailNotification();
        } else
            throw new IllegalArgumentException("Not good type: " + type);
    }
}

class Mainest01 {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification first = factory.notificationType("SMS");
        first.sendNotification();

        Notification second = factory.notificationType("Email");
        second.sendNotification();
    }
}