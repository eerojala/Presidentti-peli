package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

public class KiinteistonvalittajaTest {

    KaikenLuoja luoja;
    Pelilauta lauta;
    Kiinteistonvalittaja valittaja;
    ArrayList<String> nimet;
    Pelaaja pelaaja;
    int rahatEnnen;
    Mokki mokki;
    Liike liike;
    double kerroin;

    public KiinteistonvalittajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        nimet = new ArrayList();
        nimet.add("Testi1");
        nimet.add("Testi2");
        luoja = new KaikenLuoja(nimet);
        lauta = luoja.getPeli().getLauta();
        valittaja = luoja.getPeli().getKiinteistonvalittaja();
        pelaaja = lauta.getNappulat().get(0).getOmistaja();
        pelaaja.setRahat(1000000);
        pelaaja.getOmistamatMokit().add(lauta.getMokit().poll());
        pelaaja.getOmistamatLiikkeet().add(lauta.getLiikkeet().poll());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void antaaPelaajalleMokin() {
        mokki = lauta.getMokit().peek();
        valittaja.annaPelaajalleMokki(pelaaja, 1);
        assertEquals(true, pelaaja.getOmistamatMokit().contains(mokki));
    }

    @Test
    public void ottaaMokinPoisPinosta() {
        mokki = lauta.getMokit().peek();
        valittaja.annaPelaajalleMokki(pelaaja, 1);
        assertEquals(false, lauta.getMokit().contains(mokki));
    }

    @Test
    public void ottaaPelaajaltaMokinArvonVerranRahaa() {
        mokki = lauta.getMokit().peek();
        rahatEnnen = pelaaja.getRahat();
        valittaja.annaPelaajalleMokki(pelaaja, 1);
        assertEquals(rahatEnnen - mokki.getArvo(), pelaaja.getRahat());
    }

    @Test
    public void kerroinToimiiMokinAntamisessa() {
        mokki = lauta.getMokit().peek();
        kerroin = 0.1;
        rahatEnnen = pelaaja.getRahat();
        valittaja.annaPelaajalleMokki(pelaaja, kerroin);
        assertEquals(rahatEnnen - mokki.getArvo() * kerroin, pelaaja.getRahat(), 0.1);
    }
    
    @Test
    public void ottaaPelaajaltaPoisMokin() {
        mokki = pelaaja.getOmistamatMokit().get(0);
        valittaja.otaPelaajaltaMokkiPois(pelaaja, mokki, 1);
        assertEquals(false, pelaaja.getOmistamatMokit().contains(mokki));
    }
    
    @Test
    public void asettaaMokinTakaisinPinoon() {
        mokki = pelaaja.getOmistamatMokit().get(0);
        valittaja.otaPelaajaltaMokkiPois(pelaaja, mokki, 1);
        assertEquals(mokki, lauta.getMokit().peekLast());
    }
    
    @Test
    public void antaaPelaajalleMokinArvonVerranRahaa() {
        mokki = pelaaja.getOmistamatMokit().get(0);
        rahatEnnen = pelaaja.getRahat();
        valittaja.otaPelaajaltaMokkiPois(pelaaja, mokki, 1);
        assertEquals(rahatEnnen + mokki.getArvo(), pelaaja.getRahat());
    }
    
    @Test
    public void kerroinToimiiMokinOttamisessa() {
        mokki = pelaaja.getOmistamatMokit().get(0);
        kerroin = 0.1;
        rahatEnnen = pelaaja.getRahat();
        valittaja.otaPelaajaltaMokkiPois(pelaaja, mokki, kerroin);
        assertEquals(rahatEnnen + mokki.getArvo() * kerroin, pelaaja.getRahat(), 0.1);
    }
    
    @Test
    public void antaaPelaajalleLiikkeen() {
        liike = lauta.getLiikkeet().peek();
        valittaja.annaPelaajalleLiike(pelaaja, 1);
        assertEquals(true, pelaaja.getOmistamatLiikkeet().contains(liike));
    }
    
    @Test
    public void ottaaLiikkeenPoisPinosta() {
        liike = lauta.getLiikkeet().peek();
        valittaja.annaPelaajalleLiike(pelaaja, 1);
        assertEquals(false, lauta.getLiikkeet().contains(liike));
    }
    
    @Test
    public void ottaaPelaajaltaLiikkeenArvonVerranRahaa() {
        liike = lauta.getLiikkeet().peek();
        rahatEnnen = pelaaja.getRahat();
        valittaja.annaPelaajalleLiike(pelaaja, 1);
        assertEquals(rahatEnnen - liike.getArvo(), pelaaja.getRahat());
    }
    
    @Test
    public void kerroinToimiiLiikkeidenAntamisessa() {
        liike = lauta.getLiikkeet().peek();
        kerroin = 0.1;
        rahatEnnen = pelaaja.getRahat();
        valittaja.annaPelaajalleLiike(pelaaja, kerroin);
        assertEquals(rahatEnnen - liike.getArvo() * kerroin, pelaaja.getRahat(), 0.1);
    }
    
    @Test
    public void ottaaPelaajaltaLiikkeenPois() {
        liike = pelaaja.getOmistamatLiikkeet().get(0);
        valittaja.otaPelaajaltaLiikePois(pelaaja, liike, 1);
        assertEquals(false, pelaaja.getOmistamatLiikkeet().contains(liike));
    }
    
    @Test
    public void asettaaLiikkeenTakaisinPinoon() {
        liike = pelaaja.getOmistamatLiikkeet().get(0);
        valittaja.otaPelaajaltaLiikePois(pelaaja, liike, 1);
        assertEquals(liike, lauta.getLiikkeet().getLast());
    }
    
    @Test
    public void antaaPelaajalleLiikkeenArvonVerranRahaa() {
        liike = pelaaja.getOmistamatLiikkeet().get(0);
        rahatEnnen = pelaaja.getRahat();
        valittaja.otaPelaajaltaLiikePois(pelaaja, liike, 1);
        assertEquals(rahatEnnen + liike.getArvo(), pelaaja.getRahat());
    }
    
    @Test
    public void kerroinToimiiLiikkeidenOttamisessa() {
        liike = pelaaja.getOmistamatLiikkeet().get(0);
        rahatEnnen = pelaaja.getRahat();
        kerroin = 0.1;
        valittaja.otaPelaajaltaLiikePois(pelaaja, liike, kerroin);
        assertEquals(rahatEnnen + liike.getArvo() * kerroin, pelaaja.getRahat(), 0.1);
    }
}
