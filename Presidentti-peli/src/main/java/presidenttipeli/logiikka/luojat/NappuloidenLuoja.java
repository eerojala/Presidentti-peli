package presidenttipeli.logiikka.luojat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.util.KuvanLataaja;

public class NappuloidenLuoja extends Luoja {

    private ArrayList<Pelaaja> pelaajat;
    private ArrayList<Nappula> nappulat;

    public NappuloidenLuoja(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        nappulat = new ArrayList();
    }

    @Override
    public void luo() {
        for (Pelaaja pelaaja : pelaajat) {
            Nappula nappula = new Nappula(pelaaja);
            pelaaja.setNappula(nappula);
            nappulat.add(nappula);
        }
        asetaNappuloilleKuvat();
    }

    private void asetaNappuloilleKuvat() {
        for (int i = 0; i < nappulat.size(); i++) {
            String tiedostopolku = "/kuvat/Pelaaja";
            tiedostopolku += (i + 1) + ".png";
                nappulat.get(i).setKuva(KuvanLataaja.palautaKuva(tiedostopolku));
        }
    }

    public ArrayList<Nappula> getNappulat() {
        return nappulat;
    }

}
