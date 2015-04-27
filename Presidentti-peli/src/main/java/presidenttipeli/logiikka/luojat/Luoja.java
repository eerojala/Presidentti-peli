package presidenttipeli.logiikka.luojat;

import java.io.InputStream;
import java.util.Scanner;

public abstract class Luoja {

    protected InputStream inputStream;
    protected Scanner lukija;

    public Luoja() {
    }

    public abstract void luo();

    protected void asetaScannerilleTiedosto(String tiedostopolku, ClassLoader classloader) {
        inputStream = classloader.getResourceAsStream(tiedostopolku);
        try {
            lukija = new Scanner(inputStream, "UTF-8");
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }
}
