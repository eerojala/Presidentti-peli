
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Tapahtumakortti;

public class OtaTapahtumakortti implements Tapahtuma{
    private Pelilauta lauta;

    public OtaTapahtumakortti(Pelilauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Tapahtumakortti kortti = lauta.getTapahtumakortit().pollFirst();
        for (Tapahtuma tapahtuma : kortti.getTapahtumat()) {
            tapahtuma.suoritaTapahtuma(pelaaja);
        }
        lauta.getTapahtumakortit().add(kortti);
        return true;
    }
    
    
}
