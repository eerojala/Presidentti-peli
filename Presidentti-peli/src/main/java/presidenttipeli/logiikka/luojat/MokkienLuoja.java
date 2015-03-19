
package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import presidenttipeli.domain.Mokki;


public class MokkienLuoja extends Luoja{
    private ArrayDeque<Mokki> mokit;

    public MokkienLuoja() {
        mokit = new ArrayDeque();
        luo();
    }

    @Override
    public void luo() {
        for (int i = 0; i < 15; i++) {
            mokit.add(new Mokki("Mökki", 10000));
        }
    }

    public ArrayDeque<Mokki> getMokit() {
        return mokit;
    }
    
}
