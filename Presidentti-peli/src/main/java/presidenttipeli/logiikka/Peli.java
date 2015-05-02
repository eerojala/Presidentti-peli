package presidenttipeli.logiikka;

import java.util.Collections;
import java.util.Random;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.domain.tapahtumat.Tapahtuma;
import presidenttipeli.gui.PeliGUI;
import presidenttipeli.logiikka.luojat.TapahtumienLuoja;

/**
 * Pelin päälogiikkaluokka joka pitää muistissa tämänhetkistä pelaajaa sekä
 * huolehtii ruutujen tapahtumien suorittamisesta.
 */
public class Peli {

    private Pelilauta lauta;
    private TapahtumienLuoja tapahtumienluoja;
    private Liikuttelija liikuttelija;
    private Pankinjohtaja pankinjohtaja;
    private Kiinteistonvalittaja kiinteistonvalittaja;
    private Vaalienjarjestaja vaalienjarjestaja;
    private Putka putka;
    private Pelaaja nykyinenPelaaja;
    private Vuoronvaihtaja vuoronvaihtaja;
    private PeliGUI peligui; // haters will haters

    public Peli(Pelilauta lauta) {
        this.lauta = lauta;
        tapahtumienluoja = new TapahtumienLuoja(lauta);
        liikuttelija = new Liikuttelija(lauta, tapahtumienluoja);
        pankinjohtaja = new Pankinjohtaja(lauta);
        kiinteistonvalittaja = new Kiinteistonvalittaja(lauta, pankinjohtaja);
        vaalienjarjestaja = new Vaalienjarjestaja(lauta);
        putka = new Putka(tapahtumienluoja);
        arvoJarjestys();
        nykyinenPelaaja = lauta.getNappulat().get(0).getOmistaja();
        vuoronvaihtaja = new Vuoronvaihtaja(lauta);
    }

    private void arvoJarjestys() {
        Collections.shuffle(lauta.getNappulat());
    }

    public Pelilauta getLauta() {
        return lauta;
    }

    public Pelaaja getNykyinenPelaaja() {
        return nykyinenPelaaja;
    }

    public TapahtumienLuoja getTapahtumienluoja() {
        return tapahtumienluoja;
    }

    public Pankinjohtaja getPankinjohtaja() {
        return pankinjohtaja;
    }

    public Kiinteistonvalittaja getKiinteistonvalittaja() {
        return kiinteistonvalittaja;
    }

    public Putka getPutka() {
        return putka;
    }

    public Liikuttelija getLiikuttelija() {
        return liikuttelija;
    }

    public Vaalienjarjestaja getVaalienjarjestaja() {
        return vaalienjarjestaja;
    }

    public void setNykyinenPelaaja(Pelaaja nykyinenPelaaja) {
        this.nykyinenPelaaja = nykyinenPelaaja;
    }

    public void setPeligui(PeliGUI peligui) {
        this.peligui = peligui;
    }

    public int heitaNoppaa() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    /**
     * Suorittaa ruutuun liittyvät tapahtumat, tai jos kyseessä on erikoisruutu
     * käskee guita avaamaan niihin liittyvät GUIt.
     *
     * @return True jos ruudun tapahtumien suorittaminen onnistui, muuten false.
     */
    public boolean suoritaRuudunTapahtumat() {
        Ruutu ruutu = nykyinenPelaaja.getNappula().getSijainti();
        if (onkoErikoisruutu(ruutu)) {
            return suoritaErikoisruutu();
        } else {
            if (ruutu.getNumero() == 19 && !onkoPinossaLiikkeita()) {
                peligui.liikkeitaEiOleEnaaJaljella();
                return true;
            }
            naytaKortti(ruutu.getNumero());
            return suoritaRuudunTapahtumat(ruutu);
        }
    }

    private boolean suoritaRuudunTapahtumat(Ruutu ruutu) {
        Ruutu vanha = nykyinenPelaaja.getNappula().getSijainti();
        for (Tapahtuma tapahtuma : ruutu.getTapahtumat()) {
            if (tapahtuma.suoritaTapahtuma(nykyinenPelaaja) == false) {
                return false;
            }
        }
        suoritaRuudunTapahtumat2(ruutu, vanha);
        return true;
    }

    private void suoritaRuudunTapahtumat2(Ruutu ruutu, Ruutu vanha) {
        if (ruutu.getNumero() == 22 || (ruutu.getNumero() == 12 && nykyinenPelaaja.isPuolueenJasen())) {
            peligui.naytaKortinSisalto(nykyinenPelaaja.getAmmatti().toString());
        }

        if (nykyinenPelaaja.getNappula().getSijainti().getNumero() == 1) {
            pankinjohtaja.annaPelaajalleKuukaudenTuotot(nykyinenPelaaja);
            peligui.uusiKierros();
        }

        if (!vanha.equals(nykyinenPelaaja.getNappula().getSijainti())) {
            suoritaRuudunTapahtumat();
        }
    }

    private boolean suoritaErikoisruutu() {
        Ruutu ruutu = nykyinenPelaaja.getNappula().getSijainti();
        if (ruutu.isOstoJaMyyntiruutu()) {
            return suoritaOstoJaMyyntiruutu(ruutu);
        } else if (ruutu.isVaaliruutu()) {
            suoritaVaaliruutu(ruutu);
        } else if (ruutu.isPutkaruutu()) {
            suoritaPutkaruutu();
        }
        return true;
    }

    private void suoritaVaaliruutu(Ruutu ruutu) {
        if (ruutu.getNumero() == 10 || ruutu.getNumero() == 25) {
            suoritaEduskuntavaaliruutu(ruutu);
        } else if (ruutu.getNumero() == 30) {
            suoritaPresidentinvaaliruutu();
        }
    }

    private void suoritaEduskuntavaaliruutu(Ruutu ruutu) {
        if (nykyinenPelaaja.isKansanedustaja()) {
            peligui.pelaajaJoKansanedustaja();
        } else {
            if (ruutu.getNumero() == 10) {
                Eduskuntavaalienhallinta hallinta = new Eduskuntavaalienhallinta(nykyinenPelaaja,
                        vaalienjarjestaja, pankinjohtaja);
                peligui.avaaEduskuntavaalienHallintaGUI(hallinta);
            } else if (ruutu.getNumero() == 25) {
                if (nykyinenPelaaja.getAmmatti().getPalkka() > 4000 && nykyinenPelaaja.isPuolueenJasen()) {
                    peligui.avaaRuutu25KyselyGUI();
                }
            }
        }
    }

    private void suoritaPresidentinvaaliruutu() {
        Presidentinvaalienhallinta hallinta = new Presidentinvaalienhallinta(nykyinenPelaaja,
                vaalienjarjestaja, pankinjohtaja, kiinteistonvalittaja);
        if (hallinta.pystyykoPelaajaOsallistumaanVaaleihin() == false) {
            peligui.varallisuusEiRiitaVaaleihin();
        } else {
            peligui.avaaPresidentinvaalienHallintaGUI(hallinta);
        }
    }

    private void naytaKortti(int ruudunNro) {
        String sisalto = "";

        if ((ruudunNro == 12 && !nykyinenPelaaja.isPuolueenJasen()) || ruudunNro == 16
                || ruudunNro == 28) {
            sisalto = lauta.getTapahtumakortit().peek().getSeloste();
        } else if (ruudunNro == 7) {
            sisalto = lauta.getSattumaAmmatit().peek().toString();
        } else if (ruudunNro == 19) {
            sisalto = lauta.getLiikkeet().peek().toString();
        } else {
            return;
        }
        peligui.naytaKortinSisalto(sisalto);
    }

    /**
     * Tarkistaa onko kyseinen ruutu erikoisruutu
     *
     * @param ruutu Ruutu joka tarkastetaan
     *
     * @return True jos tarkasteltava ruutu on erikoisruutu, muuten false.
     */
    public boolean onkoErikoisruutu(Ruutu ruutu) {
        return ruutu.isOstoJaMyyntiruutu() || ruutu.isPutkaruutu() || ruutu.isVaaliruutu();
    }

    /**
     * Vaihtaa vuoroa, nykyinen pelaaja vaihtuu seuraavaan.
     */
    public void vaihdaVuoroa() {
        nykyinenPelaaja = vuoronvaihtaja.vaihdaVuoroa(nykyinenPelaaja);
    }


    /**
     * Tiputtaa nykyisen pelaajan pelistä ja tarkistaa onko pelaajia enää
     * jäljellä.
     *
     * @return True jos pelaajia on vielä jäljellä, muuten false.
     */
    public boolean tiputaPelaajaPelista() {
        lauta.getNappulat().remove(nykyinenPelaaja.getNappula());
        return lauta.getNappulat().isEmpty();
    }

    private boolean suoritaOstoJaMyyntiruutu(Ruutu ruutu) {
        OstoJaMyynti ostoJaMyynti;
        if (ruutu.getNumero() == 1) {
            ostoJaMyynti = luoUusiOstoJaMyynti(true, 1, false, false);
            peligui.avaaOstoJaMyyntiGUI(ostoJaMyynti);
        } else if (ruutu.getNumero() == 16) {
            return suoritaRuutu16(ruutu);
        } else if (ruutu.getNumero() == 20) {
            ostoJaMyynti = luoUusiOstoJaMyynti(false, 0.1, true, false);
            peligui.avaaOstoJaMyyntiGUI(ostoJaMyynti);
        }
        return true;
    }

    private boolean suoritaRuutu16(Ruutu ruutu) {
        OstoJaMyynti ostoJaMyynti;
        naytaKortti(ruutu.getNumero());
        if (suoritaRuudunTapahtumat(ruutu) == false) {
            return false;
        } else if (nykyinenPelaaja.getNappula().getSijainti().getNumero() == 16) {
            // jos tulee tapahtumakortti joka siirtää pelaajan muualle niin
            // pelaaja ei voi enää ostaa tai myydä omistuskirjojaan
            int silmaluku = heitaNoppaa();
            boolean tarjous = false;
            if (silmaluku == 6) {
                tarjous = true;
            }
            ostoJaMyynti = luoUusiOstoJaMyynti(true, 1, false, tarjous);
            peligui.avaaOstoJaMyyntiGUI(ostoJaMyynti);
        }
        return true;
    }

    private OstoJaMyynti luoUusiOstoJaMyynti(boolean saaMyyda, double kerroin,
            boolean ruutu20, boolean ruutu16Tarjous) {
        OstoJaMyynti ostojamyynti = new OstoJaMyynti(saaMyyda, kerroin, ruutu20,
                nykyinenPelaaja, kiinteistonvalittaja, lauta.getMokit().peek(),
                lauta.getLiikkeet().peek(), lauta, ruutu16Tarjous);
        return ostojamyynti;
    }

    /**
     * Tarkistaa onko laudan liikepinossa enää kortteja jäljellä.
     *
     * @return True jos laudan liikepinossa on vielä liikkeitä, muuten false.
     */
    public boolean onkoPinossaLiikkeita() {
        return !lauta.getLiikkeet().isEmpty();
    }

    private void suoritaPutkaruutu() {
        if (nykyinenPelaaja.getRahat() >= 4000) {
            peligui.avaaPutkakyselyGUI();
        } else {
            peligui.pelaajaJoutuuPutkaan();
        }
    }

    /**
     * Suorittaa ruudun tapahtumat. Tätä metodia kutsutaan jos pelaaja
     * epäonnistui suorittaa ruudun tapahtumat ensimmäisellä kerralla. Jos
     * pelaaja epäonnistuu jälleen tiputetaan hänet pelistä, ja mikäli hän oli
     * viimeinen pelaaja, lopetetaan ohjelman suoritus.
     */
    public void yritaSuorittaaTapahtumaaToisenKerran() {
        naytaKortti(nykyinenPelaaja.getNappula().getSijainti().getNumero());
        if (suoritaRuudunTapahtumat() == false) {
            peligui.pelaajaTippuuPelista();
            if (tiputaPelaajaPelista() == true) {
                peligui.kaikkiHavisivat();
            }
        }
    }
}
