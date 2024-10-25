package org.example;

import java.io.*;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter a phrase: ");
            String userInput = inputFromUser.readLine();

            outputToServer.writeBytes(userInput + "\n");

            String serverResponse = inputFromServer.readLine();
            System.out.println("Received from server: " + serverResponse);

            socket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
