
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;

public class TutkintoonVaikuttavaTapahtumaTest {
    Pelaaja pelaaja;
    Tapahtuma test1;
    Tapahtuma test2;
    
    public TutkintoonVaikuttavaTapahtumaTest() {
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
        test1 = new TutkintoonVaikuttavaTapahtuma(true);
        test2 = new TutkintoonVaikuttavaTapahtuma(false);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void tutkinnonAntaminenPelaajalleOnnistuu() {
        test1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.omistaaTutkinnon());
    }
    
    @Test
    public void tutkinnonOttaminenPelaajaltaOnnistuu() {
        test1.suoritaTapahtuma(pelaaja);
        test2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.omistaaTutkinnon());
    }
}
