package Threads.LabExercises;


class ChatApplication {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start(12345); // Replace with desired port
    }
}