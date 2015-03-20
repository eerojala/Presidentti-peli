package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Ruutu;

public class NappulanSijaintiinVaikuttavaTapahtuma implements Tapahtuma {
    private Nappula nappula;
    private Ruutu uusiSijainti;

    public NappulanSijaintiinVaikuttavaTapahtuma(Ruutu uusiSijainti) {
        this.uusiSijainti = uusiSijainti;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        nappula = pelaaja.getNappula();
        nappula.setSijainti(uusiSijainti);
        return true;
    }
    
    
}
