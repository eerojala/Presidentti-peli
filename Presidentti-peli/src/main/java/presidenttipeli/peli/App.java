package presidenttipeli.peli;

import java.util.ArrayList;
import presidenttipeli.domain.*;
import presidenttipeli.domain.tapahtumat.*;
import presidenttipeli.logiikka.*;
import javax.swing.SwingUtilities;
import presidenttipeli.gui.*;

public class App {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new AloitusGUI());
        //presidentinVaaliTestaus();
        //testaaOstoJaMyyntiGUI();

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

    private static void testaaOstoJaMyyntiGUI() {
        ArrayList<String> nimet = new ArrayList<String>();
        nimet.add("Testi");
        KaikenLuoja luoja = new KaikenLuoja(nimet);
        Peli peli = luoja.getPeli();
        PeliGUI peligui = new PeliGUI(peli);
        Pelaaja pelaaja = peli.getNykyinenPelaaja();
        pelaaja.setRahat(50000);
        ArrayList<Mokki> mokit = new ArrayList();
        ArrayList<Liike> liikkeet = new ArrayList();
        mokit.add(new Mokki("hassula", 10000));
        mokit.add(new Mokki("dipoli", 20000));
        liikkeet.add(new Liike("testiliike", "testi", 30000, 5000));
        pelaaja.setOmistamatMokit(mokit);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(new Tutkinto(true));
        peli.getLauta().getMokit().clear();      
        peli.getLauta().getLiikkeet().clear();
        OstoJaMyynti ostoJaMyynti = new OstoJaMyynti(true, 1, false, peli.getNykyinenPelaaja(),
                peli.getKiinteistonvalittaja(), peli.getLauta().getMokit().peek(),
                peli.getLauta().getLiikkeet().peek(), peli.getLauta(), true);
        java.awt.EventQueue.invokeLater(new OstoJaMyyntiGUI(ostoJaMyynti));
    }

}
