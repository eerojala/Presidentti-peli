
package presidenttipeli.logiikka;

import java.util.ArrayList;
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
import presidenttipeli.logiikka.luojat.*;


public class PeliTest {
    KaikenLuoja luoja;
    ArrayList<String> nimet;
    Peli peli;
    
    public PeliTest() {
        
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
        nimet.add("Testi3");
        luoja = new KaikenLuoja(nimet);
        peli = luoja.getPeli();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void vaihtaaPelaajaa() {
        peli.vaihdaVuoroa();
        assertEquals(peli.getNykyinenPelaaja(), 
                peli.getLauta().getNappulat().get(1).getOmistaja());
    }
    
    @Test
    public void vaihtaaOikeinJosNykyinenPelaajaListanViimeinen() {
        peli.setNykyinenPelaaja(
                peli.getLauta().getNappulat().get(peli.getLauta().getNappulat().size() - 1).getOmistaja());
        peli.vaihdaVuoroa();
        assertEquals(peli.getNykyinenPelaaja(), peli.getLauta().getNappulat().get(0).getOmistaja());
    }
    
    @Test
    public void vaihtaaSitaSeuraavaanPelaajaanJosSeuraavaJoutuuOdottomaanVuoroaan() {
        peli.getLauta().getNappulat().get(1).getOmistaja().setOdottaaVuoroaan(1);
        peli.vaihdaVuoroa();
        assertEquals(peli.getNykyinenPelaaja(), peli.getLauta().getNappulat().get(2).getOmistaja());
    }


    
}
