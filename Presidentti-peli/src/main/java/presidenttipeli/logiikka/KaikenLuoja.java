
package presidenttipeli.logiikka;

import java.util.ArrayList;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;
import presidenttipeli.logiikka.luojat.*;


public class KaikenLuoja {
    private ArrayList<String> pelaajienNimet;
    private Pelilauta lauta;
    private JohtajaAmmattienLuoja jALuoja;
    private SattumaAmmattienLuoja sALuoja;
    private LiikkeidenLuoja lLuoja;
    private MokkienLuoja mLuoja;
    private RuutujenLuoja rLuoja;
    private TapahtumakorttienLuoja tLuoja;
    private PelaajienLuoja pLuoja;
    private NappuloidenLuoja nLuoja;
    private Peli peli;
    
    public KaikenLuoja(ArrayList<String> pelaajienNimet) {
        this.pelaajienNimet = pelaajienNimet;
        lauta = new Pelilauta();
        jALuoja = new JohtajaAmmattienLuoja();
        sALuoja = new SattumaAmmattienLuoja();
        lLuoja = new LiikkeidenLuoja();
        mLuoja = new MokkienLuoja();
        pLuoja = new PelaajienLuoja(pelaajienNimet);
        luoKaikki();
    }
    
    private void luoKaikki() {
        luoPelaajatJaNappulat();
        luoAmmatitMokitJaLiikkeet();
        luoTapahtumaKortit();
        luoRuudut();
        asetaNappulatAloitusruudulle();
        luoPeli();
    }
    
    private void luoPelaajatJaNappulat() {
        pLuoja.luo();
        ArrayList<Pelaaja> pelaajat = pLuoja.getPelaajat();
        nLuoja = new NappuloidenLuoja(pelaajat);
        nLuoja.luo();
        lauta.setNappulat(nLuoja.getNappulat());

    }
    
    private void luoAmmatitMokitJaLiikkeet() {
        jALuoja.luo();
        sALuoja.luo();
        lLuoja.luo();
        mLuoja.luo();
        lauta.setJohtajaAmmatit(jALuoja.getSekoitetutAmmatit());
        lauta.setLiikkeet(lLuoja.getSekoitetutLiikkeet());
        lauta.setMokit(mLuoja.getSekoitetutMokit());
        lauta.setSattumaAmmatit(sALuoja.getSekoitetutAmmatit());
    }
    
    private void luoTapahtumaKortit() {
        tLuoja = new TapahtumakorttienLuoja(lauta);
        tLuoja.luo();
        lauta.setTapahtumakortit(tLuoja.getKortit());
    }
    
    private void luoRuudut() {
        rLuoja = new RuutujenLuoja(lauta);
        rLuoja.luo();
        lauta.setRuudut(rLuoja.getRuudut());
    }
    
    private void asetaNappulatAloitusruudulle() {
        for (Nappula nappula : lauta.getNappulat()) {
            nappula.setSijainti(lauta.getRuudut().get(0));
        }
    }
    
    public Pelilauta getLauta() {
        return lauta;
    }
    
    private void luoPeli() {
        peli = new Peli(lauta);
    }

    public Peli getPeli() {
        return peli;
    }
     
}
