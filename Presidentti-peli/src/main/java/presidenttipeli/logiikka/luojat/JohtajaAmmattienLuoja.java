
package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;


public class JohtajaAmmattienLuoja extends Luoja{
    private ArrayList<Ammatti> johtajaAmmatit;

    public JohtajaAmmattienLuoja() {
        johtajaAmmatit = new ArrayList();
    }
    
    @Override
    public void luo() {
        asetaScannerilleTiedosto("tekstit/JohtajaAmmatit.txt", 
                JohtajaAmmattienLuoja.class.getClassLoader());
        luoAmmatit(lukija);  
    }
    
    private void luoAmmatit(Scanner lukija) {
        boolean palkkaViimeksi = true;
        String nimi = "";
        int palkka = 0;
        
        while (lukija.hasNext()) {
            String rivi = lukija.nextLine();
            if (!rivi.isEmpty()) {
                if (palkkaViimeksi) {
                    nimi = rivi;
                    palkkaViimeksi = false;
                } else {
                    palkka = Integer.parseInt(rivi);
                    palkkaViimeksi = true;
                }
            } else {
                johtajaAmmatit.add(new Ammatti(nimi, palkka, true, false, false));
            }
        }
    }
    
    public ArrayList<Ammatti> getSekoitetutAmmatit() {
        Collections.shuffle(johtajaAmmatit);
        return johtajaAmmatit;
    }

    public ArrayList<Ammatti> getJohtajaAmmatit() {
        return johtajaAmmatit;
    }
       
}
