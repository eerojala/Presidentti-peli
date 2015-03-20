/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eero
 */
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsToimiiJosKaksiEriMokkia() {
        mokki1 = new Mokki("Mokki1", 0);
        mokki2 = new Mokki("Mokki2", 0);
        assertEquals(false, mokki1.equals(mokki2));
    }
    
    @Test
    public void equalsToimiiJosKaksiSamaaMokkia() {
        mokki1 = new Mokki("a", 0);
        mokki2 = new Mokki("a", 10000);
        assertEquals(true, mokki1.equals(mokki2));
    }
    
    @Test
    public void equalsToimiiJosKaksiEriLuokkaa() {
        mokki1 = new Mokki("aaa", 0);
        Object object = new Object();
        assertEquals(false, mokki1.equals(object));
    }
    
    @Test
    public void compareToLaittaaOikeaanJarjestykseen() {
        mokki1 = new Mokki("aaa", 1);
        mokki2 = new Mokki("aaa", 2);
        ArrayList<Mokki> mokit = new ArrayList();
        mokit.add(mokki1);
        mokit.add(mokki2);
        Collections.sort(mokit);
        assertEquals(mokki2, mokit.get(0));
    }
}
