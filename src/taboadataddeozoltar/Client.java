/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taboadataddeozoltar;


import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author CASOLARO.DIEGO
 */
public class Client {

     /**
     * @param args the command line arguments
     */
    public void utente() throws IOException {
        String ip = "localhost";
        int porta = 12345;
        Socket socket = new Socket(ip,porta);
        Scanner scanner = new Scanner(System.in);
        
        String message, response;
        
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        
        response = dataInputStream.readUTF(); // Su response ho la risposta
        System.out.println(response);
        dataOutputStream.writeUTF("Ciao io sono Eldego e sono collegato!");
        response = dataInputStream.readUTF(); // Su response ho la risposta
        System.out.println(response);
        
        /*
        if(response=="Arrivederci"){
            socket.close();
        }
        else{
            do{
                System.out.println("messaggia:");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);

                response = dataInputStream.readUTF(); // Su response ho la risposta
                System.out.println(response);
            } while(!response.equals("Arrivederci")||!message.equals("Arrivederci"));
            socket.close();
        }
        */
    }    
}
