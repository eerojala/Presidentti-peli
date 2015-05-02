
package presidenttipeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;


public class PutkaTest {
    Putka putka;
    Pelaaja pelaaja;
    TapahtumienLuoja luoja = new TapahtumienLuoja(new Pelilauta());
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
        putka = new Putka(luoja);
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
