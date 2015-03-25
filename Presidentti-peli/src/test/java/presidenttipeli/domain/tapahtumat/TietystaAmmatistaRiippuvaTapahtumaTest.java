
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

public class TietystaAmmatistaRiippuvaTapahtumaTest {
    Tapahtuma testi1;
    Tapahtuma testi2;
    Ammatti tyoton;
    Ammatti johtaja;
    Pelaaja pelaaja;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;
    Tapahtuma tapahtuma3;
    
    public TietystaAmmatistaRiippuvaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tyoton = new Ammatti("Työtön", 1000, false, false, true);
        johtaja = new Ammatti("Johtaja", 10000, true, false, false);
        tapahtuma1 = new JasenkirjaanVaikuttavaTapahtuma(true);
        tapahtuma2 = new JasenkirjaanVaikuttavaTapahtuma(false);
        tapahtuma3 = new TutkintoonVaikuttavaTapahtuma(true);
        testi1 = new TietystaAmmatistaRiippuvaTapahtuma(tyoton, tapahtuma1, tapahtuma2);
        testi2 = new TietystaAmmatistaRiippuvaTapahtuma(tyoton, tapahtuma1, tapahtuma3);
        pelaaja = new Pelaaja("Testi");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void tekeeTapahtuman1JosPelaajallaTiettyAmmatti() {
        pelaaja.setPuolueenJasen(false);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void tekeeTapahtuman2JosPelaajallaEiTiettyaAmmattia() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setPuolueenJasen(true);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void eiTeeTapahtumaa2JosPelaajallaTiettyAmmatti() {
        pelaaja.setTutkinto(false);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.omistaaTutkinnon());
    }
    
    @Test
    public void eiTeeTapahtumaa1JosPelaajallaEiTiettyaAmmattia() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setPuolueenJasen(false);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
    
}
