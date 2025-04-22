package Threads;

public class ThreadExample {
    public static void main(String[] args) {
        CounterThread thread1 = new CounterThread();
        thread1.start(); // Pokretanje niti
    }
}
