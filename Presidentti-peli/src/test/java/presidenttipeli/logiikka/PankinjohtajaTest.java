
package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class PankinjohtajaTest {
    KaikenLuoja luoja;
    Pelilauta lauta;
    Pankinjohtaja pankinjohtaja;
    ArrayList<String> nimet;
    Pelaaja pelaaja;
    int rahatEnnen;
    int velatEnnen;
    
    public PankinjohtajaTest() {
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
        lauta = luoja.getPeli().getLauta();
        pankinjohtaja = luoja.getPeli().getPankinjohtaja();
        pelaaja = lauta.getNappulat().get(0).getOmistaja();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void antaaPelaajalleKuukaudenTuotot() {
        rahatEnnen = pelaaja.getRahat();
        pankinjohtaja.annaPelaajalleKuukaudenTuotot(pelaaja);
        assertEquals(rahatEnnen + 1000, pelaaja.getRahat());
    }
    
    @Test
    public void vahentaaVelkaa() {
        pelaaja.setVelkaa(2000);
        velatEnnen = pelaaja.getVelkaa();
        pankinjohtaja.vahennaVelkaa(pelaaja, 1000);
        assertEquals(velatEnnen - 1000, pelaaja.getVelkaa());
    }
    
    @Test
    public void vahentaaRahaa() {
        pelaaja.setVelkaa(2000);
        rahatEnnen = pelaaja.getRahat();
        pankinjohtaja.vahennaVelkaa(pelaaja, 1000);
        assertEquals(rahatEnnen - 1000, pelaaja.getRahat());
    }
    
    @Test
    public void palauttaaTrueJosVelanVahennysOnnistuu() {
        pelaaja.setVelkaa(2000);
        assertEquals(true, pankinjohtaja.vahennaVelkaa(pelaaja, rahatEnnen));
    }
    
    @Test
    public void eiVaikutaPelaajanVelkaanJosVelkaOnPienempiKuinAnnettuMaara() {
        velatEnnen = pelaaja.getVelkaa();
        pankinjohtaja.vahennaVelkaa(pelaaja, 1);
        assertEquals(velatEnnen, pelaaja.getVelkaa());
    }
    
    @Test
    public void eiVaikutaPelaajanVelkaanJosRahatOnPienempiKuinAnnettuMaara() {
        pelaaja.setRahat(2000);
        pelaaja.setVelkaa(2001);
        velatEnnen = pelaaja.getVelkaa();
        pankinjohtaja.vahennaVelkaa(pelaaja, 2001);
        assertEquals(velatEnnen, pelaaja.getVelkaa());
    }
    
    @Test
    public void eiVaikutaPelaajanRahoihinJosVelkaOnPienempiKuinAnnettuMaara() {
        rahatEnnen = pelaaja.getRahat();
        pankinjohtaja.vahennaVelkaa(pelaaja, 3000);
        assertEquals(rahatEnnen, pelaaja.getRahat());
    }
    
    @Test
    public void eiVaikutaPelaajanRahoihinJosRahatOnPienempiKuinAnnettuMaara() {
        rahatEnnen = pelaaja.getRahat();
        pelaaja.setVelkaa(rahatEnnen + 1);
        pankinjohtaja.vahennaVelkaa(pelaaja, rahatEnnen + 1);
        assertEquals(rahatEnnen, pelaaja.getRahat());
    }
    
    @Test
    public void palauttaaFalseJosVelanVahennysEiOnnistu() {
        assertEquals(false, pankinjohtaja.vahennaVelkaa(pelaaja, 3000));
    }
    
    @Test
    public void kasvattaaVelkaa() {
        velatEnnen = pelaaja.getVelkaa();
        pankinjohtaja.kasvataVelkaa(pelaaja, 1000);
        assertEquals(velatEnnen + 1000, pelaaja.getVelkaa());
    }
    
    @Test
    public void kasvattaaPelaajanRahamaaraa() {
        rahatEnnen = pelaaja.getRahat();
        pankinjohtaja.kasvataVelkaa(pelaaja, 1000);
        assertEquals(rahatEnnen + 1000, pelaaja.getRahat());
    }
    
    public void palauttaaTrueJosVelanKasvatusOnnistuu() {
        assertEquals(true, pankinjohtaja.kasvataVelkaa(pelaaja, 5000));
    }
    
    @Test
    public void eiVaikutaPelaajanVelkaanJosVelkaKasvaisiYli5000() {
        pelaaja.setVelkaa(3000);
        velatEnnen = pelaaja.getVelkaa();
        pankinjohtaja.kasvataVelkaa(pelaaja, 2001);
        assertEquals(velatEnnen, pelaaja.getVelkaa());
    }
    
    @Test
    public void eiVaikutaPelaajanRahaanJosVelkaKasvaisiYli5000() {
        rahatEnnen = pelaaja.getRahat();
        pankinjohtaja.kasvataVelkaa(pelaaja, 5001);
        assertEquals(rahatEnnen, pelaaja.getRahat());
    }
    
    @Test
    public void palauttaaFalseJosVelanKasvatusEpaonnistuu() {
        assertEquals(false, pankinjohtaja.kasvataVelkaa(pelaaja, 5001));
    }
}
