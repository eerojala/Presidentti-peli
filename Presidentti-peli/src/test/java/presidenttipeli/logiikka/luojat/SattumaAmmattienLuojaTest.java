
package presidenttipeli.logiikka.luojat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;

public class SattumaAmmattienLuojaTest {
    SattumaAmmattienLuoja luoja;
    boolean ehto;
    
    public SattumaAmmattienLuojaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        luoja = new SattumaAmmattienLuoja();
        luoja.luo();
        ehto = true;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaran() {
        assertEquals(22, luoja.getAmmatit().size());
    }
    
    @Test
    public void ensimmaisellaAlkiollaOikeaNimi() {
        assertEquals("﻿Sairaanhoitaja", luoja.getAmmatit().get(0).getNimi());
    }
    
    @Test
    public void ensimmaisellaAlkiollaOikeaPalkka() {
        assertEquals(3000, luoja.getAmmatit().get(0).getPalkka());
    }
    
    @Test
    public void viimeisellaAlkiollaOikeaNimi() {
        assertEquals("Hammaslääkäri", luoja.getAmmatit().get(21).getNimi());
    }
    
    @Test
    public void viimeisellaAlkiollaOikeaPalkka() {
        assertEquals(9000, luoja.getAmmatit().get(21).getPalkka());
    }
    
    @Test
    public void luodutAmmatitSattumaAmmatteja() {
        for (Ammatti ammatti : luoja.getAmmatit()) {
            if (!ammatti.isSattumaAmmmatti()) {
                ehto = false;
            }
        }
        assertEquals(true, ehto);
    }
    
    @Test
    public void luodutAmmatitEivatJohtajia() {
        for (Ammatti ammatti : luoja.getAmmatit()) {
            if (ammatti.isJohtaja()) {
                ehto = false;
            }
        }
        assertEquals(true, ehto);
    }
    
    @Test
    public void luodutAmmatitSallivatKansanedustajuuden() {
        for (Ammatti ammatti : luoja.getAmmatit()) {
            if (!ammatti.salliiKansanedustajuuden()) {
                ehto = false;
            }
        }
        assertEquals(true, ehto);
    }
    
    @Test
    public void luoduillaAmmateillaNimet() {
        for (Ammatti ammatti : luoja.getAmmatit()) {
            if (ammatti.getNimi() == null) {
                ehto = false;
            }
        }
        assertEquals(true, ehto);
    }
}
