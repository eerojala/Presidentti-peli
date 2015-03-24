
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

public class OtaTapahtumakortti implements Tapahtuma{
    private Pelilauta lauta;

    public OtaTapahtumakortti(Pelilauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Tapahtuma tapahtuma = lauta.getTapahtumakortit().getFirst();
        tapahtuma.suoritaTapahtuma(pelaaja);
        lauta.getTapahtumakortit().add(tapahtuma);
        return true;
    }
    
    
}
