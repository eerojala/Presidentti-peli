
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class TutkintoonVaikuttavaTapahtuma implements Tapahtuma{
    private boolean pelaajalleTutkinto;

    public TutkintoonVaikuttavaTapahtuma(boolean pelaajalleTutkinto) {
        this.pelaajalleTutkinto = pelaajalleTutkinto;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setTutkinto(pelaajalleTutkinto);
        return true;
    }
    
    
}
