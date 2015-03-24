
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;


public class TietystaAmmatistaRiippuvaTapahtuma implements Tapahtuma{
    private Ammatti ammattiJostaTapahtumaRiippuu;
    private Tapahtuma tapahtuma1;
    private Tapahtuma tapahtuma2;

    public TietystaAmmatistaRiippuvaTapahtuma(Ammatti ammattiJostaTapahtumaRiippuu, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        this.ammattiJostaTapahtumaRiippuu = ammattiJostaTapahtumaRiippuu;
        this.tapahtuma1 = tapahtuma1;
        this.tapahtuma2 = tapahtuma2;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaaja.getAmmatti().equals(ammattiJostaTapahtumaRiippuu)) {
            return tapahtuma1.suoritaTapahtuma(pelaaja);
        } else {
            return tapahtuma2.suoritaTapahtuma(pelaaja);
        }
    }
    
    
    
}
