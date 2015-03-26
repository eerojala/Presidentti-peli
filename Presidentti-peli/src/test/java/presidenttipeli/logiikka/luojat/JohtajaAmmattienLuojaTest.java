
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

}
