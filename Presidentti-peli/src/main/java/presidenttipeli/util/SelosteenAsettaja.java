package presidenttipeli.util;

import java.util.ArrayList;
import java.util.Scanner;
import presidenttipeli.domain.SelosteenOmaava;

/**
 * Luokka joka asettaa ruuduille ja tapahtumakorteille selosteet tiedostosta
 */
public class SelosteenAsettaja {

    /**
     * Asettaa annetuille ruuduille/tapahtumakorteille selosteet jotka luetaan
     * tiedostosta.
     *
     * @param lista Lista ruuduista tai tapahtumakorteista
     * @param lukija Scanner johon on asetettu luettava tiedosto
     */
    public static void asetaSelosteet(ArrayList<SelosteenOmaava> lista, Scanner lukija) {
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
