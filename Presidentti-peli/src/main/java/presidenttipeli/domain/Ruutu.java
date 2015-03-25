package presidenttipeli.domain;

import java.util.ArrayList;
import presidenttipeli.domain.tapahtumat.Tapahtuma;

public class Ruutu implements Comparable<Ruutu>{

    private int numero;
    private boolean ostoJaMyyntiruutu;
    private boolean vaaliruutu;
    private boolean putkaruutu;
    private ArrayList<Tapahtuma> tapahtumat;
    private String seloste;

    public Ruutu(int numero, boolean ostoJaMyyntiruutu, boolean vaaliruutu, boolean putkaruutu) {
        this.numero = numero;
        this.ostoJaMyyntiruutu = ostoJaMyyntiruutu;
        this.vaaliruutu = vaaliruutu;
        this.putkaruutu = putkaruutu;
        tapahtumat = new ArrayList();
        seloste = "placeholder";
    }

    public int getNumero() {
        return numero;
    }

    public String getSeloste() {
        return seloste;
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

    @Override
    public boolean equals(Object obj) {
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

    @Override
    public int compareTo(Ruutu o) {
        return this.numero - o.getNumero();
    }
    
    
}
