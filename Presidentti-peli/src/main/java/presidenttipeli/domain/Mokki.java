
package presidenttipeli.domain;

public class Mokki {
    private String nimi;
    private int arvo;
    
    public Mokki(String nimi, int arvo) {
       this.nimi = nimi;
       this.arvo = arvo;
    }

    public int getArvo() {
        return arvo;
    }

    public String getNimi() {
        return nimi;
    }
    
}
