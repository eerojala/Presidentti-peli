package presidenttipeli.domain;

/**
 * Luokka pitää muistissa ammatin nimen ja palkan sekä tiedon onko ammatti
 * johtaja-ammatti tai sattuma-ammatti ja salliiko se kansan edustajuuden.
 */
public class Ammatti implements Comparable<Ammatti> {

    private String nimi;
    private int palkka;
    private boolean johtaja;
    private boolean sattumaAmmmatti;
    private boolean salliiKansanedustajuuden;

    public Ammatti(String nimi, int palkka, boolean johtaja, boolean sattumaAmmmatti, boolean salliiKansanedustajuuden) {
        this.nimi = nimi;
        this.palkka = palkka;
        this.johtaja = johtaja;
        this.sattumaAmmmatti = sattumaAmmmatti;
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

    public boolean isSattumaAmmmatti() {
        return sattumaAmmmatti;
    }

    public boolean salliiKansanedustajuuden() {
        return salliiKansanedustajuuden;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setPalkka(int palkka) {
        this.palkka = palkka;
    }

    /**
     * Metodi joka tarkastaa ovatko kaksi oliota samoja.
     *
     * @param obj Toinen olio
     *
     * @return Ovatko verrattavat oliot samoja (Molemmat ammatteja, samat nimet)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

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

    /**
     * Metodi joka vertaa kahta Ammatti-oliota toisiinsa
     *
     * @param o toinen ammatti
     *
     * @return Numero joka määrää ammattien keskenäisen järjestyksen
     */
    @Override
    public int compareTo(Ammatti o) {
        return o.getPalkka() - this.palkka;
    }

}
