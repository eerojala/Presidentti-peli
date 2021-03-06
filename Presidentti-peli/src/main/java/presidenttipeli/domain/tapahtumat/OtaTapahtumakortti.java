package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Tapahtumakortti;

/**
 * Tapahtumaluokka joka ottaa laudan päälimmäisen tapahtumakortin ja suorittaa
 * sen tapahtumat.
 */
public class OtaTapahtumakortti implements Tapahtuma {

    private Pelilauta lauta;

    public OtaTapahtumakortti(Pelilauta lauta) {
        this.lauta = lauta;
    }

    /**
     * Metodi joka nostaa laudan päälimmäisen tapahtumakortin ja suorittaa sen
     * tapahtumat. Jos tapahtumien suoritus onnistui asetetaan kortti takaisin
     * pinon pohjalle.
     *
     * @param pelaaja Pelaaja jolle suoritetaan tapahtumakortin tapahtumat.
     *
     * @return Jos kaikkien tapahtumien suoritus onnistui, muuten false.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Tapahtumakortti kortti = lauta.getTapahtumakortit().peek();
        boolean onnistuikoKaikki = true;

        for (Tapahtuma tapahtuma : kortti.getTapahtumat()) {
            if (tapahtuma.suoritaTapahtuma(pelaaja) == false) {
                onnistuikoKaikki = false;
            }
        }

        if (onnistuikoKaikki) {
            lauta.getTapahtumakortit().poll();
            lauta.getTapahtumakortit().add(kortti);
        }
        return onnistuikoKaikki;
    }

}
