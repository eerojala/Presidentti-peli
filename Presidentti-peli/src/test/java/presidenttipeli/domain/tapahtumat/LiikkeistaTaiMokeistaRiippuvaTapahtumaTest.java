
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;


public class LiikkeistaTaiMokeistaRiippuvaTapahtumaTest {
    Tapahtuma testi;
    Pelaaja pelaaja;
    int pelaajanRahat;
    int annettavaRaha;
    Liike liike;
    Mokki mokki;
    
    public LiikkeistaTaiMokeistaRiippuvaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Testi");
        pelaajanRahat = pelaaja.getRahat();
        annettavaRaha = 500;
        Tapahtuma tapahtuma1 = new JasenkirjaanVaikuttavaTapahtuma(true);
        Tapahtuma tapahtuma2 = new RahaanVaikuttavaTapahtuma(true, annettavaRaha);
        liike = new Liike("Testiliike", "Testi", 15000, 1500);
        mokki = new Mokki("Testi", 10000);
        testi = new LiikkeistaTaiMokeistaRiippuvaTapahtuma(tapahtuma1, tapahtuma2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void suorittaaTapahtuman1JosLiikeMuttaEiMokkia() {
        pelaaja.setPuolueenJasen(false);
        pelaaja.getOmistamatLiikkeet().add(liike);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void suorittaaTapahtuman1JosMokkiMuttaEiLiikkeita() {
        pelaaja.setPuolueenJasen(true);
        pelaaja.getOmistamatMokit().add(mokki);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void suorittaaTapahtuman1JosMokkiJaLiike() {
        pelaaja.setPuolueenJasen(true);
        pelaaja.getOmistamatLiikkeet().add(liike);
        pelaaja.getOmistamatMokit().add(mokki);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void suorittaaTapahtuman2JosEiYhtaanMokkiaTaiLiikettta() {
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(pelaajanRahat + annettavaRaha, pelaaja.getRahat());
    }
    
    @Test
    public void eiSuoritaTapahtumaa2JosOnMokkiTaiLiike() {
        pelaaja.getOmistamatLiikkeet().add(liike);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(pelaajanRahat, pelaaja.getRahat());
    }
    
    @Test
    public void eiSuoritaTapahtumaa1JosEiMokkejaTaiLiikkeita() {
        pelaaja.setPuolueenJasen(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
    
}
