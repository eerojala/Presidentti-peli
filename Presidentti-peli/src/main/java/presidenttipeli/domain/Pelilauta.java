
package presidenttipeli.domain;

import java.util.ArrayList;
import java.util.List;


public class Pelilauta {
    private List<Ruutu> ruudut;
    private List<Nappula> nappulat;
    private List<Ammatti> ammatit;
    private List<Mokki> mokit;
    private List<Liike> liikkeet;
    private List<Tapahtuma> tapahtumakortit;

    public Pelilauta() {
        ruudut = new ArrayList();
        nappulat = new ArrayList();
        ammatit = new ArrayList();
        mokit = new ArrayList();
        liikkeet = new ArrayList();
        tapahtumakortit = new ArrayList();
    }

    public List<Ammatti> getAmmatit() {
        return ammatit;
    }

    public List<Liike> getLiikkeet() {
        return liikkeet;
    }

    public List<Mokki> getMokit() {
        return mokit;
    }

    public List<Nappula> getNappulat() {
        return nappulat;
    }

    public List<Ruutu> getRuudut() {
        return ruudut;
    }
    
    
    
}
