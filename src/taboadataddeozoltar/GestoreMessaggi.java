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
    private String tipoRichiesta;
    private String richiesta;
    
    public GestoreMessaggi(String messaggio) {
        String[] m = messaggio.split("_");
        tipoRichiesta = m[0];
        richiesta = m[1];
    }
}
