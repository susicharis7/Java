package Design_Patterns.Singleton;

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void readOut(String message) {
        System.out.println(message);
    }
}

class Main01 {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        firstLogger.readOut("Hello");

        Logger secondLogger = Logger.getInstance();
        secondLogger.readOut("Hello again!");

        System.out.println(firstLogger == secondLogger);
    }
}