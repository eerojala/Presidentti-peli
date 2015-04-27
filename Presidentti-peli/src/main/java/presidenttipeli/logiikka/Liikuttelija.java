package presidenttipeli.logiikka;

import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

/**
 * Logiikkaluoka joka liikuttaa pelaajien nappuloita ympäri lautaa.
 */
public class Liikuttelija {

    private Pelilauta lauta;
    private TapahtumienLuoja luoja;

    public Liikuttelija(Pelilauta lauta, TapahtumienLuoja luoja) {
        this.lauta = lauta;
        this.luoja = luoja;
    }

    /**
     * Liikuttaa nappulaa annetun luvun verran askelia eteenpäin laudalla.
     *
     * @param nappula Nappula jota liikutetaan.
     * @param silmaluku Kuinka monta askelta nappulaa liikutetaan
     *
     * @return Siirtyikö nappula seuraavalle kierrokselle.
     */
    public boolean liikutaNappulaa(Nappula nappula, int silmaluku) {
        int nykyinenSijainti = nappula.getSijainti().getNumero();
        boolean uusiKierros = false;
        for (int i = 0; i < silmaluku; i++) {
            nykyinenSijainti++;
            if (nykyinenSijainti > 30) {
                uusiKierros = true;
                nykyinenSijainti = 1;
            }
        }
        luoja.luoSiirraNappulaaTapahtuma(nykyinenSijainti).suoritaTapahtuma(nappula.getOmistaja());
        return uusiKierros;
    }
}
