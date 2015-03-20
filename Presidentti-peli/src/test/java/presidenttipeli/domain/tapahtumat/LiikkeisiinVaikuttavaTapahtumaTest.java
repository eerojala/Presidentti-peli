
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;

public class LiikkeisiinVaikuttavaTapahtumaTest {
    Liike liike;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;
    Pelaaja pelaaja;
    
    public LiikkeisiinVaikuttavaTapahtumaTest() {
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
        liike = new Liike("liike1", 10000, 1000);
        tapahtuma1 = new LiikkeisiinVaikuttavaTapahtuma(liike, true);
        tapahtuma2 = new LiikkeisiinVaikuttavaTapahtuma(liike, false);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void liikkeenLisaaminenOnnistuu() {
        assertEquals(true, tapahtuma1.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void lisaaOikeanLiikkeen() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        assertEquals(liike, pelaaja.getOmistamatLiikkeet().get(0));
    }
    
    @Test
    public void liikkeenPoistaminenOnnistuu() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        assertEquals(true, tapahtuma2.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void poistaaOikeanLiikkeen() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        Tapahtuma tapahtuma3 = new LiikkeisiinVaikuttavaTapahtuma(new Liike("testi", 30000, 3000), true);
        tapahtuma3.suoritaTapahtuma(pelaaja);
        tapahtuma2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.getOmistamatLiikkeet().contains(liike));
    }
    
    @Test
    public void liikkeenPoistaminenEpaonnistuuJosPelaajallaEiOleTataLiiketta() {
        assertEquals(false, tapahtuma2.suoritaTapahtuma(pelaaja));
    }
    
}
