package com.company.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Server is running");

        ServerSocket serverSocket= new ServerSocket(6000);
        System.out.println("Server socket is created");

        while (true) {
            Socket client = serverSocket.accept(); //waiting for client
            System.out.println("Client accepted!");

            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();

        }

    }
}

//accept the user inputs using command line
//use a gui for client and server
// encrypt messages
// limit the clients queue