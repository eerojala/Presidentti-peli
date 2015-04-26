package presidenttipeli.logiikka;

import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

public class OstoJaMyynti {

    private boolean saaMyyda;
    private double kerroin;
    private boolean ruutu20;
    private Pelaaja pelaaja;
    private Kiinteistonvalittaja valittaja;
    private String[] pelaajanMokit;
    private String[] pelaajanLiikkeet;
    private Mokki paallimmainenMokki;
    private Liike paallimmainenLiike;
    private Pelilauta lauta;
    private boolean ruutu16Tarjous;

    public OstoJaMyynti(boolean saaMyyda, double kerroin, boolean ruutu20, Pelaaja pelaaja, Kiinteistonvalittaja valittaja, Mokki paallimmainenMokki, Liike paallimmainenLiike, Pelilauta lauta, boolean ruutu16) {
        this.saaMyyda = saaMyyda;
        this.kerroin = kerroin;
        this.ruutu20 = ruutu20;
        this.pelaaja = pelaaja;
        this.valittaja = valittaja;
        this.pelaajanMokit = pelaajanMokit;
        this.pelaajanLiikkeet = pelaajanLiikkeet;
        this.paallimmainenMokki = paallimmainenMokki;
        this.paallimmainenLiike = paallimmainenLiike;
        this.lauta = lauta;
        this.ruutu16Tarjous = ruutu16;
        taytaMokkiTaulukko();
        taytaLiikeTaulukko();
    }

    public void ostaMokki(Mokki mokki) {
        valittaja.annaPelaajalleMokki(pelaaja, kerroin);
    }

    public void ostaLiike(Liike liike) {
        valittaja.annaPelaajalleLiike(pelaaja, kerroin);
    }

    public void myyMokki(int i) {
        Mokki mokki = pelaaja.getOmistamatMokit().get(i);
        if (ruutu16Tarjous) {
            valittaja.otaPelaajaltaMokkiPois(pelaaja, mokki, 2);
        } else {
            valittaja.otaPelaajaltaMokkiPois(pelaaja, mokki, kerroin);
        }
    }

    public void myyLiike(int i) {
        Liike liike = pelaaja.getOmistamatLiikkeet().get(i);
        if (ruutu16Tarjous) {
            valittaja.otaPelaajaltaLiikePois(pelaaja, liike, 2);
        } else {
            valittaja.otaPelaajaltaLiikePois(pelaaja, liike, kerroin);
        }
    }

    public boolean isRuutu20() {
        return ruutu20;
    }

    public boolean isSaaMyyda() {
        return saaMyyda;
    }

    public boolean isRuutu16Tarjous() {
        return ruutu16Tarjous;
    }

    public String[] getPelaajanLiikkeet() {
        return pelaajanLiikkeet;
    }

    public String[] getPelaajanMokit() {
        return pelaajanMokit;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public Liike getPaallimmainenLiike() {
        return paallimmainenLiike;
    }

    public Mokki getPaallimmainenMokki() {
        return paallimmainenMokki;
    }

    private void taytaMokkiTaulukko() {
        pelaajanMokit = new String[pelaaja.getOmistamatMokit().size()];
        int i = 0;
        for (Mokki mokki : pelaaja.getOmistamatMokit()) {
            pelaajanMokit[i] = mokki.toString();
            i++;
        }
    }

    private void taytaLiikeTaulukko() {
        pelaajanLiikkeet = new String[pelaaja.getOmistamatLiikkeet().size()];
        int i = 0;
        for (Liike liike : pelaaja.getOmistamatLiikkeet()) {
            pelaajanLiikkeet[i] = liike.toString();
            i++;
        }
    }

    public void vieMokkiPinonPohjalle() {
        if (paallimmainenMokki != null) {
            lauta.getMokit().poll();
            lauta.getMokit().add(paallimmainenMokki);
        }
    }

    public void vieLiikePinonPohjalle() {
        if (paallimmainenLiike != null) {
            lauta.getLiikkeet().poll();
            lauta.getLiikkeet().add(paallimmainenLiike);
        }
    }

    public boolean riittaakoRahatMokkiin() {
        if (paallimmainenMokki == null) {
            return false;
        } else if (ruutu20) {
            return pelaaja.getRahat() >= paallimmainenMokki.getArvo() / 10;
        }
        return pelaaja.getRahat() >= paallimmainenMokki.getArvo();
    }

    public boolean riittaakoRahatLiikkeeseen() {
        if (paallimmainenLiike == null) {
            return false;
        }
        return pelaaja.getRahat() >= paallimmainenLiike.getArvo();
    }

}
