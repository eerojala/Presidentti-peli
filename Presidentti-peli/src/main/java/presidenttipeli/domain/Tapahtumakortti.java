
package presidenttipeli.domain;

import java.util.ArrayList;
import presidenttipeli.domain.tapahtumat.Tapahtuma;


public class Tapahtumakortti implements Comparable<Tapahtumakortti>{
    private ArrayList<Tapahtuma> tapahtumat;
    private String seloste;

    public Tapahtumakortti() {
        tapahtumat = new ArrayList();
        seloste = "placeholder";
    }

    public String getSeloste() {
        return seloste;
    }

    public ArrayList<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }

    public void setSeloste(String seloste) {
        this.seloste = seloste;
    }

    @Override
    public boolean equals(Object obj) {
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

    @Override
    public int compareTo(Tapahtumakortti o) {
        return this.seloste.compareTo(o.getSeloste());
    }
    
    
   
}
