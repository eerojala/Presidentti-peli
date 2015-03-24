
package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import presidenttipeli.domain.Ammatti;


public class JohtajaAmmattienLuoja extends Luoja{
    private ArrayDeque<Ammatti> johtajaAmmatit;

    public JohtajaAmmattienLuoja() {
        johtajaAmmatit = new ArrayDeque();
        luo();
    }
    
    
    @Override
    public void luo() {
        for (int i = 0; i < 10; i++) {
            johtajaAmmatit.add(new Ammatti("Johtaja-Ammatti", 10000, true, false, false));
        }
    }

    public ArrayDeque<Ammatti> getJohtajaAmmatit() {
        return johtajaAmmatit;
    }
       
}
