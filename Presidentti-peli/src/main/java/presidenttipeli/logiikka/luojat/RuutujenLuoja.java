package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.SelosteenOmaava;
import presidenttipeli.domain.tapahtumat.*;
import presidenttipeli.util.SelosteenAsettaja;

/**
 * Luojaluokka joka luo ruudut pelille.
 */
public class RuutujenLuoja extends Luoja {

    private ArrayList<SelosteenOmaava> lista;
    private Pelilauta lauta;
    private Ammatti tyoton;
    private TapahtumienLuoja luoja;
    private ArrayList<Ruutu> ruudut;

    public RuutujenLuoja(Pelilauta lauta) {
        lista = new ArrayList();
        this.lauta = lauta;
        tyoton = new Ammatti("Työtön", 1000, false, false, true);
        luoja = new TapahtumienLuoja(lauta);
        ruudut = new ArrayList();
    }

    @Override
    public void luo() {
        luoRuudut();
        asetaScannerilleTiedosto("tekstit/RuutujenSelostukset.txt", RuutujenLuoja.class.getClassLoader());
        SelosteenAsettaja.asetaSelosteet(lista, lukija);
        ruudut = muunnaRuuduiksi();
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

    /**
     *  Muuntaa ruudut SelosteenOmaava-muodosta Ruuduiksi.
     * 
     *  @return Ruudut listana.
     */
    public ArrayList<Ruutu> muunnaRuuduiksi() {
        ArrayList<Ruutu> temp = new ArrayList();
        for (SelosteenOmaava apu : lista) {
            temp.add((Ruutu) apu);
        }
        return temp;
    }

    private void luoRuudut() {
        luoRuudut1();
        luoRuudut2();
        luoRuudut3();
    }

    private void asetaRuudulleTapahtumat(Ruutu ruutu, Tapahtuma... tapahtumat) {
        for (Tapahtuma tapahtuma : tapahtumat) {
            ruutu.getTapahtumat().add(tapahtuma);
        }
        lista.add(ruutu);
    }

    private void luoRuudut1() {
        luoOstoJaMyyntiruutu(1, 862, 557, false);
        luoYksinkertainenAmmattiruutu(2, 767, 557, tyoton);
        luoYksinkertainenAmmattiruutu(3, 672, 557,
                new Ammatti("Opettaja", 5000, false, false, false));
        luoYksinkertainenAmmattiruutu(4, 577, 557,
                new Ammatti("Autonkuljettaja", 3000, false, false, true));
        luoYksinkertainenAmmattiruutu(5, 484, 557, tyoton);
        luoYksinkertainenAmmattiruutu(6, 389, 557,
                new Ammatti("Päälikkö", 9000, false, false, false));
        luoJohtajaTaiSattumaAmmattiruutu(7, 294, 557, false);
        luoJasenkirjaanVaikuttavaRuutu(8, 199, 557, true);
        luoRahaanVaikuttavaRuutu(9, 104, 557, true, 2000);
        luoVaaliruutu(10, 10, 557);
    }

    private void luoRuudut2() {
        luoPalkastaRiippuvaRuutu(11, 10, 465,
                luoRuudun11Tapahtumat(), luoRuudun11Palkkarajat());
        luoJasenkirjastaRiippuvaRuutu(12, 10, 373,
                luoja.luoOtaAmmattikorttiTapahtuma(true), luoja.luoOtaTapahtumakorttiTapahtuma());
        luoTietystaAmmatistaRiippuvaRuutu(13, 10, 281,
                tyoton, luoja.luoTapahtumaJokaEiTeeMitaan(),
                luoja.luoRahaanVaikuttavaTapahtuma(false, 500));
        luoTietystaAmmatistaRiippuvaRuutu(14, 10, 190, tyoton,
                luoja.luoTapahtumaJokaEiTeeMitaan(),
                luoja.luoRahaanVaikuttavaTapahtuma(true, 1000));
        luoRahaanVaikuttavaRuutu(15, 10, 98, false, 5000);
        luoOstoJaMyyntiruutu(16, 10, 8, true);
        luoTutkintoonVaikuttavaRuutu(17, 105, 8, true, false);
        luoYksinkertainenAmmattiruutu(18, 199, 8, tyoton);
        luoOtaLiikekorttiRuutu(19, 294, 8);
        luoOstoJaMyyntiruutu(20, 389, 8, false);
    }

    private void luoRuudut3() {
        luoMokinpoistoruutu(21, 484, 8, true);
        luoJohtajaTaiSattumaAmmattiruutu(22, 577, 8, true);
        luoRuutuJossaUseampiTapahtuma(23, 672, 8, luoja.luoRahaanVaikuttavaTapahtuma(false, 500),
                luoja.luoJohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(luoja.luoSiirraNappulaaTapahtuma(30), luoja.luoTapahtumaJokaEiTeeMitaan()));
        luoPutkaruutu(24, 767, 8);
        luoVaaliruutu(25, 862, 8);
        luoNappulaaSiirtavaRuutu(26, 862, 98, 1);
        luoRahaanVaikuttavaRuutu(27, 862, 190, true, 20000);
        luoTapahtumakorttiRuutu(28, 862, 281);
        luoVerotarkastusRuutu(29, 862, 373, false);
        luoVaaliruutu(30, 862, 465);
    }

    private void luoOstoJaMyyntiruutu(int numero, int x, int y, boolean ruutu16) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        ruutu.setOstoJaMyyntiruutu(true);
        if (ruutu16) {
            asetaRuudulleTapahtumat(ruutu, luoja.luoOtaTapahtumakorttiTapahtuma());
        } else {
            asetaRuudulleTapahtumat(ruutu);
        }
    }

    private void luoYksinkertainenAmmattiruutu(int numero, int x, int y, Ammatti ammatti) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, luoja.luoAsetaAmmattiTapahtuma(ammatti));
    }

    private void luoJohtajaTaiSattumaAmmattiruutu(int numero, int x, int y, boolean johtajaAmmatti) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, luoja.luoOtaAmmattikorttiTapahtuma(johtajaAmmatti));
    }

    private void luoJasenkirjaanVaikuttavaRuutu(int numero, int x, int y, boolean pelaajalleJasenkirja) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu,
                luoja.luoJasenkirjaanVaikuttavaTapahtuma(pelaajalleJasenkirja));
    }

    private void luoRahaanVaikuttavaRuutu(int numero, int x, int y, boolean pelaajalleRahaa, int rahasumma) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu,
                luoja.luoRahaanVaikuttavaTapahtuma(pelaajalleRahaa, rahasumma));
    }

    private void luoVaaliruutu(int numero, int x, int y) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        ruutu.setVaaliruutu(true);
        asetaRuudulleTapahtumat(ruutu);
    }

    private void luoPalkastaRiippuvaRuutu(int numero, int x, int y, ArrayList<Tapahtuma> tapahtumat, ArrayList<Integer> palkkarajat) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu,
                luoja.luoPalkastaRiippuvaTapahtuma(tapahtumat, palkkarajat));
    }

    private ArrayList<Tapahtuma> luoRuudun11Tapahtumat() {
        ArrayList<Tapahtuma> tapahtumat = new ArrayList();
        tapahtumat.add(luoja.luoRahaanVaikuttavaTapahtuma(false, 500));
        tapahtumat.add(luoja.luoRahaanVaikuttavaTapahtuma(false, 1000));
        tapahtumat.add(luoja.luoRahaanVaikuttavaTapahtuma(false, 1500));
        return tapahtumat;
    }

    private ArrayList<Integer> luoRuudun11Palkkarajat() {
        ArrayList<Integer> palkkarajat = new ArrayList();
        palkkarajat.add(2001);
        palkkarajat.add(4001);
        palkkarajat.add(Integer.MAX_VALUE);
        return palkkarajat;
    }

    private void luoJasenkirjastaRiippuvaRuutu(int numero, int x, int y, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu,
                luoja.luoTapahtumaJokaRiippuuJasenkirjasta(tapahtuma1, tapahtuma2));
    }

    private void luoTietystaAmmatistaRiippuvaRuutu(int numero, int x, int y, Ammatti ammatti, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu,
                luoja.luoTietystaAmmatistaRiippuvaTapahtuma(ammatti, tapahtuma1, tapahtuma2));
    }

    private void luoTutkintoonVaikuttavaRuutu(int numero, int x, int y, boolean pelaajalleTutkinto, boolean yleissivistava) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu,
                luoja.luoTutkintoonVaikuttavaTapahtuma(pelaajalleTutkinto, yleissivistava));
    }

    private void luoOtaLiikekorttiRuutu(int numero, int x, int y) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, luoja.luoOtaLiikekorttiTapahtuma());
    }

    private void luoMokinpoistoruutu(int numero, int x, int y, boolean vakuutusKorvaa) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, luoja.luoMokinPoistoTapahtuma(vakuutusKorvaa));
    }

    private void luoRuutuJossaUseampiTapahtuma(int numero, int x, int y, Tapahtuma... tapahtumat) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, tapahtumat);
    }

    private void luoPutkaruutu(int numero, int x, int y) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        ruutu.setPutkaruutu(true);
        asetaRuudulleTapahtumat(ruutu);
    }

    private void luoNappulaaSiirtavaRuutu(int numero, int x, int y, int minne) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, luoja.luoSiirraNappulaaTapahtuma(minne));
    }

    private void luoTapahtumakorttiRuutu(int numero, int x, int y) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, luoja.luoOtaTapahtumakorttiTapahtuma());
    }

    private void luoVerotarkastusRuutu(int numero, int x, int y, boolean oikeusTuottoon) {
        Ruutu ruutu = new Ruutu(numero, x, y);
        asetaRuudulleTapahtumat(ruutu, luoja.luoVieTaiAnnaOikeusLiikkeidenTuottoon(oikeusTuottoon));
    }

}
