
package presidenttipeli.logiikka.luojat;

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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaran() {
       assertEquals(15, luokka.getMokit().size());
    }
    
}
