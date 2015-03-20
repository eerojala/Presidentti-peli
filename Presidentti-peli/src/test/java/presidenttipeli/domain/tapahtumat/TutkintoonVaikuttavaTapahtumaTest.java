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
    Tapahtuma test1;
    Tapahtuma test2;
    
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
        test1 = new TutkintoonVaikuttavaTapahtuma(true);
        test2 = new TutkintoonVaikuttavaTapahtuma(false);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void tutkinnonAntaminenPelaajalleOnnistuu() {
        test1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isTutkinto());
    }
    
    @Test
    public void tutkinnonOttaminenPelaajaltaOnnistuu() {
        test1.suoritaTapahtuma(pelaaja);
        test2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isTutkinto());
    }
}
