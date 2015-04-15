
package presidenttipeli.logiikka;

import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;


public class Liikuttelija {
    private Pelilauta lauta;
    private TapahtumienLuoja luoja;

    public Liikuttelija(Pelilauta lauta, TapahtumienLuoja luoja) {
        this.lauta = lauta;
        this.luoja = luoja;
    }
    
    public boolean liikutaNappulaa(Nappula nappula) {
        int nykyinenSijainti = nappula.getSijainti().getNumero();
        Tapahtuma tapahtuma;
        boolean uusiKierros = false;
        
        if (nykyinenSijainti == 30) {
            tapahtuma = luoja.luoSiirraNappulaaTapahtuma(1);
            uusiKierros = true;
        } else {
            tapahtuma = luoja.luoSiirraNappulaaTapahtuma(nykyinenSijainti + 1);
        }
        tapahtuma.suoritaTapahtuma(nappula.getOmistaja());
        return uusiKierros;
    }
}
