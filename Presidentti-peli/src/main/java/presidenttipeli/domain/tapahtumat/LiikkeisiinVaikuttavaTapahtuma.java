package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

public class LiikkeisiinVaikuttavaTapahtuma implements Tapahtuma {

    private Liike liike;
    private boolean pelaajalleLiike;
    private Pelilauta lauta;

    public LiikkeisiinVaikuttavaTapahtuma(Liike liike, boolean pelaajalleLiike, Pelilauta lauta) {
        this.liike = liike;
        this.pelaajalleLiike = pelaajalleLiike;
        this.lauta = lauta;
    }

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
