package presidenttipeli.domain;

/**
 * Luokka pitää muistissa liikkeen tyypin, nimen, arvon sekä tuoton
 */
public class Liike implements Comparable<Liike> {

    private String tyyppi;
    private String nimi;
    private int arvo;
    private int tuotto;

    public Liike(String tyyppi, String nimi, int arvo, int tuotto) {
        this.tyyppi = tyyppi;
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

    public String getTyyppi() {
        return tyyppi;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setTuotto(int tuotto) {
        this.tuotto = tuotto;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    /**
     * Metodi joka tarkastaa ovatko kaksi oliota samoja
     *
     * @param obj Toinen olio
     *
     * @return Ovatko verrattavat oliot samoja (molemmat liikkeitä ja sama nimi)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

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

    /**
     * Metodi joka vertaa kahta Liike-oliota toisiinsa
     *
     * @param o Toinen liike
     *
     * @return Numero joka määrää liikkeiden keskenäisen järjestyksen
     */
    @Override
    public int compareTo(Liike o) {
        if (this.arvo != o.getArvo()) {
            return o.getArvo() - this.arvo;
        } else {
            return o.getTuotto() - this.tuotto;
        } // Ei ole liikkeitä joilla olisi sekä sama arvo että tuotto
    }

    @Override
    public String toString() {
        return tyyppi + " " + nimi + ", Arvo: " + arvo + " mk, Tuotto: " + tuotto +
                " mk/kk";
    }
    
    

}
