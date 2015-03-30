package presidenttipeli.logiikka.luojat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.tapahtumat.*;

public class RuutujenLuoja extends Luoja {

    private ArrayList<Ruutu> ruudut;
    private Pelilauta lauta;
    private Ammatti tyoton;
    private TapahtumienLuoja tapahtumienluoja;

    public RuutujenLuoja(Pelilauta lauta) {
        ruudut = new ArrayList();
        this.lauta = lauta;
        tyoton = new Ammatti("Työtön", 1000, false, false, true);
        tapahtumienluoja = new TapahtumienLuoja(lauta);
    }

    @Override
    public void luo() {
        luoRuudut();
        Collections.sort(ruudut);
        lueTiedosto();
    }

    private void luoRuudut() {
        luoOstoJaMyyntiruudut();
        luoYksinkertaisetAmmattiruudut();
        luoJohtajaJaSattumaAmmattiruudut();
        luoJasenkirjaanVaikuttavatRuudut();
        luoRahaanVaikuttavatRuudut();
        luoVaaliruudut();
        luoRuudutJoidenTapahtumaRiippuuPelaajasta();
        luoTutkintoonVaikuttavatRuudut();
        luoPerintoRuudut();
        luoRuudutJossaMokkiPalaa();
        luoRuudutJossaUseampiTapahtuma();
        luoPutkaruudut();
        luoNappulaaSiirtavatRuudut();
        luoTapahtumakorttiRuudut();
        luoVerotarkastusRuudut();
    }

    private void lueTiedosto() {
        classloader = getClass().getClassLoader();
        tiedosto = new File(classloader.getResource("RuutujenSelostukset.txt").getFile());

        try {
            lukija = new Scanner(tiedosto, "UTF-8");
            lisaaSelosteet(lukija);           
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }
    
    public void lisaaSelosteet(Scanner lukija) {
        StringBuilder seloste = new StringBuilder("");
        int indeksi = 0;
        while (lukija.hasNext()) {
                String rivi = lukija.nextLine();
                if (rivi.isEmpty()) {
                    ruudut.get(indeksi).setSeloste(seloste.toString());
                    seloste = new StringBuilder("");
                    indeksi++;
                } else {
                    seloste.append(rivi + "\n");
                }
            }
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }
    
    private void luoRuutu(boolean ostoJaMyyntiruutu, boolean vaaliruutu, boolean putkaruutu, int numero, Tapahtuma... tapahtumat) {
        Ruutu ruutu = new Ruutu(numero, ostoJaMyyntiruutu, vaaliruutu, putkaruutu);
        for (Tapahtuma tapahtuma : tapahtumat) {
            ruutu.getTapahtumat().add(tapahtuma);
        }
        ruudut.add(ruutu);
    }

    private void luoOstoJaMyyntiruudut() {
        luoRuutu(true, false, false, 1);
        luoRuutu(true, false, false, 16);
        luoRuutu(true, false, false, 20);
    }

    private void luoYksinkertaisetAmmattiruudut() {
        luoRuutu(false, false, false, 2, tapahtumienluoja.luoAsetaAmmattiTapahtuma(tyoton));
        luoRuutu(false, false, false, 3, tapahtumienluoja.luoAsetaAmmattiTapahtuma(new Ammatti("Opettaja", 5000, false, false, false)));
        luoRuutu(false, false, false, 4, tapahtumienluoja.luoAsetaAmmattiTapahtuma(new Ammatti("Autonkuljettaja", 3000, false, false, true)));
        luoRuutu(false, false, false, 5, tapahtumienluoja.luoAsetaAmmattiTapahtuma(tyoton));
        luoRuutu(false, false, false, 6, tapahtumienluoja.luoAsetaAmmattiTapahtuma(new Ammatti("Päälikkö", 9000, false, false, false)));
        luoRuutu(false, false, false, 18, tapahtumienluoja.luoAsetaAmmattiTapahtuma(tyoton));
    }

    private void luoJohtajaJaSattumaAmmattiruudut() {
        luoRuutu(false, false, false, 7, tapahtumienluoja.luoOtaAmmattikorttiTapahtuma(false));
        luoRuutu(false, false, false, 22, tapahtumienluoja.luoOtaAmmattikorttiTapahtuma(true));
    }
    
    private void luoJasenkirjaanVaikuttavatRuudut() {
        luoRuutu(false, false, false, 8, tapahtumienluoja.luoJasenkirjaanVaikuttavaTapahtuma(true));
    }

    private void luoRahaanVaikuttavatRuudut() {
        luoRuutu(false, false, false, 9, tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(true, 2000));
        luoRuutu(false, false, false, 15, tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(false, 5000));
        luoRuutu(false, false, false, 27, tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(true, 20000));
    }

    private void luoVaaliruudut() {
        luoRuutu(false, true, false, 10);
        luoRuutu(false, true, false, 25);
        luoRuutu(false, true, false, 30);
    }

    private void luoRuudutJoidenTapahtumaRiippuuPelaajasta() {
        luoRuudutJotkaRiippuvatPalkasta();
        luoRuudutJotkaRiippuvatJasenkirjasta();
        luoRuudutJotkaRiippuvatTietystaAmmatista();
    }

    private void luoRuudutJotkaRiippuvatPalkasta() {
        luoRuutu(false, false, false, 11, tapahtumienluoja.luoPalkastaRiippuvaTapahtuma(luoRuudun11Tapahtumat(), luoRuudun11Palkkarajat()));
    }

    private ArrayList<Tapahtuma> luoRuudun11Tapahtumat() {
        ArrayList<Tapahtuma> tapahtumat = new ArrayList();
        tapahtumat.add(tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(false, 500));
        tapahtumat.add(tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(false, 1000));
        tapahtumat.add(tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(false, 1500));
        return tapahtumat;
    }

    private ArrayList<Integer> luoRuudun11Palkkarajat() {
        ArrayList<Integer> palkkarajat = new ArrayList();
        palkkarajat.add(2001);
        palkkarajat.add(4001);
        palkkarajat.add(Integer.MAX_VALUE);
        return palkkarajat;
    }

    private void luoRuudutJotkaRiippuvatJasenkirjasta() {
        luoRuutu(false, false, false, 12, tapahtumienluoja.luoTapahtumaJokaRiippuuJasenkirjasta(tapahtumienluoja.luoOtaAmmattikorttiTapahtuma(true), tapahtumienluoja.luoOtaTapahtumakorttiTapahtuma()));
    }

    private void luoRuudutJotkaRiippuvatTietystaAmmatista() {
        luoRuutu(false, false, false, 13, tapahtumienluoja.luoTietystaAmmatistaRiippuvaTapahtuma(tyoton, tapahtumienluoja.luoTapahtumaJokaEiTeeMitaan(), tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(false, 500)));
        luoRuutu(false, false, false, 14, tapahtumienluoja.luoTietystaAmmatistaRiippuvaTapahtuma(tyoton, tapahtumienluoja.luoTapahtumaJokaEiTeeMitaan(), tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(true, 1000)));
    }

    private void luoTutkintoonVaikuttavatRuudut() {
        luoRuutu(false, false, false, 17, tapahtumienluoja.luoTutkintoonVaikuttavaTapahtuma(true, false));
    }

    private void luoPerintoRuudut() {
        luoRuutu(false, false, false, 19, tapahtumienluoja.luoOtaLiikekorttiTapahtuma());
    }

    private void luoRuudutJossaMokkiPalaa() {
        luoRuutu(false, false, false, 21, tapahtumienluoja.luoMokinPoistoTapahtuma(true));
    }

    private void luoRuudutJossaUseampiTapahtuma() {
        luoRuutu(false, false, false, 23, tapahtumienluoja.luoRahaanVaikuttavaTapahtuma(false, 500), tapahtumienluoja.luoJohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(tapahtumienluoja.luoSiirraNappulaaTapahtuma(30), tapahtumienluoja.luoTapahtumaJokaEiTeeMitaan()));
    }
    
    private void luoPutkaruudut() {
        luoRuutu(false, false, true, 24);
    }
    
    private void luoNappulaaSiirtavatRuudut() {
        luoRuutu(false, false, false, 26, tapahtumienluoja.luoSiirraNappulaaTapahtuma(1));
    }
    
    private void luoTapahtumakorttiRuudut() {
        luoRuutu(false, false, false, 28, tapahtumienluoja.luoOtaTapahtumakorttiTapahtuma());
    }
    
    private void luoVerotarkastusRuudut() {
        luoRuutu(false, false, false, 29, tapahtumienluoja.luoVerotarkastusTapahtuma());
    }
    
}
