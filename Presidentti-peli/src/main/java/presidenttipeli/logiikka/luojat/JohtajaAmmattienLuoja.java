package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import java.util.Collections;
import presidenttipeli.domain.Ammatti;

/**
 * Luojaluokka joka luo pelille johtaja-ammatit.
 */
public class JohtajaAmmattienLuoja extends AmmatinLuoja {

    private ArrayList<Ammatti> johtajaAmmatit;

    public JohtajaAmmattienLuoja() {
        johtajaAmmatit = new ArrayList();
    }

    @Override
    public void luo() {
        asetaScannerilleTiedosto("tekstit/JohtajaAmmatit.txt",
                JohtajaAmmattienLuoja.class.getClassLoader());
        luoAmmatit(lukija, true, johtajaAmmatit);
    }

    /**
     * Sekoittaa johtaja-ammattilistan ja palauttaa sen.
     * 
     * @return Sekoitettu lista.
     */
    public ArrayList<Ammatti> getSekoitetutAmmatit() {
        Collections.shuffle(johtajaAmmatit);
        return johtajaAmmatit;
    }

    public ArrayList<Ammatti> getJohtajaAmmatit() {
        return johtajaAmmatit;
    }

}
