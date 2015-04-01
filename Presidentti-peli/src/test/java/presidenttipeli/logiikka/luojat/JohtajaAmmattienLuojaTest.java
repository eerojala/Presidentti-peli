
package presidenttipeli.logiikka.luojat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;


public class JohtajaAmmattienLuojaTest {

    JohtajaAmmattienLuoja luokka;

    public JohtajaAmmattienLuojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luokka = new JohtajaAmmattienLuoja();
        luokka.luo();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaran() {
        assertEquals(10, luokka.getJohtajaAmmatit().size());
    }

    @Test
    public void luodutAmmatitOnJohtajaAmmatteja() {
        boolean johtajia = true;
        for (Ammatti ammatti : luokka.getJohtajaAmmatit()) {
            if (!ammatti.isJohtaja()) {
                johtajia = false;
            }
        }
        assertEquals(true, johtajia);
    }
    
    @Test
    public void luodutAmmatitEivatOleSattumaAmmatteja() {
        boolean sattumaAmmatteja = false;
        for (Ammatti ammatti : luokka.getJohtajaAmmatit()) {
            if (ammatti.isSattumaAmmmatti()) {
                sattumaAmmatteja = true;
            }
        }
        assertEquals(false, sattumaAmmatteja);
    }
    
    @Test
    public void luodutAmmatitEivatSalliKansanedustajuutta() {
        boolean ehto = true;
        for (Ammatti ammatti : luokka.getJohtajaAmmatit()) {
            if (ammatti.salliiKansanedustajuuden()) {
                ehto = false;
            }
        }
        assertEquals(true, ehto);
    }
    
    @Test
    public void ensimmaisellaAlkiollaOnOikeaNimi( ) {
        assertEquals("﻿Toimitusjohtaja", luokka.getJohtajaAmmatit().get(0).getNimi());
    }
    
    @Test
    public void ensimmaisellaAlkiollaOnOikeaPalkka() {
        assertEquals(10000, luokka.getJohtajaAmmatit().get(0).getPalkka());
    }
    
    @Test
    public void viimeisellaAlkiollaOnOikeaNimi() {
        assertEquals("Maaherra", luokka.getJohtajaAmmatit().get(luokka.getJohtajaAmmatit().size() - 1).getNimi());
    }
    
    @Test
    public void viimeisellaAlkiollaOnOikeaPalkka() {
        assertEquals(12000, luokka.getJohtajaAmmatit().get(luokka.getJohtajaAmmatit().size() - 1).getPalkka());
    }
    
    @Test
    public void luoduillaAmmateillaOnNimi() {
        boolean vaite = true;
        for (Ammatti ammatti : luokka.getJohtajaAmmatit()) {
            if (ammatti.getNimi() == null) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }

}
