package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.SelosteenOmaava;
import presidenttipeli.domain.tapahtumat.*;
import presidenttipeli.util.SelosteenAsettaja;

public class RuutujenLuoja extends Luoja {

    private ArrayList<SelosteenOmaava> lista;
    private Pelilauta lauta;
    private Ammatti tyoton;
    private TapahtumienLuoja luoja;
    private SelosteenAsettaja asettaja;
    private ArrayList<Ruutu> ruudut;

    public RuutujenLuoja(Pelilauta lauta) {
        lista = new ArrayList();
        this.lauta = lauta;
        tyoton = new Ammatti("Työtön", 1000, false, false, true);
        luoja = new TapahtumienLuoja(lauta);
        asettaja = new SelosteenAsettaja();
        ruudut = new ArrayList();
    }

    @Override
    public void luo() {
        luoRuudut();
        asetaScannerilleTiedosto("tekstit/RuutujenSelostukset.txt", RuutujenLuoja.class.getClassLoader());
        asettaja.asetaSelosteet(lista, lukija);
        ruudut = muunnaRuuduiksi();
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

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
        luoOstoJaMyyntiruutu(1, 574, 374, false);
        luoYksinkertainenAmmattiruutu(2, 513, 374, tyoton);
        luoYksinkertainenAmmattiruutu(3, 450, 374,
                new Ammatti("Opettaja", 5000, false, false, false));
        luoYksinkertainenAmmattiruutu(4, 387, 374,
                new Ammatti("Autonkuljettaja", 3000, false, false, true));
        luoYksinkertainenAmmattiruutu(5, 324, 374, tyoton);
        luoYksinkertainenAmmattiruutu(6, 261, 374,
                new Ammatti("Päälikkö", 9000, false, false, false));
        luoJohtajaTaiSattumaAmmattiruutu(7, 198, 374, false);
        luoJasenkirjaanVaikuttavaRuutu(8, 135, 374, true);
        luoRahaanVaikuttavaRuutu(9, 72, 374, true, 2000);
        luoVaaliruutu(10, 8, 374);
    }

    private void luoRuudut2() {
        luoPalkastaRiippuvaRuutu(11, 8, 312,
                luoRuudun11Tapahtumat(), luoRuudun11Palkkarajat());
        luoJasenkirjastaRiippuvaRuutu(12, 8, 251,
                luoja.luoOtaAmmattikorttiTapahtuma(true), luoja.luoOtaTapahtumakorttiTapahtuma());
        luoTietystaAmmatistaRiippuvaRuutu(13, 8, 190,
                tyoton, luoja.luoTapahtumaJokaEiTeeMitaan(),
                luoja.luoRahaanVaikuttavaTapahtuma(false, 500));
        luoTietystaAmmatistaRiippuvaRuutu(14, 8, 129, tyoton,
                luoja.luoTapahtumaJokaEiTeeMitaan(),
                luoja.luoRahaanVaikuttavaTapahtuma(true, 1000));
        luoRahaanVaikuttavaRuutu(15, 8, 68, false, 5000);
        luoOstoJaMyyntiruutu(16, 8, 7, true);
        luoTutkintoonVaikuttavaRuutu(17, 72, 7, true, false);
        luoYksinkertainenAmmattiruutu(18, 135, 7, tyoton);
        luoOtaLiikekorttiRuutu(19, 198, 7);
        luoOstoJaMyyntiruutu(20, 261, 7, false);
    }

    private void luoRuudut3() {
        luoMokinpoistoruutu(21, 324, 7, true);
        luoJohtajaTaiSattumaAmmattiruutu(22, 387, 7, true);
        luoRuutuJossaUseampiTapahtuma(23, 450, 7, luoja.luoRahaanVaikuttavaTapahtuma(false, 500),
                luoja.luoJohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(luoja.luoSiirraNappulaaTapahtuma(30), luoja.luoTapahtumaJokaEiTeeMitaan()));
        luoPutkaruutu(24, 513, 7);
        luoVaaliruutu(25, 575, 7);
        luoNappulaaSiirtavaRuutu(26, 575, 68, 1);
        luoRahaanVaikuttavaRuutu(27, 575, 129, true, 20000);
        luoTapahtumakorttiRuutu(28, 575, 190);
        luoVerotarkastusRuutu(29, 575, 251, false);
        luoVaaliruutu(30, 575, 312);
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
