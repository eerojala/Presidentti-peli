package presidenttipeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Tutkinto;

public class PresidentinvaalienhallintaTest {

    Presidentinvaalienhallinta hallinta;
    Pelaaja pelaaja;
    Ammatti johtaja;
    ArrayList<Liike> liikkeet;
    ArrayList<Mokki> mokit;
    Tutkinto tutkinto;

    public PresidentinvaalienhallintaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ArrayList<String> nimet = new ArrayList();
        nimet.add("testi");
        KaikenLuoja luoja = new KaikenLuoja(nimet);
        pelaaja = luoja.getLauta().getNappulat().get(0).getOmistaja();
        hallinta = new Presidentinvaalienhallinta(pelaaja, luoja.getPeli().getVaalienjarjestaja(),
                luoja.getPeli().getPankinjohtaja(), luoja.getPeli().getKiinteistonvalittaja());
        johtaja = new Ammatti("Johtaja", 10000, true, false, false);
        liikkeet = new ArrayList();
        liikkeet.add(new Liike("Testiliike", "Testi", 10000, 1000));
        mokit = new ArrayList();
        mokit.add(new Mokki("Testi", 10000));
        tutkinto = new Tutkinto(false);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void vaihtoehto1AsettaaOikeanHinnanJosKansanedustaja() {
        pelaaja.setKansanedustaja(true);
        hallinta.vaihtoehto1();
        assertEquals(40000, hallinta.getMaksettavaHinta());
    }

    @Test
    public void vaihtoehto1AsettaaOikeanAanimaaranJosKansanedustaja() {
        pelaaja.setKansanedustaja(true);
        hallinta.vaihtoehto1();
        assertEquals(100, hallinta.getTarvittavaAanimaara());
    }

    @Test
    public void vaihtoehto1AsettaaOikeanHinnanJosJohtaja() {
        pelaaja.setAmmatti(johtaja);
        hallinta.vaihtoehto1();
        assertEquals(50000, hallinta.getMaksettavaHinta());
    }

    @Test
    public void vaihtoehto1AsettaaOikeanAanimaaranJosJohtaja() {
        pelaaja.setAmmatti(johtaja);
        hallinta.vaihtoehto1();
        assertEquals(110, hallinta.getTarvittavaAanimaara());
    }

    @Test
    public void vaihtoehto1AsettaaBooleanitOikein() {
        boolean vaite = true;
        hallinta.vaihtoehto1();
        if (hallinta.isVaihtoehto1Valittu() == false || hallinta.isVaihtoehto2Valittu() == true
                || hallinta.isVaihtoehto3Valittu() == true) {
            vaite = false;
        }
        assertEquals(true, vaite);
    }

    @Test
    public void vaihtoehto2AsettaaOikeanHinnanJosKansanedustaja() {
        pelaaja.setKansanedustaja(true);
        hallinta.vaihtoehto2();
        assertEquals(30000, hallinta.getMaksettavaHinta());
    }

    @Test
    public void vaihtoehto2AsettaaOikeanAanimaaranJosKansanedustaja() {
        pelaaja.setKansanedustaja(true);
        hallinta.vaihtoehto2();
        assertEquals(90, hallinta.getTarvittavaAanimaara());
    }

    @Test
    public void vaihtoehto2AsettaaOikeanHinnanJosJohtaja() {
        pelaaja.setAmmatti(johtaja);
        hallinta.vaihtoehto2();
        assertEquals(40000, hallinta.getMaksettavaHinta());
    }

    @Test
    public void vaihtoehto2AsettaaOikeanAanimaaranJosJohtaja() {
        pelaaja.setAmmatti(johtaja);
        hallinta.vaihtoehto2();
        assertEquals(100, hallinta.getTarvittavaAanimaara());
    }

    @Test
    public void vaihtoehto2AsettaaBooleanitOikein() {
        boolean vaite = true;
        hallinta.vaihtoehto2();
        if (hallinta.isVaihtoehto1Valittu() == true || hallinta.isVaihtoehto2Valittu() == false
                || hallinta.isVaihtoehto3Valittu() == true) {
            vaite = false;
        }
        assertEquals(vaite, true);
    }

    @Test
    public void vaihtoehto3AsettaaOikeanHinnanJosKansanedustaja() {
        pelaaja.setKansanedustaja(true);
        hallinta.vaihtoehto3();
        assertEquals(10000, hallinta.getMaksettavaHinta());
    }

    @Test
    public void vaihtoehto3AsettaaOikeanAanimaaranJosKansanedustaja() {
        pelaaja.setKansanedustaja(true);
        hallinta.vaihtoehto3();
        assertEquals(75, hallinta.getTarvittavaAanimaara());
    }

    @Test
    public void vaihtoehto3AsettaaOikeanHinnanJosJohtaja() {
        pelaaja.setAmmatti(johtaja);
        hallinta.vaihtoehto3();
        assertEquals(20000, hallinta.getMaksettavaHinta());
    }

    @Test
    public void vaihtoehto3AsettaaOikeanAanimaaranJosJohtaja() {
        pelaaja.setAmmatti(johtaja);
        hallinta.vaihtoehto3();
        assertEquals(85, hallinta.getTarvittavaAanimaara());
    }

    @Test
    public void vaihtoehto3AsettaaBooleanitOikein() {
        boolean vaite = true;
        hallinta.vaihtoehto3();
        if (hallinta.isVaihtoehto1Valittu() == true || hallinta.isVaihtoehto2Valittu() == true
                || hallinta.isVaihtoehto3Valittu() == false) {
            vaite = false;
        }
        assertEquals(vaite, true);
    }

    @Test
    public void pelaajallaLiikePalauttaaTrueJosOnLiikkeita() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(true, hallinta.pelaajallaLiike());
    }
    
    @Test
    public void pelaajallaLiikePalauttaaFalseJosEiOleLiikkeita() {
        assertEquals(false, hallinta.pelaajallaLiike());
    }
    
    @Test
    public void pelaajallaMokkiPalauttaaTrueJosOnMokkeja() {
        pelaaja.setOmistamatMokit(mokit);
        assertEquals(true, hallinta.pelaajallaMokki());
    }
    
    @Test
    public void pelaajallaMokkiPalauttaaFalseJosEiOleMokkeja() {
        assertEquals(false, hallinta.pelaajallaMokki());
    }
    
    @Test
    public void pelaajallaMokkiTaiLiikePalauttaaTrueJosOnMokkeja() {
        pelaaja.setOmistamatMokit(mokit);
        assertEquals(true, hallinta.pelaajallaMokkiTaiLiike());
    }
    
    @Test
    public void pelaajallaMokkiTaiLiikePalauttaaTrueJosOnLiikkeita() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(true, hallinta.pelaajallaMokkiTaiLiike());
    }
    
    @Test
    public void pelaajallaMokkiTailiikePalauttaaTrueJosOnMokkejaJaLiikkeita() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setOmistamatMokit(mokit);
        assertEquals(true, hallinta.pelaajallaMokkiTaiLiike());
    }
    
    @Test
    public void pelaajallaMokkiTaiLiikePalauttaaFalseJosEiMokkejaTaiLiikkeita() {
        assertEquals(false, hallinta.pelaajallaMokkiTaiLiike());
    }
    
    @Test
    public void pelaajallaTutkintoPalauttaaTrueJosPelaajallaTutkinto() {
        pelaaja.setTutkinto(tutkinto);
        assertEquals(true, hallinta.pelaajallaTutkinto());
    }
    
    @Test
    public void pelaajallaTutkintoPalauttaaFalseJosPelaajallaEiTutkintoa() {
        assertEquals(false, hallinta.pelaajallaTutkinto());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon1PalauttaaTrueJosRahaa() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(40000);
        assertEquals(true, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon1());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon1PalauttaaFalseJosEiRahaa() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(39999);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon1());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon1PalauttaaFalseJosEiKansanedustaja() {
        pelaaja.setRahat(40000);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon1());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon1PalauttaaTrueJosRahaa() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(50000);
        assertEquals(true, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon1());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon1PalauttaaFalseJosEiRahaa() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(49999);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon1());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon1PalauttaaFalseJosEiJohtaja() {
        pelaaja.setRahat(50000);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon1());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon2PalauttaaTrueJosEhdotTayttyvat() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setRahat(30000);
        assertEquals(true, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon2());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon2PalauttaaFalseJosEiLiikkeitaTaiMokkeja() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(30000);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon2());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon2PalauttaaFalseJosEiRahaa() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(29999);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon2());
    } 
    
    @Test
    public void pelaajaKykeeneeKansanedustajanVaihtoehtoon2PalauttaaFalseJosEiKansanedustaja() {
        pelaaja.setRahat(30000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon2());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon2PalauttaaTrueJosEhdotTayttyvat() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(40000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(true, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon2());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon2PalauttaaFalseJosEiRahaa() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(39999);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon2());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon2PalauttaaFalseJosEiLiikkeitaTaiMokkeja() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(40000);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon2());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon2PalauttaaFalseJosEiJohtaja() {
        pelaaja.setRahat(40000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon2());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon3PalauttaaTrueJosEhdotTayttyvat() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(10000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(true, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon3PalauttaaFalseJosEiRahaa() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(9999);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon3PalauttaaFalseJosEiLiikkeitaTaiMokkeja() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(10000);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon3PalauttaaFalseJosEiTutkintoa() {
        pelaaja.setKansanedustaja(true);
        pelaaja.setRahat(10000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeKansanedustajanVaihtoehtoon3PalauttaaFalseJosEiKansanedustaja() {
        pelaaja.setRahat(10000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon3PalauttaaTrueJosEhdotTayttyvat() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(20000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(true, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon3PalauttaaFalseJosRahaEiRiita() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(19999);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon3PalauttaaFalseJosEiLiikkeitaTaiMokkeja() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(20000);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon3PalauttaaFalseJosEiTutkintoa() {
        pelaaja.setAmmatti(johtaja);
        pelaaja.setRahat(20000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        assertEquals(false, hallinta.pelaajaKykeneeJohtajanVaihtoehtoon3());
    }
    
    @Test
    public void pelaajaKykeneeJohtajanVaihtoehtoon3PalauttaaFalseJosEiJohtaja() {
        pelaaja.setRahat(20000);
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setTutkinto(tutkinto);
        assertEquals(false, hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon3());
    }
}

