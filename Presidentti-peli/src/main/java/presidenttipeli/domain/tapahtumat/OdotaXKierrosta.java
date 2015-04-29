package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;

/**
 * Tapahtumaluokka joka rajoittaa pelaajan liikkumiskykyä X vuoron ajaksi
 */
public class OdotaXKierrosta implements Tapahtuma {

    private int montakoKierrosta;

    public OdotaXKierrosta(int montakoKierrosta) {
        this.montakoKierrosta = montakoKierrosta;
    }

    /**
     * Metodi asettaa pelaajan liikkumiskieltoon konstruktorille annetun
     * kokonaislukumuuttujan ilmoittamaksi ajaksi.
     *
     * @param pelaaja Pelaaja jonka liikkumiskykyä rajoitetaan.
     * 
     * @return Aina true.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        pelaaja.setOdottaaVuoroaan(montakoKierrosta);
        return true;
    }

}
