package presidenttipeli.domain.tapahtumat;

import java.util.Collections;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

public class MenetaMokki implements Tapahtuma {

    private Pelilauta lauta;
    private boolean vakuutusKorvaa;

    public MenetaMokki(Pelilauta lauta, boolean vakuutusKorvaa) {
        this.lauta = lauta;
        this.vakuutusKorvaa = vakuutusKorvaa;
    }

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
