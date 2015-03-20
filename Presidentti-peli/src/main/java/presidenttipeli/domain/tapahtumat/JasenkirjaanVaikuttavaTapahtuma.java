
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class JasenkirjaanVaikuttavaTapahtuma implements Tapahtuma{
    private boolean pelaajalleJasenKirja;

    public JasenkirjaanVaikuttavaTapahtuma(boolean pelaajalleJasenKirja) {
        this.pelaajalleJasenKirja = pelaajalleJasenKirja;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setPuolueenJasen(pelaajalleJasenKirja);
        return true;
    }
    
    
}
