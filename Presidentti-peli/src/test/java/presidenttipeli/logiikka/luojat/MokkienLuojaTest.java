
package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MokkienLuojaTest {
    MokkienLuoja luokka;
    
    public MokkienLuojaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        luokka = new MokkienLuoja();
        luokka.luo();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaran() {
       assertEquals(15, luokka.getLista().size());
    }

    @Test
    public void ensimmaisellaMokillaOikeaNimi() {
        assertEquals("﻿Männynkäpy", luokka.getLista().get(0).getNimi());
    }
    
    @Test
    public void ensimmaisellaMokillaOikeaArvo() {
        assertEquals(6000, luokka.getLista().get(0).getArvo());
    }
    
    @Test
    public void viimeisellaMokillaOikeaNimi() {
        assertEquals("Kilpasanta", luokka.getLista().get(14).getNimi());
    }
    
    @Test
    public void viimeisellaMokillaOikeaArvo() {
        assertEquals(12000, luokka.getLista().get(14).getArvo());
    }
}
