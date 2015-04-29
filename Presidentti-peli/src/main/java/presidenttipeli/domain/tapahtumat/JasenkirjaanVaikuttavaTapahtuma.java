package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka vaikuttaa pelaajan puolueen jäsenyyteen.
 */
public class JasenkirjaanVaikuttavaTapahtuma implements Tapahtuma {

    private boolean pelaajalleJasenKirja;

    public JasenkirjaanVaikuttavaTapahtuma(boolean pelaajalleJasenKirja) {
        this.pelaajalleJasenKirja = pelaajalleJasenKirja;
    }

    /**
     * Metodi joka joko antaa pelaajalle puolueen jäsenkirjan tai ottaa sen pois
     * riippuen konstrukorille annetusta totuusarvosta.
     *
     * @param pelaaja Pelaaja jonka puolueen jäsenyyteen vaikutetaan
     * 
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setPuolueenJasen(pelaajalleJasenKirja);
        return true;
    }

}
