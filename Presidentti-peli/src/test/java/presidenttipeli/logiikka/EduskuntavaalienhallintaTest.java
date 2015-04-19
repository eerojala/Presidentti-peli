package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;

public class EduskuntavaalienhallintaTest {

    Eduskuntavaalienhallinta hallinta;
    Pelaaja pelaaja;

    public EduskuntavaalienhallintaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ArrayList<String> nimet = new ArrayList();
        nimet.add("testi1");
        KaikenLuoja luoja = new KaikenLuoja(nimet);
        hallinta = new Eduskuntavaalienhallinta(luoja.getLauta().getNappulat().get(0).getOmistaja(),
        luoja.getPeli().getVaalienjarjestaja(), luoja.getPeli().getPankinjohtaja());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void riittaakoRahaaSuorittaaVaalitPalauttaaFalseJosPelaajallaEiRiitaRahaaHaluamaansaMaksuun() {
        hallinta.maksa10000Vaaleista();
        assertEquals(false, hallinta.riittaakoRahaaSuorittaaVaalit());
    }
    

}
