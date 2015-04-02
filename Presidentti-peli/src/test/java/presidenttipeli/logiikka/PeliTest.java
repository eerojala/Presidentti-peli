
package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.logiikka.luojat.*;


public class PeliTest {
    KaikenLuoja luoja;
    ArrayList<String> nimet;
    Peli peli;
    Nappula nappula;
    int silmaluku;
    int vanhaSijainti;
    
    public PeliTest() {
        nimet = new ArrayList();
        nimet.add("Testi1");
        nimet.add("Testi2");
        luoja = new KaikenLuoja(nimet);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        peli = luoja.getPeli();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        boolean vaite = true;
        assertEquals(true, vaite);
    }
    
}
