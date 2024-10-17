package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.in;

public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8089);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {


            out.println("Hello");


            String name = in.readLine();
            System.out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        } catch (IOException e) {
            System.err.println("Error occurred while communicating with the server: " + e.getMessage());
        }
    }
}

