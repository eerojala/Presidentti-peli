package presidenttipeli.domain;

import java.util.ArrayDeque;
import presidenttipeli.domain.tapahtumat.Tapahtuma;

public class Ruutu {

    private int numero;
    private ArrayDeque<Tapahtuma> tapahtumat;
    private String seloste;

    public Ruutu(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getSeloste() {
        return seloste;
    }

    public ArrayDeque<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }
    
    public void setSeloste(String seloste) {
        this.seloste = seloste;
    }

    public void setTapahtumat(ArrayDeque<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
    }
    
}
