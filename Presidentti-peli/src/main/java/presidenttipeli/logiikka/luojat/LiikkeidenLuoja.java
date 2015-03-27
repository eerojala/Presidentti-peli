
package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import presidenttipeli.domain.Liike;


public class LiikkeidenLuoja extends Luoja{
    private ArrayList<Liike> lista;

    public LiikkeidenLuoja() {
        lista = new ArrayList();
    }

    @Override
    public void luo() {
        classloader = getClass().getClassLoader();
        tiedosto = new File(classloader.getResource("Liikkeet.txt").getFile());
        try {
            lukija = new Scanner(tiedosto);
            luoLiikkeet(lukija);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }
    
    private void luoLiikkeet(Scanner lukija) {
    
    }

    public ArrayList<Liike> getLista() {
        return lista;
    }
    
}
