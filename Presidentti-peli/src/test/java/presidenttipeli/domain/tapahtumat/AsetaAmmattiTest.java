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
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 *
 * @author Eero
 */
public class AsetaAmmattiTest {
    Pelaaja pelaaja;
    Tapahtuma testi;
    Ammatti ammatti1;
    Ammatti ammatti2;
    
    public AsetaAmmattiTest() {
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
        ammatti1 = new Ammatti("ammatti1", 5000, false, false, true);
        ammatti2 = new Ammatti("ammatti2", 10000, true, false, false);
        testi = new AsetaAmmatti(new Pelilauta(), ammatti2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void uudenAmmatinAsettaminenOnnistuu() {
        pelaaja.setAmmatti(ammatti1);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(ammatti2, pelaaja.getAmmatti());
    }
    
}
