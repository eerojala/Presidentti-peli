package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import presidenttipeli.domain.Pelaaja;

/**
 *  Luojaluokka joka luo pelille pelaajat.
 */
public class PelaajienLuoja extends Luoja {

    private ArrayList<String> nimet;
    private ArrayList<Pelaaja> pelaajat;

    public PelaajienLuoja(ArrayList<String> nimet) {
        this.nimet = nimet;
        pelaajat = new ArrayList();
    }

    @Override
    public void luo() {
        for (String nimi : nimet) {
            pelaajat.add(new Pelaaja(nimi));
        }
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }

}
