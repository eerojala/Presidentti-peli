
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;

/**
 *
 * @author Eero
 */
public class RahaanVaikuttavaTapahtumaTest {
    RahaanVaikuttavaTapahtuma test1;
    RahaanVaikuttavaTapahtuma test2;
    RahaanVaikuttavaTapahtuma test3;
    Pelaaja pelaaja;
    
    public RahaanVaikuttavaTapahtumaTest() {
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
        pelaaja.setRahat(1000);
        test1 = new RahaanVaikuttavaTapahtuma(true, 1000);
        test2 = new RahaanVaikuttavaTapahtuma(false, 1000);
        test3 = new RahaanVaikuttavaTapahtuma(false, 1001);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelaajalleAntaminenOnnistuu() {      
        assertEquals(true, test1.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void pelaajaltaOttaminenOnnistuuJosTarpeeksiRahaa() {
        assertEquals(true, test2.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void pelaajaltaOttaminenEpaonnistuuJosEiTarpeeksiRahaa() {
        assertEquals(false, test3.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void pelaajalleAnnetaanOikeaSummaRahaa() {
        test1.suoritaTapahtuma(pelaaja);
        assertEquals(2000, pelaaja.getRahat());
    }
    
    @Test
    public void pelaajaltaOtetaanOikeaSummaRahaaJosOnTarpeeksi() {
        test2.suoritaTapahtuma(pelaaja);
        assertEquals(0, pelaaja.getRahat());
    }
    
    @Test
    public void pelaajaltaEiOtetaRahaaJosHanellaEiOleTarpeeksi() {
        test3.suoritaTapahtuma(pelaaja);
        assertEquals(1000, pelaaja.getRahat());
    }
}
