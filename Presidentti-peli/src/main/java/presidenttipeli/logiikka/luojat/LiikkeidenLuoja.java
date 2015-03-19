
package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import presidenttipeli.domain.Liike;


public class LiikkeidenLuoja extends Luoja{
    private ArrayDeque<Liike> liikkeet;

    public LiikkeidenLuoja() {
        liikkeet = new ArrayDeque<Liike>();
        luo();
    }

    @Override
    public void luo() {
        for (int i = 0; i < 15; i++) {
            liikkeet.add(new Liike("Liike", 20000, 2500));
        }
    }

    public ArrayDeque<Liike> getLiikkeet() {
        return liikkeet;
    }
    
}
