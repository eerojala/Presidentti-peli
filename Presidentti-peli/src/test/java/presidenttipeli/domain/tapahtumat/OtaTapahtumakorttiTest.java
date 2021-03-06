
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Tapahtumakortti;


public class OtaTapahtumakorttiTest {
    Tapahtuma testi;
    Tapahtumakortti kortti1;
    Tapahtumakortti kortti2;
    Pelilauta lauta;
    Pelaaja pelaaja;
    
    public OtaTapahtumakorttiTest() {
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
        kortti1 = new Tapahtumakortti();
        kortti1.setSeloste("kortti1");
        kortti1.getTapahtumat().add(new JasenkirjaanVaikuttavaTapahtuma(true));
        kortti2 = new Tapahtumakortti();
        kortti2.setSeloste("kortti2");
        lauta.getTapahtumakortit().add(kortti1);
        lauta.getTapahtumakortit().add(kortti2);
        testi = new OtaTapahtumakortti(lauta);
        pelaaja = new Pelaaja("test");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void palauttaaTapahtumakortinPinonViimeiseksiSuorituksenJalkeen() {
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(kortti1, lauta.getTapahtumakortit().peekLast());
    }
    
    @Test
    public void suorittaaKortinTapahtumat() {
        pelaaja.setPuolueenJasen(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void palauttaaTrueJosKaikkiTapahtumatOnnistuivat() {
        assertEquals(true, testi.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void palauttaaFalseJosJokinTapahtumistaEpaonnistuu() {
        Tapahtumakortti kortti3 = new Tapahtumakortti();
        kortti3.getTapahtumat().add(new RahaanVaikuttavaTapahtuma(false, Integer.MAX_VALUE));
        lauta.getTapahtumakortit().clear();
        lauta.getTapahtumakortit().add(kortti3);
        Tapahtuma testi2 = new OtaTapahtumakortti(lauta);
        assertEquals(false, testi2.suoritaTapahtuma(pelaaja));
    }
    
    @Test
    public void eiVieKorttiaTakaisinPinoonJosJokinTapahtumistaEpaonnistuu() {
        Tapahtumakortti kortti3 = new Tapahtumakortti();
        kortti3.getTapahtumat().add(new RahaanVaikuttavaTapahtuma(false, Integer.MAX_VALUE));
        lauta.getTapahtumakortit().clear();
        lauta.getTapahtumakortit().add(kortti3);
        Tapahtuma testi2 = new OtaTapahtumakortti(lauta);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(true, lauta.getTapahtumakortit().peek().equals(kortti3));
    }
}
