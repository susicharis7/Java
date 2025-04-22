package Threads;

class CounterRunnable implements Runnable {
    private String threadName;

    public CounterRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + threadName + ": Count " + i);
            try {
                Thread.sleep(1000); // Pauza od 1 sekunde
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}
