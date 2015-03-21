package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import presidenttipeli.domain.Ruutu;

public class RuutujenLuoja extends Luoja {

    private ArrayList<Ruutu> ruudut;

    public RuutujenLuoja() {
        ruudut = new ArrayList();
    }

    @Override
    public void luo() {
        luoRuudut();
        lisaaSelosteet();
    }
    
    private void luoRuudut() {
       for (int i = 1; i <= 30; i++) {
            ruudut.add(new Ruutu(i));
        } 
    }

    private void lisaaSelosteet() {
        StringBuilder seloste = new StringBuilder("");
        classloader = getClass().getClassLoader();
        tiedosto = new File(classloader.getResource("RuutujenSelostukset.txt").getFile());
        int indeksi = 0;
        
        try {
            lukija = new Scanner(tiedosto, "UTF-8");
            while (lukija.hasNext()) {
                String rivi = lukija.nextLine();
                if (rivi.isEmpty()) {
                    ruudut.get(indeksi).setSeloste(seloste.toString());
                    seloste = new StringBuilder("");
                    indeksi++;
                } else {
                    seloste.append(rivi + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

}
