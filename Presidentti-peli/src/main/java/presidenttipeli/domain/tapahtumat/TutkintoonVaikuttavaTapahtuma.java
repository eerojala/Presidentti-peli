package presidenttipeli.domain.tapahtumat;

import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Tutkinto;

/**
 * Tapahtumaluokka joka vaikuttaa pelaajan tutkintoon.
 */
public class TutkintoonVaikuttavaTapahtuma implements Tapahtuma {

    private boolean pelaajalleTutkinto;
    private boolean yleissivistava;

    public TutkintoonVaikuttavaTapahtuma(boolean pelaajalleTutkinto, boolean yleissivistava) {
        this.pelaajalleTutkinto = pelaajalleTutkinto;
        this.yleissivistava = yleissivistava;
    }

    /**
     * Metodi antaa pelaajalle tutkinnon tai ottaa sellaisen pois riippuen
     * konstruktorille annetusta totuusarvomuuttuja pelaajalleTutkinto:sta.
     *
     * Konstruktorille annettu totuusarvomuuttuja yleissivistava maaraa onko
     * annettava tutkinto yleissivistävä vai ei.
     *
     * Jos pelaajalla on yleissivistävä tutkinto niin ei-yleissivistä tutkinto
     * ei mene sen päälle.
     *
     * @param pelaaja Pelaaja jolle tapahtuma suoritetaan.
     *
     * @return Aina true.
     */
    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        if (pelaajalleTutkinto) {
            if (yleissivistava) {
                pelaaja.setTutkinto(new Tutkinto(true));
            } else {
                if (pelaaja.getTutkinto() == null) {
                    pelaaja.setTutkinto(new Tutkinto(false));
                } else {
                    if (!pelaaja.getTutkinto().isYleissivistava()) {
                        pelaaja.setTutkinto(new Tutkinto(false));
                    }
                }
            }
        } else {
            pelaaja.setTutkinto(null);
        }
        return true;
    }

}
