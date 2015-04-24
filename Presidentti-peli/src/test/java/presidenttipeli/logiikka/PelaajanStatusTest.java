
package presidenttipeli.logiikka;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Tutkinto;


public class PelaajanStatusTest {
    Pelaaja pelaaja;
    PelaajanStatus status;
    ArrayList<Mokki> mokit;
    ArrayList<Liike> liikkeet;
    
    public PelaajanStatusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Testi");
        liikkeet = new ArrayList();
        liikkeet.add(new Liike("Testi", "Testi", 10000, 1000));
        mokit = new ArrayList();
        mokit.add(new Mokki("Testi1", 10000));
        mokit.add(new Mokki("Testi2", 20000));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void maintitseeTutkinnonOlevanYleissivistava() {
        pelaaja.setTutkinto(new Tutkinto(true));
        status = new PelaajanStatus(pelaaja);
        assertEquals(" (Yleissivistävä)", status.getYleissivistava());
    }
    
    @Test
    public void eiLisaaYleissivistavaaPeraanJosNormaaliTutkinto() {
        pelaaja.setTutkinto(new Tutkinto(false));
        status = new PelaajanStatus(pelaaja);
        assertEquals(true, status.getYleissivistava().isEmpty());
    }
    
    @Test
    public void luoOikeanKokoiseinMokkitaulukon1() {
        status = new PelaajanStatus(pelaaja);
        assertEquals(0, status.getMokkitaulukko().length);
    }
    
    @Test
    public void luoOikeanKokoisenMokkitaulukon2() {
        pelaaja.setOmistamatMokit(mokit);
        status = new PelaajanStatus(pelaaja);
        assertEquals(pelaaja.getOmistamatMokit().size(), status.getMokkitaulukko().length);
    }
    
    @Test
    public void mokkitaulukonEnsimmainenAlkioOnOikein() {
        pelaaja.setOmistamatMokit(mokit);
        status = new PelaajanStatus(pelaaja);
        assertEquals(pelaaja.getOmistamatMokit().get(0).toString(), status.getMokkitaulukko()[0]);
    }
    
    @Test
    public void luoOikeankokoisenLiiketaulukon1() {
        status = new PelaajanStatus(pelaaja);
        assertEquals(0, status.getLiiketaulukko().length);
    }
    
    @Test
    public void luoOikeankokoisenLiiketaulukon2() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        status = new PelaajanStatus(pelaaja);
        assertEquals(pelaaja.getOmistamatLiikkeet().size(), status.getLiiketaulukko().length);
    }
    
    @Test
    public void liiketaulukonEnsimmainenAlkioOnOikein() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        status = new PelaajanStatus(pelaaja);
        assertEquals(pelaaja.getOmistamatLiikkeet().get(0).toString(), status.getLiiketaulukko()[0]);
    }
}
