
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Tutkinto;


public class TutkintoonVaikuttavaTapahtuma implements Tapahtuma{
    private boolean pelaajalleTutkinto;
    private boolean yleissivistava;

    public TutkintoonVaikuttavaTapahtuma(boolean pelaajalleTutkinto, boolean yleissivistava) {
        this.pelaajalleTutkinto = pelaajalleTutkinto;
        this.yleissivistava = yleissivistava;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaajalleTutkinto) {
            if (yleissivistava) {
                pelaaja.setTutkinto(new Tutkinto(true));
            } else {
                pelaaja.setTutkinto(new Tutkinto(false));
            }
        } else {
            pelaaja.setTutkinto(null);
        }
        return true;
    }
    
    
}
