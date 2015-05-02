package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Pelaaja;

public class VuoronvaihtajaTest {

    Peli peli;
    Vuoronvaihtaja vaihtaja;

    public VuoronvaihtajaTest() {
        ArrayList<String> nimet = new ArrayList();
        nimet.add("Testi1");
        nimet.add("Testi2");
        KaikenLuoja luoja = new KaikenLuoja(nimet);
        peli = luoja.getPeli();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void vaihtaaPelaajaa() {
        peli.vaihdaVuoroa();
        assertEquals(peli.getNykyinenPelaaja(),
                peli.getLauta().getNappulat().get(1).getOmistaja());
    }

    @Test
    public void vaihtaaOikeinJosNykyinenPelaajaListanViimeinen() {
        peli.setNykyinenPelaaja(
                peli.getLauta().getNappulat().get(peli.getLauta().getNappulat().size() - 1).getOmistaja());
        peli.vaihdaVuoroa();
        assertEquals(peli.getNykyinenPelaaja(), peli.getLauta().getNappulat().get(0).getOmistaja());
    }

    @Test
    public void vaihtaaSitaSeuraavaanPelaajaanJosSeuraavaJoutuuOdottomaanVuoroaan() {
        peli.getLauta().getNappulat().get(1).getOmistaja().setOdottaaVuoroaan(1);
        peli.vaihdaVuoroa();
        assertEquals(peli.getNykyinenPelaaja(), peli.getLauta().getNappulat().get(0).getOmistaja());
    }

    @Test
    public void vaihtaaVuoroaOikeinJosEdellinenPelaajaTippuiPelista1() {
        peli.tiputaPelaajaPelista();
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        peli.vaihdaVuoroa();
        assertEquals(false, peli.getNykyinenPelaaja().equals(edellinenPelaaja));
    }

    @Test
    public void vaihtaaVuoroaOikeinJosEdellinenPelaajaTippuiPelista2() {
        peli.setNykyinenPelaaja(peli.getLauta().getNappulat().get(1).getOmistaja());
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        peli.tiputaPelaajaPelista();
        peli.vaihdaVuoroa();
        assertEquals(false, peli.getNykyinenPelaaja().equals(edellinenPelaaja));
    }

    @Test
    public void eiVaihdaVuoroaJosPelaajaOnAinoaJaljella() {
        tiputaMuutPelaajat();
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        peli.vaihdaVuoroa();
        assertEquals(edellinenPelaaja, peli.getNykyinenPelaaja());
    }

    private void tiputaMuutPelaajat() {
        for (int i = 0; i < peli.getLauta().getNappulat().size(); i++) {
            peli.tiputaPelaajaPelista();
            peli.vaihdaVuoroa();
        }
    }

    @Test
    public void eiVaihdaVuoroaJosPelaajaOnAinoaJaljellaJaOdottaaVuoroaan() {
        tiputaMuutPelaajat();
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        edellinenPelaaja.setOdottaaVuoroaan(2);
        peli.vaihdaVuoroa();
        assertEquals(edellinenPelaaja, peli.getNykyinenPelaaja());
    }

    @Test
    public void ainoaPelaajaEiOdotaVuoroaanSeuraavallaVuorolla() {
        tiputaMuutPelaajat();
        Pelaaja edellinenPelaaja = peli.getNykyinenPelaaja();
        edellinenPelaaja.setOdottaaVuoroaan(3);
        peli.vaihdaVuoroa();
        assertEquals(0, peli.getNykyinenPelaaja().getOdottaaVuoroaan());
    }

}
