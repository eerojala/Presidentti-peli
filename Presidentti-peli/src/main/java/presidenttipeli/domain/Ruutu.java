package presidenttipeli.domain;

import java.util.ArrayDeque;
import presidenttipeli.domain.tapahtumat.Tapahtuma;

public class Ruutu {

    private int numero;
    private ArrayDeque<Tapahtuma> tapahtumat;
    private String seloste;

    public Ruutu(int numero, ArrayDeque<Tapahtuma> tapahtumat, String seloste) {
        this.numero = numero;
        this.tapahtumat = tapahtumat;
        this.seloste = seloste;
    }

    

    

}
