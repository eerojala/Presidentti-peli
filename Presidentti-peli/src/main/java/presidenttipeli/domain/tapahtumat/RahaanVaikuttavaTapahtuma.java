
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class RahaanVaikuttavaTapahtuma extends Tapahtuma{
    private boolean pelaajalleRahaa; // jos true niin pelaaja saa rahaa, jos false niin pelaajalta otetaan rahaa
    private int summa;
    
    public RahaanVaikuttavaTapahtuma(boolean pelaajalleRahaa, int summa) {
        this.pelaajalleRahaa = pelaajalleRahaa;
        this.summa = summa;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        int pelaajanRahat = pelaaja.getRahaa();
        
        if (pelaajalleRahaa) {
            pelaaja.setRahaa(pelaajanRahat + summa);
            return true;
        } else if (pelaajanRahat >= summa) {
            pelaaja.setRahaa(pelaajanRahat - summa);
            return true;
        }
        return false;
    }
    
    
}
