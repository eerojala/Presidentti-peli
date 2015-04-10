package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka antaa pelaajalle hänen kuukauden aikana keräämänsä
 * tuoton.
 */
public class OtaKuukaudenTuotot implements Tapahtuma {

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
        int summa = 0;
        summa += pelaaja.getAmmatti().getPalkka();
        if (pelaaja.getTutkinto() != null) {
            summa += 1500;
        }
        if (pelaaja.isOikeutettuTuottoon()) {
            summa += laskeLiikkeidenTuotto(pelaaja);
        }
        Tapahtuma tapahtuma = new RahaanVaikuttavaTapahtuma(true, summa);
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
}
