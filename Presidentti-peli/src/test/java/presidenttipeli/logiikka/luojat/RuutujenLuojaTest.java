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

/**
 *
 * @author Eero
 */
public class RuutujenLuojaTest {

    RuutujenLuoja luoja;

    public RuutujenLuojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luoja = new RuutujenLuoja();
        luoja.luo();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaranRuutuja() {
        assertEquals(30, luoja.getRuudut().size());
    }

    @Test
    public void ekallaRuudullaOikeaNumero() {
        assertEquals(1, luoja.getRuudut().get(0).getNumero());
    }

    @Test
    public void vikallaRuudullaOikeaNumero() {
        assertEquals(30, luoja.getRuudut().get(29).getNumero());
    }

    @Test
    public void keskimmaisellaRuudullaOikeaNumero() {
        assertEquals(15, luoja.getRuudut().get(14).getNumero());
    }

    @Test
    public void lisaaEnsimmaiselleRuudulleSelosteen() {
        assertEquals(false, luoja.getRuudut().get(0).getSeloste() == null);
    }
    
    @Test
    public void lisaaViimeiselleRuudulleSelosteen() {
        assertEquals(false, luoja.getRuudut().get(0).getSeloste() == null);
    }

}
