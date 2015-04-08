
package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AloitusTest {
    Aloitus testi;
    ArrayList<String> nimet;
    
    public AloitusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi = new Aloitus();
        nimet = new ArrayList();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pituustarkastusPalauttaaTrueJosKaikkiSopivanPituisia() {
        nimet.add("1");
        nimet.add("123456789012345678901234");
        assertEquals(true, testi.pituustarkastus(nimet));
    }
    
    @Test
    public void pituustarkastusPalauttaaFalseJosNimiOnLiianLyhyt() {
        nimet.add("");
        nimet.add("1");
        assertEquals(false, testi.pituustarkastus(nimet));
    }
    
    @Test
    public void pituustarkastusPalauttaaFalseJosNimiOnLiianPitka() {
        nimet.add("123");
        nimet.add("1234567890123456789012345");
        assertEquals(false, testi.pituustarkastus(nimet));   
    }
    
    @Test
    public void samuustarkastusPalauttaaTrueJosNimetEri() {
        nimet.add("1");
        nimet.add("2");
        assertEquals(true, testi.samuustarkastus(nimet));
    }
    
    @Test
    public void samuustarkastusPalauttaaFalseJosSamojaNimia() {
        nimet.add("1");
        nimet.add("1");
        assertEquals(false, testi.samuustarkastus(nimet));
    }
    
    
}
