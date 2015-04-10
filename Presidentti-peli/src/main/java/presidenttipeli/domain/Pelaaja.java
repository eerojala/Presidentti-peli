package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka pitää muistissaan pelaajan nimestä, rahasta yms pelaajaan liittyvästä
 * tiedosta
 *
 */
public class Pelaaja implements Comparable<Pelaaja> {

    private String nimi;
    private int rahat;
    private int velkaa;
    private int odottaaVuoroaan; // monta kierrosta pelaaja joutuu odottamaan seuraavaa vuoroaan
    private boolean puolueenJasen;
    private boolean kansanedustaja;
    private boolean oikeutettuTuottoon;
    private Ammatti ammatti;
    private List<Liike> omistamatLiikkeet;
    private List<Mokki> omistamatMokit;
    private Nappula nappula; // pelaajalle asetetaan nappula olioiden luontivaiheessa.
    private Tutkinto tutkinto;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        rahat = 5000;
        velkaa = 0;
        odottaaVuoroaan = 0;
        ammatti = new Ammatti("Työtön", 1000, false, false, true);
        puolueenJasen = false;
        kansanedustaja = false;
        oikeutettuTuottoon = true;
        omistamatLiikkeet = new ArrayList();
        omistamatMokit = new ArrayList();
    }

    public Ammatti getAmmatti() {
        return ammatti;
    }

    public Nappula getNappula() {
        return nappula;
    }

    public String getNimi() {
        return nimi;
    }

    public int getOdottaaVuoroaan() {
        return odottaaVuoroaan;
    }

    public List<Liike> getOmistamatLiikkeet() {
        return omistamatLiikkeet;
    }

    public List<Mokki> getOmistamatMokit() {
        return omistamatMokit;
    }

    public int getRahat() {
        return rahat;
    }

    public Tutkinto getTutkinto() {
        return tutkinto;
    }

    public int getVelkaa() {
        return velkaa;
    }

    public boolean isOikeutettuTuottoon() {
        return oikeutettuTuottoon;
    }

    public boolean isPuolueenJasen() {
        return puolueenJasen;
    }

    public boolean isKansanedustaja() {
        return kansanedustaja;
    }

    public void setAmmatti(Ammatti ammatti) {
        this.ammatti = ammatti;
    }

    public void setKansanedustaja(boolean kansanedustaja) {
        this.kansanedustaja = kansanedustaja;
    }

    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setOdottaaVuoroaan(int odottaaVuoroaan) {
        this.odottaaVuoroaan = odottaaVuoroaan;
    }

    public void setOikeutettuTuottoon(boolean oikeutettuTuottoon) {
        this.oikeutettuTuottoon = oikeutettuTuottoon;
    }

    public void setOmistamatMokit(List<Mokki> omistamatMokit) {
        this.omistamatMokit = omistamatMokit;
    }

    public void setOmistamatLiikkeet(List<Liike> omistamatLiikkeet) {
        this.omistamatLiikkeet = omistamatLiikkeet;
    }

    public void setPuolueenJasen(boolean puolueenJasen) {
        this.puolueenJasen = puolueenJasen;
    }

    public void setRahat(int rahat) {
        this.rahat = rahat;
    }

    public void setTutkinto(Tutkinto tutkinto) {
        this.tutkinto = tutkinto;
    }

    public void setVelkaa(int velkaa) {
        this.velkaa = velkaa;
    }

    /**
     * Metodi joka tarkistaa ovatko kaksi oliota samat
     *
     * @param obj Verrattava olio
     *
     * @return Ovatko oliot samoja (Molemmat pelaajia ja sama nimi)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Pelaaja verrattava = (Pelaaja) obj;

        if (!this.nimi.equals(verrattava.getNimi())) {
            return false;
        }

        // myöhemmin toteutettavat logiikkaosuudet huolehtivat siitä että kahta samannimistä pelaajaa ei ole
        return true;
    }

    /**
     *  Metodi joka vetaa kahta Pelaaja-oliota keskenään
     * 
     *  @param o Toinen pelaaja
     * 
     *  @return Numero joka määrää pelaajien keskenäisen järjestyksen
     */
    @Override
    public int compareTo(Pelaaja o) {
        return o.getRahat() - this.rahat;
    }

    @Override
    public String toString() {
        return this.nimi;
    }

}
