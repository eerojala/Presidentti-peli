package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;

/**
 * VelanhallintaGUIn logiikkaluokka, joka toimii välikätenä pelaajan ja muun
 * logiikan välillä.
 */
public class Velanhallinta {

    private Pelaaja pelaaja;
    private int ottoraha;
    private int maksuraha;
    private int pelaajanVelat;
    private int pelaajanRahat;

    public Velanhallinta(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        ottoraha = 0;
        maksuraha = 0;
        pelaajanVelat = pelaaja.getVelkaa();
        pelaajanRahat = pelaaja.getRahat();
    }

    /**
     * Kasvattaa haluttua velkaa sadalla, mikäli pelaajan velat eivät ylitä 5000
     * mk.
     */
    public void kasvataOttorahaaSadalla() {
        if (pelaajanVelat + ottoraha + 100 <= 5000) {
            ottoraha += 100;
        }
    }

    /**
     * Kasvattaa haluttua velkaa tuhannella, mikäli pelaajan velat eivät ylitä
     * 5000 mk.
     */
    public void kasvataOttorahaaTuhannella() {
        if (pelaajanVelat + ottoraha + 1000 <= 5000) {
            ottoraha += 1000;
        }
    }

    /**
     * Kasvattaa haluttua velanvähennystä sadalla, mikäli vähennys ei ylitä
     * pelaajan velkaa tai rahasummaa.
     */
    public void kasvataMaksurahaaSadalla() {
        if (maksuraha + 100 <= pelaajanRahat && maksuraha + 100 <= pelaajanVelat) {
            maksuraha += 100;
        } else {
            maksuraha = Math.min(pelaajanRahat, pelaajanVelat);
        }
    }

    /**
     * Kasvattaa haluttua vehanvähennystä tuhannella, mikäli vähennys ei ylitä
     * pelaajan velkaa tai rahasummaa.
     */
    public void kasvataMaksurahaaTuhannella() {
        if (maksuraha + 1000 <= pelaajanRahat && maksuraha + 1000 <= pelaajanVelat) {
            maksuraha += 1000;
        } else {
            maksuraha = Math.min(pelaajanRahat, pelaajanVelat);
        }
    }

    /**
     * Vähentää haluttua velkaa sadalla, mikäli haluttu summa ei alita 0 mk.
     */
    public void vahennaOttorahaaSadalla() {
        if (ottoraha - 100 >= 0) {
            ottoraha -= 100;
        }
    }

    /**
     * Vähentää haluttua velkaa tuhannella, mikäli haluttu summa ei alita 0 mk.
     * Jos näin käy asettaa halutun velan nollaksi.
     */
    public void vahennaOttorahaaTuhannella() {
        if (ottoraha - 1000 >= 0) {
            ottoraha -= 1000;
        } else {
            ottoraha = 0;
        }
    }

    /**
     * Vähentää haluttua velanvähennystä sadalla, mikälli haluttu summa ei alita
     * 0 mk.
     */
    public void vahennaMaksurahaaSadalla() {
        if (maksuraha - 100 >= 0) {
            maksuraha -= 100;
        }
    }

    /**
     * Vähentää haluttua velanvähennystä tuhannella, mikäli haluttu summa ei
     * alita 0mk. Jos näin käy asettaa velanvähennyksen nollaksi.
     */
    public void vahennaMaksurahaaTuhannella() {
        if (maksuraha - 1000 >= 0) {
            maksuraha -= 1000;
        } else {
            maksuraha = 0;
        }
    }

    public int getMaksuraha() {
        return maksuraha;
    }

    public int getOttoraha() {
        return ottoraha;
    }

    public int getPelaajanRahat() {
        return pelaajanRahat;
    }

    public int getPelaajanVelat() {
        return pelaajanVelat;
    }

    /**
     * Päivittää pelaajan velat ajan tasalle.
     */
    public void paivitaPelaajanVelka() {
        pelaajanVelat = pelaaja.getVelkaa();
    }

    /**
     * Päivittää pelaajan rahat ajan tasalle.
     */
    public void paivitaPelaajanRahat() {
        pelaajanRahat = pelaaja.getRahat();
    }

}
