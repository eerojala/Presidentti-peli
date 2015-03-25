
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


public class JasenkirjastaRiippuvaTapahtumaTest {
    Tapahtuma testi1;
    Tapahtuma testi2;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;
    Tapahtuma tapahtuma3;
    Pelaaja pelaaja;
    
    public JasenkirjastaRiippuvaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tapahtuma1 = new JasenkirjaanVaikuttavaTapahtuma(false);
        tapahtuma2 = new JasenkirjaanVaikuttavaTapahtuma(true);
        tapahtuma3 = new TutkintoonVaikuttavaTapahtuma(true);
        testi1 = new JasenkirjastaRiippuvaTapahtuma(tapahtuma1, tapahtuma2);
        testi2 = new JasenkirjastaRiippuvaTapahtuma(tapahtuma1, tapahtuma3);
        pelaaja = new Pelaaja("test");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void suorittaaTapahtuman1JosPuolueenJasen() {
        pelaaja.setPuolueenJasen(true);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void suorittaaTapahtuman2JosEiPuolueenJasen() {
        pelaaja.setPuolueenJasen(false);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void eiSuoritaMolempiaTapahtumiaJosPuolueenJasen() {
        pelaaja.setPuolueenJasen(true);
        pelaaja.setTutkinto(false);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.omistaaTutkinnon());
    }
    
    @Test
    public void eiSuoritaMolempiaTapahtumiaJosEiPuolueenJasen() {
        pelaaja.setPuolueenJasen(false);
        pelaaja.setTutkinto(true);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
    
}
