
package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;


public class Putka {
    private TapahtumienLuoja luoja;

    public Putka(Pelilauta lauta) {
        luoja = new TapahtumienLuoja(lauta);
    }
    
    public void panePelaajaPutkaan(Pelaaja pelaaja) {
        luoja.luoOdotaXKierrostaTapahtuma(2).suoritaTapahtuma(pelaaja);
    }
}
