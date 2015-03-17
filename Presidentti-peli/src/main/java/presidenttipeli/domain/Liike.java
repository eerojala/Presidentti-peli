
package presidenttipeli.domain;

public class Liike {
    private String nimi;
    private int arvo;
    private int tuotto;
    
    public Liike(String nimi, int arvo, int tuotto) {
        this.nimi = nimi;
        this.arvo = arvo;
        this.tuotto = tuotto;
    }

    public int getArvo() {
        return arvo;
    }

    public String getNimi() {
        return nimi;
    }
    
    public int getTuotto() {
        return tuotto;
    }
    
    
}
