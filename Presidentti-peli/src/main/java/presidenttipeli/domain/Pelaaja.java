package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.List;

public class Pelaaja {

    private String nimi;
    private int rahaa;
    private int velkaa;
    private boolean puolueenJasen;
    private boolean kansanedustaja;
    private boolean tutkinto;
    private Ammatti ammatti;
    private List<Liike> omistamatLiikkeet;
    private List<Mokki> omistamatMokit;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        rahaa = 5000;
        velkaa = 0;
        puolueenJasen = false;
        kansanedustaja = false;
        tutkinto = false;
        omistamatLiikkeet = new ArrayList();
        omistamatMokit = new ArrayList();
    }

    public Ammatti getAmmatti() {
        return ammatti;
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

    public boolean isPuolueenJasen() {
        return puolueenJasen;
    }

    public boolean isKansanedustaja() {
        return kansanedustaja;
    }

    public boolean isTutkinto() {
        return tutkinto;
    }

    public void setAmmatti(Ammatti ammatti) {
        this.ammatti = ammatti;
    }

    public void setKansanedustaja(boolean kansanedustaja) {
        this.kansanedustaja = kansanedustaja;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
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

}
