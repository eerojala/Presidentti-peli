package presidenttipeli.peli;

import java.util.ArrayList;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.tapahtumat.JasenkirjaanVaikuttavaTapahtuma;
import presidenttipeli.domain.tapahtumat.MaksaKulujaLiikkeistaJaMokeista;
import presidenttipeli.domain.tapahtumat.OtaAmmattikortti;
import presidenttipeli.domain.tapahtumat.OtaKuukaudenTuotot;
import presidenttipeli.domain.tapahtumat.SiirraNappulaa;
import presidenttipeli.domain.tapahtumat.SijainnistaRiippuvaTapahtuma;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.domain.tapahtumat.TutkintoonVaikuttavaTapahtuma;
import presidenttipeli.logiikka.KaikenLuoja;
import presidenttipeli.logiikka.luojat.JohtajaAmmattienLuoja;
import presidenttipeli.logiikka.luojat.Luoja;
import presidenttipeli.logiikka.luojat.MokkienLuoja;
import presidenttipeli.logiikka.luojat.RuutujenLuoja;

public class App {

    public static void main(String[] args) {
        Tapahtuma testi;
        Pelaaja pelaaja;
        int rahaViimekuussa;
        ArrayList<Liike> liikkeet;
        Liike liike1;
        Liike liike2;
        testi = new OtaKuukaudenTuotot();
        pelaaja = new Pelaaja("Testi");
        rahaViimekuussa = pelaaja.getRahat();
        testi.suoritaTapahtuma(pelaaja);
        liikkeet = new ArrayList();
        liike1 = new Liike("Testiliike", "Testi1", 15000, 1500);
        liike2 = new Liike("Testiliike", "Testi2", 10000, 1000);
        liikkeet.add(liike1);
        liikkeet.add(liike2);
    }

}
