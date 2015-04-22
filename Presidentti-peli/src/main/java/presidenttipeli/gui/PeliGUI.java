/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenttipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import presidenttipeli.domain.Nappula;
import presidenttipeli.domain.Ruutu;
import presidenttipeli.logiikka.Eduskuntavaalienhallinta;
import presidenttipeli.logiikka.PelaajanStatus;
import presidenttipeli.logiikka.Peli;

/**
 *
 * @author Eero
 */
public class PeliGUI extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form PeliGUI
     */
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

    public void naytaKortinSisalto(String teksti) {
        JOptionPane.showMessageDialog(rootPane, teksti, "Kortin sisältö", JOptionPane.PLAIN_MESSAGE);
    }

    public void avaaEduskuntavaalienHallintaGUI(Eduskuntavaalienhallinta hallinta) {
        SwingUtilities.invokeLater(new EduskuntavaalienhallintaGUI(hallinta, this));
    }

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
    
    public void peliVoitettu() {
        JOptionPane.showMessageDialog(rootPane, "Onneksi olkoon " 
                + peli.getNykyinenPelaaja() + "! Voitit pelin!",
                "Peli päättyy", JOptionPane.PLAIN_MESSAGE);
        this.dispose();
    }
    
    public void varallisuusEiRiitaVaaleihin() {
        JOptionPane.showMessageDialog(rootPane, 
                "Et ole kansanedustaja tai johtaja-ammatissa ja/tai varallisuutesi ei riita vaalikampanjaan",
                "Vaalien aloittaminen epäonnistui", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void varallisuusEiRiitaMaksuun() {
        JOptionPane.showMessageDialog(rootPane, "Rahasi eivät riitä tämän maksun maksamiseen", 
                "Rahat eivät riitä", JOptionPane.WARNING_MESSAGE);
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
