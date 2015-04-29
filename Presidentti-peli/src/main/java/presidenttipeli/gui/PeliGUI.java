package presidenttipeli.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import presidenttipeli.logiikka.Eduskuntavaalienhallinta;
import presidenttipeli.logiikka.OstoJaMyynti;
import presidenttipeli.logiikka.Peli;
import presidenttipeli.logiikka.Presidentinvaalienhallinta;

/**
 * Pelin pää-GUI jonka avulla pelaaja voi liikkua laudalla ja halutessaan avata
 * VelanhallintaGUIn tai StatusGUIn.
 */
public class PeliGUI extends javax.swing.JFrame implements Runnable {

    public PeliGUI(Peli peli) {
        this.peli = peli;
        run();
        this.setVisible(true);
        peli.setPeligui(this);
        actionlistener = new PeliActionListener(this.noppaButton, this.pelinSyote,
                this.piirtoalusta, this.seuraavaVuoroButton, this.statusButton,
                this.velanhallintaButton, this.peli, this.getRootPane(), this);
        lisaaNappuloilleActionListener();
    }

    private void lisaaNappuloilleActionListener() {
        this.statusButton.addActionListener(actionlistener);
        this.velanhallintaButton.addActionListener(actionlistener);
        this.noppaButton.addActionListener(actionlistener);
        this.seuraavaVuoroButton.addActionListener(actionlistener);
    }

    @Override
    public void run() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        piirtoalusta = new Piirtoalusta(peli.getLauta());
        jScrollPane1 = new javax.swing.JScrollPane();
        pelinSyote = new javax.swing.JTextArea();
        noppaButton = new javax.swing.JButton();
        velanhallintaButton = new javax.swing.JButton();
        seuraavaVuoroButton = new javax.swing.JButton();
        statusButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout piirtoalustaLayout = new javax.swing.GroupLayout(piirtoalusta);
        piirtoalusta.setLayout(piirtoalustaLayout);
        piirtoalustaLayout.setHorizontalGroup(
            piirtoalustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        piirtoalustaLayout.setVerticalGroup(
            piirtoalustaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        pelinSyote.setEditable(false);
        pelinSyote.setColumns(20);
        pelinSyote.setRows(5);
        pelinSyote.setText("Presidentti-peli");
        jScrollPane1.setViewportView(pelinSyote);

        noppaButton.setText("Noppa");
        noppaButton.setEnabled(false);
        noppaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noppaButtonActionPerformed(evt);
            }
        });

        velanhallintaButton.setText("Velanhallinta");
        velanhallintaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velanhallintaButtonActionPerformed(evt);
            }
        });

        seuraavaVuoroButton.setText("Seuraava vuoro");
        seuraavaVuoroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seuraavaVuoroButtonActionPerformed(evt);
            }
        });

        statusButton.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(noppaButton)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seuraavaVuoroButton)
                            .addComponent(velanhallintaButton)
                            .addComponent(statusButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(piirtoalusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(piirtoalusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(statusButton)
                                .addGap(15, 15, 15)
                                .addComponent(seuraavaVuoroButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(noppaButton)))
                        .addGap(14, 14, 14)
                        .addComponent(velanhallintaButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noppaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noppaButtonActionPerformed

    }//GEN-LAST:event_noppaButtonActionPerformed

    private void velanhallintaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velanhallintaButtonActionPerformed

    }//GEN-LAST:event_velanhallintaButtonActionPerformed

    private void seuraavaVuoroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seuraavaVuoroButtonActionPerformed

    }//GEN-LAST:event_seuraavaVuoroButtonActionPerformed

    /**
     * Näyttää pakan päälimmäisen kortin sisällön dialogissa. Metodia kutsutaan
     * jos pelaaja astuu ruudulle jossa hän joutuu nostamaan jonkin kortin.
     *
     * @param teksti Näytettävän kortin sisältö
     */
    public void naytaKortinSisalto(String teksti) {
        JOptionPane.showMessageDialog(rootPane, teksti, "Kortin sisältö", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Avaa EduskuntavaalienHallintaGUIn
     *
     * @param hallinta GUIn tarvitsema logiikkaluokka.
     */
    public void avaaEduskuntavaalienHallintaGUI(Eduskuntavaalienhallinta hallinta) {
        this.setEnabled(false);
        this.setVisible(false);
        EduskuntavaalienhallintaGUI gui = new EduskuntavaalienhallintaGUI(hallinta, this);
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    /**
     * Avaa PresidentinvaaliennHallintaGUIn
     *
     * @param hallinta GUIn tarvitsema logiikkaluokka.
     */
    public void avaaPresidentinvaalienHallintaGUI(Presidentinvaalienhallinta hallinta) {
        this.setEnabled(false);
        this.setVisible(false);
        PresidentinvaalienhallintaGUI gui = new PresidentinvaalienhallintaGUI(hallinta, this);
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    /**
     * Ilmoittaa vaalien tuloksen dialogissa.
     *
     * @param onnistui Totuusarvo joka kertoo onnistuiko vaalit
     * @param saadutAanet Saadut äänet yksittäisinä listattuna
     * @param saadutAanetSummattuna Saadut äänet yhteensä
     * @param tarvittavaAanimaara Vaalien voittoon tarvittu äänimäärä.
     */
    public void ilmoitaTulos(boolean onnistui, ArrayList<Integer> saadutAanet,
            int saadutAanetSummattuna, int tarvittavaAanimaara) {
        String title;

        if (onnistui) {
            title = "Voitit vaaleissa!";
        } else {
            title = "Et voittanut vaaleissa";
        }

        JOptionPane.showMessageDialog(rootPane,
                "Saamasi äänet: " + saadutAanet + "\n Yhteensä: " + saadutAanetSummattuna
                + "\n Tarvittava äänimäärä: " + tarvittavaAanimaara,
                title, JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Ilmoittaa dialogissa pelaajan joka voitti. Metodia kutsutaan jos joku
     * pelaajista voitti presidentinvaalit.
     */
    public void peliVoitettu() {
        JOptionPane.showMessageDialog(rootPane, "Onneksi olkoon "
                + peli.getNykyinenPelaaja() + "! Voitit pelin!",
                "Peli päättyy", JOptionPane.PLAIN_MESSAGE);
        this.dispose();
    }

    /**
     * Ilmoittaa dialogissa että pelaajan varat eivät riittäneet vaalien
     * aloittamiseen. Metodia kutsutaan jos pelaaja astuu ruudulle 30 eikä
     * hänellä ole varaa presidentinvaalien aloittamiseen.
     */
    public void varallisuusEiRiitaVaaleihin() {
        JOptionPane.showMessageDialog(rootPane,
                "Et ole kansanedustaja tai johtaja-ammatissa ja/tai varallisuutesi ei riita vaalikampanjaan",
                "Vaalien aloittaminen epäonnistui", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Ilmoittaa dialogissa että pelaajan varat eivät riitä maksun maksamiseen.
     */
    public void varallisuusEiRiitaMaksuun() {
        JOptionPane.showMessageDialog(rootPane, "Rahasi eivät riitä tämän maksun maksamiseen",
                "Rahat eivät riitä", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Ilmoittaa dialogissa liikkeiden loppuneen laudalla. Metodia kutsutaan jos
     * pelaaja astuu ruudulle 19 ja liikkeitä ei ole laudalle enää jäljellä.
     */
    public void liikkeitaEiOleEnaaJaljella() {
        JOptionPane.showMessageDialog(rootPane, "Liikkeita ei ole enää jäljellä",
                "Likkeitä ei ole enää jäljellä", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Avaa OstoJaMyyntiGUIn
     *
     * @param ostoJaMyynti GUIhin liittyvä logiikkaluokka
     */
    public void avaaOstoJaMyyntiGUI(OstoJaMyynti ostoJaMyynti) {
        this.setEnabled(false);
        this.setVisible(false);
        OstoJaMyyntiGUI gui = new OstoJaMyyntiGUI(ostoJaMyynti, this);
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    /**
     * Avaa PutkakyselyGUIn.
     */
    public void avaaPutkakyselyGUI() {
        this.setEnabled(false);
        this.setVisible(false);
        PutkakyselyGUI gui = new PutkakyselyGUI(peli, this);
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }

    /**
     * Ilmoittaa dialogissa pelaajan joutuneen putkaan 2 vuoron ajaksi. Metodia
     * kutsutaan jos pelaaja astuu ruudulle 24 ja ei maksa 4000 mk.
     */
    public void pelaajaJoutuuPutkaan() {
        JOptionPane.showMessageDialog(rootPane, "Jouduit putkaan 2 vuoron ajaksi",
                "Jouduit putkaan", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Ilmoittaa dialogissa pelaajan tippuneen pelistä pois. Metodia kutsutaan
     * jos pelaaja tippuu pelistä.
     */
    public void pelaajaTippuuPelista() {
        JOptionPane.showMessageDialog(rootPane,
                peli.getNykyinenPelaaja().getNimi() + " tippui pelista",
                "Pelaaja tippui pelista", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Ilmoittaa dialogissa pelin päättyneen koska pelaajia ei ole enää
     * jäljellä. Metodia kutsutaan jos viimeinen pelaaja tippuu pelistä.
     */
    public void kaikkiHavisivat() {
        JOptionPane.showMessageDialog(rootPane,
                "Peli päättyy koska pelaajia ei ole enää jäjlellä",
                "Peli päättyy", JOptionPane.WARNING_MESSAGE);
        this.dispose();
    }

    /**
     * Avaa Ruutu25KyselyGUIn. Metodia kutsutaan jos pelaaja joka täyttää
     * vaatimukset (puolueen jäsen ja ammatissa jonka palkka yli 4000 mk/kk)
     * astuu ruudulle 25.
     */
    public void avaaRuutu25KyselyGUI() {
        Ruutu25KyselyGUI kysely = new Ruutu25KyselyGUI(this, peli);
        this.setEnabled(false);
        this.setVisible(false);
        SwingUtilities.invokeLater(kysely);
        kysely.setVisible(true);
    }

    /**
     * Ilmoittaa dialogissa uuden kierroksen alkaneen ja pelaajan saamat tuotot
     * sekä nykyisen velkatilanteen. Metodia kutsutaan jos pelaaja aloittaa
     * uuden kierroksen laudalla.
     */
    public void uusiKierros() {
        JOptionPane.showMessageDialog(rootPane, peli.getNykyinenPelaaja()
                + " aloitti uuden kierroksen.\n" + "Kuukauden tuotot: "
                + peli.getPankinjohtaja().getKuukaudenTuotot() + " mk\n"
                + "Velka: " + peli.getNykyinenPelaaja().getVelkaa(), "Uusi kierros",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Ilmoittaa dialogissa pelaajan olevan jo kansanedustaja. Metodia kutsutaan
     * jos pelaaja joka on jo kansanedustaja saapuu eduskuntavaaliruudulle.
     */
    public void pelaajaJoKansanedustaja() {
        JOptionPane.showMessageDialog(rootPane, peli.getNykyinenPelaaja()
                + " on jo kansanedustaja.", "Vaalien aloittaminen epäonnistui.",
                JOptionPane.PLAIN_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton noppaButton;
    private javax.swing.JTextArea pelinSyote;
    private javax.swing.JPanel piirtoalusta;
    private javax.swing.JButton seuraavaVuoroButton;
    private javax.swing.JButton statusButton;
    private javax.swing.JButton velanhallintaButton;
    // End of variables declaration//GEN-END:variables

    private Peli peli;
    private PeliActionListener actionlistener;

}
