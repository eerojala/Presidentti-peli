
package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Mokki;


public class MokkienLuoja extends Luoja{
    private ArrayList<Mokki> lista;

    public MokkienLuoja() {
        lista = new ArrayList();
    }

    @Override
    public void luo() {
        classloader = getClass().getClassLoader();
        tiedosto = new File (classloader.getResource("Mokit.txt").getFile());
        try {
            lukija = new Scanner(tiedosto, "UTF-8");
            luoMokit(lukija);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }
    
    private void luoMokit(Scanner lukija) {
        boolean arvoViimeksi = true;
        String nimi = "";
        int arvo = 0;
        
        while(lukija.hasNext()) {
            String rivi = lukija.nextLine();
            if (!rivi.isEmpty()) {
                if (arvoViimeksi) {
                    nimi = rivi;
                    arvoViimeksi = false;
                } else {
                    arvo = Integer.parseInt(rivi);
                    arvoViimeksi = true;
                }
            } else {
                lista.add(new Mokki(nimi, arvo));
            }
        }
    }

    public ArrayList<Mokki> getLista() {
        return lista;
    }
    
    public ArrayDeque<Mokki> getSekoitetutMokit() {
        Collections.shuffle(lista);
        ArrayDeque<Mokki> mokit = new ArrayDeque();
        for (Mokki mokki : lista) {
            mokit.add(mokki);
        }
        return mokit;
    }
    
}
