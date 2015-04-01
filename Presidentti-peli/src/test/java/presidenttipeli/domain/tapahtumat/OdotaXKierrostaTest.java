
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class OdotaXKierrostaTest {
    Tapahtuma testi;
    Pelaaja pelaaja;
    
    public OdotaXKierrostaTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void asettaaOikeanLuvun() {
        pelaaja.setOdottaaVuoroaan(1);
        testi = new OdotaXKierrosta(3);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(3, pelaaja.getOdottaaVuoroaan());
    }
    
}
