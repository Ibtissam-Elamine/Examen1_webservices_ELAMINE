package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);  // Ensure it's on the correct port
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream outputToClient = new DataOutputStream(clientSocket.getOutputStream());

                String clientInput = inputFromClient.readLine();
                System.out.println("Received from client: " + clientInput);

                String response = clientInput.toUpperCase();
                outputToClient.writeBytes(response + "\n");

                clientSocket.close();
                System.out.println("Client connection closed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
