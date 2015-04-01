package presidenttipeli.logiikka.luojat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;

public class RuutujenLuojaTest {

    RuutujenLuoja luoja;
    Pelaaja pelaaja;
    boolean vaite;

    public RuutujenLuojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luoja = new RuutujenLuoja(new Pelilauta());
        luoja.luo();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaranRuutuja() {
        assertEquals(30, luoja.getRuudut().size());
    }

    @Test
    public void ruutu1Ensimmaisena() {
        assertEquals(1, luoja.getRuudut().get(0).getNumero());
    }

    @Test
    public void ruutu30Viimeisena() {
        assertEquals(30, luoja.getRuudut().get(luoja.getRuudut().size() - 1).getNumero());
    }
    
    @Test
    public void ruudutOvatNousevassaSuuruusjarjestyksessa() {
        boolean oikeaJarjestys = true;
        int edellinenNro = 0;
        for (Ruutu ruutu : luoja.getRuudut()) {
            if (ruutu.getNumero() != edellinenNro + 1) {
                oikeaJarjestys = false;
            }
            edellinenNro = ruutu.getNumero();
        }
        assertEquals(true, oikeaJarjestys);
    }

    @Test
    public void ensimmaisellaRuudullaOikeaSeloste() {
        assertEquals("﻿1. MAANANTAI\n"
                + "LÄHTÖRAHA 5000,-\n"
                + "Palkkapäivä, työttömyyskorvaus + liikkeen tuotto\n"
                + "Liikkeiden ja mökkien osto + myynti\n", luoja.getRuudut().get(0).getSeloste());
    }

    @Test
    public void keskimmaisellaRuudullaOikeaSeloste() {
        assertEquals("15. MAANANTAI\n"
                + "AUTON VAIHTO\n"
                + "Maksa 5000,-\n", luoja.getRuudut().get(luoja.getRuudut().size() / 2 - 1).getSeloste());
    }

    @Test
    public void viimeisellaRuudullaOikeaSeloste() {
        assertEquals("30. TIISTAI\n"
                + "SINUSTAKO PRESIDENTTI?\n"
                + "Osallistu vaaliin!\n", luoja.getRuudut().get(luoja.getRuudut().size() - 1).getSeloste());
    }
    
    @Test
    public void kaikillaRuuduillaSeloste() {
        vaite = true;
        for (Ruutu ruutu : luoja.getRuudut()) {
            if (ruutu.getSeloste().equals("placeholder")) {
                vaite = false;
            }
        }
        assertEquals(true, vaite);
    } 

}
