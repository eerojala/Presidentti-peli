package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

public class KansanedustajuuteenVaikuttavaTapahtuma implements Tapahtuma{
    private boolean pelaajalleKansanedustajuus;

    public KansanedustajuuteenVaikuttavaTapahtuma(boolean pelaajalleKansanedustajuus) {
        this.pelaajalleKansanedustajuus = pelaajalleKansanedustajuus;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setKansanedustaja(pelaajalleKansanedustajuus);
        return true;
    }
    
    
}
