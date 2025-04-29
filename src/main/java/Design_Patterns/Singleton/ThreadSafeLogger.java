package Design_Patterns.Singleton;

class ThreadLogger {
    private static volatile ThreadLogger instance;

    private ThreadLogger() {
        System.out.println("Logger initialized...");
    }

    public static ThreadLogger getInstance() {
        if (instance == null) {
            synchronized (ThreadLogger.class) {
                if (instance == null) {
                    instance = new ThreadLogger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class Main007 {
    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadLogger logger = ThreadLogger.getInstance();
            logger.log(Thread.currentThread().getName() + " is logging...");
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
