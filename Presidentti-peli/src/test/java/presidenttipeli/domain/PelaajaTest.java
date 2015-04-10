package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja test1;
    Pelaaja test2;

    public PelaajaTest() {
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
        test1 = new Pelaaja("test1");
        test2 = new Pelaaja("test2");
        assertEquals(false, test1.equals(test2));
    }

    @Test
    public void equalsToimiiJosKaksiSamaa() {
        test1 = new Pelaaja("hannu");
        test2 = new Pelaaja("hannu");
        assertEquals(true, test1.equals(test2));
    }
    
    @Test
    public void equalsToimiiJosEriLuokka() {
        Object test3 = new Object();
        test1 = new Pelaaja("test1");
        assertEquals(false, test1.equals(test3));
    }
    
    @Test
    public void equalsToimiiJosNull() {
        test1 = new Pelaaja("d");
        assertEquals(false, test1.equals(test2));
    }
    
    @Test
    public void compareToLaittaaOikeaanJarjestykseen() {
        test1 = new Pelaaja("test1");
        test2 = new Pelaaja("test2");
        test1.setRahat(2000);
        test2.setRahat(1000);
        List<Pelaaja> lista = new ArrayList<Pelaaja>();
        lista.add(test2);
        lista.add(test1);
        Collections.sort(lista);
        assertEquals(test1, lista.get(0));
    }
}
