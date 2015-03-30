
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class LiikkeistaTaiMokeistaRiippuvaTapahtuma implements Tapahtuma{
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;

    public LiikkeistaTaiMokeistaRiippuvaTapahtuma(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        this.tapahtuma1 = tapahtuma1;
        this.tapahtuma2 = tapahtuma2;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (!pelaaja.getOmistamatLiikkeet().isEmpty() || !pelaaja.getOmistamatMokit().isEmpty()) {
            return tapahtuma1.suoritaTapahtuma(pelaaja);
        } else {
            return tapahtuma2.suoritaTapahtuma(pelaaja);
        }
    }
    
    
}
