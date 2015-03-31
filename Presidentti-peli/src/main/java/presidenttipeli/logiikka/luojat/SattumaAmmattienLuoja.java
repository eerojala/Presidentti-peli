package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;

public class SattumaAmmattienLuoja extends Luoja {

    private ArrayList<Ammatti> ammatit;

    public SattumaAmmattienLuoja() {
        ammatit = new ArrayList();
    }

    @Override
    public void luo() {
        classloader = getClass().getClassLoader();
        tiedosto = new File(classloader.getResource("SattumaAmmatit.txt").getFile());
        try {
            lukija = new Scanner(tiedosto, "UTF-8");
            luoAmmatit(lukija);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
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
                ammatit.add(new Ammatti(nimi, palkka, false, true, true));
            }
        }
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
