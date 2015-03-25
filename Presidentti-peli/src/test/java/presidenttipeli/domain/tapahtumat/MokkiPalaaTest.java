
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


public class MokkiPalaaTest {
    Mokki mokki1;
    Mokki mokki2;
    Tapahtuma testi;
    Pelilauta lauta;
    Pelaaja pelaaja;
    
    public MokkiPalaaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mokki1 = new Mokki("mokki1", 10001);
        mokki2 = new Mokki("mokki2", 10000);
        pelaaja = new Pelaaja("testi");
        lauta = new Pelilauta();
        testi = new MokkiPalaa(lauta);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void polttaaOikeanMokin() {
        pelaaja.getOmistamatMokit().add(mokki2);
        pelaaja.getOmistamatMokit().add(mokki1);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(mokki2, pelaaja.getOmistamatMokit().get(0));
    }
    
    @Test
    public void antaaPelaajalleVakuutusrahat() {
        pelaaja.getOmistamatMokit().add(mokki2);
        int rahatEnnenVahinkoa = pelaaja.getRahaa();
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenVahinkoa + mokki2.getArvo()/2, pelaaja.getRahaa());
    }
    
    @Test
    public void poltettuMokkiEiLoydyEnaaPelaajalta() {
        pelaaja.getOmistamatMokit().add(mokki1);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.getOmistamatMokit().contains(mokki1));
    }
    
    @Test
    public void eiPoltaMokkiaJosPelaajaEiOmistaYhtaanMokkia() {
        assertEquals(false, testi.suoritaTapahtuma(pelaaja));
    }
}
