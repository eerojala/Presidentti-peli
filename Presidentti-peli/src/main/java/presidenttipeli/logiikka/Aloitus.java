
package presidenttipeli.logiikka;

import java.util.ArrayList;


public class Aloitus {
    public boolean pituustarkastus(ArrayList<String> nimet) {
        for (String nimi : nimet) {
            if (nimi.isEmpty() || nimi.length() > 24) {
                return false;
            }
        }
        return true;
    }
    
    public boolean samuustarkastus(ArrayList<String> nimet) {
        boolean samaLoydettyKerran;
        for (String nimi1 : nimet) {
            samaLoydettyKerran = false;
            for (String nimi2: nimet) {
                if (nimi1.equals(nimi2) && samaLoydettyKerran) {
                    return false;
                } else if (nimi1.equals(nimi2)) {
                    samaLoydettyKerran = true;
                }
            }
        }
        return true;
    }
}
