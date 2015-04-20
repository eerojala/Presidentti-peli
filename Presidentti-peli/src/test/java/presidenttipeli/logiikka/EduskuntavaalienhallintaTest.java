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
        pelaaja = luoja.getPeli().getNykyinenPelaaja();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void riittaakoRahaaSuorittaaVaalitPalauttaaFalseJosPelaajallaEiRiitaRahaaHaluamaansaMaksuun() {
        hallinta.maksa10000Vaaleista();
        assertEquals(false, hallinta.riittaakoRahaaSuorittaaVaalit());
    }
    
    @Test
    public void riittaakoRahaaSuorittaaVaalitPalauttaaTrueJosPelaajallaRiittaaRahatHaluamaansaMaksuun() {
        pelaaja.setRahat(50000);
        hallinta.maksa50000Vaaleista();
        assertEquals(true, hallinta.riittaakoRahaaSuorittaaVaalit());
    }
    
    @Test
    public void maksa0VaaleistaAsettaaMaksettavanRahanOikein(){
        hallinta.maksa0Vaaleista();
        assertEquals(0, hallinta.getMaksettavaRaha());
    }
    
    @Test
    public void maksa0VaaleistaAsettaaTarvittavanAanimaaranOikein(){
        hallinta.maksa0Vaaleista();
        assertEquals(110, hallinta.getTarvittavaAanimaara());
    }
    
    @Test
    public void maksa10000VaaleistaAsettaaMaksettavanRahanOikein() {
        hallinta.maksa10000Vaaleista();
        assertEquals(10000, hallinta.getMaksettavaRaha());
    }
    
    @Test
    public void maksa10000VaaleistaAsettaaTarvittavanAanimaaranOikein() {
        hallinta.maksa10000Vaaleista();
        assertEquals(100, hallinta.getTarvittavaAanimaara());
    }
    
    @Test
    public void maksa20000VaaleistaAsettaaMaksettavanRahanOikein() {
        hallinta.maksa20000Vaaleista();
        assertEquals(20000, hallinta.getMaksettavaRaha());
    }
    
    @Test
    public void maksa20000VaaleistaAsettaaTarvittavanAanimaaranOikein() {
        hallinta.maksa20000Vaaleista();
        assertEquals(90, hallinta.getTarvittavaAanimaara());
    }
    
    @Test
    public void maksa30000VaaleistaAsettaaMaksettavanRahanOikein() {
        hallinta.maksa30000Vaaleista();
        assertEquals(30000, hallinta.getMaksettavaRaha());
    }
    
    @Test
    public void maksa30000VaaleistaAsettaaTarvittavanAanimaaranOikein() {
        hallinta.maksa30000Vaaleista();
        assertEquals(80, hallinta.getTarvittavaAanimaara());
    }
    
    @Test
    public void maksa40000VaaleistaAsettaaMaksettavanRahanOikein() {
        hallinta.maksa40000Vaaleista();
        assertEquals(40000, hallinta.getMaksettavaRaha());
    }
    
    @Test
    public void maksa40000VaaleistaAsettaaTarvittavanAanimaaranOikein() {
        hallinta.maksa40000Vaaleista();
        assertEquals(70, hallinta.getTarvittavaAanimaara());
    }
    
    @Test
    public void maksa50000VaaleistaAsettaaMaksettavanRahanOikein() {
        hallinta.maksa50000Vaaleista();
        assertEquals(50000, hallinta.getMaksettavaRaha());
    }
    
    @Test
    public void maksa50000VaaleistaAsettaaTarvittavanAanimaaranOikein(){
        hallinta.maksa50000Vaaleista();
        assertEquals(60, hallinta.getTarvittavaAanimaara());
    }
     

   
}
