
package presidenttipeli.logiikka.luojat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;

public class LiikkeidenLuojaTest {

    LiikkeidenLuoja luokka;
    boolean vaite;

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
        luokka.luo();
        vaite = true;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaran() {
        assertEquals(15, luokka.getLista().size());
    }

    @Test
    public void asettaaArvonJaTuotonOikeinpain() {
        for (Liike liike : luokka.getLista()) {
            if (liike.getTuotto() > liike.getArvo()) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }

    @Test
    public void ensimmaisellaLiikkeellaOikeaNimi() {
        assertEquals("Ylensiisti", luokka.getLista().get(0).getNimi());
    }

    @Test
    public void ensimmaisellaLiikkeellaOikeaTuotto() {
        assertEquals(4500, luokka.getLista().get(0).getTuotto());
    }

    @Test
    public void viimeisellaLiikkeellaOikeaTyyppi() {
        assertEquals("Kalakauppa", luokka.getLista().get(14).getTyyppi());
    }
    
    @Test
    public void viimeisellaLiikkeellaOikeaArvo() {
        assertEquals(15000, luokka.getLista().get(14).getArvo());
    }
    
    @Test
    public void likkeillaOnNimi() {
        for (Liike liike : luokka.getLista()) {
            if (liike.getNimi() == null) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void liikkeillaOnTyyppi() {
        for (Liike liike : luokka.getLista()) {
            if (liike.getTyyppi() == null) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    }
    
}
