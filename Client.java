import java.io.*;
import java.net.*;
import java.util.Random;


public class Client {
    public static void main(String[] args){
        String host="localHost";
        int clientPort=4390;
        int counter=0;
        Random random = new Random();

        try(Socket socket = new Socket(host,clientPort)){
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
           do {

               String token = tokenGenerator.generateToken();
               out.println(token);
               counter++;
               if(counter==25){
                   out.println("EXIT");
               }
               int delay =1000+random.nextInt(5000);
               try{
                   Thread.sleep(delay);
               }catch(InterruptedException e) {
                   e.printStackTrace();
               }
           }while(counter<25);
           String serverResponse = in.readLine();
           System.out.println(serverResponse);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
