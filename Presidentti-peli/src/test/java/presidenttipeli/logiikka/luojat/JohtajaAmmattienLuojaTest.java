/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;

/**
 *
 * @author Eero
 */
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
        Ammatti temp = luokka.getJohtajaAmmatit().getFirst();
        assertEquals(true, temp.isJohtaja());
    }

}
