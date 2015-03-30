
package presidenttipeli.domain.tapahtumat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;


public class MaksaKulujaLiikkeistaJaMokeistaTest {
    Pelaaja pelaaja;
    Tapahtuma testi;
    int maksettavaHinta;
    int rahatEnnenTapahtumaa;
    int kuinkaMonta;
    
    public MaksaKulujaLiikkeistaJaMokeistaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Testi");
        maksettavaHinta = 500;
        rahatEnnenTapahtumaa = pelaaja.getRahat();
        testi = new MaksaKulujaLiikkeistaJaMokeista(maksettavaHinta);     
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelaajaltaEiMeneYhtaanRahaaJosPelaajaEiOmistaLiikkeitaTaiMokkeja() {
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenTapahtumaa, pelaaja.getRahat());
    }
    
    @Test
    public void liikkeidenMaaraVaikuttaaMaksettavaanSummaan() {
        kuinkaMonta = 2;
        for (int i = 0; i < kuinkaMonta; i++) {
            pelaaja.getOmistamatLiikkeet().add(new Liike("Testiliike", "Liike", 15000, 1500));
        }
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenTapahtumaa - 
                pelaaja.getOmistamatLiikkeet().size() * maksettavaHinta, pelaaja.getRahat());
    }
    
    @Test
    public void mokkienMaaraVaikuttaaMaksettavaanSummaan() {
        kuinkaMonta = 2;
        for (int i = 0; i < kuinkaMonta; i++) {
            pelaaja.getOmistamatMokit().add(new Mokki("Mokki", 10000));
        }
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahatEnnenTapahtumaa - 
                pelaaja.getOmistamatMokit().size() * maksettavaHinta, pelaaja.getRahat());
    }
    
    @Test
    public void mokkienJaLiikkeidenMaaraVaikuttaaMaksettavaanSummaan() {
        kuinkaMonta = 2;
        for (int i = 0; i < kuinkaMonta; i++) {
            pelaaja.getOmistamatLiikkeet().add(new Liike("Testiliike", "Liike", 15000, 1500));
            pelaaja.getOmistamatMokit().add(new Mokki("Mokki", 10000));
        }
        testi.suoritaTapahtuma(pelaaja);
        int odotettuTulos = rahatEnnenTapahtumaa - (pelaaja.getOmistamatLiikkeet().size() * 
                maksettavaHinta + pelaaja.getOmistamatMokit().size() * maksettavaHinta);
        assertEquals(odotettuTulos, pelaaja.getRahat());
    }
       
    @Test
    public void palauttaaFalseJosPelaajallaEiTarpeeksiRahaa() {
        pelaaja.setRahat(maksettavaHinta - 1);
        pelaaja.getOmistamatMokit().add(new Mokki("Mokki", 10000));
        assertEquals(false, testi.suoritaTapahtuma(pelaaja));
    }
    
}
