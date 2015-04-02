
package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

public class KiinteistonHoitaja {
    private Pelilauta lauta;
    private TapahtumienLuoja luoja;
    
    public KiinteistonHoitaja(Pelilauta lauta) {
        this.lauta = lauta;
        luoja = new TapahtumienLuoja(lauta);
    }
    
    
}
