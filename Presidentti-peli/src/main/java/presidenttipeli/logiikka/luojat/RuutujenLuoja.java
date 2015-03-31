package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.SelosteenOmaava;
import presidenttipeli.domain.tapahtumat.*;
import presidenttipeli.logiikka.SelosteenAsettaja;

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
        lueTiedosto();
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

    private void lueTiedosto() {
        classloader = getClass().getClassLoader();
        tiedosto = new File(classloader.getResource("RuutujenSelostukset.txt").getFile());
        try {
            lukija = new Scanner(tiedosto, "UTF-8");
            asettaja.asetaSelosteet(lista, lukija);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }

    private void luoRuutu(boolean ostoJaMyyntiruutu, boolean vaaliruutu, boolean putkaruutu, int numero, Tapahtuma... tapahtumat) {
        Ruutu ruutu = new Ruutu(numero, ostoJaMyyntiruutu, vaaliruutu, putkaruutu);
        for (Tapahtuma tapahtuma : tapahtumat) {
            ruutu.getTapahtumat().add(tapahtuma);
        }
        lista.add(ruutu);
    }

    private void luoRuudut1() {
        luoOstoJaMyyntiruutu(1);
        luoYksinkertainenAmmattiruutu(2, tyoton);
        luoYksinkertainenAmmattiruutu(3, new Ammatti("Opettaja", 5000, false, false, false));
        luoYksinkertainenAmmattiruutu(4, new Ammatti("Autonkuljettaja", 3000, false, false, true));
        luoYksinkertainenAmmattiruutu(5, tyoton);
        luoYksinkertainenAmmattiruutu(6, new Ammatti("Päälikkö", 9000, false, false, false));
        luoJohtajaTaiSattumaAmmattiruutu(7, false);
        luoJasenkirjaanVaikuttavaRuutu(8, true);
        luoRahaanVaikuttavaRuutu(9, true, 2000);
        luoVaaliruutu(10);
    }

    private void luoRuudut2() {
        luoPalkastaRiippuvaRuutu(11, luoRuudun11Tapahtumat(), luoRuudun11Palkkarajat());
        luoJasenkirjastaRiippuvaRuutu(12, luoja.luoOtaAmmattikorttiTapahtuma(true), luoja.luoOtaTapahtumakorttiTapahtuma());
        luoTietystaAmmatistaRiippuvaRuutu(13, tyoton, luoja.luoTapahtumaJokaEiTeeMitaan(),
                luoja.luoRahaanVaikuttavaTapahtuma(false, 500));
        luoTietystaAmmatistaRiippuvaRuutu(14, tyoton, luoja.luoTapahtumaJokaEiTeeMitaan(),
                luoja.luoRahaanVaikuttavaTapahtuma(true, 1000));
        luoRahaanVaikuttavaRuutu(15, false, 5000);
        luoOstoJaMyyntiruutu(16);
        luoTutkintoonVaikuttavaRuutu(17, true, false);
        luoYksinkertainenAmmattiruutu(18, tyoton);
        luoOtaLiikekorttiRuutu(19);
        luoOstoJaMyyntiruutu(20);
    }

    private void luoRuudut3() {
        luoMokinpoistoruutu(21, true);
        luoJohtajaTaiSattumaAmmattiruutu(22, true);
        luoRuutuJossaUseampiTapahtuma(23, luoja.luoRahaanVaikuttavaTapahtuma(false, 500),
                luoja.luoJohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(luoja.luoSiirraNappulaaTapahtuma(30), luoja.luoTapahtumaJokaEiTeeMitaan()));
        luoPutkaruutu(24);
        luoVaaliruutu(25);
        luoNappulaaSiirtavaRuutu(26, 1);
        luoRahaanVaikuttavaRuutu(27, true, 20000);
        luoTapahtumakorttiRuutu(28);
        luoVerotarkastusRuutu(29);
        luoVaaliruutu(30);
    }

    private void luoOstoJaMyyntiruutu(int numero) {
        luoRuutu(true, false, false, numero);
    }

    private void luoYksinkertainenAmmattiruutu(int numero, Ammatti ammatti) {
        luoRuutu(false, false, false, numero, luoja.luoAsetaAmmattiTapahtuma(ammatti));
    }

    private void luoJohtajaTaiSattumaAmmattiruutu(int numero, boolean johtajaAmmatti) {
        luoRuutu(false, false, false, numero, luoja.luoOtaAmmattikorttiTapahtuma(johtajaAmmatti));
    }

    private void luoJasenkirjaanVaikuttavaRuutu(int numero, boolean pelaajalleJasenkirja) {
        luoRuutu(false, false, false, numero, luoja.luoJasenkirjaanVaikuttavaTapahtuma(pelaajalleJasenkirja));
    }

    private void luoRahaanVaikuttavaRuutu(int numero, boolean pelaajalleRahaa, int rahasumma) {
        luoRuutu(false, false, false, numero, luoja.luoRahaanVaikuttavaTapahtuma(pelaajalleRahaa, rahasumma));
    }

    private void luoVaaliruutu(int numero) {
        luoRuutu(false, true, false, numero);
    }

    private void luoPalkastaRiippuvaRuutu(int numero, ArrayList<Tapahtuma> tapahtumat, ArrayList<Integer> palkkarajat) {
        luoRuutu(false, false, false, numero, luoja.luoPalkastaRiippuvaTapahtuma(tapahtumat, palkkarajat));
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

    private void luoJasenkirjastaRiippuvaRuutu(int numero, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        luoRuutu(false, false, false, numero, luoja.luoTapahtumaJokaRiippuuJasenkirjasta(tapahtuma1, tapahtuma2));
    }

    private void luoTietystaAmmatistaRiippuvaRuutu(int numero, Ammatti ammatti, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        luoRuutu(false, false, false, numero,
                luoja.luoTietystaAmmatistaRiippuvaTapahtuma(ammatti, tapahtuma1, tapahtuma2));
    }

    private void luoTutkintoonVaikuttavaRuutu(int numero, boolean pelaajalleTutkinto, boolean yleissivistava) {
        luoRuutu(false, false, false, numero, luoja.luoTutkintoonVaikuttavaTapahtuma(pelaajalleTutkinto, yleissivistava));
    }

    private void luoOtaLiikekorttiRuutu(int numero) {
        luoRuutu(false, false, false, numero, luoja.luoOtaLiikekorttiTapahtuma());
    }

    private void luoMokinpoistoruutu(int numero, boolean vakuutusKorvaa) {
        luoRuutu(false, false, false, numero, luoja.luoMokinPoistoTapahtuma(vakuutusKorvaa));
    }

    private void luoRuutuJossaUseampiTapahtuma(int numero, Tapahtuma... tapahtumat) {
        luoRuutu(false, false, false, numero, tapahtumat);
    }

    private void luoPutkaruutu(int numero) {
        luoRuutu(false, false, true, numero);
    }

    private void luoNappulaaSiirtavaRuutu(int numero, int minne) {
        luoRuutu(false, false, false, numero, luoja.luoSiirraNappulaaTapahtuma(minne));
    }

    private void luoTapahtumakorttiRuutu(int numero) {
        luoRuutu(false, false, false, numero, luoja.luoOtaTapahtumakorttiTapahtuma());
    }

    private void luoVerotarkastusRuutu(int numero) {
        luoRuutu(false, false, false, numero, luoja.luoVerotarkastusTapahtuma());
    }

}
