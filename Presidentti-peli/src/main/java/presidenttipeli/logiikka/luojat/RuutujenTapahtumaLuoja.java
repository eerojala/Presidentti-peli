
package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import java.util.HashMap;
import presidenttipeli.domain.tapahtumat.Tapahtuma;


public class RuutujenTapahtumaLuoja extends Luoja{
    private HashMap<Integer, ArrayList<Tapahtuma>> ruutujenTapahtumat;

    public RuutujenTapahtumaLuoja() {
        ruutujenTapahtumat = new HashMap();
    }

    @Override
    public void luo() {
        classloader = getClass().getClassLoader();
    }
    
    
}
