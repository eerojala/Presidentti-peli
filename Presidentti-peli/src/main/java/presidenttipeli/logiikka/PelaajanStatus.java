package presidenttipeli.logiikka;

import java.awt.image.BufferedImage;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Pelaaja;

public class PelaajanStatus {

    private Pelaaja pelaaja;
    private BufferedImage kuva;
    private boolean onkoJasen = false;
    private boolean onkoKansanedustaja = false;
    private boolean oikeutettuTuottoon = false;
    private boolean liikkumiskykyinen = false;
    private boolean omistaaTutkinnon = false;
    private String yleissivistava = "";
    private String[] liiketaulukko;
    private String[] mokkitaulukko;

    public PelaajanStatus(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        try {
            this.kuva = pelaaja.getNappula().getKuva();
        } catch (Exception e) {

        }
        asetaTotuusarvot();
        lisaaLiikkeetJaMokitTaulukkoon();
    }

    private void asetaTotuusarvot() {
        if (pelaaja.isPuolueenJasen()) {
            onkoJasen = true;
        }

        if (pelaaja.isKansanedustaja()) {
            onkoKansanedustaja = true;
        }

        if (pelaaja.isOikeutettuTuottoon()) {
            oikeutettuTuottoon = true;;
        }

        if (pelaaja.getOdottaaVuoroaan() <= 0) {
            liikkumiskykyinen = true;
        }

        if (pelaaja.getTutkinto() != null) {
            if (pelaaja.getTutkinto().isYleissivistava()) {
                yleissivistava = " (Yleissivistävä)";
            }
            omistaaTutkinnon = true;
        }
    }

    private void lisaaLiikkeetJaMokitTaulukkoon() {
        liiketaulukko = new String[pelaaja.getOmistamatLiikkeet().size()];
        mokkitaulukko = new String[pelaaja.getOmistamatMokit().size()];

        for (int i = 0; i < pelaaja.getOmistamatLiikkeet().size(); i++) {
            liiketaulukko[i] = pelaaja.getOmistamatLiikkeet().get(i).toString();
        }

        for (int i = 0; i < pelaaja.getOmistamatMokit().size(); i++) {
            mokkitaulukko[i] = pelaaja.getOmistamatMokit().get(i).toString();
        }
    }

    public BufferedImage getKuva() {
        return kuva;
    }

    public String[] getLiiketaulukko() {
        return liiketaulukko;
    }

    public String[] getMokkitaulukko() {
        return mokkitaulukko;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public String getYleissivistava() {
        return yleissivistava;
    }

    public boolean isLiikkumiskykyinen() {
        return liikkumiskykyinen;
    }

    public boolean isOikeutettuTuottoon() {
        return oikeutettuTuottoon;
    }

    public boolean isOmistaaTutkinnon() {
        return omistaaTutkinnon;
    }

    public boolean isOnkoJasen() {
        return onkoJasen;
    }

    public boolean isOnkoKansanedustaja() {
        return onkoKansanedustaja;
    }

}
