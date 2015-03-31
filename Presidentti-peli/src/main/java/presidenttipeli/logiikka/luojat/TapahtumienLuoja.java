
package presidenttipeli.logiikka.luojat;

import java.util.ArrayList;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.tapahtumat.*;

public class TapahtumienLuoja extends Luoja{
    private Pelilauta lauta;

    public TapahtumienLuoja(Pelilauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public void luo() {
        // luo ei tee mitään
    }
    
    public Tapahtuma luoAsetaAmmattiTapahtuma(Ammatti ammatti) {
        return new AsetaAmmatti(lauta, ammatti);
    }
    
    public Tapahtuma luoOtaAmmattikorttiTapahtuma(boolean johtaja) {
        return new OtaAmmattikortti(lauta, johtaja);
    }
    
    public Tapahtuma luoJasenkirjaanVaikuttavaTapahtuma(boolean pelaajalleJasenkirja) {
        return new JasenkirjaanVaikuttavaTapahtuma(pelaajalleJasenkirja);
    }
    
    public Tapahtuma luoRahaanVaikuttavaTapahtuma(boolean pelaajalleRahaa, int rahasumma) {
        return new RahaanVaikuttavaTapahtuma(pelaajalleRahaa, rahasumma);
    }
    
    public Tapahtuma luoPalkastaRiippuvaTapahtuma(ArrayList<Tapahtuma> tapahtumat, ArrayList<Integer> palkkarajat) {
        return new PalkastaRiippuvaTapahtuma(tapahtumat, palkkarajat);
    }
    
    public Tapahtuma luoTapahtumaJokaRiippuuJasenkirjasta(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        return new JasenkirjastaRiippuvaTapahtuma(tapahtuma1, tapahtuma2);
    }
    
    public Tapahtuma luoOtaTapahtumakorttiTapahtuma() {
        return new OtaTapahtumakortti(lauta);
    }
    
    public Tapahtuma luoTietystaAmmatistaRiippuvaTapahtuma(Ammatti ammatti, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        return new TietystaAmmatistaRiippuvaTapahtuma(ammatti, tapahtuma1, tapahtuma2);
    }
    
    public Tapahtuma luoTapahtumaJokaEiTeeMitaan() {
        return new TapahtumaJokaEiTeeMitaan();
    }
    
    public Tapahtuma luoTutkintoonVaikuttavaTapahtuma(boolean pelaajalleTutkinto, boolean yleissivistava) {
        return new TutkintoonVaikuttavaTapahtuma(pelaajalleTutkinto, yleissivistava);
    }
    
    public Tapahtuma luoOtaLiikekorttiTapahtuma() {
        return new OtaLiikekortti(lauta);
    }
    
    public Tapahtuma luoMokinPoistoTapahtuma(boolean vakuutusKorvaa) {
        return new MenetaMokki(lauta, vakuutusKorvaa);
    }
    
    public Tapahtuma luoJohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        return new JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(tapahtuma1, tapahtuma2);
    }
    
    public Tapahtuma luoSiirraNappulaaTapahtuma(int minne) {
        return new SiirraNappulaa(minne, lauta);
    }
    
    public Tapahtuma luoVerotarkastusTapahtuma() {
        return new Verotarkastus();
    }
    
    public Tapahtuma luoLiikkeenPoistoTapahtuma(boolean vakuutusKorvaa) {
        return new MenetaLiike(lauta, vakuutusKorvaa);
    }
    
    public Tapahtuma luoOdotaXKierrostaTapahtuma(int montakoKierrosta) {
        return new OdotaXKierrosta(montakoKierrosta);
    }
    
    public Tapahtuma luoMaksaKulujaLiikkeistaJaMokeista(int maksettavaHinta) {
        return new MaksaKulujaLiikkeistaJaMokeista(maksettavaHinta);
    }
    
    public Tapahtuma luoSijainnistaRiippuvaTapahtuma(Tapahtuma tapahtuma1, Tapahtuma tapahtuma2, int ruudunNro) {
        return new SijainnistaRiippuvaTapahtuma(tapahtuma1, tapahtuma2, ruudunNro);
    }
    
    public Tapahtuma luoNostaLikkeidenTuottoTapahtuma() {
        return new NostaLiikkeidenTuotto();
    }
}
