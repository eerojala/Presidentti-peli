package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka vaikuttaa pelaajan mökkeihin
 */
public class MokkeihinVaikuttavaTapahtuma implements Tapahtuma {

    private Mokki mokki;
    private boolean pelaajalleMokki;
    private Pelilauta lauta;

    public MokkeihinVaikuttavaTapahtuma(Mokki mokki, boolean pelaajalleMokki, Pelilauta lauta) {
        this.mokki = mokki;
        this.pelaajalleMokki = pelaajalleMokki;
        this.lauta = lauta;
    }

    /**
     * Metodi antaa pelaajalle mökin tai ottaa pelaajalta mökin ja palauttaa sen
     * takaisin laudalle.
     *
     * @param pelaaja Pelaaja joka saa tai menettää mökin.
     * 
     * @return Aina true.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaajalleMokki) {
            pelaaja.getOmistamatMokit().add(mokki);
        } else {
            lauta.getMokit().add(mokki);
            pelaaja.getOmistamatMokit().remove(mokki);
        }
        return true;
    }

}
