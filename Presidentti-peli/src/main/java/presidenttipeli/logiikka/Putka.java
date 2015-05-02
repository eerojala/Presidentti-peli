package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

/**
 * Logiikkaluokka joka asettaa pelaajan odottamaan vuoroaan 2 kierroksen ajaksi.
 */
public class Putka {

    private TapahtumienLuoja luoja;

    public Putka(TapahtumienLuoja luoja) {
        this.luoja = luoja;
    }

    /**
     *  Asettaa pelaajan odottamaan vuoraan 2 kierroksen ajaksi.    
     * 
     *  @param pelaaja Pelaaja joka joutuu odottamaan vuoroaan.
     */
    public void panePelaajaPutkaan(Pelaaja pelaaja) {
        luoja.luoOdotaXKierrostaTapahtuma(2).suoritaTapahtuma(pelaaja);
    }
}
