
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class OtaMokkikortti implements Tapahtuma{
    private Pelilauta lauta;

    public OtaMokkikortti(Pelilauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Mokki mokki = lauta.getMokit().pollFirst();
        Tapahtuma tapahtuma = new MokkeihinVaikuttavaTapahtuma(mokki, true, lauta);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }
    
    
}
