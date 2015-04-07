
package presidenttipeli.logiikka;

import java.util.Random;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

public class Peli {
    private Pelilauta lauta;
    private TapahtumienLuoja tapahtumienluoja;
    private Tapahtuma uusiKierros;
    private Liikuttelija liikuttelija;
    private Pankinjohtaja pankinjohtaja;
    private Kiinteistonvalittaja kiinteistonvalittaja;
    private Vaalienjarjestaja vaalienjarjestaja;
    private Putka putka;
    
    public Peli(Pelilauta lauta) {
        this.lauta = lauta;
        tapahtumienluoja = new TapahtumienLuoja(lauta);
        liikuttelija = new Liikuttelija(lauta);
        pankinjohtaja = new Pankinjohtaja(lauta);
        kiinteistonvalittaja = new Kiinteistonvalittaja(lauta);
        vaalienjarjestaja = new Vaalienjarjestaja(lauta);
        putka = new Putka(lauta);
    }

    public Pelilauta getLauta() {
        return lauta;
    }
    
    public void pelaa() {
        while (true) {
        
        }
    }
    
    public void eteneKierros() {
        for (Nappula nappula : lauta.getNappulat()) {
            if (liikuttelija.liikutaNappulaa(heitaNoppaa(), nappula) == true) {
                pankinjohtaja.annaPelaajalleKuukaudenTuotot(nappula.getOmistaja());
            }
            
            if (onkoErikoisruutu(nappula.getSijainti())) { // erikoisruudussa tarvitaan käyttäjän syötettä
                // tee myöhemmin
            }
            
            if (suoritaRuudunTapahtumat(nappula) == false) { // jos jokin tapahtumista palauttaa false
                // tee myöhemmin                             // tarkoittaa tämä sitä että pelaajalla ei ollut 
            }                                                // riittävästi rahaa tapahtuman maksun maksamiseen.
        }
    }
    
    private int heitaNoppaa() {
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
    
}
