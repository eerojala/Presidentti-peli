
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


public class MenetaLiikeTest {
    Liike liike1;
    Liike liike2;
    Tapahtuma testi1;
    Tapahtuma testi2;
    Pelilauta lauta;
    Pelaaja pelaaja;
    int rahatEnnenPoistoa;
    
    public MenetaLiikeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        liike1 = new Liike("Testiliike", "Liike1", 10001, 5000);
        liike2 = new Liike("Testiliike", "Liike2", 10000, 5000);
        pelaaja = new Pelaaja("Testi");
        lauta = new Pelilauta();
        testi1 = new MenetaLiike(lauta, true);
        testi2 = new MenetaLiike(lauta, false);
        rahatEnnenPoistoa = pelaaja.getRahat();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void poistaaOikeanLiikkeen() {
        pelaaja.getOmistamatLiikkeet().add(liike2);
        pelaaja.getOmistamatLiikkeet().add(liike1);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(liike2, pelaaja.getOmistamatLiikkeet().get(0));
    }
    
    @Test
    public void antaaPelaajalleVakuutusrahatJosVakuutusKorvaa() {
        pelaaja.getOmistamatLiikkeet().add(liike2);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenPoistoa + liike2.getArvo()/2, pelaaja.getRahat());
    }
     
    @Test
    public void LiikkeidenMaaraEiMuutuJosEiYhtaanLiiketta() {
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(0, pelaaja.getOmistamatLiikkeet().size());
    }
    
    @Test
    public void eiAnnaVakuutusRahojaJosVakuutusEiKorvaa() {
        pelaaja.getOmistamatLiikkeet().add(liike2);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenPoistoa, pelaaja.getRahat());
    }
}
