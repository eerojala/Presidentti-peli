package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;

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
