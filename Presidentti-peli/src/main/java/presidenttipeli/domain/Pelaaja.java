package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.List;

public class Pelaaja implements Comparable<Pelaaja> {

    private String nimi;
    private int rahaa;
    private int velkaa;
    private boolean puolueenJasen;
    private boolean kansanedustaja;
    private boolean tutkinto;
    private boolean liikuntakykyinen;
    private boolean oikeutettuTuottoon;
    private Ammatti ammatti;
    private List<Liike> omistamatLiikkeet;
    private List<Mokki> omistamatMokit;
    private Nappula nappula; // pelaajalle asetetaan nappula olioiden luontivaiheessa.

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        rahaa = 5000;
        velkaa = 0;
        puolueenJasen = false;
        kansanedustaja = false;
        tutkinto = false;
        liikuntakykyinen = true;
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

    public List<Liike> getOmistamatLiikkeet() {
        return omistamatLiikkeet;
    }

    public List<Mokki> getOmistamatMokit() {
        return omistamatMokit;
    }

    public int getRahaa() {
        return rahaa;
    }

    public int getVelkaa() {
        return velkaa;
    }

    public boolean isLiikuntakykyinen() {
        return liikuntakykyinen;
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

    public boolean onTutkinto() {
        return tutkinto;
    }

    public void setAmmatti(Ammatti ammatti) {
        this.ammatti = ammatti;
    }

    public void setKansanedustaja(boolean kansanedustaja) {
        this.kansanedustaja = kansanedustaja;
    }

    public void setLiikuntakykyinen(boolean liikuntakykyinen) {
        this.liikuntakykyinen = liikuntakykyinen;
    }

    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setOikeutettuTuottoon(boolean oikeutettuTuottoon) {
        this.oikeutettuTuottoon = oikeutettuTuottoon;
    }

    public void setPuolueenJasen(boolean puolueenJasen) {
        this.puolueenJasen = puolueenJasen;
    }

    public void setRahaa(int rahaa) {
        this.rahaa = rahaa;
    }

    public void setTutkinto(boolean tutkinto) {
        this.tutkinto = tutkinto;
    }

    public void setVelkaa(int velkaa) {
        this.velkaa = velkaa;
    }

    @Override
    public boolean equals(Object obj) {
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

    @Override
    public int compareTo(Pelaaja o) {
        return o.getRahaa() - this.rahaa;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
 
}
