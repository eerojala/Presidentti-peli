
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


public class MenetaMokkiTest {
    Mokki mokki1;
    Mokki mokki2;
    Tapahtuma testi1;
    Tapahtuma testi2;
    Pelilauta lauta;
    Pelaaja pelaaja;
    int rahatEnnenPoistoa;
    
    public MenetaMokkiTest() {
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
        testi1 = new MenetaMokki(lauta, true);
        testi2 = new MenetaMokki(lauta, false);
        rahatEnnenPoistoa = pelaaja.getRahat();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void poistaaOikeanMokin() {
        pelaaja.getOmistamatMokit().add(mokki2);
        pelaaja.getOmistamatMokit().add(mokki1);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(mokki2, pelaaja.getOmistamatMokit().get(0));
    }
    
    @Test
    public void antaaPelaajalleVakuutusrahatJosVakuutusKorvaa() {
        pelaaja.getOmistamatMokit().add(mokki2);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenPoistoa + mokki2.getArvo()/2, pelaaja.getRahat());
    }
    
    @Test
    public void mokkienMaaraEiMuutuJosEiYhtaanMokkia() {
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(0, pelaaja.getOmistamatMokit().size());
    }
    
    @Test
    public void eiAnnaVakuutusRahojaJosVakuutusEiKorvaa() {
        pelaaja.getOmistamatMokit().add(mokki2);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenPoistoa, pelaaja.getRahat());
    }
}
