
package presidenttipeli.domain.tapahtumat;

import java.util.Collections;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class MokkiPalaa implements Tapahtuma{
    Pelilauta lauta;

    public MokkiPalaa(Pelilauta lauta) {
        this.lauta = lauta;
    }
    
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaaja.getOmistamatMokit().isEmpty()) {
            return false;
        }
        Collections.sort(pelaaja.getOmistamatMokit());
        Mokki mokki = pelaaja.getOmistamatMokit().get(0);
        Tapahtuma tapahtuma = new MokkeihinVaikuttavaTapahtuma(mokki, false, lauta);
        tapahtuma.suoritaTapahtuma(pelaaja);
        tapahtuma = new RahaanVaikuttavaTapahtuma(true, mokki.getArvo()/2);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }
    
}
