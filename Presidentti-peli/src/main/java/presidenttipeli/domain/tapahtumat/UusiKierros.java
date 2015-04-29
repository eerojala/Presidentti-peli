package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka suorittaa jokaisen kierroksen alussa automaattisesti
 * tapahtuvat tapahtumat.
 */
public class UusiKierros implements Tapahtuma {

    private Pelilauta lauta;
    private int kuukaudenTuotot;

    public UusiKierros(Pelilauta lauta) {
        this.lauta = lauta;
    }

    /**
     * Metodi antaa pelaajalle kuukauden tuotot, asettaa hänelle oikeuden
     * tuottoon, asettaa hänen ammattinsa työttömäksi ja korottaa velkaa 10%.
     *
     * @param pelaaja Pelajaa joka aloittaa uuden kierroksen.
     *
     * @return Aina true.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Tapahtuma tapahtuma;
        OtaKuukaudenTuotot tuotot = new OtaKuukaudenTuotot();
        tuotot.suoritaTapahtuma(pelaaja);
        kuukaudenTuotot = tuotot.getKuukaudenTuotot();
        tapahtuma = new VieTaiAnnaOikeusLiikkeidenTuottoon(true);
        tapahtuma.suoritaTapahtuma(pelaaja);
        tapahtuma = new AsetaAmmatti(lauta, new Ammatti("Työtön", 1000, false, false, true));
        tapahtuma.suoritaTapahtuma(pelaaja);
        tapahtuma = new VelkaanVaikuttavaTapahtuma(true, pelaaja.getVelkaa() * 0.1);
        tapahtuma.suoritaTapahtuma(pelaaja);
        return true;
    }

    public int getKuukaudenTuotot() {
        return kuukaudenTuotot;
    }

}
