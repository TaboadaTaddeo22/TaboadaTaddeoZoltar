/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taboadataddeozoltar;

/**
 *
 * @author taboada.taddeo
 */
public class GestoreMessaggi {
    // Attributi
    private Client c;
    
    public GestoreMessaggi(Client c) {
        this.c = c;
    }
    
    public void inputUtente(String messaggio) {
        String[] m = messaggio.split("_");
        String tipoRichiesta = m[0];
        String richiesta = m[1];
        
        if (m.length > 1 && tipoRichiesta.equals("PER")) {
            personalita();
        } else if (m.length > 1 && tipoRichiesta.equals("DOM")) {
            domanda();
        } else if (m[0].equals("HELP")) {
            help();
        } else {
            return;
        }
    }
    
    public void personalita() {
        
    }
    
    public void domanda() {
        
    }
    
    public void help() {
        
    }
}
