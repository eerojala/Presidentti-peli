package presidenttipeli.domain;

public class Nappula {

    private Pelaaja omistaja;
    private Ruutu sijainti;

    public Nappula(Pelaaja omistaja, Ruutu sijainti) {
        this.omistaja = omistaja;
        this.sijainti = sijainti;
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
