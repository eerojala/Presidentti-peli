
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

public class OtaAmmattikorttiTest {
    Tapahtuma testi1;
    Tapahtuma testi2;
    Pelilauta lauta;
    Pelaaja pelaaja;
    int johtajaAmmattikorttipinonKoko;
    int sattumaAmmattikorttipinonKoko;
    
    public OtaAmmattikorttiTest() {
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
        lauta.getJohtajaAmmatit().add(new Ammatti("Johtaja", 10000, true, false, false));
        lauta.getSattumaAmmatit().add(new Ammatti("Sattuma", 5000, false, true, false));
        testi1 = new OtaAmmattikortti(lauta, true);
        testi2 = new OtaAmmattikortti(lauta, false);
        pelaaja = new Pelaaja("testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ottaaJohtajaAmmattikorttipinosta() {
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(false, lauta.getJohtajaAmmatit().contains(pelaaja.getAmmatti()));
    }
    
    @Test
    public void ottaaSattumaAmmattikorttipinosta() {
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(false, lauta.getSattumaAmmatit().contains(pelaaja.getAmmatti()));
    }
 
    @Test
    public void eiOtaSattumaAmmattipinostaJosOtetaanJohtajaAmmatti() {
        sattumaAmmattikorttipinonKoko = lauta.getSattumaAmmatit().size();
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(sattumaAmmattikorttipinonKoko, lauta.getSattumaAmmatit().size());
    }
    
    @Test
    public void eiOtaJohtajaAmmattipinostaJosOtetaanSattumaAmmatti() {
        johtajaAmmattikorttipinonKoko = lauta.getJohtajaAmmatit().size();
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(johtajaAmmattikorttipinonKoko, lauta.getJohtajaAmmatit().size());
    }
}
