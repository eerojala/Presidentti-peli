package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;

public class Velkalaskuri {

    private Pelaaja pelaaja;
    private int ottoraha;
    private int maksuraha;
    private int pelaajanVelat;
    private int pelaajanRahat;

    public Velkalaskuri(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        ottoraha = 0;
        maksuraha = 0;
        pelaajanVelat = pelaaja.getVelkaa();
        pelaajanRahat = pelaaja.getRahat();
    }

    public void kasvataOttorahaaSadalla() {
        if (pelaajanVelat + ottoraha + 100 <= 5000) {
            ottoraha += 100;
        }
    }

    public void kasvataOttorahaaTuhannella() {
        if (pelaajanVelat + ottoraha + 1000 <= 5000) {
            ottoraha += 1000;
        }
    }

    public void kasvataMaksurahaaSadalla() {
        if (maksuraha + 100 <= pelaajanRahat && maksuraha + 100 <= pelaajanVelat) {
            maksuraha += 100;
        }
    }

    public void kasvataMaksurahaaTuhannella() {
        if (maksuraha + 1000 <= pelaajanRahat && maksuraha + 1000 <= pelaajanVelat) {
            maksuraha += 1000;
        }
    }

    public void vahennaOttorahaaSadalla() {
        if (ottoraha - 100 >= 0) {
            ottoraha -= 100;
        }
    }

    public void vahennaOttorahaaTuhannella() {
        if (ottoraha - 1000 >= 0) {
            ottoraha -= 1000;
        } else {
            ottoraha = 0;
        }
    }

    public void vahennaMaksurahaaSadalla() {
        if (maksuraha - 100 >= 0) {
            maksuraha -= 100;
        }
    }

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
    
    public void paivitaPelaajanVelka() {
        pelaajanVelat = pelaaja.getVelkaa();
    }
    
    public void paivitaPelaajanRahat() {
        pelaajanRahat= pelaaja.getRahat();
    }

}
