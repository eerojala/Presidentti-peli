package presidenttipeli.logiikka;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

/**
 * Logiikkaluokka joka huolehtii mökkien ja liikkeiden hankkimisesta ja
 * myymisestä.
 */
public class Kiinteistonvalittaja {

    private Pelilauta lauta;
    private TapahtumienLuoja luoja;
    private Pankinjohtaja johtaja;

    public Kiinteistonvalittaja(Pelilauta lauta, Pankinjohtaja johtaja) {
        this.lauta = lauta;
        luoja = new TapahtumienLuoja(lauta);
        this.johtaja = johtaja;
    }

    /**
     * Antaa pelaajalle mökin laudalta ja veloittaa mökin arvon verran rahaa
     * pelaajalta
     *
     * @param pelaaja Pelaaja jolle mökki annetaan.
     * @param kerroin Kerroin joka vaikuttaa pelaajalta otettavaan rahaan.
     */
    public void annaPelaajalleMokki(Pelaaja pelaaja, double kerroin) {
        Mokki mokki = lauta.getMokit().poll();
        double arvo = mokki.getArvo() * kerroin;
        johtaja.otaPelaajaltaRahaa(pelaaja, (int) arvo);
        luoja.luoMokkeihinVaikuttavaTapahtuma(mokki, true).suoritaTapahtuma(pelaaja);
    }

    /**
     * Ottaa pelaajalta mökin, vie sen takaisin laudalle ja antaa mökin arvon
     * verran rahaa pelaajalle.
     *
     * @param pelaaja Pelaaja jolta mökki otetaan pois.
     * @param mokki Mökki joka otetaan pois.
     * @param kerroin Kerroin joka vaikuttaa pelaajalle annettavaan rahaan.
     */
    public void otaPelaajaltaMokkiPois(Pelaaja pelaaja, Mokki mokki, double kerroin) {
        double arvo = mokki.getArvo() * kerroin;
        johtaja.annaPelaajalleRahaa(pelaaja, (int) arvo);
        luoja.luoMokkeihinVaikuttavaTapahtuma(mokki, false).suoritaTapahtuma(pelaaja);
    }

    /**
     * Antaa pelaajalle liikkeen laudalta ja veloittaa liikkeen arvon verran
     * rahaa pelaajalta.
     *
     * @param pelaaja Pelaaja jolle liike annetaan
     * @param kerroin Kerroin joka vaikuttaa pelaajalta otettavaan rahaan.
     */
    public void annaPelaajalleLiike(Pelaaja pelaaja, double kerroin) {
        Liike liike = lauta.getLiikkeet().poll();
        double arvo = liike.getArvo() * kerroin;
        johtaja.otaPelaajaltaRahaa(pelaaja, (int) arvo);
        luoja.luoLiikkeisiinVaikuttavaTapahtuma(liike, true).suoritaTapahtuma(pelaaja);
    }

    /**
     * Ottaa pelaajalta liikkeen pois, vie sen takaisin laudalle ja antaa
     * pelaajalle liikkeen arvon verran rahaa.
     *
     * @param pelaaja Pelaaja jolta liike otetaan pois
     * @param liike Liike joka otetaan pois
     * @param kerroin Kerroin joka vaikuttaa pelaajalle annettavaan rahaan.
     */
    public void otaPelaajaltaLiikePois(Pelaaja pelaaja, Liike liike, double kerroin) {
        double arvo = liike.getArvo() * kerroin;
        johtaja.annaPelaajalleRahaa(pelaaja, (int) arvo);
        luoja.luoLiikkeisiinVaikuttavaTapahtuma(liike, false).suoritaTapahtuma(pelaaja);
    }
}
