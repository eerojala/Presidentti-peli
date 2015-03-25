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

public class VieAmmattikorttiTakaisinPinoonTest {

    Tapahtuma testi1;
    Tapahtuma testi2;
    Tapahtuma testi3;
    Pelilauta lauta;
    Pelaaja pelaaja;
    int johtajaAmmattipinonKoko;
    int sattumaAmmattipinonKoko;

    public VieAmmattikorttiTakaisinPinoonTest() {
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
        testi1 = new VieAmmattikorttiTakaisinPinoon(lauta, new Ammatti("Työtön", 1000, false, false, true));
        testi2 = new VieAmmattikorttiTakaisinPinoon(lauta, new Ammatti("Sattuma", 5000, false, true, true));
        testi3 = new VieAmmattikorttiTakaisinPinoon(lauta, new Ammatti("Johtaja", 10000, true, false, false));
        pelaaja = new Pelaaja("Testi");
        johtajaAmmattipinonKoko = lauta.getJohtajaAmmatit().size();
        sattumaAmmattipinonKoko = lauta.getSattumaAmmatit().size();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void vieJohtajaAmmattikortinTakaisinPinoon() {
        testi3.suoritaTapahtuma(pelaaja);
        assertEquals(johtajaAmmattipinonKoko + 1, lauta.getJohtajaAmmatit().size());
    }

    @Test
    public void vieSattumaAmmattikortinTakaisinPinoon() {
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(sattumaAmmattipinonKoko + 1, lauta.getSattumaAmmatit().size());
    }

    @Test
    public void eiVieAmmattikorttiaJohtajaAmmattipinoonJosAmmattiEiOleJohtajaAmmatti() {
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(johtajaAmmattipinonKoko, lauta.getJohtajaAmmatit().size());
    }

    @Test
    public void eiVieAmmattikorttiaSattumaAmmattipinoonJosAmmattiEiOleSattumaAmmatti() {
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(sattumaAmmattipinonKoko, lauta.getSattumaAmmatit().size());
    }
}
