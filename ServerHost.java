import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerHost {
    public static void main(String[] args){
        int port=4390;
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started. Waiting on client.");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Successfully connected to"+clientSocket);
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("tokens.txt", true));

            BufferedReader clientInput = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientOutput = new PrintWriter(clientSocket.getOutputStream(),true);

            String clientMessage;
            do{
                clientMessage = clientInput.readLine();
                if(clientMessage!=null){
                    System.out.println(clientMessage);
                    fileWriter.write(clientMessage+"*");


                    

                }
            }while(clientMessage != null && !clientMessage.equalsIgnoreCase("EXIT"));

            clientInput.close();
            clientOutput.close();
            clientSocket.close();
            System.out.println("Client Closed.");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
