package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka vaikuttaa pelaajan oikeuteen liikkeiden tuottoon
 */
public class VieTaiAnnaOikeusLiikkeidenTuottoon implements Tapahtuma {

    private boolean oikeusTuottoon;

    public VieTaiAnnaOikeusLiikkeidenTuottoon(boolean oikeusTuottoon) {
        this.oikeusTuottoon = oikeusTuottoon;
    }

    /**
     * Metodi joka vie tai antaa oikeuden liikkeiden tuottoon riippuen
     * konstruktorille asetetusta totuusarvosta.
     *
     * @param pelaaja Pelaaja jolle tapahtuma suoritetaan.
     * 
     * @return Aina true.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setOikeutettuTuottoon(oikeusTuottoon);
        return true;
    }

}
