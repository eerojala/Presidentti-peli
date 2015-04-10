package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka ei tee mitään.
 */
public class TapahtumaJokaEiTeeMitaan implements Tapahtuma {

    /**
     * Metodi ei tee mitään muuta kuin palauta true
     *
     * @param pelaaja Pelaaja jolle tapahtuma suoritetaan
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        return true;
    }

}
