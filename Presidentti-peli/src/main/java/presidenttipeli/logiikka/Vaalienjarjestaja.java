
package presidenttipeli.logiikka;

import java.util.ArrayList;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.tapahtumat.Vaalit;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;


public class Vaalienjarjestaja {
    private TapahtumienLuoja luoja;
    private ArrayList<Integer> saadutAanet;

    public Vaalienjarjestaja(Pelilauta lauta) {
        luoja = new TapahtumienLuoja(lauta);
        saadutAanet = new ArrayList();
    }
    
    // Peli ei anna osallistua eduskuntavaaleihin jos pelaaja on jo kansanedustaja
    
    public void jarjestaEduskuntavaalit(int tarvittavaAanimaara, Pelaaja pelaaja) {       
        Vaalit vaalit = luoja.luoVaalit(tarvittavaAanimaara);
        if (vaalit.suoritaTapahtuma(pelaaja) == true) {
            luoja.luoKansanedustajuuteenVaikuttavaTapahtuma(true).suoritaTapahtuma(pelaaja);
        }
        saadutAanet = vaalit.getSaadutAanet();
    }
    
    public boolean jarjestaPresidentinvaalit(int tarvittavaAanimaara, Pelaaja pelaaja) {
        Vaalit vaalit = luoja.luoVaalit(tarvittavaAanimaara);
        boolean onnistuiko = false;
        if (vaalit.suoritaTapahtuma(pelaaja) == true) {
            onnistuiko = true;
        }
        saadutAanet = vaalit.getSaadutAanet();
        return onnistuiko;
    }

    public ArrayList<Integer> getSaadutAanet() {
        return saadutAanet;
    }
    
    
}
