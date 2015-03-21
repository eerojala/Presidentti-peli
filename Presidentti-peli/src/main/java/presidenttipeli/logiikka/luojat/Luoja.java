package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.Scanner;

public abstract class Luoja {

    protected File tiedosto;
    protected Scanner lukija;
    protected ClassLoader classloader;

    public Luoja() {
    }

    public abstract void luo();
}
