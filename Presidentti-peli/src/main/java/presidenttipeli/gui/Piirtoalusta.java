package presidenttipeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Pelilauta;

public class Piirtoalusta extends JPanel {

    private Pelilauta lauta;
    private ArrayList<Nappula> nappulat;

    public Piirtoalusta(Pelilauta lauta) {
        super.setBackground(Color.WHITE);
        this.lauta = lauta;
        nappulat = lauta.getNappulat();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        piirraLauta(graphics);
        piirraNappulat(graphics);
    }

    private void piirraLauta(Graphics graphics) {
        graphics.drawImage(lauta.getKuva(), 0, 0, this);
    }

    private void piirraNappulat(Graphics graphics) {
        int x = 0, y = 0;
        for (Nappula nappula : lauta.getNappulat()) {
            graphics.drawImage(nappula.getKuva(), nappula.getSijainti().getX(),
                    nappula.getSijainti().getY(), this);
        }

    }
}
