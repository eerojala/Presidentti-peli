
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Tutkinto;

public class TutkintoonVaikuttavaTapahtumaTest {
    Pelaaja pelaaja;
    Tapahtuma testi1;
    Tapahtuma testi2;
    Tapahtuma testi3;
    
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
        pelaaja = new Pelaaja("Testi");
        testi1 = new TutkintoonVaikuttavaTapahtuma(true, false);
        testi2 = new TutkintoonVaikuttavaTapahtuma(false, false);
        testi3 = new TutkintoonVaikuttavaTapahtuma(true, true);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void normaalinTutkinnonAntaminenOnnistuu() {
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.getTutkinto().isYleissivistava());
    }
    
    @Test
    public void tutkinnonOttaminenPelaajaltaOnnistuu() {
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(null, pelaaja.getTutkinto());
    }
    
    @Test
    public void yleissivistavanTutkinnonAntaminenOnnistuu() {
        testi3.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.getTutkinto().isYleissivistava());
    }
    
    @Test
    public void eiAnnaNormaaliaTutkintoaJosPelaajallaOnYleissivistävaTutkinto() {
        pelaaja.setTutkinto(new Tutkinto(true));
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.getTutkinto().isYleissivistava());
    }
}
