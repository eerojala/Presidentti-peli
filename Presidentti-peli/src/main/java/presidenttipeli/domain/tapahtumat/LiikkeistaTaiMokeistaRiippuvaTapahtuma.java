package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka suorittaa jommankumman tapahtumista riippuen omistaako pelaaja
 * yhtaan liiketta tai mokkia
 */
public class LiikkeistaTaiMokeistaRiippuvaTapahtuma implements Tapahtuma {

    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;

    public LiikkeistaTaiMokeistaRiippuvaTapahtuma(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        this.tapahtuma1 = tapahtuma1;
        this.tapahtuma2 = tapahtuma2;
    }

    /**
     * Metodi joka suorittaa jommankumman konstruktorille annetuista tapahtumistata
     * riippuen siitä omistaako pelaaja yhtään liiketta tai mökkiä.
     *
     * @param pelaaja Pelaajalle jolle suoritetaan jompikumpi tapahtuma.
     * 
     * @return True jos suoritettu tapahtuma onnistui, muuten false.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (!pelaaja.getOmistamatLiikkeet().isEmpty() || !pelaaja.getOmistamatMokit().isEmpty()) {
            return tapahtuma1.suoritaTapahtuma(pelaaja);
        } else {
            return tapahtuma2.suoritaTapahtuma(pelaaja);
        }
    }

}
