package presidenttipeli.domain.tapahtumat;

import java.util.Collections;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka ottaa pois pelaajalta hänen arvokkaimman liikkeensä.
 */
public class MenetaLiike implements Tapahtuma {

    private Pelilauta lauta;
    private boolean vakuutusKorvaa;

    public MenetaLiike(Pelilauta lauta, boolean vakuutusKorvaa) {
        this.lauta = lauta;
        this.vakuutusKorvaa = vakuutusKorvaa;
    }

    /**
     * Metodi ottaa pois hänen arvokkaimman liikkeensä ja antaa hänelle puolet
     * sen arvosta korvauksena mikäli konstruktorissa on asetettu muuttuja
     * vakuutusKorvaa trueksi.
     *
     * @param pelaaja Pelaaja jolta otetaan arvokkain liike pois.
     * 
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (!pelaaja.getOmistamatLiikkeet().isEmpty()) {
            Collections.sort(pelaaja.getOmistamatLiikkeet());
            Liike liike = pelaaja.getOmistamatLiikkeet().get(0);
            Tapahtuma tapahtuma = new LiikkeisiinVaikuttavaTapahtuma(liike, false, lauta);
            tapahtuma.suoritaTapahtuma(pelaaja);

            if (vakuutusKorvaa) {
                tapahtuma = new RahaanVaikuttavaTapahtuma(true, liike.getArvo() / 2);
                tapahtuma.suoritaTapahtuma(pelaaja);
            }
        }
        return true;
    }

}
