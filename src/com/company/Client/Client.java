package com.company.Client;

import java.io.*;
import java.net.Socket;

public class Client {

    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;

    public Client(Socket socket) throws IOException {
        this.outputStream = new DataOutputStream(socket.getOutputStream());
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Client is running");
    }

    public void sendMessage(String message) throws IOException {
        System.out.println("client says :"+message);
        this.outputStream.writeBytes(message+"\n");
        String dataFromServer = bufferedReader.readLine();
        System.out.println("Server says :" + dataFromServer);
    }
}
