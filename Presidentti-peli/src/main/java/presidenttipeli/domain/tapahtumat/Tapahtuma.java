package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Rajapinta joka vaatii sen implementoivilta luokilta metodin suoritaTapahtuma
 */
public interface Tapahtuma {


    public boolean suoritaTapahtuma(Pelaaja pelaaja);
    

}
