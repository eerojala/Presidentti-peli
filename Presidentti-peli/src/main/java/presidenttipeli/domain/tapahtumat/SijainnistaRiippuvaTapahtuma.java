
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class SijainnistaRiippuvaTapahtuma implements Tapahtuma{
    private Tapahtuma tapahtuma1;
    private Tapahtuma tapahtuma2;
    private int ruudunNro;

    public SijainnistaRiippuvaTapahtuma(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2, int ruudunNro) {
        this.tapahtuma1 = tapahtuma1;
        this.tapahtuma2 = tapahtuma2;
        this.ruudunNro = ruudunNro;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaaja.getNappula().getSijainti().getNumero() == ruudunNro) {
            return tapahtuma1.suoritaTapahtuma(pelaaja);
        } else {
            return tapahtuma2.suoritaTapahtuma(pelaaja);
        }
    }
    
    
}
