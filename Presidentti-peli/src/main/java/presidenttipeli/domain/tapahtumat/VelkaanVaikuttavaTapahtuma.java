package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

public class VelkaanVaikuttavaTapahtuma implements Tapahtuma {

    private boolean velkaKasvaa;
    private double maara;

    public VelkaanVaikuttavaTapahtuma(boolean velkaKasvaa, double maara) {
        this.velkaKasvaa = velkaKasvaa;
        this.maara = maara;
    }

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
