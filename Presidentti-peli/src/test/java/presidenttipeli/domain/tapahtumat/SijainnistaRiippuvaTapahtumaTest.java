
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;


public class SijainnistaRiippuvaTapahtumaTest {
    Tapahtuma tapahtuma1, tapahtuma2;
    Tapahtuma testi;
    Pelaaja pelaaja;
    Ruutu ruutu1;
    Ruutu ruutu2;
    Nappula nappula;
    
    public SijainnistaRiippuvaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tapahtuma1 = new JasenkirjaanVaikuttavaTapahtuma(true);
        tapahtuma2 = new TutkintoonVaikuttavaTapahtuma(true, false);
        ruutu1 = new Ruutu(1, 0, 0);
        ruutu2 = new Ruutu(2, 0, 0);
        pelaaja = new Pelaaja("Testi");
        nappula = new Nappula(pelaaja);
        testi = new SijainnistaRiippuvaTapahtuma(tapahtuma1, tapahtuma2, 1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void suorittaaTapahtuman1JosOikeaSijainti() {
        nappula.setSijainti(ruutu1);
        pelaaja.setNappula(nappula);
        pelaaja.setPuolueenJasen(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
   
    @Test
    public void suorittaaTapahtuman2JosEriSijainti() {
        nappula.setSijainti(ruutu2);
        pelaaja.setNappula(nappula);
        pelaaja.setTutkinto(null);
        testi.suoritaTapahtuma(pelaaja);
        boolean vaite = true;
        if (pelaaja.getTutkinto() == null) {
            vaite = false;
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void eiSuoritaTapahtumaa2JosOikeaSijainti() {
        nappula.setSijainti(ruutu1);
        pelaaja.setNappula(nappula);
        pelaaja.setTutkinto(null);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(null, pelaaja.getTutkinto());
    }
    
    @Test
    public void eiSuoritaTapahtumaa1JosEriSijainti() {
        nappula.setSijainti(ruutu2);
        pelaaja.setNappula(nappula);
        pelaaja.setPuolueenJasen(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
}
