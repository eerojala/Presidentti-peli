
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class VieTaiAnnaOikeusLiikkeidenTuottoon implements Tapahtuma{
    private boolean oikeusTuottoon;

    public VieTaiAnnaOikeusLiikkeidenTuottoon(boolean oikeusTuottoon) {
        this.oikeusTuottoon = oikeusTuottoon;
    }
    
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setOikeutettuTuottoon(oikeusTuottoon);
        return true;
    }
    
}
