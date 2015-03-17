
package presidenttipeli.domain;


public class Ammatti {
    private String nimi;
    private int palkka;
    private boolean johtaja;
    private boolean salliiKansanedustajuuden;

    public Ammatti(String nimi, int palkka, boolean johtaja, boolean salliiKansanedustajuuden) {
        this.nimi = nimi;
        this.palkka = palkka;
        this.johtaja = johtaja;
        this.salliiKansanedustajuuden = salliiKansanedustajuuden;
    }

    public String getNimi() {
        return nimi;
    }

    public int getPalkka() {
        return palkka;
    }

    public boolean isJohtaja() {
        return johtaja;
    }

    public boolean salliiKansanedustajuuden() {
        return salliiKansanedustajuuden;
    }
    
    
}
