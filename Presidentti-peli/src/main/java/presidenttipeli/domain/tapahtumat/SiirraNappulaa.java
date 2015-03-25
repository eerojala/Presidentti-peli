package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;

public class SiirraNappulaa implements Tapahtuma {
    private int uusiSijainti;
    private Pelilauta lauta;

    public SiirraNappulaa(int uusiSijainti, Pelilauta lauta) {
        this.uusiSijainti = uusiSijainti;
        this.lauta = lauta;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.getNappula().setSijainti(lauta.getRuudut().get(uusiSijainti - 1)); // luokka olettaa että laudalla on kaikki ruudut asetettuna
        return true;
    }
    
    
}
