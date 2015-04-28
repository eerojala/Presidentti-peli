
package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;


public class JohtajaAmmattienLuoja extends AmmatinLuoja{
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

    
    public ArrayList<Ammatti> getSekoitetutAmmatit() {
        Collections.shuffle(johtajaAmmatit);
        return johtajaAmmatit;
    }

    public ArrayList<Ammatti> getJohtajaAmmatit() {
        return johtajaAmmatit;
    }
       
}
