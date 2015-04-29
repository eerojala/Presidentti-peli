package presidenttipeli.logiikka;

import java.util.ArrayList;

/**
 * AloitusGUIn logiikkaluokka jonka tarkoitus on tarkistaa pelaajien nimien
 * oikeellisuus.
 */
public class Aloitus {

    /**
     * Metodi tarkistaa ovatko pelaajien nimet sallitun mittaisia (1-24 merkin
     * pituisia)
     *
     * @param nimet Annetut nimet
     *
     * @return True jos annetut nimet ovat sallitun mittaisia, muuten false.
     */
    public boolean pituustarkastus(ArrayList<String> nimet) {
        for (String nimi : nimet) {
            if (nimi.isEmpty() || nimi.length() > 24) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi tarkistaa esiintyykö annetuissa nimissä duplikaatteja.
     *
     * @param nimet Annetut nimet.
     *
     * @return True jos duplikaatteja ei esiinny, muuten false.
     */
    public boolean samuustarkastus(ArrayList<String> nimet) {
        boolean samaLoydettyKerran;
        for (String nimi1 : nimet) {
            samaLoydettyKerran = false;
            for (String nimi2 : nimet) {
                if (nimi1.equals(nimi2) && samaLoydettyKerran) {
                    return false;
                } else if (nimi1.equals(nimi2)) {
                    samaLoydettyKerran = true;
                }
            }
        }
        return true;
    }
}
