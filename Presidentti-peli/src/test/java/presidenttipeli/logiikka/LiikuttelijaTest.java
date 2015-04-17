
package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;


public class LiikuttelijaTest {
    Liikuttelija liikuttelija;
    KaikenLuoja luoja;
    ArrayList<String> nimet;
    int silmaluku;
    int vanhaSijainti;
    Pelilauta lauta;
    
    public LiikuttelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nimet = new ArrayList();
        nimet.add("Testi1");
        nimet.add("Testi2");
        luoja = new KaikenLuoja(nimet);
        lauta = luoja.getLauta();
        liikuttelija = new Liikuttelija(lauta, luoja.getPeli().getTapahtumienluoja());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void liikuttaaNappulaaEteenpain() {
        vanhaSijainti = lauta.getNappulat().get(0).getSijainti().getNumero();
        liikuttelija.liikutaNappulaa(lauta.getNappulat().get(0), 1);
        assertEquals(vanhaSijainti + 1, lauta.getNappulat().get(0).getSijainti().getNumero());
    }
    
    @Test
    public void liikuttaaNappulaaOikeinJosUusiKierrosAlkaa() {
        lauta.getNappulat().get(0).setSijainti(lauta.getRuudut().get(29));
        liikuttelija.liikutaNappulaa(lauta.getNappulat().get(0), 1);
        assertEquals(1, lauta.getNappulat().get(0).getSijainti().getNumero());
    }
    
    @Test
    public void palauttaaFalseJosUusiKierrosEiAlkanut() {    
        assertEquals(false, liikuttelija.liikutaNappulaa(lauta.getNappulat().get(0), 1));
    }
    
    @Test
    public void palauttaaTrueJosUusiKierrosAlkaa() {
        lauta.getNappulat().get(0).setSijainti(lauta.getRuudut().get(29));
        assertEquals(true, liikuttelija.liikutaNappulaa(lauta.getNappulat().get(0), 1));
    }
    
}
