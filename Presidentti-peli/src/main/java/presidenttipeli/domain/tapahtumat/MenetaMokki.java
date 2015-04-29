package presidenttipeli.domain.tapahtumat;

import java.util.Collections;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka ottaa pelaajalta pois hänen arvokkaimman mökkinsä.
 */
public class MenetaMokki implements Tapahtuma {

    private Pelilauta lauta;
    private boolean vakuutusKorvaa;

    public MenetaMokki(Pelilauta lauta, boolean vakuutusKorvaa) {
        this.lauta = lauta;
        this.vakuutusKorvaa = vakuutusKorvaa;
    }

    /**
     * Metodi ottaa pelaajalta pois hänen arvokkaimman mökkinsä ja antaa
     * korvauksena puolet sen arvosta mikäli konstruktorissa on asetettu muuttuja
     * vakuutusKorvaa trueksi.
     *
     * @param pelaaja Pelaaja jolta otetaan hänen arvokkain mökkinsä pois
     * 
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (!pelaaja.getOmistamatMokit().isEmpty()) {
            Collections.sort(pelaaja.getOmistamatMokit());
            Mokki mokki = pelaaja.getOmistamatMokit().get(0);
            Tapahtuma tapahtuma = new MokkeihinVaikuttavaTapahtuma(mokki, false, lauta);
            tapahtuma.suoritaTapahtuma(pelaaja);

            if (vakuutusKorvaa) {
                tapahtuma = new RahaanVaikuttavaTapahtuma(true, mokki.getArvo() / 2);
                tapahtuma.suoritaTapahtuma(pelaaja);
            }
        }
        return true;
    }

}
