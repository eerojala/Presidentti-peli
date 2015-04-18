package presidenttipeli.logiikka;

import java.awt.Component;
import java.util.Collections;
import java.util.Random;
import javax.swing.JPanel;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.gui.PeliGUI;
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

        } else {

            naytaKortti(ruutu.getNumero());

            for (Tapahtuma tapahtuma : ruutu.getTapahtumat()) {
                if (tapahtuma.suoritaTapahtuma(nykyinenPelaaja) == false) {
                    return false;
                }
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

}
