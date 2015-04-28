package presidenttipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import presidenttipeli.logiikka.Pankinjohtaja;
import presidenttipeli.logiikka.Peli;
import presidenttipeli.logiikka.Velanhallinta;

/**
 * VelanhallintaGUIn nappuloille tarkoitettu ActionListener-luokka.
 */
public class VelanhallintaActionListener implements ActionListener {

    private JButton hyvaksyTakaisinmaksu;
    private JButton hyvaksyVelanotto;
    private JButton maksurahaMinus100;
    private JButton maksurahaMinus1000;
    private JButton maksurahaPlus100;
    private JButton maksurahaPlus1000;
    private JButton ottorahaMinus100;
    private JButton ottorahaMinus1000;
    private JButton ottorahaPlus100;
    private JButton ottorahaPlus1000;
    private JButton suljeButton;
    private JTextField maksurahat;
    private JTextField ottorahat;
    private JLabel pelaajanRahat;
    private JLabel pelaajanVelat;
    private JFrame frame;
    private JRootPane rootPane;
    private Peli peli;
    private Velanhallinta laskuri;
    private Pankinjohtaja pankinjohtaja;

    public VelanhallintaActionListener(JButton hyvaksyTakaisinmaksu, JButton hyvaksyVelanotto, JButton maksurahaMinus100, JButton maksurahaMinus1000, JButton maksurahaPlus100, JButton maksurahaPlus1000, JButton ottorahatMinus100, JButton ottorahatMinus1000, JButton ottorahatPlus100, JButton ottorahatPlus1000, JButton suljeButton, JTextField maksurahat, JTextField ottorahat, JLabel pelaajanRahat, JLabel pelaajanVelat, JFrame frame, JRootPane rootPane, Peli peli, Velanhallinta laskuri, Pankinjohtaja pankinjohtaja) {
        this.hyvaksyTakaisinmaksu = hyvaksyTakaisinmaksu;
        this.hyvaksyVelanotto = hyvaksyVelanotto;
        this.maksurahaMinus100 = maksurahaMinus100;
        this.maksurahaMinus1000 = maksurahaMinus1000;
        this.maksurahaPlus100 = maksurahaPlus100;
        this.maksurahaPlus1000 = maksurahaPlus1000;
        this.ottorahaMinus100 = ottorahatMinus100;
        this.ottorahaMinus1000 = ottorahatMinus1000;
        this.ottorahaPlus100 = ottorahatPlus100;
        this.ottorahaPlus1000 = ottorahatPlus1000;
        this.suljeButton = suljeButton;
        this.maksurahat = maksurahat;
        this.ottorahat = ottorahat;
        this.pelaajanRahat = pelaajanRahat;
        this.pelaajanVelat = pelaajanVelat;
        this.frame = frame;
        this.rootPane = rootPane;
        this.peli = peli;
        this.laskuri = laskuri;
        this.pankinjohtaja = pankinjohtaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ottorahaMinus1000) {
            ottorahatMinus1000Painettu();
        } else if (e.getSource() == ottorahaMinus100) {
            ottorahatMinus100Painettu();
        } else if (e.getSource() == ottorahaPlus100) {
            ottorahatPlus100Painettu();
        } else if (e.getSource() == ottorahaPlus1000) {
            ottorahatPlus1000Painettu();
        } else if (e.getSource() == maksurahaMinus1000) {
            maksurahatMinus1000Painettu();
        } else if (e.getSource() == maksurahaMinus100) {
            maksurahatMinus100Painettu();
        } else if (e.getSource() == maksurahaPlus100) {
            maksurahatPlus100Painettu();
        } else if (e.getSource() == maksurahaPlus1000) {
            maksurahatPlus1000Painettu();
        } else if (e.getSource() == hyvaksyVelanotto) {
            hyvaksyVelanottoPainettu();
        } else if (e.getSource() == suljeButton) {
            frame.dispose();
        } else if (e.getSource() == hyvaksyTakaisinmaksu) {
            hyvaksyTakaisinmaksuPainettu();
        }
    }

    private void hyvaksyTakaisinmaksuPainettu() {
        if (pankinjohtaja.vahennaVelkaa(peli.getNykyinenPelaaja(),
                Integer.parseInt(maksurahat.getText())) == false) {
            JOptionPane.showMessageDialog(rootPane,
                    "Velkojen maksaminen epäonnistui",
                    "Velkojen maksaminen epäonnistui", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Velkojen maksaminen onnistui",
                    "Velkojen maksaminen onnistui", JOptionPane.PLAIN_MESSAGE);
        }
        paivitaPelaajanRahat();
        paivitaPelaajanVelat();
    }

    private void hyvaksyVelanottoPainettu() {
        if (pankinjohtaja.kasvataVelkaa(peli.getNykyinenPelaaja(),
                Integer.parseInt(ottorahat.getText())) == false) {
            JOptionPane.showMessageDialog(rootPane, "Haluamasi velka ylitti 5000 mk:n rajan",
                    "Velan ottaminen epäonnistui", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Velan ottaminen onnistui",
                    "Velan ottaminen onnistui", JOptionPane.PLAIN_MESSAGE);
        }
        paivitaPelaajanRahat();
        paivitaPelaajanVelat();
    }

    private void maksurahatPlus1000Painettu() {
        laskuri.kasvataMaksurahaaTuhannella();
        paivitaMaksuraha();
    }

    private void maksurahatPlus100Painettu() {
        laskuri.kasvataMaksurahaaSadalla();
        paivitaMaksuraha();
    }

    private void maksurahatMinus100Painettu() {
        laskuri.vahennaMaksurahaaSadalla();
        paivitaMaksuraha();
    }

    private void maksurahatMinus1000Painettu() {
        laskuri.vahennaMaksurahaaTuhannella();
        paivitaMaksuraha();
    }

    private void ottorahatMinus1000Painettu() {
        laskuri.vahennaOttorahaaTuhannella();
        paivitaOttoraha();
    }

    private void ottorahatMinus100Painettu() {
        laskuri.vahennaOttorahaaSadalla();
        paivitaOttoraha();
    }

    private void ottorahatPlus100Painettu() {
        laskuri.kasvataOttorahaaSadalla();
        paivitaOttoraha();
    }

    private void ottorahatPlus1000Painettu() {
        laskuri.kasvataOttorahaaTuhannella();
        paivitaOttoraha();
    }

    private void paivitaOttoraha() {
        ottorahat.setText("" + laskuri.getOttoraha());
    }

    private void paivitaMaksuraha() {
        maksurahat.setText("" + laskuri.getMaksuraha());
    }

    private void paivitaPelaajanRahat() {
        laskuri.paivitaPelaajanRahat();
        pelaajanRahat.setText(laskuri.getPelaajanRahat() + " mk");
    }

    private void paivitaPelaajanVelat() {
        laskuri.paivitaPelaajanVelka();
        pelaajanVelat.setText(laskuri.getPelaajanVelat() + " ");
    }

}
