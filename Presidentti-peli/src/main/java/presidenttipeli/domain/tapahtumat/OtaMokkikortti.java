package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka antaa pelaajalle pelilaudan päälimmäisen mökin.
 */
public class OtaMokkikortti implements Tapahtuma {

    private Pelilauta lauta;

    public OtaMokkikortti(Pelilauta lauta) {
        this.lauta = lauta;
    }

    /**
     * Metodi ottaa laudan päälimmäisen mökin ja antaa sen pelaajalle.
     *
     * @param pelaaja Pelaaja joka saa mökin
     * @return Onnistuiko mökin antaminen pelaajalle
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Mokki mokki = lauta.getMokit().pollFirst();
        Tapahtuma tapahtuma = new MokkeihinVaikuttavaTapahtuma(mokki, true, lauta);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }

}
