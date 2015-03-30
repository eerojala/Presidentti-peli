
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;


public class NostaLiikkeidenTuottoTest {
    Pelaaja pelaaja;
    Tapahtuma testi;
    int rahat;
    
    public NostaLiikkeidenTuottoTest() {
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
        testi = new NostaLiikkeidenTuotto();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void eiVaikutaPelaajanRahaanJosEiYhtaanLiiketta() {
        rahat = pelaaja.getRahat();
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahat, pelaaja.getRahat());
    }
    
    @Test
    public void pelaajaSaaOikeanMaaranRahaa() {
        rahat = pelaaja.getRahat();
        int liikkeen1Tuotto = 3000;
        int liikkeen2Tuotto = 5000;
        pelaaja.getOmistamatLiikkeet().add(new Liike("Testiliike", "Testi1", 0, liikkeen1Tuotto));
        pelaaja.getOmistamatLiikkeet().add(new Liike("Testiliike", "Testi2", 0, liikkeen2Tuotto));
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahat + liikkeen1Tuotto + liikkeen2Tuotto, pelaaja.getRahat());
    }
    
}
