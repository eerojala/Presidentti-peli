package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import presidenttipeli.domain.Ammatti;

/**
 * Luojaluokka joka luo sattuma-ammatit pelille.
 */
public class SattumaAmmattienLuoja extends AmmatinLuoja {

    private ArrayList<Ammatti> ammatit;

    public SattumaAmmattienLuoja() {
        ammatit = new ArrayList();
    }

    @Override
    public void luo() {
        asetaScannerilleTiedosto("tekstit/SattumaAmmatit.txt",
                SattumaAmmattienLuoja.class.getClassLoader());
        luoAmmatit(lukija, false, ammatit);
    }

    public ArrayList<Ammatti> getAmmatit() {
        return ammatit;
    }

    /**
     * Sekoittaa ammattilistan ja palauttaa sen ArrayDequena.
     *
     * @return Sekoitetut ammatit ArrayDequena.
     */
    public ArrayDeque<Ammatti> getSekoitetutAmmatit() {
        return luoPino();
    }

    private ArrayDeque<Ammatti> luoPino() {
        ArrayDeque<Ammatti> palautettava = new ArrayDeque();
        Collections.shuffle(ammatit);
        for (Ammatti ammatti : ammatit) {
            palautettava.add(ammatti);
        }
        return palautettava;
    }

}
