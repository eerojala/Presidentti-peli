package presidenttipeli.domain;

import java.util.ArrayList;
import presidenttipeli.domain.tapahtumat.Tapahtuma;

/**
 * Luokka joka pitää muistissa ruudun numeron, tapahtumat jne
 */
public class Ruutu implements Comparable<Ruutu>, SelosteenOmaava {

    private int numero;
    private int x;
    private int y;
    private boolean ostoJaMyyntiruutu;
    private boolean vaaliruutu;
    private boolean putkaruutu;
    private ArrayList<Tapahtuma> tapahtumat;
    private String seloste;

    public Ruutu(int numero, int x, int y) {
        this.numero = numero;
        this.x = x;
        this.y = y;
        this.ostoJaMyyntiruutu = false;
        this.vaaliruutu = false;
        this.putkaruutu = false;
        tapahtumat = new ArrayList();
        seloste = "placeholder";
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String getSeloste() {
        return seloste;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public ArrayList<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }

    public boolean isOstoJaMyyntiruutu() {
        return ostoJaMyyntiruutu;
    }

    public boolean isPutkaruutu() {
        return putkaruutu;
    }

    public boolean isVaaliruutu() {
        return vaaliruutu;
    }

    public void setOstoJaMyyntiruutu(boolean ostoJaMyyntiRuutu) {
        this.ostoJaMyyntiruutu = ostoJaMyyntiRuutu;
    }

    public void setPutkaruutu(boolean putkaruutu) {
        this.putkaruutu = putkaruutu;
    }

    public void setSeloste(String seloste) {
        this.seloste = seloste;
    }

    public void setTapahtumat(ArrayList<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
    }

    public void setVaaliruutu(boolean vaaliRuutu) {
        this.vaaliruutu = vaaliRuutu;
    }

    /**
     * Metodi joka vertaa kahta oliota toisiinsa
     *
     * @param obj Toinen olio
     *
     * @return ovatko kaksi oliota samoja (Molemmat ruutu-olioita ja sama
     * numero)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Ruutu ruutu = (Ruutu) obj;

        if (ruutu.getNumero() != this.numero) {
            return false;
        }

        // Samannumeroisia ruutuja ei ole
        return true;
    }

    /**
     *  Metodi joka vertaa kahta ruutua keskenään
     * 
     *  @param o Toinen ruutu
     * 
     *  @return Numeron joka määrää ruutujen keskenäisen järjestyksen 
     */
    @Override
    public int compareTo(Ruutu o) {
        return this.numero - o.getNumero();
    }

}
