
package presidenttipeli.domain.tapahtumat;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class PalkastaRiippuvaTapahtumaTest {
    Tapahtuma testi;
    Pelaaja pelaaja;
    
    public PalkastaRiippuvaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi = new PalkastaRiippuvaTapahtuma(luoTapahtumat(), luoPalkkarajat());
        pelaaja = new Pelaaja("testi");
    }
    
    private ArrayList<Tapahtuma> luoTapahtumat() {
        ArrayList<Tapahtuma> tapahtumat = new ArrayList();
        tapahtumat.add(new JasenkirjaanVaikuttavaTapahtuma(true));
        tapahtumat.add(new KansanedustajuuteenVaikuttavaTapahtuma(true, new Pelilauta()));
        tapahtumat.add(new TutkintoonVaikuttavaTapahtuma(true, false));
        return tapahtumat;
    }
    
    private ArrayList<Integer> luoPalkkarajat() {
        ArrayList<Integer> palkkarajat = new ArrayList();
        palkkarajat.add(2001);
        palkkarajat.add(4001);
        palkkarajat.add(10001);
        return palkkarajat;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void suorittaaAlimmanPalkkarajanTapahtumanJosOikeaPalkka() {
        pelaaja.setPuolueenJasen(false);
        testi.suoritaTapahtuma(pelaaja); // pelaaja on oletusarvoisesti työtön, jonka "palkka" on 1000 mk/kk
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void eiSuoritaUseampaaTapahtumaa() {
        pelaaja.setKansanedustaja(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isKansanedustaja());
    }
    
    @Test
    public void eiSuoritaAlemmanPalkkarajanTapahtumaa() {
        pelaaja.setAmmatti(new Ammatti("Ammatti", 2001, false, false, true));
        pelaaja.setPuolueenJasen(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void eiSuoritaYlimmanRajanTapahtumaaJosPalkkaYliKaikkienRajojen() {
        pelaaja.setAmmatti(new Ammatti("Johtaja", 10001, true, false, false));
        pelaaja.setTutkinto(null);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(null, pelaaja.getTutkinto());
    }
    
}
