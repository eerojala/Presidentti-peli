
package presidenttipeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;


public class VelanhallintaTest {
    Pelaaja pelaaja;
    Velanhallinta laskuri;
    
    public VelanhallintaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kasvattaaOttorahaaSadallaJosVelkaEiYlitaRajaa() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaSadalla();
        assertEquals(100, laskuri.getOttoraha());
    }
    
    @Test
    public void kasvattaaOttorahaaTuhannellaJosVelkaEiYlitaRajaa() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaTuhannella();
        assertEquals(1000, laskuri.getOttoraha());
    }
    
    @Test
    public void eiKasvataOttorahaaSadallaJosVelkaYlittaisiRajan() {
        pelaaja.setVelkaa(5000);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaSadalla();
        assertEquals(0, laskuri.getOttoraha());
    }
    
    @Test
    public void eiKasvataOttorahaaTuhannellaJosVelkaYlittaisiRajan() {
        pelaaja.setVelkaa(4100);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaTuhannella();
        assertEquals(0, laskuri.getOttoraha());
    }
    
    @Test
    public void kasvattaaMaksurahaaSadallaJosPelaajallaRiittaaRahat() {
        pelaaja.setVelkaa(5000);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaSadalla();
        assertEquals(100, laskuri.getMaksuraha());
    }
    
    @Test
    public void kasvattaaMaksurahaaTuhannellaJosPelaajallaRiittaaRahat() {
        pelaaja.setVelkaa(5000);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaTuhannella();
        assertEquals(1000, laskuri.getMaksuraha());
    }
    
    @Test
    public void eiKasvataMaksurahaaSadallaJosPelaajallaEiRiitaRahat() {
        pelaaja.setVelkaa(5000);
        pelaaja.setRahat(99);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaSadalla();
        assertEquals(0, laskuri.getMaksuraha());
    }
    
    @Test
    public void eiKasvataMaksurahaaTuhannellaJosPelaajallaEiRiitaRhat() {
        pelaaja.setVelkaa(5000);
        pelaaja.setRahat(999);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaTuhannella();
        assertEquals(0, laskuri.getMaksuraha());
    }
    
    @Test
    public void eiKasvataMaksurahaaSadallaJosSeYlittaisiVelan() {
        pelaaja.setVelkaa(99);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaSadalla();
        assertEquals(0, laskuri.getMaksuraha());
    }
    
    @Test
    public void eiKasvataMaksurahaaTuhannellaJosSeYlittaisiVelan() {
        pelaaja.setVelkaa(999);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaTuhannella();
        assertEquals(0, laskuri.getMaksuraha());
    }
    
    @Test
    public void vahentaaOttorahaaSadalla() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaSadalla();
        laskuri.kasvataOttorahaaSadalla();
        laskuri.vahennaOttorahaaSadalla();
        assertEquals(100, laskuri.getOttoraha());
    }
    
    @Test
    public void vahennaOttorahaaTuhannella() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaTuhannella();
        laskuri.kasvataOttorahaaSadalla();
        laskuri.vahennaOttorahaaTuhannella();
        assertEquals(100, laskuri.getOttoraha());
    }
    
    @Test
    public void eiVahennaOttorahaaSadallaJosSeMeneeAlleNollan() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaSadalla();
        for (int i = 0; i < 2; i++) {
            laskuri.vahennaOttorahaaSadalla();
        }
        assertEquals(0, laskuri.getOttoraha());
    }
    
    @Test
    public void asettaaOttorahanNollaksiJosMenisiAlleNollanKunVahentaaTuhannella() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataOttorahaaSadalla();
        laskuri.vahennaOttorahaaTuhannella();
        assertEquals(0, laskuri.getOttoraha());
    }
    
    
    @Test
    public void vahentaaMaksurahaaSadalla() {
        pelaaja.setVelkaa(5000);
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaSadalla();
        laskuri.kasvataMaksurahaaSadalla();
        laskuri.vahennaMaksurahaaSadalla();
        assertEquals(100, laskuri.getMaksuraha());
    }
    
    @Test
    public void vahentaaMaksurahaaTuhannella() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaTuhannella();
        laskuri.vahennaMaksurahaaTuhannella();
        
    }
    
    @Test
    public void eiVahennaMaksurahaaSadallaJosMenisiAlleNollan() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaSadalla();
        for (int i = 0; i < 2; i++) {
            laskuri.vahennaMaksurahaaSadalla();
        }
        assertEquals(0, laskuri.getMaksuraha());
    }
    
    @Test
    public void asettaaOttorahaksiNollaJosMenisiAlleNollanKunVahentaaTuhannella() {
        laskuri = new Velanhallinta(pelaaja);
        laskuri.kasvataMaksurahaaSadalla();
        laskuri.vahennaMaksurahaaTuhannella();
        assertEquals(0, laskuri.getMaksuraha());
    }
    
    @Test
    public void paivitaPelaajanVelkaToimii() {
        laskuri = new Velanhallinta(pelaaja);
        pelaaja.setVelkaa(5000);
        laskuri.paivitaPelaajanVelka();
        assertEquals(5000, laskuri.getPelaajanVelat());
    }
    
    @Test
    public void paivitaPelaajanRahatToimii() {
        laskuri = new Velanhallinta(pelaaja);
        pelaaja.setRahat(10000);
        laskuri.paivitaPelaajanRahat();
        assertEquals(10000, laskuri.getPelaajanRahat());
    }
}
