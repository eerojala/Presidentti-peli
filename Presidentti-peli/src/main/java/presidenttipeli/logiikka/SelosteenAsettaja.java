
package presidenttipeli.logiikka;

import java.util.ArrayList;
import java.util.Scanner;
import presidenttipeli.domain.SelosteenOmaava;


public class SelosteenAsettaja {

    public void asetaSelosteet(ArrayList<SelosteenOmaava> lista, Scanner lukija) {
    StringBuilder seloste = new StringBuilder("");
        int indeksi = 0;
        while (lukija.hasNext()) {
            String rivi = lukija.nextLine();
            if (rivi.isEmpty()) {
                lista.get(indeksi).setSeloste(seloste.toString());
                seloste = new StringBuilder("");
                indeksi++;
            } else {
                seloste.append(rivi + "\n");
            }
        }
    }
    
    
}
