package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka vaikuttaa pelaajan kansanedustajuuteen.
 */
public class KansanedustajuuteenVaikuttavaTapahtuma implements Tapahtuma {

    private boolean pelaajalleKansanedustajuus;
    private Pelilauta lauta;

    public KansanedustajuuteenVaikuttavaTapahtuma(boolean pelaajalleKansanedustajuus, Pelilauta lauta) {
        this.pelaajalleKansanedustajuus = pelaajalleKansanedustajuus;
        this.lauta = lauta;
    }

    /**
     * Metodi antaa pelaajalle kansanedustajuuden tai ottaa sen pois riippuen
     * konstrukorille annetusta totuusarvosta.
     * 
     * Jos Pelaaja saa kansanedustajuuden kun on ammatissa joka ei tätä salli,
     * otetaan pelaajalta nykyinen ammatti pois ja asetetaan hänet työttömäksi.
     *
     * @param pelaaja Pelaaja jonka kansanedustajuuteen vaikutetaan
     * @return aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setKansanedustaja(pelaajalleKansanedustajuus);
        if (pelaajalleKansanedustajuus == true) {
            if (!pelaaja.getAmmatti().salliiKansanedustajuuden()) {
                Tapahtuma tapahtuma = new AsetaAmmatti(lauta, new Ammatti("Työtön", 1000, false, false, true));
                tapahtuma.suoritaTapahtuma(pelaaja);
            }
        }
        return true;
    }

}
