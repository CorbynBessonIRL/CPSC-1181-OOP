package com.example.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private static int guestCount = 0;

    private final Socket socket;
    private final ChatServer server;
    private BufferedReader input;
    private PrintWriter output;
    private String username;

    public ClientHandler(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            String firstLine = input.readLine();
            if (firstLine != null && firstLine.startsWith("USERNAME|")) {
                username = firstLine.substring("USERNAME|".length()).trim();
            }
            if (username == null || username.isEmpty()) {
                username = nextGuestName();
            }

            server.addClient(this);
            System.out.println(username + " connected.");
            System.out.println("Current clients: " + server.getClientCount());
            server.broadcast("System: " + username + " joined the chat.");

            String line;
            while ((line = input.readLine()) != null) {
                if (line.startsWith("MESSAGE|")) {
                    String messageText = line.substring("MESSAGE|".length());
                    server.broadcast(username + ": " + messageText);
                } else if (line.equals("QUIT")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Connection lost for " + username);
        } finally {
            server.removeClient(this);
            if (username != null) {
                server.broadcast("System: " + username + " left the chat.");
                System.out.println(username + " disconnected.");
            }
            try {
                socket.close();
            } catch (IOException e) {
                // socket already closed
            }
        }
    }

    public void send(String message) {
        if (output != null) {
            output.println(message);
        }
    }

    private static synchronized String nextGuestName() {
        guestCount++;
        return "Guest" + guestCount;
    }
}
