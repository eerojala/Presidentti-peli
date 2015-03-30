package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

public class MokkeihinVaikuttavaTapahtuma implements Tapahtuma {

    private Mokki mokki;
    private boolean pelaajalleMokki;
    private Pelilauta lauta;

    public MokkeihinVaikuttavaTapahtuma(Mokki mokki, boolean pelaajalleMokki, Pelilauta lauta) {
        this.mokki = mokki;
        this.pelaajalleMokki = pelaajalleMokki;
        this.lauta = lauta;
    }
    
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaajalleMokki) {
            pelaaja.getOmistamatMokit().add(mokki);
        } else {
            // Ohjelma syöttää poistotilanteessa tapahtumalle pelaajan omistaman mökin
            lauta.getMokit().add(mokki);
            pelaaja.getOmistamatMokit().remove(mokki);
        }
        return true;
    }

}
