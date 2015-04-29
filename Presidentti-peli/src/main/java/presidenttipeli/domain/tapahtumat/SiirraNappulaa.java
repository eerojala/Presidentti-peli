package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka siirtää nappulan uuteen sijaintiin.
 */
public class SiirraNappulaa implements Tapahtuma {

    private int uusiSijainti;
    private Pelilauta lauta;

    public SiirraNappulaa(int uusiSijainti, Pelilauta lauta) {
        this.uusiSijainti = uusiSijainti;
        this.lauta = lauta;
    }

    /**
     * Metodi siirtää pelaajan nappulan konstruktorin määrittmään sijaintiin
     *
     * @param pelaaja Pelaaja jonka nappulaa siirretään.
     * 
     * @return Aina true.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.getNappula().setSijainti(lauta.getRuudut().get(uusiSijainti - 1)); // luokka olettaa että laudalla on kaikki ruudut asetettuna
        return true;
    }

}
