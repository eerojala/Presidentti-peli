
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
        liikuttelija = new Liikuttelija(lauta);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void liikuttaaNappulaaEteenpain() {
        silmaluku = 3;
        vanhaSijainti = lauta.getNappulat().get(0).getSijainti().getNumero();
        liikuttelija.liikutaNappulaa(silmaluku, lauta.getNappulat().get(0));
        assertEquals(vanhaSijainti + silmaluku, lauta.getNappulat().get(0).getSijainti().getNumero());
    }
    
    @Test
    public void liikuttaaNappulaaOikeinJosUusiKierrosAlkaa() {
        silmaluku = 3;
        lauta.getNappulat().get(0).setSijainti(lauta.getRuudut().get(29));
        liikuttelija.liikutaNappulaa(silmaluku, lauta.getNappulat().get(0));
        assertEquals(silmaluku, lauta.getNappulat().get(0).getSijainti().getNumero());
    }
    
    @Test
    public void palauttaaFalseJosUusiKierrosEiAlkanut() {
        silmaluku = 29;       
        assertEquals(false, liikuttelija.liikutaNappulaa(silmaluku, lauta.getNappulat().get(0)));
    }
    
    @Test
    public void palauttaaTrueJosUusiKierrosAlkaa() {
        silmaluku = 30;
        assertEquals(true, liikuttelija.liikutaNappulaa(silmaluku, lauta.getNappulat().get(0)));
    }
    
}
