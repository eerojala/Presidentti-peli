package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.SelosteenOmaava;
import presidenttipeli.domain.Tapahtumakortti;

public class TapahtumakorttienLuojaTest {

    TapahtumakorttienLuoja luoja;

    public TapahtumakorttienLuojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luoja = new TapahtumakorttienLuoja(new Pelilauta());
        luoja.luo();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaranKortteja() {
        assertEquals(35, luoja.getKortit().size());
    }

    @Test
    public void ensimmaisellaKortillaOikeaSeloste() {
        assertEquals("﻿Aprajaisvoitto,\n"
                + "nosta 1500,-\n", luoja.getLista().get(0).getSeloste());
    }

    @Test
    public void viimeisellaKortillaOikeaSeloste() {
        assertEquals("Huh! Ei tapahdu mitään\n", luoja.getLista().get(34).getSeloste());
    }

}
