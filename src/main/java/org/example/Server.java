package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server started!");
        int port = 8089;

        try (
                ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");


                try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    out.println("New connection accepted");

                    final String name = in.readLine();


                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                } catch (IOException e) {
                    System.err.println("Error in communication with the client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start the server: " + e.getMessage());
        }
    }
}
