
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;


public class LiikkeisiinVaikuttavaTapahtuma implements Tapahtuma{
    private Liike liike;
    private boolean pelaajalleLiike;

    public LiikkeisiinVaikuttavaTapahtuma(Liike liike, boolean pelaajalleLiike) {
        this.liike = liike;
        this.pelaajalleLiike = pelaajalleLiike;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
       if (pelaajalleLiike) {
           return pelaaja.getOmistamatLiikkeet().add(liike);
       } else {
           // Ohjelma syöttää tapahtumalle poistotilanteessa pelaajan omistaman mökin
           return pelaaja.getOmistamatLiikkeet().remove(liike);
       }
    }
    
    
}
