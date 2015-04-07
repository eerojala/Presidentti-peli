
package presidenttipeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class VaalienjarjestajaTest {
    Vaalienjarjestaja jarjestaja;
    Pelaaja pelaaja;
    
    public VaalienjarjestajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jarjestaja = new Vaalienjarjestaja(new Pelilauta());
        pelaaja = new Pelaaja("Testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void onnistuneetEduskuntavaalitAntaaKansanedustajuuden() {
        jarjestaja.jarjestaEduskuntavaalit(Integer.MIN_VALUE, pelaaja);
        assertEquals(true, pelaaja.isKansanedustaja());
    }
    
    @Test
    public void epaonnistuneetEduskuntaVaalitEivatAnnaKansanedustajuutta() {
        jarjestaja.jarjestaEduskuntavaalit(Integer.MAX_VALUE, pelaaja);
        assertEquals(false, pelaaja.isKansanedustaja());
    }
    
    @Test
    public void eduskuntavaalitPalauttavatOikeanMaaranAania() {
        jarjestaja.jarjestaEduskuntavaalit(110, pelaaja);
        assertEquals(5, jarjestaja.getSaadutAanet().size());
    }
    
    @Test
    public void palauttaaTrueJosPresidentinvaalitOnnistuvat() {
        assertEquals(true, jarjestaja.jarjestaPresidentinvaalit(Integer.MIN_VALUE, pelaaja));
    }
    
    @Test
    public void palauttaaFalseJosPresidentinvaalitEpaonnistuvat() {
        assertEquals(false, jarjestaja.jarjestaPresidentinvaalit(Integer.MAX_VALUE, pelaaja));
    }
    
    @Test
    public void presidentinvaalitPalauttavatOikeanMaaranAania() {
        jarjestaja.jarjestaPresidentinvaalit(110, pelaaja);
        assertEquals(5, jarjestaja.getSaadutAanet().size());
    }
}
