package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka suorittaa jommankumman kahdesta tapahtumasta riippuen onko
 * pelaaja puolueen jäsen.
 */
public class JasenkirjastaRiippuvaTapahtuma implements Tapahtuma {

    private Tapahtuma tapahtuma1;
    private Tapahtuma tapahtuma2;

    public JasenkirjastaRiippuvaTapahtuma(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        this.tapahtuma1 = tapahtuma1;
        this.tapahtuma2 = tapahtuma2;
    }

    /**
     * Metodi joka suorittaa jommankumman konstruktorille annetuista tapahtumista
     * riippuen onko pelaaja puoluuen jäsen.
     *
     * @param pelaaja Pelaaja jolle suoritetaan jompikumpi tapahtuma
     * @return Onnistuiko suoritettu tapahtuma
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaaja.isPuolueenJasen()) {
            return tapahtuma1.suoritaTapahtuma(pelaaja);
        } else {
            return tapahtuma2.suoritaTapahtuma(pelaaja);
        }
    }

}
