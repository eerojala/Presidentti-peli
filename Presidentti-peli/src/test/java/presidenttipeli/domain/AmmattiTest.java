
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
        ammatti1 = new Ammatti("Ammatti1", 10000, true, false, false);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsToimiiJosKaksiEri() {
        ammatti2 = new Ammatti("Ammatti2", 2000, true, false, true);
        assertEquals(false, ammatti1.equals(ammatti2));
    }
    
    @Test
    public void equalsToimiiJosSamat() {
        ammatti2 = new Ammatti("Ammatti1", 5000, false, false, false);
        assertEquals(true, ammatti1.equals(ammatti2));
    }
    
    @Test
    public void equalsToimiiJosEriLuokka() {
        Object object = new Object();
        assertEquals(false, ammatti1.equals(object));
    }
    
    @Test
    public void equalsToimiiJosNull() {
        assertEquals(false, ammatti1.equals(ammatti2));
    }
    
    @Test
    public void compareToLaittaaOikeaanJarjestykseen() {
        ammatti2 = new Ammatti("Ammatti2", 10001, true, false, true);
        List<Ammatti> lista = new ArrayList();
        lista.add(ammatti1);
        lista.add(ammatti2);
        Collections.sort(lista);
        assertEquals(ammatti2, lista.get(0));
    }
    
}
