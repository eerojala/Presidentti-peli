
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class TapahtumaJokaEiTeeMitaan implements Tapahtuma{

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        return true;
    }
    
}
