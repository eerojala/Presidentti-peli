package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;

public class OtaKuukaudenTuotot implements Tapahtuma {

    public OtaKuukaudenTuotot() {
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        int summa = 0;
        summa += pelaaja.getAmmatti().getPalkka();
        if (pelaaja.getTutkinto() != null) {
            summa += 1500;
        }
        if (pelaaja.isOikeutettuTuottoon()) {
            summa+=laskeLiikkeidenTuotto(pelaaja);
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
