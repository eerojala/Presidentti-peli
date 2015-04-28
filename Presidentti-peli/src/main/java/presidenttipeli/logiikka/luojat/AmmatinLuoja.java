package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;

public abstract class AmmatinLuoja extends Luoja {

    protected void luoAmmatit(Scanner lukija, boolean johtaja, ArrayList<Ammatti> ammatit) {
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
                luoAmmatti(ammatit, nimi, palkka, johtaja);
            }
        }
    }

    private void luoAmmatti(ArrayList<Ammatti> ammatit, String nimi, int palkka, boolean johtaja) {
        if (johtaja) {
            ammatit.add(new Ammatti(nimi, palkka, true, false, false));
        } else {
            ammatit.add(new Ammatti(nimi, palkka, false, true, true));
        }
    }
}
