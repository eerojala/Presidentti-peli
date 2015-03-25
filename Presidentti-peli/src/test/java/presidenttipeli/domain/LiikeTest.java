

package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LiikeTest {
    Liike liike1;
    Liike liike2;
    ArrayList<Liike> liikkeet;
    
    public LiikeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        liike1 = new Liike("Liike1", 10000, 1000);
        liikkeet = new ArrayList();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsToimiiJosKaksiEriLiiketta() {
        liike2 = new Liike("Liike2", 10000, 1000);
        assertEquals(false, liike1.equals(liike2));
    }
    
    @Test
    public void equalsToimiiJosKaksiSamaaLiikettä() {
        liike2 = new Liike("Liike1", 3000, 200);
        assertEquals(true, liike1.equals(liike2));
    }
    
    @Test
    public void equalsToimiiJosKaksiEriLuokkaa() {
        Object obj = new Object();
        assertEquals(false, liike1.equals(obj));
    }
    
    @Test
    public void compareToJarjestaaOikeinJosEriArvot() {
        liike2 = new Liike("Liike2", 9999, 1000);
        liikkeet.add(liike2);
        liikkeet.add(liike1);
        Collections.sort(liikkeet);
        assertEquals(liike1, liikkeet.get(0));
    }
    
    @Test
    public void compareToJarjestaaOikeinJosSamatArvot() {
        liike2 = new Liike("Liike2", 10000, 1001);
        liikkeet.add(liike1);
        liikkeet.add(liike2);
        Collections.sort(liikkeet);
        assertEquals(liike2, liikkeet.get(0));
    }
}
