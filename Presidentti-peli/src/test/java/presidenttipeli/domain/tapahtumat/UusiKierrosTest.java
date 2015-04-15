
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Tutkinto;

public class UusiKierrosTest {
    Tapahtuma testi;
    Pelilauta lauta;
    Pelaaja pelaaja;
    int rahatEnnen;
    int velatEnnen;
    int palkkaEnnen;
    
    
    public UusiKierrosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauta = new Pelilauta();
        testi = new UusiKierros(lauta);
        pelaaja = new Pelaaja("Testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelaajaSaaKuukaudenTuotot() {
        rahatEnnen = pelaaja.getRahat();
        palkkaEnnen = pelaaja.getAmmatti().getPalkka();
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnen + palkkaEnnen, pelaaja.getRahat());
    }
    
    @Test
    public void pelaajaSaaTakaisinOikeudenLiikkeidenTuottoon() {
        pelaaja.setOikeutettuTuottoon(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isOikeutettuTuottoon());
    }
    
    @Test
    public void pelaajaOnTyotonUudenKierroksenAlkaessa() {
        pelaaja.setAmmatti(new Ammatti("Testi", 10000, true, false, false));
        testi.suoritaTapahtuma(pelaaja);
        assertEquals("Työtön", pelaaja.getAmmatti().getNimi());
    }
    
    @Test
    public void pelaajanVelkaEiKasvaJosVelkaaEiOllutEnnestaan() {
        pelaaja.setVelkaa(0);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(0, pelaaja.getVelkaa());
    }
    
    @Test
    public void velkaKasvaaKymmenenProsenttia() {
        pelaaja.setVelkaa(1000);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(1100, pelaaja.getVelkaa());
    }
    
    @Test
    public void puolueenJasenyysSailyy() {
        pelaaja.setPuolueenJasen(true);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void kansanedustajuusSailyy() {
        pelaaja.setKansanedustaja(true);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isKansanedustaja());
    }
    
    @Test
    public void tukintoSailyy() {
        pelaaja.setTutkinto(new Tutkinto(false));
        testi.suoritaTapahtuma(pelaaja);
        boolean vaite = true;
        if (pelaaja.getTutkinto() == null) {
            vaite = false;
        }
        assertEquals(true, vaite);
    }
}
