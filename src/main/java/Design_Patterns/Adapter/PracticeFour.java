package Design_Patterns.Adapter;

interface OldNotificationSystem {
    void sendEmail(String subject, String body);
    void sendSMS(String number, String message);
}

interface NewNotificationSystem {
    void notify(String type, String recipient, String content);
}

class OldNotificationSystemImpl implements OldNotificationSystem {
    public void sendEmail(String subject, String body) {
        System.out.println("Email sent: " + subject + " - " + body);
    }

    public void sendSMS(String number, String message) {
        System.out.println("SMS sent to " + number + ": " + message);
    }
}

class NotificationAdapter implements NewNotificationSystem {
    private OldNotificationSystem oldSystem;

    public NotificationAdapter(OldNotificationSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    public void notify(String type, String recipient, String content) {
        if (type.equalsIgnoreCase("email")) {
            oldSystem.sendEmail("No Subject", content);
        } else if (type.equalsIgnoreCase("sms")) {
            oldSystem.sendSMS(recipient, content);
        } else {
            System.out.println("Notification type not supported.");
        }
    }
}
