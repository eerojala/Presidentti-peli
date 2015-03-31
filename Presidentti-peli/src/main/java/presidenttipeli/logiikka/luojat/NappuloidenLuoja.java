
package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;


public class NappuloidenLuoja extends Luoja{
    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Nappula> nappulat;
    
    public NappuloidenLuoja(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        nappulat = new ArrayList();
    }

    @Override
    public void luo() {
       for (Pelaaja pelaaja : pelaajat) {
           Nappula nappula = new Nappula(pelaaja);
           pelaaja.setNappula(nappula);
           nappulat.add(nappula);
       }
    }

    public ArrayList<Nappula> getNappulat() {
        return nappulat;
    }
    
}
