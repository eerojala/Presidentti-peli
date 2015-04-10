package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 *  Tapahtumaluokka joka vaikuttaa pelaajan velkaan
 */
public class VelkaanVaikuttavaTapahtuma implements Tapahtuma {

    private boolean velkaKasvaa;
    private double maara;

    public VelkaanVaikuttavaTapahtuma(boolean velkaKasvaa, double maara) {
        this.velkaKasvaa = velkaKasvaa;
        this.maara = maara;
    }

    /**
     *  Metodi joko kasvattaa tai vähentää pelaajan velkaa konstruktorille annetun
     *  kokonaislukumuuttujan verran riippuen konstruktorille annetusta totuusarvosta.
     * @param pelaaja Pelaaja jonka velkaa kasvatetaan tai vähennetään
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        int velka = pelaaja.getVelkaa();
        if (velkaKasvaa) {
            pelaaja.setVelkaa(velka + (int) maara);
        } else {
            pelaaja.setVelkaa(velka - (int) maara);
        }
        return true;
    }

}
