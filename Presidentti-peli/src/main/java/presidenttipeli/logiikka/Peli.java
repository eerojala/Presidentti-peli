package presidenttipeli.logiikka;

import java.util.Collections;
import java.util.Random;
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
            return suoritaErikoisruutu();
        } else {
            if (ruutu.getNumero() == 19 && !onkoPinossaLiikkeita()) {
                peligui.liikkeitaEiOleEnaaJaljella();
                return true;
            }
            naytaKortti(ruutu.getNumero());
            return suoritaRuudunTapahtumat(ruutu);
        }
    }

    private boolean suoritaRuudunTapahtumat(Ruutu ruutu) {
        Ruutu vanha = nykyinenPelaaja.getNappula().getSijainti();
        for (Tapahtuma tapahtuma : ruutu.getTapahtumat()) {
            if (tapahtuma.suoritaTapahtuma(nykyinenPelaaja) == false) {
                return false;
            }
        }

        if (ruutu.getNumero() == 22 || (ruutu.getNumero() == 12 && nykyinenPelaaja.isPuolueenJasen())) {
            peligui.naytaKortinSisalto(nykyinenPelaaja.getAmmatti().toString());
        }
        
        if (nykyinenPelaaja.getNappula().getSijainti().getNumero() == 1) {
            peligui.uusiKierros();
        }
        
        if (!vanha.equals(nykyinenPelaaja.getNappula().getSijainti())) {
            suoritaRuudunTapahtumat();
        }
        return true;
    }

    private boolean suoritaErikoisruutu() {
        Ruutu ruutu = nykyinenPelaaja.getNappula().getSijainti();
        if (ruutu.isOstoJaMyyntiruutu()) {
            return suoritaOstoJaMyyntiruutu(ruutu);
        } else if (ruutu.isVaaliruutu()) {
            return suoritaVaaliruutu(ruutu);
        } else if (ruutu.isPutkaruutu()) {
            suoritaPutkaruutu();
            return true;
        } else {
            return true;
        }
    }

    private boolean suoritaVaaliruutu(Ruutu ruutu) {
        if (ruutu.getNumero() == 10) {
            Eduskuntavaalienhallinta hallinta = new Eduskuntavaalienhallinta(nykyinenPelaaja,
                    vaalienjarjestaja, pankinjohtaja);
            peligui.avaaEduskuntavaalienHallintaGUI(hallinta);
        } else if (ruutu.getNumero() == 25) {
            if (nykyinenPelaaja.getAmmatti().getPalkka() > 4000 && nykyinenPelaaja.isPuolueenJasen()) {
                peligui.avaaRuutu25KyselyGUI();
            }
        } else if (ruutu.getNumero() == 30) {
            Presidentinvaalienhallinta hallinta = new Presidentinvaalienhallinta(nykyinenPelaaja,
                    vaalienjarjestaja, pankinjohtaja, kiinteistonvalittaja);
            if (hallinta.pystyykoPelaajaOsallistumaanVaaleihin() == false) {
                peligui.varallisuusEiRiitaVaaleihin();
            } else {
                peligui.avaaPresidentinvaalienHallintaGUI(hallinta);
            }
        }
        return true;
    }

    private void naytaKortti(int ruudunNro) {
        String sisalto = "";

        if ((ruudunNro == 12 && !nykyinenPelaaja.isPuolueenJasen()) || ruudunNro == 16
                || ruudunNro == 28) {
            sisalto = lauta.getTapahtumakortit().peek().getSeloste();
        } else if (ruudunNro == 7) {
            sisalto = lauta.getSattumaAmmatit().peek().toString();
        } else if (ruudunNro == 19) {
            sisalto = lauta.getLiikkeet().peek().toString();
        } else {
            return;
        }
        peligui.naytaKortinSisalto(sisalto);
    }

    public boolean onkoErikoisruutu(Ruutu ruutu) {
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
            if (nykyisenPelaajanIndeksi == lauta.getNappulat().size()) {
                nykyinenPelaaja = lauta.getNappulat().get(nykyisenPelaajanIndeksi - 1).getOmistaja();
            } else {
                nykyinenPelaaja = lauta.getNappulat().get(nykyisenPelaajanIndeksi).getOmistaja();
            }
        }
    }

    public boolean tiputaPelaajaPelista() {
        lauta.getNappulat().remove(nykyinenPelaaja.getNappula());
        return lauta.getNappulat().isEmpty();
    }

    private boolean suoritaOstoJaMyyntiruutu(Ruutu ruutu) {
        OstoJaMyynti ostoJaMyynti;
        if (ruutu.getNumero() == 1) { 
            ostoJaMyynti = luoUusiOstoJaMyynti(true, 1, false, false);
            peligui.avaaOstoJaMyyntiGUI(ostoJaMyynti);
        } else if (ruutu.getNumero() == 16) {
            return suoritaRuutu16(ruutu);
        } else if (ruutu.getNumero() == 20) {
            ostoJaMyynti = luoUusiOstoJaMyynti(false, 0.1, true, false);
            peligui.avaaOstoJaMyyntiGUI(ostoJaMyynti);
        }
        return true;
    }

    private boolean suoritaRuutu16(Ruutu ruutu) {
        OstoJaMyynti ostoJaMyynti;
        naytaKortti(ruutu.getNumero());
        if (suoritaRuudunTapahtumat(ruutu) == false) {
            return false;
        } else if (nykyinenPelaaja.getNappula().getSijainti().getNumero() == 16) {
            // jos tulee tapahtumakortti joka siirtää pelaajan muualle niin
            // pelaaja ei voi enää ostaa tai myydä omistuskirjojaan
            int silmaluku = heitaNoppaa();
            boolean tarjous = false;
            if (silmaluku == 6) {
                tarjous = true;
            }
            ostoJaMyynti = luoUusiOstoJaMyynti(true, 1, false, tarjous);
            peligui.avaaOstoJaMyyntiGUI(ostoJaMyynti);
        }
        return true;
    }

    private OstoJaMyynti luoUusiOstoJaMyynti(boolean saaMyyda, double kerroin,
            boolean ruutu20, boolean ruutu16Tarjous) {
        OstoJaMyynti ostojamyynti = new OstoJaMyynti(saaMyyda, kerroin, ruutu20,
                nykyinenPelaaja, kiinteistonvalittaja, lauta.getMokit().peek(),
                lauta.getLiikkeet().peek(), lauta, ruutu16Tarjous);
        return ostojamyynti;
    }

    public boolean onkoPinossaLiikkeita() {
        return !lauta.getLiikkeet().isEmpty();
    }

    private void suoritaPutkaruutu() {
        if (nykyinenPelaaja.getRahat() >= 4000) {
            peligui.avaaPutkakyselyGUI();
        } else {
            peligui.pelaajaJoutuuPutkaan();
        }
    }

    public void yritaSuorittaaTapahtumaaToisenKerran() {
        naytaKortti(nykyinenPelaaja.getNappula().getSijainti().getNumero());
        if (suoritaRuudunTapahtumat() == false) {
            peligui.pelaajaTippuuPelista();
            if (tiputaPelaajaPelista() == true) {
                peligui.kaikkiHavisivat();
            }
        }
    }
}
