package presidenttipeli.util;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Kuvien lataamiseen tarkoitettu luokka.
 */
public class KuvanLataaja {

    /**
     *  Yrittää lataa kuvan annetusta tiedostopolusta
     * 
     *  @param polku Tiedostopolku josta kuva yritetään ladata.
     *  @return Ladattu kuva tai null jos lataaminen ei onnistunut.
     */
    public static BufferedImage palautaKuva(String polku) {
        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(KuvanLataaja.class.getClass().getResource(polku));
        } catch (Exception e) {
            System.out.println("Kuvan lataaminen epäonnistui");
        }
        return kuva;
    }
}
