
package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;


public class NappuloidenLuojaTest {
    NappuloidenLuoja luoja;
    ArrayList<Pelaaja> pelaajat;
    boolean vaite;
    
    public NappuloidenLuojaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaajat = new ArrayList();
        pelaajat.add(new Pelaaja("1"));
        pelaajat.add(new Pelaaja("2"));
        luoja = new NappuloidenLuoja(pelaajat);
        luoja.luo();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaranNappuloita() {
        assertEquals(pelaajat.size(), luoja.getNappulat().size());
    }
    
    @Test
    public void asettaaNappuloillePelaajan() {
        vaite = true;
        for (Nappula nappula : luoja.getNappulat()) {
            if (nappula.getOmistaja() == null) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void asettaaPelaajilleNappulan() {
        vaite = true;
        for (Nappula nappula : luoja.getNappulat()) {
            if (nappula.getOmistaja().getNappula() == null) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
}
