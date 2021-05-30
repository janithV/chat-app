package com.company.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient2 {


    public static void main(String[] args) throws IOException {


        Socket socket= new Socket("localhost", 6000);

        Client client=new Client(socket);
        System.out.println("Client connected to server");

        Scanner input = new Scanner(System.in);

        String clientMessage="";

        while (input.hasNext()){
            clientMessage=input.nextLine();
            client.sendMessage(clientMessage);
            if (clientMessage.equalsIgnoreCase("exit")){
                break;
            }


        }

        //send data to the server
//        client.sendMessage("hello from the client");
//        client.sendMessage("how are you?");
//        client.sendMessage("Im fine");
//        client.sendMessage("Thank you!");
//        client.sendMessage("exit");

////        get data from the server
//        InputStream input= socket.getInputStream();
//        BufferedReader reader= new BufferedReader(new InputStreamReader(input));
//
//        String dataFromServer= reader.readLine();
//
//        System.out.println("Data received from server :" + dataFromServer);







    }
}
