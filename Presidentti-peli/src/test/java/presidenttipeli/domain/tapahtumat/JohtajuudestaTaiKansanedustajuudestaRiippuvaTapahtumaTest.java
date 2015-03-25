
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;


public class JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtumaTest {
    Tapahtuma testi1;
    Tapahtuma testi2;
    Tapahtuma tapahtuma1;
    Tapahtuma tapahtuma2;
    Tapahtuma tapahtuma3;
    Tapahtuma tapahtuma4;
    Ammatti eijohtaja;
    Ammatti johtaja;
    Pelaaja pelaaja;
    
    public JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtumaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tapahtuma1 = new TutkintoonVaikuttavaTapahtuma(false);
        tapahtuma2 = new TutkintoonVaikuttavaTapahtuma(true);
        tapahtuma3 = new JasenkirjaanVaikuttavaTapahtuma(true);
        testi1 = new JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(tapahtuma1, tapahtuma2);
        testi2 = new JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(tapahtuma1, tapahtuma3);
        eijohtaja = new Ammatti("Ei-Johtaja", 5000, false, false, false);
        johtaja = new Ammatti("Johtaja", 10000, true, false, false);
        pelaaja = new Pelaaja("testi");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void suorittaaTapahtuman1JosKansanedustaja() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setAmmatti(eijohtaja);
        pelaaja.setTutkinto(true);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.omistaaTutkinnon());
    }
    
    @Test
    public void suorittaaTapahtuman1JosJohtaja() {
        pelaaja.setKansanedustaja(false);
        pelaaja.setAmmatti(johtaja);
        pelaaja.setTutkinto(true);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.omistaaTutkinnon());
    }
    
    @Test
    public void suorittaaTapahtuman2JosEiKansanedustajaTaiJohtaja() {
        pelaaja.setKansanedustaja(false);
        pelaaja.setAmmatti(eijohtaja);
        pelaaja.setTutkinto(false);
        testi1.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.omistaaTutkinnon());
    }
    
    @Test
    public void eiSuoritaMolempiaTapahtumiaJosKansanedustajaTaiJohtaja() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setPuolueenJasen(false);
        pelaaja.setAmmatti(eijohtaja);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(false, pelaaja.isPuolueenJasen());
    }
    
    @Test
    public void eiSuoritaMolempiaTapahtumaJosEiKansanedustajaTaiJohtaja() {
        pelaaja.setKansanedustaja(false);
        pelaaja.setPuolueenJasen(false);
        pelaaja.setAmmatti(eijohtaja);
        pelaaja.setTutkinto(true);
        testi2.suoritaTapahtuma(pelaaja);
        assertEquals(true, pelaaja.omistaaTutkinnon());
    }
    
    
}
