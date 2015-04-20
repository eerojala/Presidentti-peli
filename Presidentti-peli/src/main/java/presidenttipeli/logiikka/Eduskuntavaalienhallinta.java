package presidenttipeli.logiikka;

import presidenttipeli.domain.Pelaaja;

public class Eduskuntavaalienhallinta {

    private Pelaaja pelaaja;
    private Vaalienjarjestaja jarjestaja;
    private Pankinjohtaja pankinjohtaja;
    private int maksettavaRaha = 0;
    private int tarvittavaAanimaara = 110;

    public Eduskuntavaalienhallinta(Pelaaja pelaaja, Vaalienjarjestaja jarjestaja, Pankinjohtaja pankinjohtaja) {
        this.pelaaja = pelaaja;
        this.jarjestaja = jarjestaja;
        this.pankinjohtaja = pankinjohtaja;
    }

    public void maksa0Vaaleista() {
        maksettavaRaha = 0;
        tarvittavaAanimaara = 110;
    }

    public void maksa10000Vaaleista() {
        maksettavaRaha = 10000;
        tarvittavaAanimaara = 100;
    }

    public void maksa20000Vaaleista() {
        maksettavaRaha = 20000;
        tarvittavaAanimaara = 90;
    }

    public void maksa30000Vaaleista() {
        maksettavaRaha = 30000;
        tarvittavaAanimaara = 80;
    }

    public void maksa40000Vaaleista() {
        maksettavaRaha = 40000;
        tarvittavaAanimaara = 70;
    }

    public void maksa50000Vaaleista() {
        maksettavaRaha = 50000;
        tarvittavaAanimaara = 60;
    }

    public boolean riittaakoRahaaSuorittaaVaalit() {
        if (pankinjohtaja.otaPelaajaltaRahaa(pelaaja, maksettavaRaha) == false) {
            return false;
        } else {
            return true;
        }
    }

    public boolean suoritaVaalit() {
        jarjestaja.jarjestaEduskuntavaalit(tarvittavaAanimaara, pelaaja);
        return pelaaja.isKansanedustaja();
    }

    public int getTarvittavaAanimaara() {
        return tarvittavaAanimaara;
    }

    public Vaalienjarjestaja getJarjestaja() {
        return jarjestaja;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public int getMaksettavaRaha() {
        return maksettavaRaha;
    }

}
