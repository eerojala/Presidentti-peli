/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenttipeli.gui;

import javax.swing.JOptionPane;
import presidenttipeli.logiikka.Pankinjohtaja;
import presidenttipeli.logiikka.Peli;
import presidenttipeli.logiikka.Velkalaskuri;

/**
 *
 * @author Eero
 */
public class VelanhallintaGUI extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form VelkaGUI
     */
    public VelanhallintaGUI(Peli peli) {
        this.peli = peli;
        pankinjohtaja = peli.getPankinjohtaja();
        laskuri = new Velkalaskuri(peli.getNykyinenPelaaja());
        run();
        this.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pelaajanRahat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pelaajanVelat = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ottorahatMinus1000 = new javax.swing.JButton();
        ottorahaMinus100 = new javax.swing.JButton();
        ottorahat = new javax.swing.JTextField();
        ottorahaPlus100 = new javax.swing.JToggleButton();
        ottorahatPlus1000 = new javax.swing.JButton();
        hyvaksyVelanOtto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        maksurahaMinus1000 = new javax.swing.JButton();
        maksurahaMinus100 = new javax.swing.JButton();
        maksurahat = new javax.swing.JTextField();
        maksurahaPlus100 = new javax.swing.JButton();
        maksurahaPlus1000 = new javax.swing.JButton();
        hyvaksyTakaisinMaksu = new javax.swing.JButton();
        suljeButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pelaajanNimi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Pelaajan rahat:");

        pelaajanRahat.setText(laskuri.getPelaajanRahat() + " mk");

        jLabel2.setText("Pelaajan velat:");

        pelaajanVelat.setText(laskuri.getPelaajanVelat() + " mk");

        jLabel3.setText("Ota velkaa:");

        ottorahatMinus1000.setText("-1000");
        ottorahatMinus1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ottorahatMinus1000ActionPerformed(evt);
            }
        });

        ottorahaMinus100.setText("-100");
        ottorahaMinus100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ottorahaMinus100ActionPerformed(evt);
            }
        });

        ottorahat.setEditable(false);
        ottorahat.setText("00000");

        ottorahaPlus100.setText("+100");
        ottorahaPlus100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ottorahaPlus100ActionPerformed(evt);
            }
        });

        ottorahatPlus1000.setText("+1000");
        ottorahatPlus1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ottorahatPlus1000ActionPerformed(evt);
            }
        });

        hyvaksyVelanOtto.setText("OK");
        hyvaksyVelanOtto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hyvaksyVelanOttoActionPerformed(evt);
            }
        });

        jLabel4.setText("Maksa velkoja:");

        maksurahaMinus1000.setText("-1000");
        maksurahaMinus1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maksurahaMinus1000ActionPerformed(evt);
            }
        });

        maksurahaMinus100.setText("-100");
        maksurahaMinus100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maksurahaMinus100ActionPerformed(evt);
            }
        });

        maksurahat.setEditable(false);
        maksurahat.setText("00000");
        maksurahat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maksurahatActionPerformed(evt);
            }
        });

        maksurahaPlus100.setText("+100");
        maksurahaPlus100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maksurahaPlus100ActionPerformed(evt);
            }
        });

        maksurahaPlus1000.setText("+1000");
        maksurahaPlus1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maksurahaPlus1000ActionPerformed(evt);
            }
        });

        hyvaksyTakaisinMaksu.setText("OK");
        hyvaksyTakaisinMaksu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hyvaksyTakaisinMaksuActionPerformed(evt);
            }
        });

        suljeButton.setText("Sulje");
        suljeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suljeButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Pelaaja:");

        pelaajanNimi.setText(peli.getNykyinenPelaaja().getNimi());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(suljeButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pelaajanNimi))
                            .addComponent(ottorahat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(maksurahat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(maksurahaMinus1000)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maksurahaMinus100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maksurahaPlus100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maksurahaPlus1000)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hyvaksyTakaisinMaksu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pelaajanRahat)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pelaajanVelat))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ottorahatMinus1000, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ottorahaMinus100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ottorahaPlus100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ottorahatPlus1000)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hyvaksyVelanOtto)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pelaajanRahat)
                    .addComponent(jLabel2)
                    .addComponent(pelaajanVelat)
                    .addComponent(jLabel5)
                    .addComponent(pelaajanNimi))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ottorahatMinus1000)
                    .addComponent(ottorahaMinus100)
                    .addComponent(ottorahaPlus100)
                    .addComponent(ottorahatPlus1000)
                    .addComponent(ottorahat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hyvaksyVelanOtto))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maksurahat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maksurahaMinus1000)
                    .addComponent(maksurahaMinus100)
                    .addComponent(maksurahaPlus100)
                    .addComponent(hyvaksyTakaisinMaksu)
                    .addComponent(maksurahaPlus1000))
                .addGap(18, 18, 18)
                .addComponent(suljeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ottorahatMinus1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ottorahatMinus1000ActionPerformed
        laskuri.vahennaOttorahaaTuhannella();
        paivitaOttoraha();
    }//GEN-LAST:event_ottorahatMinus1000ActionPerformed

    private void ottorahaMinus100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ottorahaMinus100ActionPerformed
        laskuri.vahennaOttorahaaSadalla();
        paivitaOttoraha();
    }//GEN-LAST:event_ottorahaMinus100ActionPerformed

    private void ottorahaPlus100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ottorahaPlus100ActionPerformed
        laskuri.kasvataOttorahaaSadalla();
        paivitaOttoraha();
    }//GEN-LAST:event_ottorahaPlus100ActionPerformed

    private void ottorahatPlus1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ottorahatPlus1000ActionPerformed
        laskuri.kasvataOttorahaaTuhannella();
        paivitaOttoraha();
    }//GEN-LAST:event_ottorahatPlus1000ActionPerformed

    private void maksurahaMinus1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maksurahaMinus1000ActionPerformed
        laskuri.vahennaMaksurahaaTuhannella();
        paivitaMaksuraha();
    }//GEN-LAST:event_maksurahaMinus1000ActionPerformed

    private void maksurahaMinus100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maksurahaMinus100ActionPerformed
        laskuri.vahennaMaksurahaaSadalla();
        paivitaMaksuraha();
    }//GEN-LAST:event_maksurahaMinus100ActionPerformed

    private void maksurahaPlus100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maksurahaPlus100ActionPerformed
        laskuri.kasvataMaksurahaaSadalla();
        paivitaMaksuraha();
    }//GEN-LAST:event_maksurahaPlus100ActionPerformed

    private void maksurahaPlus1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maksurahaPlus1000ActionPerformed
        laskuri.kasvataMaksurahaaTuhannella();
        paivitaMaksuraha();
    }//GEN-LAST:event_maksurahaPlus1000ActionPerformed

    private void hyvaksyVelanOttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hyvaksyVelanOttoActionPerformed
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
    }//GEN-LAST:event_hyvaksyVelanOttoActionPerformed

    private void maksurahatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maksurahatActionPerformed

    }//GEN-LAST:event_maksurahatActionPerformed

    private void suljeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suljeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_suljeButtonActionPerformed

    private void hyvaksyTakaisinMaksuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hyvaksyTakaisinMaksuActionPerformed
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
    }//GEN-LAST:event_hyvaksyTakaisinMaksuActionPerformed

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
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hyvaksyTakaisinMaksu;
    private javax.swing.JButton hyvaksyVelanOtto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton maksurahaMinus100;
    private javax.swing.JButton maksurahaMinus1000;
    private javax.swing.JButton maksurahaPlus100;
    private javax.swing.JButton maksurahaPlus1000;
    private javax.swing.JTextField maksurahat;
    private javax.swing.JButton ottorahaMinus100;
    private javax.swing.JToggleButton ottorahaPlus100;
    private javax.swing.JTextField ottorahat;
    private javax.swing.JButton ottorahatMinus1000;
    private javax.swing.JButton ottorahatPlus1000;
    private javax.swing.JLabel pelaajanNimi;
    private javax.swing.JLabel pelaajanRahat;
    private javax.swing.JLabel pelaajanVelat;
    private javax.swing.JButton suljeButton;
    // End of variables declaration//GEN-END:variables
    private Peli peli;
    private Velkalaskuri laskuri;
    private Pankinjohtaja pankinjohtaja;
}
