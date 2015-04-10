
package presidenttipeli.domain;

/**
 *  Luokka joka pitää muistissaan onko tutkinto yleissivistävä vai ei.
 */

public class Tutkinto {
    private boolean yleissivistava;

    public Tutkinto(boolean yleissivistava) {
        this.yleissivistava = yleissivistava;
    }

    public boolean isYleissivistava() {
        return yleissivistava;
    }
    
    
}
