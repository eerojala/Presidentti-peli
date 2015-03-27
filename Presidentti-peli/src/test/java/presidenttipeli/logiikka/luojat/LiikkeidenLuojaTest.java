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
import presidenttipeli.domain.Liike;

/**
 *
 * @author Eero
 */
public class LiikkeidenLuojaTest {

    private LiikkeidenLuoja luokka;

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
        boolean arvoJaTuottoOikeinPain = true;
        for (Liike liike : luokka.getLista()) {
            if (liike.getTuotto() > liike.getArvo()) {
                arvoJaTuottoOikeinPain = false;
            }
        }
        assertEquals(true, arvoJaTuottoOikeinPain);
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
}
