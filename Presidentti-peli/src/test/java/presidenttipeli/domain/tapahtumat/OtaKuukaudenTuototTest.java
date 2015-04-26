
package presidenttipeli.domain.tapahtumat;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Tutkinto;


public class OtaKuukaudenTuototTest {
    Tapahtuma testi;
    Pelaaja pelaaja;
    int rahaViimekuussa;
    ArrayList<Liike> liikkeet;
    Liike liike1;
    Liike liike2;
    
    public OtaKuukaudenTuototTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testi = new OtaKuukaudenTuotot();
        pelaaja = new Pelaaja("Testi");
        rahaViimekuussa = pelaaja.getRahat();
        liikkeet = new ArrayList();
        liike1 = new Liike("Testiliike", "Testi1", 15000, 1500);
        liike2 = new Liike("Testiliike", "Testi2", 10000, 1000);
        liikkeet.add(liike1);
        liikkeet.add(liike2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ottaaPalkanMukaan() {
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahaViimekuussa + pelaaja.getAmmatti().getPalkka(), pelaaja.getRahat());
    }
    
    @Test
    public void ottaaTutkinnonMukaan() {
        pelaaja.setTutkinto(new Tutkinto(false));
        pelaaja.setAmmatti(new Ammatti("Testi", 1000, false, false, false));
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahaViimekuussa + pelaaja.getAmmatti().getPalkka() + 1500, pelaaja.getRahat());
    }
    
    @Test
    public void ottaaLiikkeidenTuotonMukaan() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahaViimekuussa + pelaaja.getAmmatti().getPalkka() + 
                laskeLiikkeidenTuotto(), pelaaja.getRahat());
    }
    
    private int laskeLiikkeidenTuotto() {
        int summa = 0;
        for (Liike liike : liikkeet) {
            summa+=liike.getTuotto();
        }
        return summa;
    }
    
    @Test
    public void eiOtaLiikkeidenTuottoaMukaanJosEiOikeutettu() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setOikeutettuTuottoon(false);
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahaViimekuussa + pelaaja.getAmmatti().getPalkka(), pelaaja.getRahat());
    }
    
    @Test
    public void eiLaskeTutkintoaMukaanJosTyoton() {
        pelaaja.setTutkinto(new Tutkinto(false));
        testi.suoritaTapahtuma(pelaaja);
        assertEquals(rahaViimekuussa + 1000, pelaaja.getRahat());
    }
}
