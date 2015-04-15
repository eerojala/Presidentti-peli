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

    public Peli(Pelilauta lauta) {
        this.lauta = lauta;
        tapahtumienluoja = new TapahtumienLuoja(lauta);
        liikuttelija = new Liikuttelija(lauta, tapahtumienluoja);
        pankinjohtaja = new Pankinjohtaja(lauta);
        kiinteistonvalittaja = new Kiinteistonvalittaja(lauta);
        vaalienjarjestaja = new Vaalienjarjestaja(lauta);
        putka = new Putka(lauta);
        arvoJarjestys();
        nykyinenPelaaja = lauta.getNappulat().get(0).getOmistaja();
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

    public void pelaa() {
        while (true) {

        }
    }

    public int heitaNoppaa() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public boolean suoritaRuudunTapahtumat(Nappula nappula) {
        for (Tapahtuma tapahtuma : nappula.getSijainti().getTapahtumat()) {
            if (tapahtuma.suoritaTapahtuma(nappula.getOmistaja()) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean onkoErikoisruutu(Ruutu ruutu) {
        return ruutu.isOstoJaMyyntiruutu() || ruutu.isPutkaruutu() || ruutu.isVaaliruutu();
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


    public boolean liikutaPelaajaa(int silmaluku) {
        boolean uusiKierros = false;
        for (int i = 0; i < silmaluku; i++) {
            if (liikuttelija.liikutaNappulaa(nykyinenPelaaja.getNappula()) == true) {
                uusiKierros = true;
                
            }
        }
        return uusiKierros;
    }

}
