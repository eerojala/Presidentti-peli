
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma implements Tapahtuma{
    private Tapahtuma tapahtuma1;
    private Tapahtuma tapahtuma2;

    public JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        this.tapahtuma1 = tapahtuma1;
        this.tapahtuma2 = tapahtuma2;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaaja.getAmmatti().isJohtaja() || pelaaja.isKansanedustaja()) {
            return tapahtuma1.suoritaTapahtuma(pelaaja);
        } else {
            return tapahtuma2.suoritaTapahtuma(pelaaja);
        }
    }
    
    
}
