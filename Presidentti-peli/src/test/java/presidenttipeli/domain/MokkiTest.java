
package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MokkiTest {
    Mokki mokki1;
    Mokki mokki2;
    
    public MokkiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mokki1 = new Mokki("Mokki1", 10000);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsToimiiJosKaksiEriMokkia() {
        mokki2 = new Mokki("Mokki2", 10000);
        assertEquals(false, mokki1.equals(mokki2));
    }
    
    @Test
    public void equalsToimiiJosKaksiSamaaMokkia() {
        mokki2 = new Mokki("Mokki1", 1);
        assertEquals(true, mokki1.equals(mokki2));
    }
    
    @Test
    public void equalsToimiiJosKaksiEriLuokkaa() {
        Object object = new Object();
        assertEquals(false, mokki1.equals(object));
    }
    
    @Test
    public void compareToLaittaaOikeaanJarjestykseen() {
        mokki2 = new Mokki("Mokki2", 10001);
        ArrayList<Mokki> mokit = new ArrayList();
        mokit.add(mokki1);
        mokit.add(mokki2);
        Collections.sort(mokit);
        assertEquals(mokki2, mokit.get(0));
    }
}
