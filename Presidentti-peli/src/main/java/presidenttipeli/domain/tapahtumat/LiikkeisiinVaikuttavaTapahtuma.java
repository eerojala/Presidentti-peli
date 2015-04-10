package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka antaa tai ottaa pelaajalta liikkeen
 */
public class LiikkeisiinVaikuttavaTapahtuma implements Tapahtuma {

    private Liike liike;
    private boolean pelaajalleLiike;
    private Pelilauta lauta;

    public LiikkeisiinVaikuttavaTapahtuma(Liike liike, boolean pelaajalleLiike, Pelilauta lauta) {
        this.liike = liike;
        this.pelaajalleLiike = pelaajalleLiike;
        this.lauta = lauta;
    }

    /**
     * Metodi antaa pelaajalle liikkeen tai ottaa pelaajalta liikkeen ja asettaa
     * sen takaisin laudalle
     *
     * @param pelaaja Pelaaja jolle annetaan tai otetaan liike
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaajalleLiike) {
            pelaaja.getOmistamatLiikkeet().add(liike);
        } else {
            // Ohjelma syöttää tapahtumalle poistotilanteessa pelaajan omistaman mökin
            lauta.getLiikkeet().add(liike);
            pelaaja.getOmistamatLiikkeet().remove(liike);
        }
        return true;
    }

}
