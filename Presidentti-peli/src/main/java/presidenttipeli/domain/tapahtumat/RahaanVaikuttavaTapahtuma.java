package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka antaa pelaajalle rahaa tai ottaa pelaajalta rahaa pois.
 */
public class RahaanVaikuttavaTapahtuma implements Tapahtuma {

    private boolean pelaajalleRahaa; // jos true niin pelaaja saa rahaa, jos false niin pelaajalta otetaan rahaa
    private int summa;

    public RahaanVaikuttavaTapahtuma(boolean pelaajalleRahaa, int summa) {
        this.pelaajalleRahaa = pelaajalleRahaa;
        this.summa = summa;
    }

    /**
     * Metodi antaa pelaajalle konstruktorille annetun kokonaislukumuuttujan
     * verran rahaa tai ottaa sen verran rahaa pois riippuen konstruktorille
     * annetusta totuusarvosta
     *
     * @param pelaaja Pelaaja jolle annetaan tai otetaan pois rahaa.
     *
     * @return True jos rahan ottaminen tai antaminen onnistui, muuten false.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        int pelaajanRahat = pelaaja.getRahat();

        if (pelaajalleRahaa) {
            pelaaja.setRahat(pelaajanRahat + summa);
            return true;
        } else if (pelaajanRahat >= summa) {
            pelaaja.setRahat(pelaajanRahat - summa);
            return true;
        }
        return false;
    }

    public int getSumma() {
        return summa;
    }

    public boolean isPelaajalleRahaa() {
        return pelaajalleRahaa;
    }

}
