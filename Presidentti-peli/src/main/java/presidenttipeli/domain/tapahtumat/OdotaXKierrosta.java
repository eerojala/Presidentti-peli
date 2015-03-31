
package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;


public class OdotaXKierrosta implements Tapahtuma{
    private int montakoKierrosta;

    public OdotaXKierrosta(int montakoKierrosta) {
        this.montakoKierrosta = montakoKierrosta;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setOdottaaVuoroaan(montakoKierrosta);
        return true;
    }
    
    
}
