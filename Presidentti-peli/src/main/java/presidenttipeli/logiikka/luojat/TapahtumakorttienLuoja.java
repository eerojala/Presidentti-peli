package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.SelosteenOmaava;
import presidenttipeli.domain.Tapahtumakortti;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.util.SelosteenAsettaja;

public class TapahtumakorttienLuoja extends Luoja {

    private Pelilauta lauta;
    private ArrayList<SelosteenOmaava> lista;
    private TapahtumienLuoja luoja;
    private SelosteenAsettaja asettaja;

    public TapahtumakorttienLuoja(Pelilauta lauta) {
        this.lauta = lauta;
        lista = new ArrayList();
        luoja = new TapahtumienLuoja(lauta);
        asettaja = new SelosteenAsettaja();
    }

    @Override
    public void luo() {
        luoKortit();
        asetaScannerilleTiedosto("tekstit/TapahtumakorttienSelostukset.txt",
                TapahtumakorttienLuoja.class.getClassLoader());
        asettaja.asetaSelosteet(lista, lukija);
    }

    public ArrayList<SelosteenOmaava> getLista() {
        return lista;
    }

    public ArrayDeque<Tapahtumakortti> getKortit() {
        return muunnaTapahtumakorteiksi();
    }

    private ArrayDeque<Tapahtumakortti> muunnaTapahtumakorteiksi() {
        ArrayDeque<Tapahtumakortti> kortit = new ArrayDeque();
        Collections.shuffle(lista);
        for (SelosteenOmaava apu : lista) {
            kortit.add((Tapahtumakortti) apu);
        }
        return kortit;
    }

    private void luoKortit() {
        luoRahaanVaikuttavatKortit();
        luoSijaintiinVaikuttavatKortit();
        luoKonkurssiKortit();
        luoStressaantumisKortit();
        luoMaksaKulujaLiikkeistaJaMokeistaKortit();
        luoSijainnistaRiippuvatKortit();
        luoYleissivistavaKoulutusKortit();
        luoPuolueenJasenkirjanMenetysKortit();
        luoKortitJoissaEiTapahduMitaan();
    }

    private void luoTapahtumakortti(Tapahtuma... tapahtumat) {
        Tapahtumakortti kortti = new Tapahtumakortti();
        for (Tapahtuma tapahtuma : tapahtumat) {
            kortti.getTapahtumat().add(tapahtuma);
        }
        lista.add(kortti);
    }

    private void luoRahaanVaikuttavatKortit() {
        luoXArvoisetRahakortit(1500, 1, true);
        luoXArvoisetRahakortit(1500, 2, false);
        luoXArvoisetRahakortit(1400, 1, false);
        luoXArvoisetRahakortit(1200, 1, true);
        luoXArvoisetRahakortit(1000, 2, true);
        luoXArvoisetRahakortit(1000, 2, false);
        luoXArvoisetRahakortit(800, 1, true);
        luoXArvoisetRahakortit(800, 2, false);
        luoXArvoisetRahakortit(500, 2, true);
        luoXArvoisetRahakortit(500, 2, false);
        luoXArvoisetRahakortit(400, 1, false);
        luoXArvoisetRahakortit(200, 3, false);
    }

    private void luoXArvoisetRahakortit(int summa, int montako, boolean pelaajalleRahaa) {
        for (int i = 0; i < montako; i++) {
            luoTapahtumakortti(luoja.luoRahaanVaikuttavaTapahtuma(pelaajalleRahaa, summa));
        }
    }

    private void luoSijaintiinVaikuttavatKortit() {
        luoTapahtumakortti(luoja.luoSiirraNappulaaTapahtuma(30));
        luoTapahtumakortti(luoja.luoSiirraNappulaaTapahtuma(25));
        luoTapahtumakortti(luoja.luoSiirraNappulaaTapahtuma(22));
    }

    private void luoKonkurssiKortit() {
        luoTapahtumakortti(luoja.luoLiikkeenPoistoTapahtuma(false));
        luoTapahtumakortti(luoja.luoLiikkeenPoistoTapahtuma(false));
    }

    private void luoStressaantumisKortit() {
        luoTapahtumakortti(luoja.luoOdotaXKierrostaTapahtuma(2));
    }

    private void luoMaksaKulujaLiikkeistaJaMokeistaKortit() {
        luoTapahtumakortti(luoja.luoMaksaKulujaLiikkeistaJaMokeista(500));
    }

    private void luoSijainnistaRiippuvatKortit() {
        luoTapahtumakortti(luoja.luoSijainnistaRiippuvaTapahtuma(luoja.luoNostaLikkeidenTuottoTapahtuma(),
                luoja.luoTapahtumaJokaEiTeeMitaan(), 16));
    }

    private void luoYleissivistavaKoulutusKortit() {
        luoTapahtumakortti(luoja.luoTutkintoonVaikuttavaTapahtuma(true, true));
        luoTapahtumakortti(luoja.luoTutkintoonVaikuttavaTapahtuma(true, true));
    }

    private void luoPuolueenJasenkirjanMenetysKortit() {
        luoTapahtumakortti(luoja.luoJasenkirjaanVaikuttavaTapahtuma(false));
        luoTapahtumakortti(luoja.luoJasenkirjaanVaikuttavaTapahtuma(false));

    }

    private void luoKortitJoissaEiTapahduMitaan() {
        luoTapahtumakortti(luoja.luoTapahtumaJokaEiTeeMitaan());
        luoTapahtumakortti(luoja.luoTapahtumaJokaEiTeeMitaan());
        luoTapahtumakortti(luoja.luoTapahtumaJokaEiTeeMitaan());
    }

}
