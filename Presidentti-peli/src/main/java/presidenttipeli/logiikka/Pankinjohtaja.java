package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.tapahtumat.UusiKierros;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

/**
 * Logiikkaluokka joka huolehtii pelaajan rahansiirroista ja velasta.
 */
public class Pankinjohtaja {

    private Pelilauta lauta;
    private TapahtumienLuoja luoja;
    private int kuukaudenTuotot;

    public Pankinjohtaja(Pelilauta lauta) {
        this.lauta = lauta;
        luoja = new TapahtumienLuoja(lauta);
    }

    /**
     * Antaa pelaajalle hänen kuukauden aikana saamansa tuotot.
     *
     * @param pelaaja Pelaaja joka saa omat tuottonsa.
     */
    public void annaPelaajalleKuukaudenTuotot(Pelaaja pelaaja) {
        UusiKierros uusikierros = luoja.luoUusiKierros();
        uusikierros.suoritaTapahtuma(pelaaja);
        kuukaudenTuotot = uusikierros.getKuukaudenTuotot();
    }

    /**
     * Vähentää pelaajan velkaa mikäli pelaajalla riittää haluamaansa
     * vähennykseen rahaa.
     *
     * @param pelaaja Pelaaja jonka velkaa vähennetään.
     * @param maara Rahamäärä joka vähennetään velasta
     *
     * @see #otaPelaajaltaRahaa(presidenttipeli.domain.Pelaaja, int)
     *
     * @return Onnistuiko velkojen vähennys.
     */
    public boolean vahennaVelkaa(Pelaaja pelaaja, int maara) {
        if (pelaaja.getRahat() < maara || pelaaja.getVelkaa() < maara) {
            return false;
        } else {
            luoja.luoVelkaanVaikuttavaTapahtuma(false, maara).suoritaTapahtuma(pelaaja);
            otaPelaajaltaRahaa(pelaaja, maara);
            return true;
        }
    }

    /**
     *  Kasvattaa pelaajan velkaa mikäli velka ei kasva yli 5000 mk.
     * 
     *  @param pelaaja Pelaaja jonka velkaa kasvatetaan.
     *  @param maara Halutun velan suuruus
     * 
     *  @see #annaPelaajalleRahaa(presidenttipeli.domain.Pelaaja, int) 
     * 
     *  @return Onnistuiko velankasvatus.
     */
    public boolean kasvataVelkaa(Pelaaja pelaaja, int maara) {
        if (pelaaja.getVelkaa() + maara > 5000) {
            return false;
        } else {
            luoja.luoVelkaanVaikuttavaTapahtuma(true, maara).suoritaTapahtuma(pelaaja);
            annaPelaajalleRahaa(pelaaja, maara);
            return true;
        }
    }

    public boolean otaPelaajaltaRahaa(Pelaaja pelaaja, int maara) {
        if (pelaaja.getRahat() < maara) {
            return false;
        } else {
            luoja.luoRahaanVaikuttavaTapahtuma(false, maara).suoritaTapahtuma(pelaaja);
            return true;
        }
    }

    public void annaPelaajalleRahaa(Pelaaja pelaaja, int maara) {
        luoja.luoRahaanVaikuttavaTapahtuma(true, maara).suoritaTapahtuma(pelaaja);
    }

    public int getKuukaudenTuotot() {
        return kuukaudenTuotot;
    }

}
