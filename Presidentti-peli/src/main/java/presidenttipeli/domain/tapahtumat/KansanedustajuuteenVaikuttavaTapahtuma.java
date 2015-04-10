package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka vaikuttaa pelaajan kansanedustajuuteen.
 */
public class KansanedustajuuteenVaikuttavaTapahtuma implements Tapahtuma {

    private boolean pelaajalleKansanedustajuus;

    public KansanedustajuuteenVaikuttavaTapahtuma(boolean pelaajalleKansanedustajuus) {
        this.pelaajalleKansanedustajuus = pelaajalleKansanedustajuus;
    }

    /**
     * Metodi antaa pelaajalle kansanedustajuuden tai ottaa sen pois riippuen
     * konstrukorille annetusta totuusarvosta.
     *
     * @param pelaaja Pelaaja jonka kansanedustajuuteen vaikutetaan
     * @return aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setKansanedustaja(pelaajalleKansanedustajuus);
        return true;
    }

}
