package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;

/**
 * Tapahtumaluokka joka asettaa pelaajalle uuden ammattin
 */
public class AsetaAmmatti implements Tapahtuma {

    private Pelilauta lauta;
    private Ammatti ammatti;

    public AsetaAmmatti(Pelilauta lauta, Ammatti ammatti) {
        this.lauta = lauta;
        this.ammatti = ammatti;
    }

    /**
     * Metodi asettaa pelaajalle konstruktorin määrittämän ammatin ja vie hänen 
     * edellisen ammattinsavtakaisin pelilaudalle mikäli se oli johtaja- tai 
     * sattuma-ammatti.
     * Pelaajalta otetaan pois kansanedustajuus jos uusi ammatti ei salli sitä
     * ja tutkintokin lähtee pois jos kyseessä ei ole yleissivistävä tutkinto.
     *
     * @param pelaaja Pelaaja jolle uusi ammatti asetetaan
     * @return Aina true
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Tapahtuma tapahtuma1 = new VieAmmattikorttiTakaisinPinoon(lauta, pelaaja.getAmmatti());
        tapahtuma1.suoritaTapahtuma(pelaaja);
        pelaaja.setAmmatti(ammatti);
        otaPoisKansanedustajuus(pelaaja);
        otaPoisTutkinto(pelaaja);
        return true;
    }

    private void otaPoisKansanedustajuus(Pelaaja pelaaja) {
        if (pelaaja.isKansanedustaja() && ammatti.salliiKansanedustajuuden() == false) {
            Tapahtuma tapahtuma = new KansanedustajuuteenVaikuttavaTapahtuma(false);
            tapahtuma.suoritaTapahtuma(pelaaja);
        }
    }

    private void otaPoisTutkinto(Pelaaja pelaaja) {
        if (pelaaja.getTutkinto() == null) {
            return;
        }

        if (!pelaaja.getTutkinto().isYleissivistava() && !ammatti.getNimi().equals("Työtön")) {
            Tapahtuma tapahtuma = new TutkintoonVaikuttavaTapahtuma(false, false);
            tapahtuma.suoritaTapahtuma(pelaaja);
        }
    }

}
