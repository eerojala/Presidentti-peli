
package presidenttipeli.domain;

import java.util.ArrayDeque;
import presidenttipeli.domain.tapahtumat.Tapahtuma;


public class TapahtumaKortti {
    private ArrayDeque<Tapahtuma> tapahtumat;
    private String seloste;

    public TapahtumaKortti(ArrayDeque<Tapahtuma> tapahtumat, String seloste) {
        this.tapahtumat = tapahtumat;
        this.seloste = seloste;
    }
    
}
