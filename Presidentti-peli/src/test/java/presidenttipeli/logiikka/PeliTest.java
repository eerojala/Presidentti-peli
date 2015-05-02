
package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Ruutu;


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

    
    
    private void tiputaMuutPelaajat() {
        for (int i = 0; i < peli.getLauta().getNappulat().size(); i++) {
            peli.tiputaPelaajaPelista();
            peli.vaihdaVuoroa();
        }
    }

    @Test
    public void tiputtaaPelaajanPelista() {
        peli.tiputaPelaajaPelista();
        assertEquals(false, 
                peli.getLauta().getNappulat().contains(peli.getNykyinenPelaaja().getNappula()));
    }
    
    @Test
    public void tiputaPelaajaPalauttaaFalseJosPelaajiaJaljella() {
        assertEquals(false, peli.tiputaPelaajaPelista());
    }
    
    @Test
    public void tiputaPelaajaPalauttaaTrueJosPelaajiaEiEnaaJaljella() {
        tiputaMuutPelaajat();
        assertEquals(true, peli.tiputaPelaajaPelista());
    }
    
    @Test
    public void suoritaRuudunTapahtumatSuorittaaRuudunTapahtumat() {
        peli.getLiikuttelija().liikutaNappulaa(peli.getNykyinenPelaaja().getNappula(), 2);
        peli.suoritaRuudunTapahtumat();
        assertEquals("Opettaja", peli.getNykyinenPelaaja().getAmmatti().getNimi());
    }
    
    @Test
    public void suoritaRuudunTapahtumatPalauttaaTrueJosTapahtumaOnnistuu() {
        peli.getLiikuttelija().liikutaNappulaa(peli.getNykyinenPelaaja().getNappula(), 2);
        assertEquals(true, peli.suoritaRuudunTapahtumat());
    }
    
    @Test
    public void suoritaRuudunTapahtumanPalauttaaFalseJosTapahtumaEpaonnistuu() {
        peli.getLiikuttelija().liikutaNappulaa(peli.getNykyinenPelaaja().getNappula(), 14);
        peli.getNykyinenPelaaja().setRahat(0);
        assertEquals(false, peli.suoritaRuudunTapahtumat());
    }
    
    @Test
    public void onkoErikoisruutuPalauttaaTrueJosOstoTaiMyyntiruutu() {
        Ruutu ruutu = new Ruutu(1, 1, 1);
        ruutu.setOstoJaMyyntiruutu(true);
        assertEquals(true, peli.onkoErikoisruutu(ruutu));
    }
    
    @Test
    public void onkoErikoisruutuPalauttaaTrueJosVaaliruutu() {
        Ruutu ruutu = new Ruutu(1, 1, 1);
        ruutu.setVaaliruutu(true);
        assertEquals(true, peli.onkoErikoisruutu(ruutu));
    }
    
    @Test
    public void onkoErikoisruutuPalauttaaTrueJosPutkaruutu() {
        Ruutu ruutu = new Ruutu(1, 1, 1);
        ruutu.setVaaliruutu(true);
        assertEquals(true, peli.onkoErikoisruutu(ruutu));
    }
    
    @Test
    public void onkoErikoisRuutuPalauttaaFalseJosEiErikoisruutu() {
        Ruutu ruutu = new Ruutu(1, 1, 1);
        assertEquals(false, peli.onkoErikoisruutu(ruutu));
    }
    
}
