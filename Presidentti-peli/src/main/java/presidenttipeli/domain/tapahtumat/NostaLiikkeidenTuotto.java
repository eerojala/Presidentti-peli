package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka antaa pelaajalle hänen liikkeidensä tuoton.
 */
public class NostaLiikkeidenTuotto implements Tapahtuma {

    /**
     * Metodi antaa pelaajalle jokaisen hänen omistaman liikkeidensä tuoton
     *
     * @param pelaaja Pelaaja joka saa likkeidensä tuoton
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        for (Liike liike : pelaaja.getOmistamatLiikkeet()) {
            Tapahtuma tapahtuma = new RahaanVaikuttavaTapahtuma(true, liike.getTuotto());
            tapahtuma.suoritaTapahtuma(pelaaja);
        }

        // pelaaja saa liikkeiden tuotot riippumatta siitä onko hänellä oikeus
        // liikkeiden tuottoon.
        return true;
    }

}
