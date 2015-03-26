package presidenttipeli.logiikka.luojat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelilauta;

public class RuutujenLuojaTest {

    RuutujenLuoja luoja;

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

}
