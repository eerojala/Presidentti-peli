package presidenttipeli.logiikka.luojat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Liike;

/**
 * Luojaluokka joka luo pelille liikkeet.
 */
public class LiikkeidenLuoja extends Luoja {

    private ArrayList<Liike> lista;

    public LiikkeidenLuoja() {
        lista = new ArrayList();
    }

    @Override
    public void luo() {
        asetaScannerilleTiedosto("tekstit/Liikkeet.txt",
                LiikkeidenLuoja.class.getClassLoader());
        luoLiikkeet(lukija);
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

    /**
     * Sekoittaa liikelistan ja palauttaa sen ArrayDequena.
     *
     * @return Sekoitetut liikkeet ArrayDeque-muodossa.
     */
    public ArrayDeque<Liike> getSekoitetutLiikkeet() {
        ArrayDeque<Liike> liikkeet = new ArrayDeque();
        Collections.shuffle(lista);
        for (Liike liike : lista) {
            liikkeet.add(liike);
        }
        return liikkeet;
    }

}
