package presidenttipeli.peli;

import presidenttipeli.logiikka.luojat.RuutujenLuoja;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RuutujenLuoja luoja = new RuutujenLuoja();
        luoja.luo();
        System.out.println(luoja.getRuudut().get(29).getSeloste());
    }
}
