package Threads.LabExercises;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server_ip>");
            return;
        }

        String username = args[0];
        String serverIp = args[1];
        int port = 12345; // Same port used by server

        try {
            Socket socket = new Socket(serverIp, port);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);

            serverWriter.println(username);

            Thread receiverThread = new Thread(() -> {
                String serverMsg;
                try {
                    while ((serverMsg = serverReader.readLine()) != null) {
                        System.out.println(serverMsg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;
            while ((inputLine = userInput.readLine()) != null) {
                serverWriter.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}