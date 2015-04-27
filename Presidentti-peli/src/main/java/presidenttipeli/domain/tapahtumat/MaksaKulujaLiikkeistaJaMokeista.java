package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka veloittaa pelaajalta rahaa hänen omistamistaan mökeistä ja
 * liikkeistä.
 */
public class MaksaKulujaLiikkeistaJaMokeista implements Tapahtuma {

    private int maksettavaHinta;

    public MaksaKulujaLiikkeistaJaMokeista(int maksettavaHinta) {
        this.maksettavaHinta = maksettavaHinta;
    }

    /**
     * Metodi joka veloittaa pelaajalta konstruktorin määräämän summan jokaiselta hänen
     * omistamaltaan mökiltä ja liikkeeltä
     *
     * @param pelaaja Pelaaja jolta veloitetaan rahaa
     * @return Onnistuiko rahojen veloitus
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        int maksettavaSumma = 0
                + pelaaja.getOmistamatLiikkeet().size() * maksettavaHinta
                + pelaaja.getOmistamatMokit().size() * maksettavaHinta;

        Tapahtuma tapahtuma = new RahaanVaikuttavaTapahtuma(false, maksettavaSumma);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }

}
