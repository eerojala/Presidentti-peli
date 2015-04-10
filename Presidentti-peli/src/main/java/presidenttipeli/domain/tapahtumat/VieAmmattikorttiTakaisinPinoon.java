
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 *  Tapahtumaluokka joka vie pelaajan ammatin takaisin laudalle
 */
public class VieAmmattikorttiTakaisinPinoon implements Tapahtuma{

    private Pelilauta lauta;
    private Ammatti ammatti;

    public VieAmmattikorttiTakaisinPinoon(Pelilauta lauta, Ammatti ammatti) {
        this.lauta = lauta;
        this.ammatti = ammatti;
    }

    /**
     * Metodi palauttaa konstruktorille annetun ammatin johtaja- tai
     * sattuma-ammattipinoon riippuen onko ammatti johtaja- vai sattuma-ammatti.
     * 
     * @param pelaaja Pelaaja jolle tapahtuma suoritetaan
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (ammatti.isJohtaja()) {
            lauta.getJohtajaAmmatit().add(ammatti);
        } else if (ammatti.isSattumaAmmmatti()) {
            lauta.getSattumaAmmatit().add(ammatti);
        }
        return true;
    }
    
    
}
