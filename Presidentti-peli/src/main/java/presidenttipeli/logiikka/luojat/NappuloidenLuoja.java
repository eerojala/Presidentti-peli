package presidenttipeli.logiikka.luojat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;

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
        File tiedosto;

        for (int i = 0; i < nappulat.size(); i++) {
            String tiedostonNimi = "Pelaaja";
            tiedostonNimi += (i + 1) + ".png";
            try {
                tiedosto = new File(getClass().getClassLoader().getResource(tiedostonNimi).getFile());
                BufferedImage kuva = ImageIO.read(tiedosto);
                nappulat.get(i).setKuva(kuva);
            } catch (Exception e) {
                System.out.println("Nappuloiden kuvien asettaminen epäonnistui");
            }
        }
    }

    public ArrayList<Nappula> getNappulat() {
        return nappulat;
    }

}
