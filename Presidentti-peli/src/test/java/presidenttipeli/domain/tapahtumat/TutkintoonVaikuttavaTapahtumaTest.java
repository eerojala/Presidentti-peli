/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;

/**
 *
 * @author Eero
 */
public class TutkintoonVaikuttavaTapahtumaTest {
    Pelaaja pelaaja;
    
    public TutkintoonVaikuttavaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("test");
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void tutkinnonAntaminenPelaajalleOnnistuu() {
        Tapahtuma test = new TutkintoonVaikuttavaTapahtuma(true);
        test.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isTutkinto());
    }
    
    @Test
    public void tutkinnonOttaminenPelaajaltaOnnistuu() {
        Tapahtuma test = new TutkintoonVaikuttavaTapahtuma(false);
        test.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isTutkinto());
    }
}
