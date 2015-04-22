package presidenttipeli.logiikka;

import java.awt.Component;
import java.util.Collections;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.Tapahtumakortti;
import presidenttipeli.domain.tapahtumat.OtaMokkikortti;
import presidenttipeli.domain.tapahtumat.RahaanVaikuttavaTapahtuma;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.gui.PeliGUI;
import presidenttipeli.gui.PresidentinvaalienhallintaGUI;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

public class Peli {

    private Pelilauta lauta;
    private TapahtumienLuoja tapahtumienluoja;
    private Liikuttelija liikuttelija;
    private Pankinjohtaja pankinjohtaja;
    private Kiinteistonvalittaja kiinteistonvalittaja;
    private Vaalienjarjestaja vaalienjarjestaja;
    private Putka putka;
    private Pelaaja nykyinenPelaaja;
    private int viimeisinSilmaluku;
    private int nykyisenPelaajanIndeksi;
    private PeliGUI peligui; // haters will haters

    public Peli(Pelilauta lauta) {
        this.lauta = lauta;
        tapahtumienluoja = new TapahtumienLuoja(lauta);
        liikuttelija = new Liikuttelija(lauta, tapahtumienluoja);
        pankinjohtaja = new Pankinjohtaja(lauta);
        kiinteistonvalittaja = new Kiinteistonvalittaja(lauta, pankinjohtaja);
        vaalienjarjestaja = new Vaalienjarjestaja(lauta);
        putka = new Putka(lauta);
        arvoJarjestys();
        nykyinenPelaaja = lauta.getNappulat().get(0).getOmistaja();
        nykyisenPelaajanIndeksi = 0;
        viimeisinSilmaluku = 0;
    }

    private void arvoJarjestys() {
        Collections.shuffle(lauta.getNappulat());
    }

    public Pelilauta getLauta() {
        return lauta;
    }

    public Pelaaja getNykyinenPelaaja() {
        return nykyinenPelaaja;
    }

    public TapahtumienLuoja getTapahtumienluoja() {
        return tapahtumienluoja;
    }

    public int getViimeisinSilmaluku() {
        return viimeisinSilmaluku;
    }

    public Pankinjohtaja getPankinjohtaja() {
        return pankinjohtaja;
    }

    public Kiinteistonvalittaja getKiinteistonvalittaja() {
        return kiinteistonvalittaja;
    }

    public Putka getPutka() {
        return putka;
    }

    public Liikuttelija getLiikuttelija() {
        return liikuttelija;
    }

    public Vaalienjarjestaja getVaalienjarjestaja() {
        return vaalienjarjestaja;
    }

    public void setNykyinenPelaaja(Pelaaja nykyinenPelaaja) {
        this.nykyinenPelaaja = nykyinenPelaaja;
    }

    public void setPeligui(PeliGUI peligui) {
        this.peligui = peligui;
    }

    public int heitaNoppaa() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public boolean suoritaRuudunTapahtumat() {
        Ruutu ruutu = nykyinenPelaaja.getNappula().getSijainti();
        if (onkoErikoisruutu(ruutu)) {
            tarkistaRuutu();
            return true;
        } else {
            if (onkoTapahtumakorttiRuutu(ruutu)) {
                if (tapahtumakorttiRuutu(ruutu) == false) {
                    return false;
                }
            }
            naytaKortti(ruutu.getNumero());
            return suoritaRuudunTapahtumat(ruutu);   
        }
    }
    
    private boolean suoritaRuudunTapahtumat(Ruutu ruutu) {
        for (Tapahtuma tapahtuma : ruutu.getTapahtumat()) {
                if (tapahtuma.suoritaTapahtuma(nykyinenPelaaja) == false) {
                    return false;
                }
            }
        return true;
    }

    private void tarkistaRuutu() {
        Ruutu ruutu = nykyinenPelaaja.getNappula().getSijainti();
        if (ruutu.isOstoJaMyyntiruutu()) {

        } else if (ruutu.isVaaliruutu()) {
            suoritaVaaliruutu(ruutu);
        } else if (ruutu.isPutkaruutu()) {

        } else {

        }

    }

    private void suoritaVaaliruutu(Ruutu ruutu) {
        if (ruutu.getNumero() == 10) {
            peligui.avaaEduskuntavaalienHallintaGUI(new Eduskuntavaalienhallinta(nykyinenPelaaja,
                    vaalienjarjestaja, pankinjohtaja));
        } else if (ruutu.getNumero() == 25) {
            if (nykyinenPelaaja.getAmmatti().getPalkka() > 4000 && nykyinenPelaaja.isPuolueenJasen()) {
                boolean tulos = vaalienjarjestaja.jarjestaPresidentinvaalit(80, nykyinenPelaaja);
                peligui.ilmoitaTulos(tulos, vaalienjarjestaja.getSaadutAanet(), vaalienjarjestaja.getSaadutAanetSummattuna(), 80);
            }
        } else if (ruutu.getNumero() == 30) {
            Presidentinvaalienhallinta hallinta = new Presidentinvaalienhallinta(nykyinenPelaaja,
                    vaalienjarjestaja, pankinjohtaja, kiinteistonvalittaja);
            if (hallinta.pystyykoPelaajaOsallistumaanVaaleihin() == false) {
                peligui.varallisuusEiRiitaVaaleihin();
            } else {
                SwingUtilities.invokeLater(new PresidentinvaalienhallintaGUI(hallinta, peligui));
            }
        }
    }

    private void naytaKortti(int ruudunNro) {
        String sisalto = "";

        if (ruudunNro == 12 || ruudunNro == 16 || ruudunNro == 28) {
            sisalto = lauta.getTapahtumakortit().peek().getSeloste();
        } else if (ruudunNro == 7) {
            sisalto = lauta.getSattumaAmmatit().peek().toString();
        } else if (ruudunNro == 22) {
            sisalto = lauta.getJohtajaAmmatit().get(0).toString();
        } else if (ruudunNro == 19) {
            sisalto = lauta.getLiikkeet().peek().toString();
        } else {
            return;
        }
        peligui.naytaKortinSisalto(sisalto);
    }

    private boolean onkoErikoisruutu(Ruutu ruutu) {
        return ruutu.isOstoJaMyyntiruutu() || ruutu.isPutkaruutu() || ruutu.isVaaliruutu();
    }

    public void vaihdaVuoroa() {
        Pelaaja edellinenPelaaja = nykyinenPelaaja;
        edellinenPelaaja.setOdottaaVuoroaan(edellinenPelaaja.getOdottaaVuoroaan() - 1);
        if (!lauta.getNappulat().contains(nykyinenPelaaja.getNappula())) {
            vaihdaVuoroaKunEdellinenTippuiPelista();
        } else {
            etsiUusiPelaaja();
        }

    }

    private void etsiUusiPelaaja() {
        for (int i = 0; i < lauta.getNappulat().size(); i++) {
            if (lauta.getNappulat().get(i).getOmistaja() == nykyinenPelaaja) {
                if (i == lauta.getNappulat().size() - 1) {
                    nykyinenPelaaja = lauta.getNappulat().get(0).getOmistaja();
                    nykyisenPelaajanIndeksi = 0;
                } else {
                    nykyinenPelaaja = lauta.getNappulat().get(i + 1).getOmistaja();
                    nykyisenPelaajanIndeksi = i + 1;
                }

                if (nykyinenPelaaja.getOdottaaVuoroaan() > 0) {
                    vaihdaVuoroa();
                }
                break;
            }

        }
    }

    private void vaihdaVuoroaKunEdellinenTippuiPelista() {
        if (nykyisenPelaajanIndeksi == lauta.getNappulat().size() - 1) {
            nykyinenPelaaja = lauta.getNappulat().get(0).getOmistaja();
        } else {
            nykyinenPelaaja = lauta.getNappulat().get(nykyisenPelaajanIndeksi).getOmistaja();
        }
    }

    public boolean tiputaPelaajaPelista() {
        lauta.getNappulat().remove(nykyinenPelaaja.getNappula());
        return lauta.getNappulat().isEmpty();
    }

    private boolean tarkistaPystyykoPelaajaMaksamaanTapahtumakortinMaksua() {
        Tapahtumakortti kortti = lauta.getTapahtumakortit().peek();
        Tapahtuma tapahtuma = kortti.getTapahtumat().get(0);
        if (onkoRahaanVaikuttavaTapahtuma(tapahtuma) == false) {
            return true;
        }

        RahaanVaikuttavaTapahtuma kortinTapahtuma = (RahaanVaikuttavaTapahtuma) tapahtuma;

        if (viekoTapahtumaPelaajaltaRahaa(kortinTapahtuma)) {
            return riittaakoPelaajanRahat(kortinTapahtuma);
        }
        return true;
    }

    private boolean onkoRahaanVaikuttavaTapahtuma(Tapahtuma tapahtuma) {
        RahaanVaikuttavaTapahtuma verrattava = new RahaanVaikuttavaTapahtuma(true, 0);

        if (tapahtuma.getClass() == verrattava.getClass()) {
            return true;
        }
        return false;
    }

    private boolean viekoTapahtumaPelaajaltaRahaa(RahaanVaikuttavaTapahtuma tapahtuma) {
        if (tapahtuma.isPelaajalleRahaa()) {
            return false;
        }
        return true;
    }

    private boolean riittaakoPelaajanRahat(RahaanVaikuttavaTapahtuma tapahtuma) {
        return nykyinenPelaaja.getRahat() >= tapahtuma.getSumma();
    }

    private boolean onkoTapahtumakorttiRuutu(Ruutu ruutu) {
        if (ruutu.getNumero() == 12 || ruutu.getNumero() == 28) {
            return true;
        }
        return false;
    }

    private boolean tapahtumakorttiRuutu(Ruutu ruutu) {
        if (ruutu.getNumero() == 12 && nykyinenPelaaja.isPuolueenJasen()) {
            return true;
        }
        
        if (tarkistaPystyykoPelaajaMaksamaanTapahtumakortinMaksua() == false) {
            naytaKortti(ruutu.getNumero());
            peligui.varallisuusEiRiitaMaksuun();
            return false;
        }
        return true;
    }
}
