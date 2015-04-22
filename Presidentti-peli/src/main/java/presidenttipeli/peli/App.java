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
import presidenttipeli.domain.Tutkinto;
import presidenttipeli.domain.tapahtumat.OdotaXKierrosta;
import presidenttipeli.domain.tapahtumat.RahaanVaikuttavaTapahtuma;
import presidenttipeli.gui.*;
import presidenttipeli.logiikka.PelaajanStatus;
import presidenttipeli.logiikka.Peli;
import presidenttipeli.logiikka.Presidentinvaalienhallinta;
import presidenttipeli.logiikka.Velkalaskuri;

public class App {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new AloitusGUI());
        //presidentinVaaliTestaus();

    }

    private static void presidentinVaaliTestaus() {
        ArrayList<String> nimet = new ArrayList<String>();
        nimet.add("Testi");
        KaikenLuoja luoja = new KaikenLuoja(nimet);
        Peli peli = luoja.getPeli();
        PeliGUI peligui = new PeliGUI(peli);
        Pelaaja pelaaja = peli.getNykyinenPelaaja();
        //pelaaja.setAmmatti(new Ammatti("Johtaja", 10000, true, false, false));
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(40000);
        ArrayList<Mokki> mokit = new ArrayList();
        ArrayList<Liike> liikkeet = new ArrayList();
        mokit.add(new Mokki("hassula", 10000));
        mokit.add(new Mokki("dipoli", 20000));
        liikkeet.add(new Liike("testiliike", "testi", 30000, 5000));
        pelaaja.setOmistamatMokit(mokit);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(new Tutkinto(true));
        Presidentinvaalienhallinta hallinta = new Presidentinvaalienhallinta(peli.getNykyinenPelaaja(), peli.getVaalienjarjestaja(), peli.getPankinjohtaja(), peli.getKiinteistonvalittaja());
        java.awt.EventQueue.invokeLater(new PresidentinvaalienhallintaGUI(hallinta, peligui));

    }

}
