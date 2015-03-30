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
import presidenttipeli.domain.Tutkinto;

/**
 *
 * @author Eero
 */
public class AsetaAmmattiTest {
    Pelaaja pelaaja;
    Tapahtuma testi1;
    Tapahtuma testi2;
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
        ammatti1 = new Ammatti("Työtön", 5000, false, false, true);
        ammatti2 = new Ammatti("ammatti2", 10000, true, false, false);
        testi1 = new AsetaAmmatti(new Pelilauta(), ammatti1);
        testi2 = new AsetaAmmatti(new Pelilauta(), ammatti2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void uudenAmmatinAsettaminenOnnistuu() {
        pelaaja.setAmmatti(ammatti2);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(ammatti1, pelaaja.getAmmatti());
    }
    
    @Test
    public void ottaaPoisKansanedustajuudenJosAmmattiEiSalliSita() {
        pelaaja.setKansanedustaja(true);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isKansanedustaja());
    }
    
    @Test
    public void eiOtaPoisKansanedustajuuttaJosAmmattiSalliiSen() {
        pelaaja.setKansanedustaja(true);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isKansanedustaja());
    }
    
    @Test
    public void tutkintoPoisJosPelaajallaOnTutkinto() {
        pelaaja.setTutkinto(new Tutkinto(false));
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(null, pelaaja.getTutkinto());
    }
    
    @Test
    public void tutkintoEiMenePoisJosTyoton() {
        boolean vaite = true;
        pelaaja.setTutkinto(new Tutkinto(false));
        testi1.suoritaTapahtuma(pelaaja);
        if (pelaaja.getTutkinto() == null) {
            vaite = false;
        }
        assertEquals(true, vaite);
    }
    
    @Test
    public void pelaajaEiSaaUuttaTutkintoaJosTyoton() {
        pelaaja.setTutkinto(null);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(null, pelaaja.getTutkinto());
    }
    
    @Test
    public void yleissivistavaTutkintoEiMenePois() {
        pelaaja.setTutkinto(new Tutkinto(true));
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.getTutkinto().isYleissivistava());
    }
    
    @Test
    public void yleissivistavaTutkintoEiMenePoisJosTyoton() {
        pelaaja.setTutkinto(new Tutkinto(true));
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.getTutkinto().isYleissivistava());
    }
}
