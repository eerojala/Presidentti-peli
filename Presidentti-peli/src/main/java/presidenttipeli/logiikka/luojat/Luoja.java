package presidenttipeli.logiikka.luojat;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Abstrakti luokka jonka luojaluokat perivät.
 */
public abstract class Luoja {

    protected InputStream inputStream;
    protected Scanner lukija;

    public Luoja() {
    }

    /**
     * Luojaluokka luo oliot joista on vastuussa.
     */
    public abstract void luo();

    /**
     * Asettaa Scanner-oliolle halutun tiedoston.
     *
     * @param tiedostopolku Tiedostopolku josta tiedosto löytyy.
     * @param classloader Luojaluokan classloader.
     */
    protected void asetaScannerilleTiedosto(String tiedostopolku, ClassLoader classloader) {
        inputStream = classloader.getResourceAsStream(tiedostopolku);
        try {
            lukija = new Scanner(inputStream, "UTF-8");
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }
}
