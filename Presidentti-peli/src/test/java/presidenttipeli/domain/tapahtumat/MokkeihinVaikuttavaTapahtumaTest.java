
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


public class MokkeihinVaikuttavaTapahtumaTest {
    Mokki mokki;
    Pelaaja pelaaja;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;
    Pelilauta lauta;
    
    public MokkeihinVaikuttavaTapahtumaTest() {
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
        mokki = new Mokki("mokki1", 10000);
        lauta = new Pelilauta();
        tapahtuma1 = new MokkeihinVaikuttavaTapahtuma(mokki, true, lauta);
        tapahtuma2 = new MokkeihinVaikuttavaTapahtuma(mokki, false, lauta);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void mokinAntaminenOnnistuu() {
        assertEquals(true, tapahtuma1.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void antaaPelaajalleOikeanMokin() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        assertEquals(mokki, pelaaja.getOmistamatMokit().get(0));
    }
    
    @Test
    public void mokinOttaminenOnnistuu() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        assertEquals(true, tapahtuma2.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void ottaaPelaajaltaPoisOikeanMokin() {
        tapahtuma1.suoritaTapahtuma(pelaaja);
        Tapahtuma tapahtuma3 = new MokkeihinVaikuttavaTapahtuma(new Mokki("testi", 45000), true, lauta);
        tapahtuma3.suoritaTapahtuma(pelaaja);
        tapahtuma2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.getOmistamatMokit().contains(mokki));
    }
    
    @Test
    public void palauttaaMokinTakaisinKorttipinoonPoistonJalkeen() {
        tapahtuma2.suoritaTapahtuma(pelaaja);
        assertEquals(mokki, lauta.getMokit().getLast());
    }
}
