package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

public class AsetaAmmatti implements Tapahtuma {

    private Pelilauta lauta;
    private Ammatti ammatti;

    public AsetaAmmatti(Pelilauta lauta, Ammatti ammatti) {
        this.lauta = lauta;
        this.ammatti = ammatti;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Tapahtuma tapahtuma1 = new VieAmmattikorttiTakaisinPinoon(lauta, ammatti);
        tapahtuma1.suoritaTapahtuma(pelaaja);
        pelaaja.setAmmatti(ammatti);
        Tapahtuma tapahtuma2;
        
        if (pelaaja.isKansanedustaja() && ammatti.salliiKansanedustajuuden() == false) {
            tapahtuma2 = new KansanedustajuuteenVaikuttavaTapahtuma(false);
            tapahtuma2.suoritaTapahtuma(pelaaja);
        }
        
        if (pelaaja.onTutkinto() && !ammatti.getNimi().equals("Työtön")) {
            tapahtuma2 = new TutkintoonVaikuttavaTapahtuma(false);
            tapahtuma2.suoritaTapahtuma(pelaaja);
        }
        return true;
    }

}
