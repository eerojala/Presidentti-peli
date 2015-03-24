
package presidenttipeli.domain;

public class Liike implements Comparable<Liike> {
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

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        Liike verrattava = (Liike) obj;
        
        if (!this.nimi.equals(verrattava.getNimi())) {
            return false;
        }
        // Samannimisiä liikkeitä ei ole
        return true;
    }

    @Override
    public int compareTo(Liike o) {
        if (this.arvo != o.getArvo()) {
            return o.getArvo() - this.arvo;
        } else {
            return o.getTuotto() - this.tuotto;
        } // Ei ole liikkeitä joilla olisi sekä sama arvo että tuotto
    }
    
    
}
