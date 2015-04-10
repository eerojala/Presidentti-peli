package presidenttipeli.domain;

import java.util.ArrayList;
import presidenttipeli.domain.tapahtumat.Tapahtuma;

/**
 * Luokka joka pitää muistissaan tapahtumakortin selostuksen ja sen tapahtumat
 */
public class Tapahtumakortti implements Comparable<Tapahtumakortti>, SelosteenOmaava {

    private ArrayList<Tapahtuma> tapahtumat;
    private String seloste;

    public Tapahtumakortti() {
        tapahtumat = new ArrayList();
        seloste = "placeholder";
    }

    @Override
    public String getSeloste() {
        return seloste;
    }

    public ArrayList<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }

    @Override
    public void setSeloste(String seloste) {
        this.seloste = seloste;
    }

    /**
     * Metodi joka tarkastaa ovatko kaksi oliota samoja
     *
     * @param obj Toinen olio
     *
     * @return Ovatko oliot samoja
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Tapahtumakortti verrattava = (Tapahtumakortti) obj;

        if (!verrattava.getSeloste().equals(this.seloste)) {
            return false;
        }
        // saman selosteisia kortteja voi olla.
        return true;
    }

    /**
     *  Metodi joka vertaa kahta Tapahtumakortti-oliota toisiinsa
     * 
     *  @param o Toinen tapahtumakortti-olio
     * 
     *  @return Numero joka määrää kahden tapahtumakortin keskenäisen järjestyksen
     */
    @Override
    public int compareTo(Tapahtumakortti o) {
        return this.seloste.compareTo(o.getSeloste());
    }

}
