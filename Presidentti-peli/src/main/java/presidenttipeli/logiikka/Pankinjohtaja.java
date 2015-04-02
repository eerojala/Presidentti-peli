
package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;


public class Pankinjohtaja {
    private Pelilauta lauta;
    private TapahtumienLuoja luoja;

    public Pankinjohtaja(Pelilauta lauta) {
        this.lauta = lauta;
        luoja = new TapahtumienLuoja(lauta);
    }
    
    public void annaPelaajalleKuukaudenTuotot(Pelaaja pelaaja) {
        luoja.luoAloitaUusiKierros().suoritaTapahtuma(pelaaja);
    }
    
    public boolean vahennaVelkaa(Pelaaja pelaaja, int maara) {
        if (pelaaja.getRahat() < maara || pelaaja.getVelkaa() < maara) {
            return false;
        } else {
            luoja.luoVelkaanVaikuttavaTapahtuma(false, maara).suoritaTapahtuma(pelaaja);
            luoja.luoRahaanVaikuttavaTapahtuma(false, maara).suoritaTapahtuma(pelaaja);
            return true;
        }
    }
    
    public boolean kasvataVelkaa(Pelaaja pelaaja, int maara) {
        if (pelaaja.getVelkaa() + maara > 5000) {
            return false;
        } else {
            luoja.luoVelkaanVaikuttavaTapahtuma(true, maara).suoritaTapahtuma(pelaaja);
            luoja.luoRahaanVaikuttavaTapahtuma(true, maara).suoritaTapahtuma(pelaaja);
            return true;
        }
    }
    
}
