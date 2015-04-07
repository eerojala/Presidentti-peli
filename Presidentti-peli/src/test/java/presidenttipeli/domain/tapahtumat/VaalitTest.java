
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class VaalitTest {
    Vaalit testi;
    Pelaaja pelaaja;
  
    public VaalitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi = new Vaalit(110);
        pelaaja = new Pelaaja("Testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaranAania() {
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(5, testi.getSaadutAanet().size());
    }
    
    @Test
    public void palauttaaTrueJosSaaTasanAania() {
        assertEquals(true, testi.onnistuikoVaalit(110));
    }
    
    @Test
    public void palauttaaTrueJosSaaEnemmanAania() {
        assertEquals(true, testi.onnistuikoVaalit(111));
    }
    
    @Test
    public void palauttaaFalseJosEiSaaTarpeeksiAania() {
        assertEquals(false, testi.onnistuikoVaalit(109));
    }
    
}
