package Design_Patterns.Singleton;

class DatabaseConnection {
    private static DatabaseConnection instance;
    private boolean connected = false;

    private DatabaseConnection() {}

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        if (!connected) {
            System.out.println("Connecting to DB...");
            connected = true;
        } else {
            System.out.println("Already connected!");
        }
    }

    public void disconnect() {
        if (connected) {
            System.out.println("Disconnecting...");
            connected = false;
        }
    }

    public boolean isConnected() {
        return connected;
    }
}

class Main03 {
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        conn1.connect();

        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        System.out.println(conn2.isConnected());

        conn2.disconnect();
    }
}
