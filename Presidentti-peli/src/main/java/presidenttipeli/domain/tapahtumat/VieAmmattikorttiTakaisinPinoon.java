
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class VieAmmattikorttiTakaisinPinoon implements Tapahtuma{

    private Pelilauta lauta;
    private Ammatti ammatti;

    public VieAmmattikorttiTakaisinPinoon(Pelilauta lauta, Ammatti ammatti) {
        this.lauta = lauta;
        this.ammatti = ammatti;
    }

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
