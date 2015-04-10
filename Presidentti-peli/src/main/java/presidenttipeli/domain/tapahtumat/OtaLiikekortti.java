package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka ottaa korttipinon päälimmäisen Liikekortin
 */
public class OtaLiikekortti implements Tapahtuma {

    private Pelilauta lauta;

    public OtaLiikekortti(Pelilauta lauta) {
        this.lauta = lauta;
    }

    /**
     * Metodi joka ottaa pelilaudan korttipinon päälimmäisen liikekortin ja
     * antaa sen pelaajalle.
     *
     * @param pelaaja Pelaaja joka saa korttipinon päälimmäisen liikkeen
     * @return Onnistuiko liikkeen antaminen pelaajalle
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Liike liike = lauta.getLiikkeet().pollFirst();
        Tapahtuma tapahtuma = new LiikkeisiinVaikuttavaTapahtuma(liike, true, lauta);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }

}
