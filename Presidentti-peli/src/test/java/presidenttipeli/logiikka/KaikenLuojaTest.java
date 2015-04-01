
package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Nappula;


public class KaikenLuojaTest {
    KaikenLuoja luoja;
    ArrayList<String> nimet;
    boolean vaite;
    
    public KaikenLuojaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nimet = new ArrayList();
        nimet.add("Testi1");
        nimet.add("Testi2");
        luoja = new KaikenLuoja(nimet);
        vaite = true;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void asettaaLaudalleJohtajaAmmatit() {
        assertEquals(false, luoja.getLauta().getJohtajaAmmatit().isEmpty());
    }
    
    @Test
    public void asettaaLaudalleSattumaAmmatit() {
        assertEquals(false, luoja.getLauta().getSattumaAmmatit().isEmpty());
    }
    
    @Test
    public void asettaaLaudalleLiikkeet() {
        assertEquals(false, luoja.getLauta().getLiikkeet().isEmpty());
    }
    
    @Test
    public void asettaaLaudalleMokit() {
        assertEquals(false, luoja.getLauta().getMokit().isEmpty());
    }
    
    @Test
    public void asettaaLaudalleTapahtumakortit() {
        assertEquals(false, luoja.getLauta().getTapahtumakortit().isEmpty());
    }
    
    @Test
    public void asettaaLaudalleRuudut() {
        assertEquals(false, luoja.getLauta().getRuudut().isEmpty());
    }
    
    @Test
    public void asettaaLaudalleNappulat() {
        assertEquals(false, luoja.getLauta().getNappulat().isEmpty());
    }
    
    @Test
    public void asettaaNappulatAloitusruudulle() {
        for (Nappula nappula : luoja.getLauta().getNappulat()) {
            if (nappula.getSijainti().getNumero() != 1) {
                vaite = false;
            } 
        }
        assertEquals(true, vaite);
    }
}
