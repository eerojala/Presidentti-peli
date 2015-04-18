package presidenttipeli.logiikka;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

public class Kiinteistonvalittaja {

    private Pelilauta lauta;
    private TapahtumienLuoja luoja;
    private Pankinjohtaja johtaja;

    public Kiinteistonvalittaja(Pelilauta lauta, Pankinjohtaja johtaja) {
        this.lauta = lauta;
        luoja = new TapahtumienLuoja(lauta);
        this.johtaja = johtaja;
    }

    // Ennen kuin kiinteistönvälittäjää kutsutaan peli kysyy pelaajalta haluaako
    // ostaa korttipinon päälimmäisen mökin/liikkeen ja varmistaa onko pelaajalla
    // siihen varaa
    public void annaPelaajalleMokki(Pelaaja pelaaja, double kerroin) {
        Mokki mokki = lauta.getMokit().poll();
        double arvo = mokki.getArvo() * kerroin;
        johtaja.otaPelaajaltaRahaa(pelaaja, (int) arvo);
        luoja.luoMokkeihinVaikuttavaTapahtuma(mokki, true).suoritaTapahtuma(pelaaja);
    }

    // Ennen kuin kiinteistönvälittäjää kutsutaan peli tarkistaa onko pelaajalla
    // mokkia ja kysyy minkä mökin/liikkeen pelaaja haluaa myydä
    
    public void otaPelaajaltaMokkiPois(Pelaaja pelaaja, Mokki mokki, double kerroin) {
        double arvo = mokki.getArvo() * kerroin;
        johtaja.annaPelaajalleRahaa(pelaaja, (int) arvo);
        luoja.luoMokkeihinVaikuttavaTapahtuma(mokki, false).suoritaTapahtuma(pelaaja);
    }

    public void annaPelaajalleLiike(Pelaaja pelaaja, double kerroin) {
        Liike liike = lauta.getLiikkeet().poll();
        double arvo = liike.getArvo() * kerroin;
        johtaja.otaPelaajaltaRahaa(pelaaja, (int) arvo);
        luoja.luoLiikkeisiinVaikuttavaTapahtuma(liike, true).suoritaTapahtuma(pelaaja);
    }

    public void otaPelaajaltaLiikePois(Pelaaja pelaaja, Liike liike, double kerroin) {
        double arvo = liike.getArvo() * kerroin;
        johtaja.annaPelaajalleRahaa(pelaaja, (int) arvo);
        luoja.luoLiikkeisiinVaikuttavaTapahtuma(liike, false).suoritaTapahtuma(pelaaja);
    }
}
