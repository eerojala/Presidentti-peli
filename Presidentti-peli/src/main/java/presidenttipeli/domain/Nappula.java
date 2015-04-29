package presidenttipeli.domain;

import java.awt.image.BufferedImage;

/**
 * Luokka pitää muistissaan nappulan kuvaa, omistajaa ja sen sijantia.
 */
public class Nappula {

    private Pelaaja omistaja;
    private Ruutu sijainti; // Nappula asetetaan luontivaiheessa aloitusruudulle
    private BufferedImage kuva;

    public Nappula(Pelaaja omistaja) {
        this.omistaja = omistaja;
    }

    public BufferedImage getKuva() {
        return kuva;
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

    public void setKuva(BufferedImage kuva) {
        this.kuva = kuva;
    }

}
