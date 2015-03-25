
package presidenttipeli.domain.tapahtumat;

import java.util.Random;
import presidenttipeli.domain.Ammatti;
import presidenttipeli.domain.Pelaaja;
import presidenttipeli.domain.Pelilauta;


public class OtaAmmattikortti implements Tapahtuma{
    private Pelilauta lauta;
    private boolean johtaja; // jos true niin otetaan johtaja-ammatti, jos false niin sattuma-ammatti

    public OtaAmmattikortti(Pelilauta lauta, boolean johtaja) {
        this.lauta = lauta;
        this.johtaja = johtaja;
    }

    @Override
    public boolean suoritaTapahtuma(Pelaaja pelaaja) {
        Ammatti ammatti;
        if (johtaja) {
            ammatti = otaJohtaja();
        } else {
            ammatti = lauta.getSattumaAmmatit().pollFirst();
        }
        Tapahtuma tapahtuma = new AsetaAmmatti(lauta, ammatti);
        return tapahtuma.suoritaTapahtuma(pelaaja);
    }
    
    private Ammatti otaJohtaja() {
        Random random = new Random();
        int indeksi = random.nextInt(lauta.getJohtajaAmmatit().size());
        Ammatti ammatti = lauta.getJohtajaAmmatit().get(indeksi);
        lauta.getJohtajaAmmatit().remove(indeksi); // muista tarkistaa että siirtääkö arraylist poistetun alkion oikealla olevia alkioita yhden vasemmalle
        return ammatti;
    }
    
    
}
