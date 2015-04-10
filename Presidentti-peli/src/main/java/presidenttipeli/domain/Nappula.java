package presidenttipeli.domain;

/**
 * Luokka pitää muistissaan nappulan omistajaa ja sen sijantia.
 */
public class Nappula {

    private Pelaaja omistaja;
    private Ruutu sijainti; // Nappula asetetaan luontivaiheessa aloitusruudulle

    public Nappula(Pelaaja omistaja) {
        this.omistaja = omistaja;
    }

    public Pelaaja getOmistaja() {
        return omistaja;
    }

    public Ruutu getSijainti() {
        return sijainti;
    }

    public void setSijainti(Ruutu sijainti) {
        this.sijainti = sijainti;
    }
}
