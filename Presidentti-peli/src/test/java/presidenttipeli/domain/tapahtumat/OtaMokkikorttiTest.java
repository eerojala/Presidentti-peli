
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class OtaMokkikorttiTest {
    Pelilauta lauta;
    Pelaaja pelaaja;
    Tapahtuma testi;
    
    public OtaMokkikorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauta = new Pelilauta();
        lauta.getMokit().add(new Mokki("Testimokki", 10000));
        testi = new OtaMokkikortti(lauta);
        pelaaja = new Pelaaja("testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ottaaMokkipinostaYhdenKortin() {
        int mokkipinonkoko = lauta.getMokit().size();
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(mokkipinonkoko - 1, lauta.getMokit().size());
    }
    
}
