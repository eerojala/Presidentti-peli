/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenttipeli.logiikka.luojat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;

/**
 *
 * @author Eero
 */
public class LiikkeidenLuojaTest {
    private LiikkeidenLuoja luokka;
    
    public LiikkeidenLuojaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        luokka = new LiikkeidenLuoja();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaran() {
        assertEquals(15, luokka.getLiikkeet().size());
    }
    
    @Test
    public void asettaaArvonJaTuotonOikeinpain() {       
        Liike temp = luokka.getLiikkeet().getFirst();
        assertTrue(temp.getArvo() > temp.getTuotto());
    }
    
}
