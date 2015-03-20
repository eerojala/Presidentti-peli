
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class KansanedustajuuteenVaikuttavaTapahtumaTest {
    Pelaaja pelaaja;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;
    
    public KansanedustajuuteenVaikuttavaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("test");
        tapahtuma1 = new KansanedustajuuteenVaikuttavaTapahtuma(true);
        tapahtuma2 = new KansanedustajuuteenVaikuttavaTapahtuma(false);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void asettaaPelaajalleKansanedustajuuden() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isKansanedustaja());
    }
    
    @Test
    public void ottaaPelaajaltaPoisKansanedustajuuden() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        tapahtuma2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isKansanedustaja());
    }
    
}
