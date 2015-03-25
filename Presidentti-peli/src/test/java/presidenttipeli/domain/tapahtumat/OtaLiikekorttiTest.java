
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class OtaLiikekorttiTest {
    Pelilauta lauta;
    Pelaaja pelaaja;
    Tapahtuma testi;
    
    public OtaLiikekorttiTest() {
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
        lauta.getLiikkeet().add(new Liike("Liike", 30000, 3000));
        testi = new OtaLiikekortti(lauta);
        pelaaja = new Pelaaja("testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ottaaLiikepinostaYhdenKortin() {
        int liikekorttipinonKoko = lauta.getLiikkeet().size();
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(liikekorttipinonKoko - 1, lauta.getLiikkeet().size());
    }
    
}
