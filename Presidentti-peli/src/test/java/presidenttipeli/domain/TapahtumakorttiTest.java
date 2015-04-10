
package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TapahtumakorttiTest {
    Tapahtumakortti kortti1;
    Tapahtumakortti kortti2;
    Tapahtumakortti kortti3;
    
    public TapahtumakorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kortti1 = new Tapahtumakortti();
        kortti2 = new Tapahtumakortti();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsToToimiiJosKaksiEriTapahtumakorttia() {
        kortti2.setSeloste("testi");
        assertEquals(false, kortti1.equals(kortti2));
    }
    
    @Test
    public void equalsToToimiiJosKaksiSamaaTapahtumakorttia() {
        assertEquals(true, kortti1.equals(kortti2));
    }
    
    @Test
    public void equalsToToimiiJosKaksiEriLuokkaa() {
        Object object = new Object();
        assertEquals(false, kortti1.equals(object));
    }
    
    @Test
    public void equalsToimiiJosNull() {
        assertEquals(false, kortti1.equals(kortti3));
    }
    
    @Test
    public void compareToLaittaaOikeaanJarjestykseen() {
        kortti2.setSeloste("testi"); // oletusseloste on "placeholder"
        ArrayList<Tapahtumakortti> kortit = new ArrayList();
        kortit.add(kortti2);
        kortit.add(kortti1);
        Collections.sort(kortit);
        assertEquals(kortti1, kortit.get(0));
    }
}
