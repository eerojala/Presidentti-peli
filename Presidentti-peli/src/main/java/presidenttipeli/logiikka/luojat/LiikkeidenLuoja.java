package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Liike;

public class LiikkeidenLuoja extends Luoja {

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
        int laskuri = 1;
        Liike liike = new Liike("Temp", "Temp", 0, 0);

        while (lukija.hasNext()) {
            String rivi = lukija.nextLine();
            if (!rivi.isEmpty()) {
                if (laskuri == 1) {
                    liike.setTyyppi(rivi);
                    laskuri++;
                } else if (laskuri == 2) {
                    liike.setNimi(rivi);
                    laskuri++;
                } else if (laskuri == 3) {
                    liike.setArvo(Integer.parseInt(rivi));
                    laskuri++;
                } else {
                    liike.setTuotto(Integer.parseInt(rivi));
                    laskuri = 1;
                }
            } else {
                lista.add(liike);
                liike = new Liike("Temp", "Temp", 0, 0);
            }
        }
    }

    public ArrayList<Liike> getLista() {
        return lista;
    }
    
    public ArrayDeque<Liike> getLiikkeet() {
        ArrayDeque<Liike> liikkeet = new ArrayDeque();
        Collections.sort(lista);
        for (Liike liike : lista) {
            liikkeet.add(liike);
        }
        return liikkeet;
    }

}
