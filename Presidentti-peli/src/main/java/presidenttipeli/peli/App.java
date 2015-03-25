package presidenttipeli.peli;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.tapahtumat.OtaAmmattikortti;
import presidenttipeli.domain.tapahtumat.SiirraNappulaa;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.logiikka.luojat.RuutujenLuoja;

public class App {

    public static void main(String[] args) {
        Pelilauta lauta;
        Tapahtuma testi;
        Pelaaja pelaaja;
        lauta = new Pelilauta();
        lauta.getRuudut().add(new Ruutu(1, true, false, false));
        lauta.getRuudut().add(new Ruutu(2, false, false, false));
        lauta.getRuudut().add(new Ruutu(3, false, true, false));
        testi = new SiirraNappulaa(3, lauta);
        pelaaja = new Pelaaja("testi");
        testi.suoritaTapahtuma(pelaaja);
    }

}
