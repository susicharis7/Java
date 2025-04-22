package Threads;

class JoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        });

        thread1.start();
        try {
            thread1.join(); // Čekanje da se thread1 završi
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        thread2.start();
    }
}
