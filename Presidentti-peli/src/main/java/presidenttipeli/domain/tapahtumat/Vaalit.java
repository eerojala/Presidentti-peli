
package presidenttipeli.domain.tapahtumat;

import java.util.ArrayList;
import java.util.Collections;
import presidenttipeli.domain.Pelaaja;


public class Vaalit implements Tapahtuma{
    private int tarvittavaAanimaara;
    private ArrayList<Integer> aanet;
    private ArrayList<Integer> saadutAanet;
    
    
    public Vaalit(int tarvittavaAanimaara) {
        this.tarvittavaAanimaara = tarvittavaAanimaara;
        aanet = new ArrayList();
        saadutAanet = new ArrayList();
        aanet.add(1);
        aanet.add(3);
        aanet.add(5);
        aanet.add(7);
        aanet.add(8);
        aanet.add(9);
        aanet.add(10);
        aanet.add(12);
        aanet.add(15);
        aanet.add(20);
        aanet.add(25);
        aanet.add(30);
        aanet.add(40);
        aanet.add(50);
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        return onnistuikoVaalit(laskeAanet());
    }
    
    private int laskeAanet() {
        Collections.shuffle(aanet);
        int summa = 0;
        for (int i = 0; i < 5; i++) {
            saadutAanet.add(aanet.get(i));
            summa += aanet.get(i);
        }
        return summa;
    }
    
    public boolean onnistuikoVaalit(int aanimaara) {
        return aanimaara >= tarvittavaAanimaara;
    }

    public ArrayList<Integer> getSaadutAanet() {
        return saadutAanet;
    }
    
}
