package com.company.Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client=socket;
    }

    @Override
    public void run() {
        try {
            //Thread.sleep(20000); //waiting for 20s
            //get data from the client
            InputStream inputStream = this.client.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = this.client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String inputData;
            String outputData;
            Scanner input = new Scanner(System.in);
            while((inputData=bufferedReader.readLine()) !=null){

                System.out.println("client says :"+inputData );

                if(inputData.equals("exit")){
                    System.out.println("");
                    dataOutputStream.writeBytes("good bye!");
                    break;
                }else {
                    outputData=input.nextLine();
                    System.out.println("server says :"+outputData);
                    dataOutputStream.writeBytes(outputData+"\n");
                }

//                switch (inputData){
//                    case "hello from the client":
//                        dataOutputStream.writeBytes("Hello from the server side \n");
//                        break;
//                    case "how are you?":
//                        dataOutputStream.writeBytes("Im fine. how are you? \n");
//                        break;
//                    case "Im fine":
//                        dataOutputStream.writeBytes("Good to know \n");
//                        break;
//                    case "Thank you!":
//                        dataOutputStream.writeBytes("You are welcome \n");
//                        break;
//                    default:
//                        dataOutputStream.writeBytes(" Sorry i didnt understand that. \n");
//                }


            }
            System.out.println("Client finished execution!");
            System.out.println("");

//        //close client port
            this.client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
