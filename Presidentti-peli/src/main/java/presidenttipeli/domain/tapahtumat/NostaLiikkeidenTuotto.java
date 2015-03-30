
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;


public class NostaLiikkeidenTuotto implements Tapahtuma{

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        for (Liike liike : pelaaja.getOmistamatLiikkeet()) {
            Tapahtuma tapahtuma = new RahaanVaikuttavaTapahtuma(true, liike.getTuotto());
            tapahtuma.suoritaTapahtuma(pelaaja);
        }
        return true;
    }
    
}
