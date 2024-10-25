package org.example;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a client socket and connect to the server at localhost on port 8080
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            // Setup input and output streams
            BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Get user input
            System.out.print("Enter a phrase: ");
            String userInput = inputFromUser.readLine();

            // Send user input to the server
            outputToServer.writeBytes(userInput + "\n");

            // Receive and print the response from the server
            String serverResponse = inputFromServer.readLine();
            System.out.println("Received from server: " + serverResponse);

            // Close the socket
            socket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
