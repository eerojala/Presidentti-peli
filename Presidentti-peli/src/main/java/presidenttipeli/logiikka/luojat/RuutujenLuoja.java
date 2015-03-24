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
    // VAROITUS: TÄMÄ LUOKKA SISÄLTÄÄ KOVAKOODAUSTA
    private ArrayList<Ruutu> ruudut;
    private Pelilauta lauta;
    private Ammatti tyoton;

    public RuutujenLuoja(Pelilauta lauta) {
        ruudut = new ArrayList();
        this.lauta = lauta;
        tyoton = new Ammatti("Työtön", 1000, false, false, true);
    }

    @Override
    public void luo() {
        luoRuudut();
        Collections.sort(ruudut);
        lisaaSelosteet();
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
        luoPerintoruutu();
        luoRuudutJossaMokkiPalaa();
        luoRuudutJossaUseampiTapahtuma();
        luoPutkaruudut();
        luoNappulaaSiirtavatRuudut();
        luoTapahtumakorttiRuudut();
        luoVerotarkastusRuudut();
    }

    private void lisaaSelosteet() {
        StringBuilder seloste = new StringBuilder("");
        classloader = getClass().getClassLoader();
        tiedosto = new File(classloader.getResource("RuutujenSelostukset.txt").getFile());
        int indeksi = 0;

        try {
            lukija = new Scanner(tiedosto, "UTF-8");
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
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
        }
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

    private void luoOstoJaMyyntiruudut() {
        luoOstoJaMyyntiruutu(1);
        luoOstoJaMyyntiruutu(16);
        luoOstoJaMyyntiruutu(20);
    }

    private void luoOstoJaMyyntiruutu(int numero) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.setOstoJaMyyntiruutu(true);
        ruudut.add(ruutu);
    }

    private void luoYksinkertaisetAmmattiruudut() {
        luoYksinkertainenAmmattiruutu(2, tyoton);
        luoYksinkertainenAmmattiruutu(3, new Ammatti("Opettaja", 5000, false, false, false));
        luoYksinkertainenAmmattiruutu(4, new Ammatti("Autonkuljettaja", 3000, false, false, true));
        luoYksinkertainenAmmattiruutu(5, tyoton);
        luoYksinkertainenAmmattiruutu(6, new Ammatti("Päälikkö", 9000, false, false, false));
        luoYksinkertainenAmmattiruutu(18, tyoton);
    }

    private void luoYksinkertainenAmmattiruutu(int numero, Ammatti ammatti) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new AsetaAmmatti(lauta, ammatti));
        ruudut.add(ruutu);
    }

    private void luoJohtajaJaSattumaAmmattiruudut() {
        luoJohtajaTaiSattumaAmmattiRuutu(7, false);
        luoJohtajaTaiSattumaAmmattiRuutu(22, true);
    }

    private void luoJohtajaTaiSattumaAmmattiRuutu(int numero, boolean johtaja) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new OtaAmmattikortti(lauta, false));
        ruudut.add(ruutu);
    }

    private void luoJasenkirjaanVaikuttavatRuudut() {
        luoJasenkirjaanVaikuttavaRuutu(8, true);
    }

    private void luoJasenkirjaanVaikuttavaRuutu(int numero, boolean pelaajalleJasenkirja) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new JasenkirjaanVaikuttavaTapahtuma(pelaajalleJasenkirja));
        ruudut.add(ruutu);
    }

    private void luoRahaanVaikuttavatRuudut() {
        luoRahaanVaikuttavaRuutu(9, 2000, true);
        luoRahaanVaikuttavaRuutu(15, 5000, false);
        luoRahaanVaikuttavaRuutu(27, 20000, true);
    }

    private void luoRahaanVaikuttavaRuutu(int numero, int rahasumma, boolean pelaajalleRahaa) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new RahaanVaikuttavaTapahtuma(pelaajalleRahaa, rahasumma));
        ruudut.add(ruutu);
    }

    private void luoVaaliruudut() {
        luoVaaliruutu(10);
        luoVaaliruutu(25);
        luoVaaliruutu(30);
    }

    private void luoVaaliruutu(int numero) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.setVaaliruutu(true);
        ruudut.add(ruutu);
    }

    private void luoRuudutJoidenTapahtumaRiippuuPelaajasta() {
        luoRuudutJotkaRiippuvatPalkasta();
        luoRuudutJotkaRiippuvatJasenkirjasta();
        luoRuudutJotkaRiippuvatTietystaAmmatista();
    }

    private void luoRuudutJotkaRiippuvatPalkasta() {
        luoRuutuJokaRiippuuPalkasta(11, luoRuudun11Tapahtumat(), luoRuudun11Palkkarajat());
    }

    private ArrayList<Tapahtuma> luoRuudun11Tapahtumat() {
        ArrayList<Tapahtuma> tapahtumat = new ArrayList();
        tapahtumat.add(new RahaanVaikuttavaTapahtuma(false, 500));
        tapahtumat.add(new RahaanVaikuttavaTapahtuma(false, 1000));
        tapahtumat.add(new RahaanVaikuttavaTapahtuma(false, 1500));
        return tapahtumat;
    }

    private ArrayList<Integer> luoRuudun11Palkkarajat() {
        ArrayList<Integer> palkkarajat = new ArrayList();
        palkkarajat.add(2001);
        palkkarajat.add(4001);
        palkkarajat.add(Integer.MAX_VALUE);
        return palkkarajat;
    }

    private void luoRuutuJokaRiippuuPalkasta(int numero, ArrayList<Tapahtuma> tapahtumat, ArrayList<Integer> palkkarajat) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new PalkastaRiippuvatTapahtumat(tapahtumat, palkkarajat));
        ruudut.add(ruutu);
    }

    private void luoRuudutJotkaRiippuvatJasenkirjasta() {
        luoRuutuJokaRiippuuJasenkirjasta(12, new OtaAmmattikortti(lauta, true), new OtaTapahtumakortti(lauta));
    }

    private void luoRuutuJokaRiippuuJasenkirjasta(int numero, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new JasenkirjastaRiippuvaTapahtuma(tapahtuma1, tapahtuma2));
        ruudut.add(ruutu);
    }

    private void luoRuudutJotkaRiippuvatTietystaAmmatista() {
        Tapahtuma tapahtuma = new TapahtumaJokaEiTeeMitaan();
        luoRuutuJokaRiippuuTietystaAmmatista(13, tyoton, tapahtuma, new RahaanVaikuttavaTapahtuma(false, 500));
        luoRuutuJokaRiippuuTietystaAmmatista(14, tyoton, tapahtuma, new RahaanVaikuttavaTapahtuma(true, 1000));
    }

    private void luoRuutuJokaRiippuuTietystaAmmatista(int numero, Ammatti ammatti, Tapahtuma tapahtuma1, Tapahtuma tapahtuma2) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new TietystaAmmatistaRiippuvaTapahtuma(ammatti, tapahtuma1, tapahtuma2));
        ruudut.add(ruutu);
    }

    private void luoTutkintoonVaikuttavatRuudut() {
        luoTutkintoonVaikuttavaRuutu(17, true);
    }

    private void luoTutkintoonVaikuttavaRuutu(int numero, boolean pelaajalleTutkinto) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new TutkintoonVaikuttavaTapahtuma(pelaajalleTutkinto));
        ruudut.add(ruutu);
    }

    private void luoPerintoruutu() {
        luoPerintoruutu(19);
    }

    private void luoPerintoruutu(int numero) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new OtaLiikekortti(lauta));
        ruudut.add(ruutu);
    }

    private void luoRuudutJossaMokkiPalaa() {
        luoRuutuJossaMokkiPalaa(21);
    }

    private void luoRuutuJossaMokkiPalaa(int numero) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new MokkiPalaa());
        ruudut.add(ruutu);
    }

    private void luoRuudutJossaUseampiTapahtuma() {
        Tapahtuma tapahtuma1 = new SiirraNappulaa(30, lauta);
        Tapahtuma tapahtuma2 = new TapahtumaJokaEiTeeMitaan();
        luoRuutuJossaUseampiTapahtuma(23, new RahaanVaikuttavaTapahtuma(false, 500), new JohtajuudestaTaiKansanedustajuudestaRiippuvaTapahtuma(tapahtuma1, tapahtuma2));
    }

    private void luoRuutuJossaUseampiTapahtuma(int numero, Tapahtuma... tapahtumat) {
        Ruutu ruutu = new Ruutu(numero);
        for (Tapahtuma tapahtuma : tapahtumat) {
            ruutu.getTapahtumat().add(tapahtuma);
        }
        ruudut.add(ruutu);
    }
    
    private void luoPutkaruudut() {
        luoPutkaruutu(24);
    }
    
    private void luoPutkaruutu(int numero) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.setPutkaruutu(true);
        ruudut.add(ruutu);
    }
    
    private void luoNappulaaSiirtavatRuudut() {
        luoNappulaaSiirtavaRuutu(26, 1);
    }
    
    private void luoNappulaaSiirtavaRuutu(int numero, int minne) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new SiirraNappulaa(minne, lauta));
        ruudut.add(ruutu);
    }
    
    private void luoTapahtumakorttiRuudut() {
        luoTapahtumakorttiRuutu(28);
    }
    
    private void luoTapahtumakorttiRuutu(int numero) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new OtaTapahtumakortti(lauta));
        ruudut.add(ruutu);  
    }
    
    private void luoVerotarkastusRuudut() {
        luoVerotarkastusRuutu(29);
    }
    
    private void luoVerotarkastusRuutu(int numero) {
        Ruutu ruutu = new Ruutu(numero);
        ruutu.getTapahtumat().add(new Verotarkastus());
        ruudut.add(ruutu);
    }
    
}
