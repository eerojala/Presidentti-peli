
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
    
    @Test
    public void vaihtaaVuoroaOikeinJosEdellinenPelaajaTippuiPelista1() {
        peli.tiputaPelaajaPelista();
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        peli.vaihdaVuoroa();
        assertEquals(false, peli.getNykyinenPelaaja().equals(edellinenPelaaja));
    }
    
    @Test
    public void vaihtaaVuoroaOikeinJosEdellinenPelaajaTippuiPelista2() {
        peli.setNykyinenPelaaja(peli.getLauta().getNappulat().get(2).getOmistaja());
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        peli.tiputaPelaajaPelista();
        peli.vaihdaVuoroa();
        assertEquals(false, peli.getNykyinenPelaaja().equals(edellinenPelaaja));
    }
    
    @Test
    public void eiVaihdaVuoroaJosPelaajaOnAinoaJaljella() {
       tiputaMuutPelaajat();
       Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
       peli.vaihdaVuoroa();
       assertEquals(edellinenPelaaja, peli.getNykyinenPelaaja());
    }
    
    private void tiputaMuutPelaajat() {
        for (int i = 0; i < peli.getLauta().getNappulat().size(); i++) {
            peli.tiputaPelaajaPelista();
            peli.vaihdaVuoroa();
        }
    }
    
    @Test
    public void eiVaihdaVuoroaJosPelaajaOnAinoaJaljellaJaOdottaaVuoroaan() {
        tiputaMuutPelaajat();
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        edellinenPelaaja.setOdottaaVuoroaan(2);
        peli.vaihdaVuoroa();
        assertEquals(edellinenPelaaja, peli.getNykyinenPelaaja());
    }
    
    @Test
    public void ainoaPelaajaEiOdotaVuoroaanSeuraavallaVuorolla() {
        tiputaMuutPelaajat();
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        edellinenPelaaja.setOdottaaVuoroaan(3);
        peli.vaihdaVuoroa();
        assertEquals(0, peli.getNykyinenPelaaja().getOdottaaVuoroaan());
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
