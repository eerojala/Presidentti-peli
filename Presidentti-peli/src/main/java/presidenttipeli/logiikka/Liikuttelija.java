
package presidenttipeli.logiikka;

import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelilauta;


public class Liikuttelija {
    private Pelilauta lauta;

    public Liikuttelija(Pelilauta lauta) {
        this.lauta = lauta;
    }
    
    public boolean liikutaNappulaa(int silmaluku, Nappula nappula) {
        int nykyinenSijainti = nappula.getSijainti().getNumero();
        int uusiSijainti = nykyinenSijainti;
        boolean uusiKierros = false;
        
        for (int i = 0; i < silmaluku; i++) {
            uusiSijainti++;
            if (uusiSijainti > 30) {
                uusiSijainti = 1;
                uusiKierros = true;
            }
        }
        nappula.setSijainti(lauta.getRuudut().get(uusiSijainti - 1));
        return uusiKierros;
    }
}
