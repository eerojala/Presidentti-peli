package presidenttipeli.domain.tapahtumat;

import java.util.ArrayList;
import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka suorittaa tietyn tapahtuman riippuen pelaajan palkasta.
 */
public class PalkastaRiippuvaTapahtuma implements Tapahtuma {

    private ArrayList<Tapahtuma> tapahtumat;
    private ArrayList<Integer> palkkarajat;

    public PalkastaRiippuvaTapahtuma(ArrayList<Tapahtuma> tapahtumat, ArrayList<Integer> palkkarajat) {
        this.tapahtumat = tapahtumat;
        this.palkkarajat = palkkarajat;
    }

    /**
     * Metodi suorittaa yhden tapahtumista joka vastaa palkkarajaa johon
     * pelaajan palkka kuuluu
     *
     * @param pelaaja Pelaaja jolle tapahtuma suoritetaan.
     * @return Onnistuiko suoritettava tapahtuma.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        // Luokka olettaa että tapahtumia ja palkkarajoja on saman verran.

        for (int i = 0; i < tapahtumat.size(); i++) {

            if (pelaaja.getAmmatti().getPalkka() < palkkarajat.get(i)) {
                return tapahtumat.get(i).suoritaTapahtuma(pelaaja);
            }
        }
        return true;
    }

}
