
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;


public class MaksaKulujaLiikkeistaJaMokeista implements Tapahtuma{
    private int maksettavaHinta;

    public MaksaKulujaLiikkeistaJaMokeista(int maksettavaHinta) {
        this.maksettavaHinta = maksettavaHinta;
    }
    
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        int maksettavaSumma = 0 +
                pelaaja.getOmistamatLiikkeet().size() * maksettavaHinta +
                pelaaja.getOmistamatMokit().size() * maksettavaHinta;

        Tapahtuma tapahtuma = new RahaanVaikuttavaTapahtuma(false, maksettavaSumma);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }
    
}
