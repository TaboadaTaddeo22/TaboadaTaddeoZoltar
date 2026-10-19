/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taboadataddeozoltar;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JTextArea;

/**
 *
 * @author taboada.taddeo
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public void zoltar(JTextArea output) throws IOException {
        int porta = 12345;
        ServerSocket server = new ServerSocket(porta);
        Socket clientSocket = server.accept();
        String message;
        Scanner scanner = new Scanner(System.in);
       
        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        
        // Primo messaggio
        message = "Ciao sono Zoltar, l'oracolo che risponderà ad ogni tua domanda. \n"
                + "Puoi utilizzare i seguenti comandi: \n"
                + "PER_{personalita'} per scegliere con chi parlare \n"
                + "DOM_{domanda} per scrivere la tua domanda \n"
                + "HELP per ricevere informazioni sul programma \n";
        
        javax.swing.SwingUtilities.invokeLater(() -> output.append(message));
        dataOutputStream.writeUTF(message);
       
        /*
        while (!clientSocket.isClosed()) {
        String clientMessage = dataInputStream.readUTF(); // Su clientMessage ho i dati del Client
        System.out.println("Ricevuto messaggio: " + clientMessage);
        System.out.println("\n");
        
        System.out.println("Scrivi il tuo messaggio:");
        message = scanner.nextLine();
        dataOutputStream.writeUTF(message);
        System.out.println("\n");
        
        if (clientMessage.equals("Arrivederci"))
            clientSocket.close();
        
        };
        
        server.close();
        */
    }
    
}
