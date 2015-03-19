package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;

public class AmmattiinVaikuttavaTapahtuma extends Tapahtuma {

    private Ammatti ammatti;

    public AmmattiinVaikuttavaTapahtuma(Ammatti ammatti) {
        this.ammatti = ammatti;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setAmmatti(ammatti);
        return true;
    }

}
