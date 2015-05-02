package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Huolehtii pelaajien vuoron vaihdosta.
 */
public class Vuoronvaihtaja {

    private Pelilauta lauta;
    private int nykyisenPelaajanIndeksi;

    public Vuoronvaihtaja(Pelilauta lauta) {
        this.lauta = lauta;
        nykyisenPelaajanIndeksi = 0;
    }

    /**
     * Vaihtaa nykyisen pelaajan vuorossa seuraavaan. Mikäli pelaaja on ainoa
     * jäljellä pysyy hän edelleen vuorossa.
     * 
     * @param nykyinenPelaaja Tämänhetkinen pelaaja ennen vuoronvaihtoa.
     * 
     * @return Seuraava pelaaja.
     */
    public Pelaaja vaihdaVuoroa(Pelaaja nykyinenPelaaja) {
        nykyinenPelaaja.setOdottaaVuoroaan(nykyinenPelaaja.getOdottaaVuoroaan() - 1);
        if (!lauta.getNappulat().contains(nykyinenPelaaja.getNappula())) {
            nykyinenPelaaja = vaihdaVuoroaKunEdellinenTippuiPelista(nykyinenPelaaja);
        } else {
            nykyinenPelaaja = etsiUusiPelaaja(nykyinenPelaaja);
        }
        return nykyinenPelaaja;
    }

    private Pelaaja etsiUusiPelaaja(Pelaaja nykyinenPelaaja) {
        for (int i = 0; i < lauta.getNappulat().size(); i++) {
            if (lauta.getNappulat().get(i).getOmistaja() == nykyinenPelaaja) {
                if (i == lauta.getNappulat().size() - 1) {
                    nykyinenPelaaja = lauta.getNappulat().get(0).getOmistaja();
                    nykyisenPelaajanIndeksi = 0;
                } else {
                    nykyinenPelaaja = lauta.getNappulat().get(i + 1).getOmistaja();
                    nykyisenPelaajanIndeksi = i + 1;
                }

                if (nykyinenPelaaja.getOdottaaVuoroaan() > 0) {
                    nykyinenPelaaja = vaihdaVuoroa(nykyinenPelaaja);
                }
                break;
            }
        }
        return nykyinenPelaaja;
    }

    private Pelaaja vaihdaVuoroaKunEdellinenTippuiPelista(Pelaaja nykyinenPelaaja) {
        if (nykyisenPelaajanIndeksi == lauta.getNappulat().size() - 1) {
            nykyinenPelaaja = lauta.getNappulat().get(0).getOmistaja();
        } else {
            if (nykyisenPelaajanIndeksi == lauta.getNappulat().size()) {
                nykyinenPelaaja = lauta.getNappulat().get(nykyisenPelaajanIndeksi - 1).getOmistaja();
            } else {
                nykyinenPelaaja = lauta.getNappulat().get(nykyisenPelaajanIndeksi).getOmistaja();
            }
        }
        return nykyinenPelaaja;
    }

}
