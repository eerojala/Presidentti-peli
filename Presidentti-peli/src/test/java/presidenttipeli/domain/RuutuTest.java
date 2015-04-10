
package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.tapahtumat.Tapahtuma;

public class RuutuTest {
    Ruutu ruutu1;
    Ruutu ruutu2;
    
    public RuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruutu1 = new Ruutu(1, true, true, true);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsToimiiJosKaksiEriRuutua() {
        ruutu2 = new Ruutu(2, true, true, true);
        assertEquals(false, ruutu1.equals(ruutu2));
    }
    
    @Test
    public void equalsToimiiJosKaksiSamaaRuutua() {
        ruutu2 = new Ruutu(1, false, false, false);
        assertEquals(true, ruutu1.equals(ruutu2));
    }
    
    @Test
    public void equalsToimiiJosKaksiEriLuokkaa() {
        Object object = new Object();
        assertEquals(false, ruutu1.equals(object));
    }
    
    @Test
    public void equalsToimiiJosNull() {
        assertEquals(false, ruutu1.equals(ruutu2));
    }
    
    @Test
    public void compareToLaittaaOikeaanJarjestykseen() {
        ruutu2 = new Ruutu(2, true, true, true);
        ArrayList<Ruutu> ruudut = new ArrayList();
        ruudut.add(ruutu2);
        ruudut.add(ruutu1);
        Collections.sort(ruudut);
        assertEquals(ruutu1, ruudut.get(0));
    }
}
