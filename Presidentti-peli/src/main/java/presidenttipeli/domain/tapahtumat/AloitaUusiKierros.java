
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class AloitaUusiKierros implements Tapahtuma{
    private Pelilauta lauta;

    public AloitaUusiKierros(Pelilauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Tapahtuma tapahtuma = new OtaKuukaudenTuotot();
        tapahtuma.suoritaTapahtuma(pelaaja);
        tapahtuma = new VieTaiAnnaOikeusLiikkeidenTuottoon(true);
        tapahtuma.suoritaTapahtuma(pelaaja);
        tapahtuma = new AsetaAmmatti(lauta, new Ammatti("Työtön", 1000, false, false, true));
        tapahtuma.suoritaTapahtuma(pelaaja);
        tapahtuma = new VelkaanVaikuttavaTapahtuma(true, pelaaja.getVelkaa() * 0.1);
        tapahtuma.suoritaTapahtuma(pelaaja);
        return true;
    }
    
    
}
