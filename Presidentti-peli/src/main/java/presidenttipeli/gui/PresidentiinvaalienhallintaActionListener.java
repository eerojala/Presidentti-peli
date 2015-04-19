package presidenttipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import presidenttipeli.domain.Liike;
import presidenttipeli.domain.Mokki;
import presidenttipeli.logiikka.Presidentinvaalienhallinta;

public class PresidentiinvaalienhallintaActionListener implements ActionListener {

    private JButton okButton;
    private JComboBox liikkeet;
    private JComboBox mokit;
    private JRadioButton vaihtoehto1;
    private JRadioButton vaihtoehto2;
    private JRadioButton vaihtoehto3;
    private JFrame frame;
    private JRootPane rootpane;
    private PeliGUI peligui;
    private Presidentinvaalienhallinta hallinta;

    public PresidentiinvaalienhallintaActionListener(JButton okButton, JComboBox liikkeet, JComboBox mokit, JRadioButton vaihtoehto1, JRadioButton vaihtoehto2, JRadioButton vaihtoehto3, JFrame frame, JRootPane rootpane, PeliGUI peligui, Presidentinvaalienhallinta hallinta) {
        this.okButton = okButton;
        this.liikkeet = liikkeet;
        this.mokit = mokit;
        this.vaihtoehto1 = vaihtoehto1;
        this.vaihtoehto2 = vaihtoehto2;
        this.vaihtoehto3 = vaihtoehto3;
        this.frame = frame;
        this.rootpane = rootpane;
        this.peligui = peligui;
        this.hallinta = hallinta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vaihtoehto1) {
            hallinta.vaihtoehto1();
        } else if (e.getSource() == vaihtoehto2) {
            hallinta.vaihtoehto2();
        } else if (e.getSource() == vaihtoehto3) {
            hallinta.vaihtoehto3();
        } else if (e.getSource() == okButton) {
            okPainettu();
        }
    }

    private void okPainettu() {

        if (hallinta.isVaihtoehto1Valittu()) {
            ilmoitaTulos(jarjestaPresidentinvaalit());
        } else if (hallinta.isVaihtoehto2Valittu()) {
            if (uhraaMokkiTaiLiike() == true) {
                ilmoitaTulos(jarjestaPresidentinvaalit());
            }
        } else if (hallinta.isVaihtoehto3Valittu()) {
            if (uhraaMokkiTaiLiike() == true) {
                hallinta.uhraaTutkinto();
                ilmoitaTulos(jarjestaPresidentinvaalit());
            }
        } else {
            JOptionPane.showMessageDialog(rootpane, "Valitse jokin vaihtoehdoista!",
                    "Vaalien yrittäminen epäonnistui", JOptionPane.PLAIN_MESSAGE);
        }

    }

    private boolean jarjestaPresidentinvaalit() {
        return hallinta.getJarjestaja().jarjestaPresidentinvaalit(hallinta.getTarvittavaAanimaara(),
                hallinta.getPelaaja());
    }

    private boolean onkoLiikettaValittu() {
        int i = liikkeet.getSelectedIndex();
        if (hallinta.getLiikkeet()[i].equals("none")) {
            return false;
        }
        return true;
    }

    private boolean onkoMokkiaValittu() {
        int i = mokit.getSelectedIndex();
        if (hallinta.getMokit()[i].equals("none")) {
            return false;
        }
        return true;
    }

    private void naytaViesti() {
        JOptionPane.showMessageDialog(rootpane, "Valitse mökki tai liike jonka uhraat vaaleja varten",
                "Vaalien aloittaminen epäonnistui", JOptionPane.PLAIN_MESSAGE);
    }

    private boolean uhraaMokkiTaiLiike() {
        if (onkoMokkiaValittu()) {
            hallinta.uhraaMokki(liikkeet.getSelectedIndex() - 1);
            return true;
        } else if (onkoLiikettaValittu()) {
            hallinta.uhraaLiike(liikkeet.getSelectedIndex() - 1);
            return true;
        } else {
            naytaViesti();
            return false;
        }
    }

    private void ilmoitaTulos(boolean tulos) {
        peligui.ilmoitaTulos(tulos, hallinta.getJarjestaja().getSaadutAanet(),
                hallinta.getJarjestaja().getSaadutAanetSummattuna(),
                hallinta.getTarvittavaAanimaara());
        frame.dispose();
        if (tulos == true) {
            peligui.peliVoitettu();
        }
    }

}
