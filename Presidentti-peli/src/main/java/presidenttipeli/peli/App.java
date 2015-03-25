package presidenttipeli.peli;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.tapahtumat.OtaAmmattikortti;
import presidenttipeli.domain.tapahtumat.SiirraNappulaa;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.logiikka.luojat.Luoja;
import presidenttipeli.logiikka.luojat.RuutujenLuoja;

public class App {

    public static void main(String[] args) {
        Pelilauta lauta = new Pelilauta();
        Luoja luoja = new RuutujenLuoja(lauta);
        luoja.luo();
    }

}
