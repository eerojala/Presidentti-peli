package presidenttipeli.domain;

/**
 * Luokka pitää muistissa Mökin nimen ja arvon
 */
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

    /**
     * Metodi joka tarkistaa ovatko kaksi oliota samoja
     *
     * @param obj toinen olio
     *
     * @return Ovatko oliot samoja (Molemmat mokkejä ja sama nimi)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
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

    /**
     * Metodi joka vertaa kahta mokki-oliota toisiinsa
     *
     * @param o Toinen mokki-olio
     *
     * @return Numero joka määrää mökkien keskenäisen järjestyksen
     */
    @Override
    public int compareTo(Mokki o) {
        return o.getArvo() - this.arvo;
    }

    @Override
    public String toString() {
        return nimi + ", Arvo: " + arvo + " mk";
    }

}
