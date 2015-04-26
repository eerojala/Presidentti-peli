package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka antaa pelaajalle hänen kuukauden aikana keräämänsä
 * tuoton.
 */
public class OtaKuukaudenTuotot implements Tapahtuma {
    private int kuukaudenTuotot;
    public OtaKuukaudenTuotot() {
    }

    /**
     * Metodi joka laskee pelaajan saaman tuoton ja antaa hänelle sen verran
     * rahaa
     *
     * @param pelaaja Pelaaja joka saa keräämänsä tuoton
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        kuukaudenTuotot = 0;
        kuukaudenTuotot += pelaaja.getAmmatti().getPalkka();
        if (pelaaja.getTutkinto() != null && !pelaaja.getAmmatti().getNimi().equals("Työtön")) {
            kuukaudenTuotot += 1500;
        }
        if (pelaaja.isOikeutettuTuottoon()) {
            kuukaudenTuotot += laskeLiikkeidenTuotto(pelaaja);
        }
        Tapahtuma tapahtuma = new RahaanVaikuttavaTapahtuma(true, kuukaudenTuotot);
        tapahtuma.suoritaTapahtuma(pelaaja);
        return true;
    }

    private int laskeLiikkeidenTuotto(Pelaaja pelaaja) {
        int tuotto = 0;
        for (Liike liike : pelaaja.getOmistamatLiikkeet()) {
            tuotto += liike.getTuotto();
        }
        return tuotto;
    }

    public int getKuukaudenTuotot() {
        return kuukaudenTuotot;
    }
    
    
}
