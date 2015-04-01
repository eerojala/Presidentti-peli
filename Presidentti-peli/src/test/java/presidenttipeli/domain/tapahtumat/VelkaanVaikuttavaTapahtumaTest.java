
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class VelkaanVaikuttavaTapahtumaTest {
    Tapahtuma testi1;
    Tapahtuma testi2;
    Pelaaja pelaaja;
    int velatEnnen;
    int kuinkaPaljon;
    
    public VelkaanVaikuttavaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kuinkaPaljon = 2000;
        testi1 = new VelkaanVaikuttavaTapahtuma(true, kuinkaPaljon);
        testi2 = new VelkaanVaikuttavaTapahtuma(false, kuinkaPaljon);
        pelaaja = new Pelaaja("Testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void velanLisaysOnnistuu() {
        velatEnnen = pelaaja.getVelkaa();
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(velatEnnen + kuinkaPaljon, pelaaja.getVelkaa());
    }
    
    @Test
    public void velanVahentaminenOnnistuu() {
        testi1.suoritaTapahtuma(pelaaja);
        velatEnnen = pelaaja.getVelkaa();
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(velatEnnen - kuinkaPaljon, pelaaja.getVelkaa());
    }
}
