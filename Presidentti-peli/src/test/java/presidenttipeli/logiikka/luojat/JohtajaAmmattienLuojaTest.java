
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
    public void luomatAmmatitOnJohtajaAmmatteja() {
        Ammatti temp = luokka.getJohtajaAmmatit().get(0);
        assertEquals(true, temp.isJohtaja());
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

}
