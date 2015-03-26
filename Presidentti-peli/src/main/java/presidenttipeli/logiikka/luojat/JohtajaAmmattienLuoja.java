
package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import presidenttipeli.domain.Ammatti;


public class JohtajaAmmattienLuoja extends Luoja{
    private ArrayList<Ammatti> johtajaAmmatit;

    public JohtajaAmmattienLuoja() {
        johtajaAmmatit = new ArrayList();
        luo();
    }
    
    
    @Override
    public void luo() {
        for (int i = 0; i < 10; i++) {
            johtajaAmmatit.add(new Ammatti("Johtaja-Ammatti", 10000, true, false, false));
        }
    }

    public ArrayList<Ammatti> getJohtajaAmmatit() {
        return johtajaAmmatit;
    }
       
}
