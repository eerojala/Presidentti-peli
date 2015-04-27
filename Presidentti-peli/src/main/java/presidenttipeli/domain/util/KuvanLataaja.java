
package presidenttipeli.domain.util;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class KuvanLataaja {
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
