
package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class PelaajienLuojaTest {
    PelaajienLuoja luoja;
    ArrayList<String> nimet;
    boolean vaite;
    
    public PelaajienLuojaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nimet = new ArrayList<String>();
        nimet.add("Testi1");
        nimet.add("Testi2");
        luoja = new PelaajienLuoja(nimet);
        luoja.luo();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaranPelaajia() {
        assertEquals(nimet.size(), luoja.getPelaajat().size());
    }
    
    @Test
    public void antaaPelaajalleOikeanNimen() {
        assertEquals(nimet.get(1), luoja.getPelaajat().get(1).getNimi());
    }
    
    @Test
    public void antaaKaikillePelaajilleNimen() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (pelaaja.getNimi() == null) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void antaaPelaajilleAloitusrahat() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (pelaaja.getRahat() != 5000) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajillaEiOleVelkaa() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (pelaaja.getVelkaa() != 0) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajatSaavatLiikkua() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (pelaaja.getOdottaaVuoroaan() != 0) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajatOvatTyottomia() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (!pelaaja.getAmmatti().getNimi().equals("Työtön")) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajatEivatKuuluPuolueeseen() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (pelaaja.isPuolueenJasen() != false) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajatEivatOleKansanedustajia() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (pelaaja.isKansanedustaja() != false) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajillaOnOikeusLiikkeittenTuottoon() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (pelaaja.isOikeutettuTuottoon() != true) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajillaEiOleMokkeja() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (!pelaaja.getOmistamatMokit().isEmpty()) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajillaEiOleLiikkeita() {
        vaite = true;
        for (Pelaaja pelaaja : luoja.getPelaajat()) {
            if (!pelaaja.getOmistamatLiikkeet().isEmpty()) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
}
