
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class VerotarkastusTest {
    Tapahtuma testi;
    Pelaaja pelaaja;
    
    public VerotarkastusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi = new Verotarkastus();
        pelaaja = new Pelaaja("Testi");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void ottaaPoisOikeudenLiikkeidenTuottoon() {
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isOikeutettuTuottoon()); // pelaajalla on oletusarvoisesti oikeus tuottoon
    }
    
}
