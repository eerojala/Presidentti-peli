package presidenttipeli.domain;

import presidenttipeli.domain.tapahtumat.Tapahtuma;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Pelilauta {

    private List<Ruutu> ruudut;
    private ArrayList<Nappula> nappulat;
    private List<Ammatti> johtajaAmmatit;
    private ArrayDeque<Ammatti> sattumaAmmatit;
    private ArrayDeque<Mokki> mokit;
    private ArrayDeque<Liike> liikkeet;
    private ArrayDeque<Tapahtumakortti> tapahtumakortit;

    public Pelilauta() {
        ruudut = new ArrayList();
        nappulat = new ArrayList();
        johtajaAmmatit = new ArrayList();
        sattumaAmmatit = new ArrayDeque();
        mokit = new ArrayDeque();
        liikkeet = new ArrayDeque();
        tapahtumakortit = new ArrayDeque();
    }

    public List<Ammatti> getJohtajaAmmatit() {
        return johtajaAmmatit;
    }

    public ArrayDeque<Liike> getLiikkeet() {
        return liikkeet;
    }

    public ArrayDeque<Mokki> getMokit() {
        return mokit;
    }

    public ArrayList<Nappula> getNappulat() {
        return nappulat;
    }

    public ArrayDeque<Ammatti> getSattumaAmmatit() {
        return sattumaAmmatit;
    }

    public ArrayDeque<Tapahtumakortti> getTapahtumakortit() {
        return tapahtumakortit;
    }

    public List<Ruutu> getRuudut() {
        return ruudut;
    }

    public void setJohtajaAmmatit(List<Ammatti> johtajaAmmatit) {
        this.johtajaAmmatit = johtajaAmmatit;
    }

    public void setLiikkeet(ArrayDeque<Liike> liikkeet) {
        this.liikkeet = liikkeet;
    }

    public void setMokit(ArrayDeque<Mokki> mokit) {
        this.mokit = mokit;
    }

    public void setNappulat(ArrayList<Nappula> nappulat) {
        this.nappulat = nappulat;
    }

    public void setRuudut(List<Ruutu> ruudut) {
        this.ruudut = ruudut;
    }

    public void setSattumaAmmatit(ArrayDeque<Ammatti> sattumaAmmatit) {
        this.sattumaAmmatit = sattumaAmmatit;
    }

    public void setTapahtumakortit(ArrayDeque<Tapahtumakortti> tapahtumakortit) {
        this.tapahtumakortit = tapahtumakortit;
    }
    
}
