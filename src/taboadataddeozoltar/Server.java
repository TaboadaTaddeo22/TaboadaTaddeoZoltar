/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taboadataddeozoltar;

import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

/**
 *
 * @author taboada.taddeo
 */
public class Server {
    private int porta = 12345;
    private ServerSocket server;
    private Personalita personalita = new Zoltar();   // default
    private JTextArea output;
    
    public Server(JTextArea output) {
        this.output = output;
    }
 
    // Apre la porta subito, poi aspetta il client in un thread
    public void avvia() throws IOException {
        server = new ServerSocket(porta);
        new Thread(() -> {
            try {
                servi();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
 
    private void servi() throws IOException {
        Socket client = server.accept();
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
 
        out.writeUTF("Ciao sono Zoltar, l'oracolo che risponderà ad ogni tua domanda.\n"
            + "Puoi utilizzare i seguenti comandi:\n"
            + "PER_{personalita'} per scegliere con chi parlare\n"
            + "DOM_{domanda} per scrivere la tua domanda\n"
            + "HELP per ricevere informazioni sul programma");
 
        while (true) {
            String richiesta = in.readUTF();
            out.writeUTF(elabora(richiesta));
        }
    }
    
    private String elabora(String richiesta) {
        String[] parti = richiesta.split("_", 2);
        String comando = parti[0];
        String argomento = parti.length > 1 ? parti[1] : "";
 
        if (comando.equals("PER")) {
            Personalita nuova = new Zoltar();
            if (argomento.equals("Eldego")) {
                nuova = new Eldego();
            } else if (argomento.equals("Sindaco")) {
                nuova = new Sindaco();
            }
            personalita = nuova;
            return "Personalita' cambiata";
        } else if (comando.equals("DOM")) {
            return personalita.risposta();
        } else {
            return "Comando non riconosciuto";
        }
    }
    
    public void mostra(String testo) {
        output.append(testo + "\n");
    }
}
