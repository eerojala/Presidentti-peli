package presidenttipeli.logiikka;

import java.util.ArrayList;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.tapahtumat.Vaalit;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

public class Vaalienjarjestaja {

    /**
     * Logiikkaluokka joka huolehtii eduskunta- ja presidentinvaalien
     * järjestämisestä.
     */
    private TapahtumienLuoja luoja;
    private ArrayList<Integer> saadutAanet;

    public Vaalienjarjestaja(Pelilauta lauta) {
        luoja = new TapahtumienLuoja(lauta);
        saadutAanet = new ArrayList();
    }

    /**
     * Järjestää kansanedustajanvaalit. Jos vaalit onnistuvat pelaajasta tulee
     * kansanedustaja.
     *
     * @param tarvittavaAanimaara Tarvittava äänimäärä kansanedustajan
     * pääsemiseksi.
     * @param pelaaja Pelaaja joka yrittää vaaleja.
     */
    public void jarjestaEduskuntavaalit(int tarvittavaAanimaara, Pelaaja pelaaja) {
        Vaalit vaalit = luoja.luoVaalit(tarvittavaAanimaara);
        if (vaalit.suoritaTapahtuma(pelaaja) == true) {
            luoja.luoKansanedustajuuteenVaikuttavaTapahtuma(true).suoritaTapahtuma(pelaaja);
        }
        saadutAanet = vaalit.getSaadutAanet();
    }

    /**
     * Järjestää presidnetinvaalit. Jos pelaaja voittaa vaaleissa voittaa hän
     * samalla koko pelin.
     *
     * @param tarvittavaAanimaara Tarvittava äänimäärä presidentiksi
     * pääsemiseksi.
     * @param pelaaja Pelaaja joka yrittää vaaleja.
     *
     * @return True jos pelaaja voitti vaalit, muuten false.
     */
    public boolean jarjestaPresidentinvaalit(int tarvittavaAanimaara, Pelaaja pelaaja) {
        Vaalit vaalit = luoja.luoVaalit(tarvittavaAanimaara);
        boolean onnistuiko = false;
        if (vaalit.suoritaTapahtuma(pelaaja) == true) {
            onnistuiko = true;
        }
        saadutAanet = vaalit.getSaadutAanet();
        return onnistuiko;
    }

    public ArrayList<Integer> getSaadutAanet() {
        return saadutAanet;
    }

    /**
     *  Palauttaa saadut yksittäiset äänet summattuna.
     * 
     *  @return Saadut yksittäiset äänet summattuna.
     */
    public int getSaadutAanetSummattuna() {
        int summa = 0;
        for (Integer aani : saadutAanet) {
            summa += aani;
        }
        return summa;
    }

}
