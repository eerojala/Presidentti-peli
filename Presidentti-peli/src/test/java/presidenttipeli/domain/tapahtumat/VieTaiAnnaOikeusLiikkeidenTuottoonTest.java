
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class VieTaiAnnaOikeusLiikkeidenTuottoonTest {
    Tapahtuma testi1;
    Tapahtuma testi2;
    Pelaaja pelaaja;
    
    public VieTaiAnnaOikeusLiikkeidenTuottoonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi1 = new VieTaiAnnaOikeusLiikkeidenTuottoon(false);
        testi2 = new VieTaiAnnaOikeusLiikkeidenTuottoon(true);
        pelaaja = new Pelaaja("Testi");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void ottaaPoisOikeudenLiikkeidenTuottoon() {
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isOikeutettuTuottoon()); // pelaajalla on oletusarvoisesti oikeus tuottoon
    }
    
    @Test
    public void antaaOikeudenLiikkeidenTuottoon() {
        pelaaja.setOikeutettuTuottoon(false);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isOikeutettuTuottoon());
    }
    
}
