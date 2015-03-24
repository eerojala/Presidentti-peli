
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class Verotarkastus implements Tapahtuma{

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setOikeutettuTuottoon(false);
        return true;
    }
    
}
