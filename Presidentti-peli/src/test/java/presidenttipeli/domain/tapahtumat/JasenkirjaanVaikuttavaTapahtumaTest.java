
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
    Tapahtuma test1;
    Tapahtuma test2;
    
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
        test1 = new JasenkirjaanVaikuttavaTapahtuma(true);
        test2 = new JasenkirjaanVaikuttavaTapahtuma(false);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void jasenKirjanAntaminenOnnistuu() {
        test1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void jasenKirjanPoisOttaminenOnnistuu() {
        test1.suoritaTapahtuma(pelaaja);
        test2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
}
