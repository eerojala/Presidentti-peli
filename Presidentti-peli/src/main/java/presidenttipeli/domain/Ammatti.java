
package presidenttipeli.domain;


public class Ammatti implements Comparable<Ammatti>{
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

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        Ammatti verrattava = (Ammatti) obj;
        
        if (!this.nimi.equals(verrattava.getNimi())) {
            return false;
        }
        
        // Samannimisiä ammatteja ei voi olla
        return true;
    }

    @Override
    public int compareTo(Ammatti o) {
        return o.getPalkka() - this.palkka;
    }

    

    
    
}
