
package presidenttipeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class PutkaTest {
    Putka putka;
    Pelaaja pelaaja;
    
    public PutkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        putka = new Putka(new Pelilauta());
        pelaaja = new Pelaaja("Pelaaja");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelaajaJoutuuOdottamaan2Kierrosta() {
        putka.panePelaajaPutkaan(pelaaja);
        assertEquals(2, pelaaja.getOdottaaVuoroaan());
    }
    
}
