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
import presidenttipeli.domain.tapahtumat.Vaalit;
import presidenttipeli.logiikka.KaikenLuoja;
import presidenttipeli.logiikka.Kiinteistonvalittaja;
import presidenttipeli.logiikka.luojat.JohtajaAmmattienLuoja;
import presidenttipeli.logiikka.luojat.Luoja;
import presidenttipeli.logiikka.luojat.MokkienLuoja;
import presidenttipeli.logiikka.luojat.RuutujenLuoja;
import javax.swing.SwingUtilities;
import presidenttipeli.gui.*;
import presidenttipeli.logiikka.PelaajanStatus;

public class App {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AloitusGUI().setVisible(true);
            }
        });
    }

}
