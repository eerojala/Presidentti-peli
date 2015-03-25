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
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;


public class SiirraNappulaaTest {
    Pelilauta lauta;
    Tapahtuma testi;
    Pelaaja pelaaja;
    
    public SiirraNappulaaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauta = new Pelilauta();
        lauta.getRuudut().add(new Ruutu(1, true, false, false));
        lauta.getRuudut().add(new Ruutu(2, false, false, false));
        lauta.getRuudut().add(new Ruutu(3, false, true, false));
        testi = new SiirraNappulaa(3, lauta);
        pelaaja = new Pelaaja("testi");
        Nappula nappula = new Nappula(pelaaja);
        pelaaja.setNappula(nappula);
        nappula.setSijainti(lauta.getRuudut().get(0));
    }

    @Test
    public void nappulaSiirtyyOikealleRuudulle() {
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(3, pelaaja.getNappula().getSijainti().getNumero());
    }
    
}
