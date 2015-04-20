package presidenttipeli.logiikka;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;

public class Presidentinvaalienhallinta {

    private Pelaaja pelaaja;
    private Vaalienjarjestaja jarjestaja;
    private Pankinjohtaja johtaja;
    private Kiinteistonvalittaja valittaja;
    private int maksettavaHinta = 0;
    private int tarvittavaAanimaara = 0;
    private boolean vaihtoehto1Valittu = false;
    private boolean vaihtoehto2Valittu = false;
    private boolean vaihtoehto3Valittu = false;
    private String[] mokit;
    private String[] liikkeet;

    public Presidentinvaalienhallinta(Pelaaja pelaaja, Vaalienjarjestaja jarjestaja, Pankinjohtaja johtaja, Kiinteistonvalittaja valittaja) {
        this.pelaaja = pelaaja;
        this.jarjestaja = jarjestaja;
        this.johtaja = johtaja;
        this.valittaja = valittaja;
        taytaMokkitaulukko();
        taytaLiiketaulukko();
    }

    public void vaihtoehto1() {
        if (pelaaja.isKansanedustaja()) {
            maksettavaHinta = 40000;
            tarvittavaAanimaara = 100;
        } else {
            maksettavaHinta = 50000;
            tarvittavaAanimaara = 110;
        }
        vaihtoehto1Valittu = true;
        vaihtoehto2Valittu = false;
        vaihtoehto3Valittu = false;
    }

    public void vaihtoehto2() {
        if (pelaaja.isKansanedustaja()) {
            maksettavaHinta = 30000;
            tarvittavaAanimaara = 90;
        } else {
            maksettavaHinta = 40000;
            tarvittavaAanimaara = 100;
        }
        vaihtoehto1Valittu = false;
        vaihtoehto2Valittu = true;
        vaihtoehto3Valittu = false;
    }

    public void vaihtoehto3() {
        if (pelaaja.isKansanedustaja()) {
            maksettavaHinta = 10000;
            tarvittavaAanimaara = 75;
        } else {
            maksettavaHinta = 20000;
            tarvittavaAanimaara = 85;
        }
        vaihtoehto1Valittu = false;
        vaihtoehto2Valittu = false;
        vaihtoehto3Valittu = true;
    }

    public Vaalienjarjestaja getJarjestaja() {
        return jarjestaja;
    }

    public Pankinjohtaja getJohtaja() {
        return johtaja;
    }

    public int getMaksettavaHinta() {
        return maksettavaHinta;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public int getTarvittavaAanimaara() {
        return tarvittavaAanimaara;
    }

    public Kiinteistonvalittaja getValittaja() {
        return valittaja;
    }

    public String[] getMokit() {
        return mokit;
    }

    public String[] getLiikkeet() {
        return liikkeet;
    }

    public boolean pelaajallaLiike() {
        return !pelaaja.getOmistamatLiikkeet().isEmpty();
    }

    public boolean pelaajallaMokki() {
        return !pelaaja.getOmistamatMokit().isEmpty();
    }

    public boolean pelaajallaMokkiTaiLiike() {
        return pelaajallaMokki() || pelaajallaLiike();
    }

    public boolean pelaajallaTutkinto() {
        return pelaaja.getTutkinto() != null;
    }

    public boolean isVaihtoehto1Valittu() {
        return vaihtoehto1Valittu;
    }

    public boolean isVaihtoehto2Valittu() {
        return vaihtoehto2Valittu;
    }

    public boolean isVaihtoehto3Valittu() {
        return vaihtoehto3Valittu;
    }

    public boolean pystyykoPelaajaOsallistumaanVaaleihin() {
        if (pelaajaKykeneeKansanedustajanVaihtoehtoon1()
                || pelaajaKykeneeJohtajanVaihtoehtoon1()) {
            return true;
        }

        if (pelaajaKykeneeKansanedustajanVaihtoehtoon2()
                || pelaajaKykeneeJohtajanVaihtoehtoon2()) {
            return true;
        }

        if (pelaajaKykeneeKansanedustajanVaihtoehtoon3()
                || pelaajaKykeneeJohtajanVaihtoehtoon3()) {
            return true;
        }

        return false;
    }

    public boolean pelaajaKykeneeKansanedustajanVaihtoehtoon3() {
        if (pelaaja.isKansanedustaja() && pelaajallaMokkiTaiLiike()
                && pelaajallaTutkinto() && pelaaja.getRahat() >= 10000) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pelaajaKykeneeJohtajanVaihtoehtoon3() {
        if (pelaaja.getAmmatti().isJohtaja() && pelaajallaMokkiTaiLiike()
                && pelaajallaTutkinto() && pelaaja.getRahat() >= 20000) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pelaajaKykeneeKansanedustajanVaihtoehtoon2() {
        if (pelaaja.isKansanedustaja() && pelaajallaMokkiTaiLiike()
                && pelaaja.getRahat() >= 30000) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pelaajaKykeneeJohtajanVaihtoehtoon2() {
        if (pelaaja.getAmmatti().isJohtaja() && pelaajallaMokkiTaiLiike()
                && pelaaja.getRahat() >= 40000) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pelaajaKykeneeKansanedustajanVaihtoehtoon1() {
        return pelaaja.isKansanedustaja() && pelaaja.getRahat() >= 40000;
    }

    public boolean pelaajaKykeneeJohtajanVaihtoehtoon1() {
        return pelaaja.getAmmatti().isJohtaja() && pelaaja.getRahat() >= 50000;
    } 

    private void taytaMokkitaulukko() {
        mokit = new String[pelaaja.getOmistamatMokit().size() + 1];
        mokit[0] = "none";
        int indeksi = 1;
        for (Mokki mokki : pelaaja.getOmistamatMokit()) {
            mokit[indeksi] = mokki.toString();
            indeksi++;
        }
    }

    private void taytaLiiketaulukko() {
        liikkeet = new String[pelaaja.getOmistamatLiikkeet().size() + 1];
        liikkeet[0] = "none";
        int indeksi = 1;
        for (Liike liike : pelaaja.getOmistamatLiikkeet()) {
            liikkeet[indeksi] = liike.toString();
            indeksi++;
        }
    }

    public void lisaaMokkiTaulukkoon(Mokki mokki) {
        mokit[mokit.length - 1] = mokki.toString();
    }
    
    public void lisaaLiikeTaulukkoon(Liike liike) {
        liikkeet[liikkeet.length - 1] = liike.toString();
    }
    public Mokki getValittuMokki(int i) {
        return pelaaja.getOmistamatMokit().get(i);
    }

    public Liike getValittuLiike(int i) {
        return pelaaja.getOmistamatLiikkeet().get(i);
    }

    public void uhraaLiike(int i) {
        valittaja.otaPelaajaltaLiikePois(pelaaja, pelaaja.getOmistamatLiikkeet().get(i), 0);
    }

    public void uhraaMokki(int i) {
        valittaja.otaPelaajaltaMokkiPois(pelaaja, pelaaja.getOmistamatMokit().get(i), 0);
    }
    
    public void uhraaTutkinto() {
        pelaaja.setTutkinto(null);
    }

}
