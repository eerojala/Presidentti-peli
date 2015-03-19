
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class JasenkirjaanVaikuttavaTapahtumaTest {
    Pelaaja pelaaja;
    
    public JasenkirjaanVaikuttavaTapahtumaTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void jasenKirjanAntaminenOnnistuu() {
        Tapahtuma test = new JasenkirjaanVaikuttavaTapahtuma(true);
        test.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void jasenKirjanPoisOttaminenOnnistuu() {
        Tapahtuma test = new JasenkirjaanVaikuttavaTapahtuma(false);
        test.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
}
