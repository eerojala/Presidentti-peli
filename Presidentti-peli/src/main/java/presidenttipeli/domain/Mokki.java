
package presidenttipeli.domain;

public class Mokki implements Comparable<Mokki> {
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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        
        Mokki verrattava = (Mokki) obj;
        
        if (!this.nimi.equals(verrattava.getNimi())) {
            return false;
        }
        // Samannimisiä mökkejä ei ole.
        
        return true;
    }

    @Override
    public int compareTo(Mokki o) {
        return o.getArvo() - this.arvo;
    }
    
    
}
