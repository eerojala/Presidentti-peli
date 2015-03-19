
package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AmmattiTest {
    Ammatti ammatti1;
    Ammatti ammatti2;
    
    public AmmattiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsToimiiJosKaksiEri() {
        ammatti1 = new Ammatti("ammatti1", 10000, true, true);
        ammatti2 = new Ammatti("ammatti2", 2000, true, true);
        assertEquals(false, ammatti1.equals(ammatti2));
    }
    
    @Test
    public void equalsToimiiJosSamat() {
        ammatti1 = new Ammatti("testi", 1000, true, true);
        ammatti2 = new Ammatti("testi", 5000, false, false);
        assertEquals(true, ammatti1.equals(ammatti2));
    }
    
    @Test
    public void equalsToimiiJosEriLuokka() {
        Object object = new Object();
        ammatti1 = new Ammatti("testi", 100, true, true);
        assertEquals(false, ammatti1.equals(object));
    }
    
    @Test
    public void compareToLaittaaOikeaanJarjestykseen() {
        ammatti1 = new Ammatti("ammatti1", 10000, true, true);
        ammatti2 = new Ammatti("ammatti2", 10001, true, true);

        List<Ammatti> lista = new ArrayList();
        lista.add(ammatti1);
        lista.add(ammatti2);
        Collections.sort(lista);
        assertEquals(ammatti2, lista.get(0));
    }
    
}
