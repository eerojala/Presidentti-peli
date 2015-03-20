package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;

public class MokkeihinVaikuttavaTapahtuma implements Tapahtuma {

    private Mokki mokki;
    private boolean pelaajalleMokki;

    public MokkeihinVaikuttavaTapahtuma(Mokki mokki, boolean pelaajalleMokki) {
        this.mokki = mokki;
        this.pelaajalleMokki = pelaajalleMokki;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaajalleMokki) {
            return pelaaja.getOmistamatMokit().add(mokki);
        } else {
            // Ohjelma syöttää poistotilanteessa tapahtumalle pelaajan omistaman mökin
            return pelaaja.getOmistamatMokit().remove(mokki);
        }
    }

}
