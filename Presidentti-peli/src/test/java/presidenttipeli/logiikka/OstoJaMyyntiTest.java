
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


public class OstoJaMyyntiTest {
    OstoJaMyynti ostoJaMyynti;
    Pelaaja pelaaja;
    KaikenLuoja luoja;
    Peli peli;
    ArrayList<Liike> liikkeet;
    ArrayList<Mokki> mokit;
    Mokki mokki;
    Liike liike;
    int rahatEnnen;
    double kerroin;
    
    public OstoJaMyyntiTest() {
        ArrayList<String> nimet = new ArrayList();
        nimet.add("testi");
        luoja = new KaikenLuoja(nimet);
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
        pelaaja = peli.getNykyinenPelaaja();
        mokit = new ArrayList();
        mokit.add(new Mokki("Testi", 10000));
        liikkeet = new ArrayList();
        liikkeet.add(new Liike("Testiliike", "Testi", 30000, 3000));
        liikkeet.add(new Liike("asddsadas", "sfadsaddsa", 40000, 4000));
        
    }
    
    @After
    public void tearDown() {
    }

    private OstoJaMyynti luoOstoJaMyynti(boolean saaMyyda, double kerroin, boolean ruutu20,
            boolean ruutu16Tarjous) {
        OstoJaMyynti palautettava = new OstoJaMyynti(saaMyyda, kerroin, ruutu20,
        pelaaja, peli.getKiinteistonvalittaja(), peli.getLauta().getMokit().peek(),
        peli.getLauta().getLiikkeet().peek(), peli.getLauta(), ruutu16Tarjous);
        return palautettava;
    }
    
    private OstoJaMyynti luoOstoJaMyyntiEiLiikkeitaJaMokkeja(boolean saaMyyda, double kerroin, boolean ruutu20,
            boolean ruutu16Tarjous) {
        peli.getLauta().getLiikkeet().clear();
        peli.getLauta().getMokit().clear();
        OstoJaMyynti palautettava = new OstoJaMyynti(saaMyyda, kerroin, ruutu20,
        pelaaja, peli.getKiinteistonvalittaja(), peli.getLauta().getMokit().peek(),
        peli.getLauta().getLiikkeet().peek(), peli.getLauta(), ruutu16Tarjous);
        return palautettava;
    }
    
    private void asetaPelaajalleMokitJaLiikkeet() {
        pelaaja.setOmistamatLiikkeet(liikkeet);
        pelaaja.setOmistamatMokit(mokit);
    }
    
    @Test
    public void myyMokkiAntaaNormaalinHinnanJosEiTarjous1() {
        kerroin = 1;
        asetaPelaajalleMokitJaLiikkeet();
        mokki = pelaaja.getOmistamatMokit().get(0);
        ostoJaMyynti = luoOstoJaMyynti(true, kerroin, false, false);
        rahatEnnen = pelaaja.getRahat();
        ostoJaMyynti.myyMokki(0);
        assertEquals(rahatEnnen + mokki.getArvo(), pelaaja.getRahat());
    }
    
    @Test
    public void myyMokkiAntaaNormaalinHinnanJosEiTarjous2() {
        kerroin = 0.5;
        asetaPelaajalleMokitJaLiikkeet();
        mokki = pelaaja.getOmistamatMokit().get(0);
        ostoJaMyynti = luoOstoJaMyynti(true, kerroin, false, false);
        rahatEnnen = pelaaja.getRahat();
        ostoJaMyynti.myyMokki(0);
        assertEquals(rahatEnnen + mokki.getArvo() * kerroin, pelaaja.getRahat(), 0.1);
    }
    
    @Test
    public void myyMokkiAntaaKaksinkertaisenHinnanJosTarjous() {
        asetaPelaajalleMokitJaLiikkeet();
        kerroin = 99;
        mokki = pelaaja.getOmistamatMokit().get(0);
        ostoJaMyynti = luoOstoJaMyynti(true,  kerroin, false, true);
        rahatEnnen = pelaaja.getRahat();
        ostoJaMyynti.myyMokki(0);
        assertEquals(rahatEnnen + mokki.getArvo() * 2, pelaaja.getRahat());
    }
    
    @Test
    public void myyLiikeAntaaNormaalinHinnanJosEiTarjous1() {
        asetaPelaajalleMokitJaLiikkeet();
        liike = pelaaja.getOmistamatLiikkeet().get(0);
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        rahatEnnen = pelaaja.getRahat();
        ostoJaMyynti.myyLiike(0);
        assertEquals(rahatEnnen + liike.getArvo(), pelaaja.getRahat());
    }
    
    @Test
    public void myyLiikeAntaaNormaalinHinnanJosEiTarjous2() {
        kerroin = 0.5;
        asetaPelaajalleMokitJaLiikkeet();
        liike = pelaaja.getOmistamatLiikkeet().get(0);
        ostoJaMyynti = luoOstoJaMyynti(true, kerroin, false, false);
        rahatEnnen = pelaaja.getRahat();
        ostoJaMyynti.myyLiike(0);
        assertEquals(rahatEnnen + liike.getArvo() * kerroin, pelaaja.getRahat(), 0.1);
    }
    
    @Test
    public void myyLiikeAntaaKaksinkertaisenHinnanJosTarjous() {
        asetaPelaajalleMokitJaLiikkeet();
        kerroin = 99;
        liike = pelaaja.getOmistamatLiikkeet().get(0);
        ostoJaMyynti = luoOstoJaMyynti(true,  kerroin, false, true);
        rahatEnnen = pelaaja.getRahat();
        ostoJaMyynti.myyLiike(0);
        assertEquals(rahatEnnen + liike.getArvo() * 2, pelaaja.getRahat());
    }
    
    @Test
    public void luoOikeanKokoisenMokinNimitaulukon1() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        assertEquals(0, ostoJaMyynti.getPelaajanMokit().length);
    }
    
    @Test
    public void luoOikeanKokoisenMokinNimitaulukon2() {
        asetaPelaajalleMokitJaLiikkeet();
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        assertEquals(pelaaja.getOmistamatMokit().size(), ostoJaMyynti.getPelaajanMokit().length);
    }
    
    @Test
    public void mokkiTaulukonEnsimmainenAlkioOnOikea() {
        asetaPelaajalleMokitJaLiikkeet();
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        assertEquals(pelaaja.getOmistamatMokit().get(0).toString(), ostoJaMyynti.getPelaajanMokit()[0]);
    }
    
    @Test
    public void luoOikeanKokoisenLiikeTaulukon1() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        assertEquals(0, ostoJaMyynti.getPelaajanLiikkeet().length);
    }
    
    @Test
    public void luoOikeanKokoisenLiikeTaulukon2() {
        asetaPelaajalleMokitJaLiikkeet();
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        assertEquals(pelaaja.getOmistamatLiikkeet().size(), ostoJaMyynti.getPelaajanLiikkeet().length);
    }
    
    @Test
    public void liikeTaulukonEnsimmainenAlkioOnOikea() {
        asetaPelaajalleMokitJaLiikkeet();
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        assertEquals(pelaaja.getOmistamatLiikkeet().get(0).toString(), ostoJaMyynti.getPelaajanLiikkeet()[0]);
    }
    
    @Test
    public void vieMokinPinonPohjalle() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        mokki = ostoJaMyynti.getPaallimmainenMokki();
        ostoJaMyynti.vieMokkiPinonPohjalle();
        assertEquals(mokki, peli.getLauta().getMokit().getLast());
    }
    
    @Test
    public void eiVieMokkiaPohjalleJosPinoOnTyhja() {
        ostoJaMyynti = luoOstoJaMyyntiEiLiikkeitaJaMokkeja(true, 1, false, false);
        ostoJaMyynti.vieMokkiPinonPohjalle();
        assertEquals(0, peli.getLauta().getLiikkeet().size());
    }
    
    @Test
    public void otettuMokkiEiLoydyEnaaPinonPaalta() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        mokki = ostoJaMyynti.getPaallimmainenMokki();
        ostoJaMyynti.vieMokkiPinonPohjalle();
        assertEquals(false, peli.getLauta().getMokit().peekFirst().equals(mokki));
    }
    
    @Test
    public void vieLiikePinonPohjalle() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        liike = ostoJaMyynti.getPaallimmainenLiike();
        ostoJaMyynti.vieLiikePinonPohjalle();
        assertEquals(liike, peli.getLauta().getLiikkeet().getLast());
    }
    
    @Test
    public void eiVieLiikettaPohjalleJosPinoOnTyhja() {
        ostoJaMyynti = luoOstoJaMyyntiEiLiikkeitaJaMokkeja(true, 1, false, false);
        ostoJaMyynti.vieLiikePinonPohjalle();
        assertEquals(0, peli.getLauta().getLiikkeet().size());
    }
    
    @Test
    public void otettuLiikeEiLoydyEnaaPinonPaalta() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        liike = ostoJaMyynti.getPaallimmainenLiike();
        ostoJaMyynti.vieLiikePinonPohjalle();
        assertEquals(false, peli.getLauta().getLiikkeet().peekFirst().equals(liike));
    }
    
    @Test
    public void riittaaRahatMokkiinPalauttaaTrueJosVaraa() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        pelaaja.setRahat(ostoJaMyynti.getPaallimmainenMokki().getArvo());
        assertEquals(true, ostoJaMyynti.riittaakoRahatMokkiin());
    }
    
    @Test
    public void riittaakoRahatMokkiinPalauttaaFalseJosEiVaraa() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        pelaaja.setRahat(ostoJaMyynti.getPaallimmainenMokki().getArvo() - 1);
        assertEquals(false, ostoJaMyynti.riittaakoRahatMokkiin());
    }
    
    public void riittaakoRahatMokkiinPalauttaaFalseJosEiMokkeja() {
        ostoJaMyynti = luoOstoJaMyyntiEiLiikkeitaJaMokkeja(true, 1, false, false);
        assertEquals(false, ostoJaMyynti.riittaakoRahatMokkiin());
    }
    
    @Test
    public void riittaakoRahatLiikkeeseenPalauttaaTrueJosVaraa() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        pelaaja.setRahat(ostoJaMyynti.getPaallimmainenLiike().getArvo());
        assertEquals(true, ostoJaMyynti.riittaakoRahatLiikkeeseen());
    }
    
    @Test
    public void riittaakoRahatLiikkeeseenPalauttaaFalseJosEiVaraa() {
        ostoJaMyynti = luoOstoJaMyynti(true, 1, false, false);
        pelaaja.setRahat(ostoJaMyynti.getPaallimmainenLiike().getArvo() - 1);
        assertEquals(false, ostoJaMyynti.riittaakoRahatLiikkeeseen());
    }
    
    @Test
    public void riittaakoRahatLiikkeeseenPalauttaaFalseJosLiikkeitaEiEnaaOle() {
        ostoJaMyynti = luoOstoJaMyyntiEiLiikkeitaJaMokkeja(true, 1, false, false);
        assertEquals(false, ostoJaMyynti.riittaakoRahatLiikkeeseen());
    }
}
