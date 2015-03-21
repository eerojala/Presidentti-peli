
package presidenttipeli.domain.tapahtumat;

import java.util.ArrayDeque;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Ruutu;


public class NappulanSijaintiinVaikuttavaTapahtumaTest {
    Pelaaja pelaaja;
    Nappula nappula;
    Ruutu uusiSijainti;
    Ruutu vanhaSijainti;
    Tapahtuma tapahtuma;
    
    public NappulanSijaintiinVaikuttavaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("");
        uusiSijainti = new Ruutu(0);
        vanhaSijainti = new Ruutu(1);
        nappula = new Nappula(pelaaja);
        pelaaja.setNappula(nappula);
        nappula.setSijainti(vanhaSijainti);
        tapahtuma = new NappulanSijaintiinVaikuttavaTapahtuma(uusiSijainti);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void asettaaUudenSijainnin() {
        tapahtuma.suoritaTapahtuma(pelaaja);
        assertEquals(uusiSijainti, pelaaja.getNappula().getSijainti());
    }
    
    
}
