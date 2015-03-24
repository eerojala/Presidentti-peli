
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class OtaLiikekortti implements Tapahtuma{
    private Pelilauta lauta;

    public OtaLiikekortti(Pelilauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Liike liike = lauta.getLiikkeet().getFirst();
        Tapahtuma tapahtuma = new LiikkeisiinVaikuttavaTapahtuma(liike, true, lauta);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }
    
    
}
