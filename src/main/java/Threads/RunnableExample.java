package Threads;

class RunnableExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CounterRunnable("A"));
        Thread thread2 = new Thread(new CounterRunnable("B"));

        thread1.start();
        thread2.start();
    }
}
