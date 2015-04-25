package presidenttipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.logiikka.PelaajanStatus;
import presidenttipeli.logiikka.Peli;

public class PeliActionListener implements ActionListener {

    private JButton noppaButton;
    private JTextArea pelinSyote;
    private JPanel piirtoalusta;
    private JButton seuraavaVuoroButton;
    private JButton statusButton;
    private JButton velanhallintaButton;
    private Peli peli;
    private JRootPane rootPane;
    private JFrame frame;

    public PeliActionListener(JButton noppaButton, JTextArea pelinSyote, JPanel piirtoalusta, JButton seuraavaVuoroButton, JButton statusButton, JButton velanhallintaButton, Peli peli, JRootPane rootPane, JFrame frame) {
        this.noppaButton = noppaButton;
        this.pelinSyote = pelinSyote;
        this.piirtoalusta = piirtoalusta;
        this.seuraavaVuoroButton = seuraavaVuoroButton;
        this.statusButton = statusButton;
        this.velanhallintaButton = velanhallintaButton;
        this.peli = peli;
        this.rootPane = rootPane;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == statusButton) {
            statusButtonPainettu();
        } else if (e.getSource() == velanhallintaButton) {
            velanhallintaButtonPainettu();
        } else if (e.getSource() == noppaButton) {
            noppaButtonPainettu();
        } else if (e.getSource() == seuraavaVuoroButton) {
            seuraavaVuoroButtonPainettu();
        }
    }

    private void statusButtonPainettu() {
        frame.setEnabled(false);
        PelaajanStatus status = new PelaajanStatus(peli.getNykyinenPelaaja());
        PelaajanStatusGUI gui = new PelaajanStatusGUI(status, frame);
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    private void velanhallintaButtonPainettu() {
        frame.setEnabled(false);
        VelanhallintaGUI velanhallintagui = new VelanhallintaGUI(peli, frame, false);
        SwingUtilities.invokeLater(velanhallintagui);
        velanhallintagui.setVisible(true);
    }

    private void noppaButtonPainettu() {
        noppaButton.setEnabled(false);
        seuraavaVuoroButton.setEnabled(true);
        int silmaluku = peli.heitaNoppaa();
        pelinSyote.setText(peli.getNykyinenPelaaja() + " heitti " + silmaluku);
        piirtoalusta.repaint();
        if (peli.getLiikuttelija().liikutaNappulaa(peli.getNykyinenPelaaja().getNappula(),
                silmaluku) == true) {
            uusiKierros();
        }
        naytaSelostus();
        suoritaTapahtuma();
    }

    private void seuraavaVuoroButtonPainettu() {
        this.seuraavaVuoroButton.setEnabled(false);
        peli.vaihdaVuoroa();
        ilmoitaKenenVuoro();
        this.noppaButton.setEnabled(true);
    }

    private void uusiKierros() {
        peli.getPankinjohtaja().annaPelaajalleKuukaudenTuotot(peli.getNykyinenPelaaja());
        JOptionPane.showMessageDialog(rootPane, peli.getNykyinenPelaaja()
                + " aloitti uuden kierroksen.\n" + "Kuukauden tuotot: "
                + peli.getPankinjohtaja().getKuukaudenTuotot() + " mk\n"
                + "Velka: " + peli.getNykyinenPelaaja().getVelkaa(), "Uusi kierros",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void naytaSelostus() {
        Ruutu ruutu = peli.getNykyinenPelaaja().getNappula().getSijainti();
        JOptionPane.showMessageDialog(rootPane, ruutu.getSeloste(), "Ruutu "
                + ruutu.getNumero(), JOptionPane.PLAIN_MESSAGE);
    }

    private void suoritaTapahtuma() {
        if (peli.suoritaRuudunTapahtumat() == false) {
            frame.setEnabled(false);
            VelanhallintaGUI velanhallintagui = new VelanhallintaGUI(peli, frame, true);
            SwingUtilities.invokeLater(velanhallintagui);
            velanhallintagui.setVisible(true);
        }

    }

    private void ilmoitaKenenVuoro() {
        JOptionPane.showMessageDialog(rootPane, "Pelaajan " + peli.getNykyinenPelaaja() + " vuoro",
                "Uusi vuoro", JOptionPane.PLAIN_MESSAGE);
    }

}
