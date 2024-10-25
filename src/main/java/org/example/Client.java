package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a client socket and connect to the server at localhost on port 8080
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            // Setup input and output streams
            ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            // Get user input
            System.out.print("Enter the first operand: ");
            double operand1 = scanner.nextDouble();
            System.out.print("Enter the operator (+, -, *, /): ");
            String operator = scanner.next();
            System.out.print("Enter the second operand: ");
            double operand2 = scanner.nextDouble();

            // Create an Operation object
            Operation operation = new Operation(operand1, operand2, operator);

            // Send the Operation object to the server
            outputToServer.writeObject(operation);

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
