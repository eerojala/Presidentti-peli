/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidenttipeli.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import presidenttipeli.logiikka.Aloitus;

/**
 *
 * @author Eero
 */
public class AloitusGUI extends javax.swing.JFrame {

    /**
     * Creates new form AloitusGUI
     */
    public AloitusGUI() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        kaksiPelaajaa = new javax.swing.JRadioButton();
        kolmePelaajaa = new javax.swing.JRadioButton();
        neljaPelaajaa = new javax.swing.JRadioButton();
        viisiPelaajaa = new javax.swing.JRadioButton();
        kuusiPelaajaa = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pelaaja1Nimi = new javax.swing.JTextField();
        pelaaja2Nimi = new javax.swing.JTextField();
        pelaaja3Nimi = new javax.swing.JTextField();
        pelaaja5Nimi = new javax.swing.JTextField();
        pelaaja6Nimi = new javax.swing.JTextField();
        pelaaja4Nimi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Montako pelaajaa"));

        buttonGroup1.add(kaksiPelaajaa);
        kaksiPelaajaa.setText("2 ");
        kaksiPelaajaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaksiPelaajaaActionPerformed(evt);
            }
        });

        buttonGroup1.add(kolmePelaajaa);
        kolmePelaajaa.setText("3");
        kolmePelaajaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolmePelaajaaActionPerformed(evt);
            }
        });

        buttonGroup1.add(neljaPelaajaa);
        neljaPelaajaa.setText("4");
        neljaPelaajaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neljaPelaajaaActionPerformed(evt);
            }
        });

        buttonGroup1.add(viisiPelaajaa);
        viisiPelaajaa.setText("5");
        viisiPelaajaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viisiPelaajaaActionPerformed(evt);
            }
        });

        buttonGroup1.add(kuusiPelaajaa);
        kuusiPelaajaa.setText("6");
        kuusiPelaajaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kuusiPelaajaaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kolmePelaajaa)
                    .addComponent(viisiPelaajaa)
                    .addComponent(kuusiPelaajaa)
                    .addComponent(kaksiPelaajaa)
                    .addComponent(neljaPelaajaa))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(kaksiPelaajaa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kolmePelaajaa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(neljaPelaajaa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viisiPelaajaa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kuusiPelaajaa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pelaajien nimet"));

        jLabel1.setText("Pelaaja 1:");

        jLabel2.setText("Pelaaja 2:");

        jLabel3.setText("Pelaaja 3:");

        jLabel4.setText("Pelaaja 4:");

        jLabel5.setText("Pelaaja 5:");

        jLabel6.setText("Pelaaja 6:");

        pelaaja1Nimi.setText("Pelaaja 1");

        pelaaja2Nimi.setText("Pelaaja 2");

        pelaaja3Nimi.setText("Pelaaja 3");

        pelaaja5Nimi.setText("Pelaaja 5");

        pelaaja6Nimi.setText("Pelaaja 6");

        pelaaja4Nimi.setText("Pelaaja 4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pelaaja1Nimi, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pelaaja3Nimi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pelaaja2Nimi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pelaaja5Nimi)
                            .addComponent(pelaaja4Nimi)
                            .addComponent(pelaaja6Nimi))))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pelaaja1Nimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pelaaja2Nimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pelaaja3Nimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pelaaja4Nimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pelaaja5Nimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pelaaja6Nimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)))
        );

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kaksiPelaajaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaksiPelaajaaActionPerformed
        pelaaja3Nimi.setEnabled(false);
        pelaaja4Nimi.setEnabled(false);
        pelaaja5Nimi.setEnabled(false);
        pelaaja6Nimi.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel4.setEnabled(false);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
    }//GEN-LAST:event_kaksiPelaajaaActionPerformed

    private void kolmePelaajaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolmePelaajaaActionPerformed
        pelaaja3Nimi.setEnabled(true);
        pelaaja4Nimi.setEnabled(false);
        pelaaja5Nimi.setEnabled(false);
        pelaaja6Nimi.setEnabled(false);
        jLabel3.setEnabled(true);
        jLabel4.setEnabled(false);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
    }//GEN-LAST:event_kolmePelaajaaActionPerformed

    private void neljaPelaajaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neljaPelaajaaActionPerformed
        pelaaja3Nimi.setEnabled(true);
        pelaaja4Nimi.setEnabled(true);
        pelaaja5Nimi.setEnabled(false);
        pelaaja6Nimi.setEnabled(false);
        jLabel3.setEnabled(true);
        jLabel4.setEnabled(true);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
    }//GEN-LAST:event_neljaPelaajaaActionPerformed

    private void viisiPelaajaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viisiPelaajaaActionPerformed
        pelaaja3Nimi.setEnabled(true);
        pelaaja4Nimi.setEnabled(true);
        pelaaja5Nimi.setEnabled(true);
        pelaaja6Nimi.setEnabled(false);
        jLabel3.setEnabled(true);
        jLabel4.setEnabled(true);
        jLabel5.setEnabled(true);
        jLabel6.setEnabled(false);
    }//GEN-LAST:event_viisiPelaajaaActionPerformed

    private void kuusiPelaajaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kuusiPelaajaaActionPerformed
        pelaaja3Nimi.setEnabled(true);
        pelaaja4Nimi.setEnabled(true);
        pelaaja5Nimi.setEnabled(true);
        pelaaja6Nimi.setEnabled(true);
        jLabel3.setEnabled(true);
        jLabel4.setEnabled(true);
        jLabel5.setEnabled(true);
        jLabel6.setEnabled(true);
    }//GEN-LAST:event_kuusiPelaajaaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<String> nimet = new ArrayList();
        lisaaNimetListaan(nimet);
        boolean samuustarkastus = aloitus.samuustarkastus(nimet);
        boolean pituustarkastus = aloitus.pituustarkastus(nimet);
        if (samuustarkastus == false || pituustarkastus == false) {
            JOptionPane.showMessageDialog(rootPane, "Pelaajilla ei saa olla samoja nimiä ja niiden"
                    + " pituuden tulisi olla 1-24 merkkiä", "Väärä syöte",
                    JOptionPane.WARNING_MESSAGE);
        } else {
           this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lisaaNimetListaan(ArrayList<String> nimet) {
        nimet.add(pelaaja1Nimi.getText());
        nimet.add(pelaaja2Nimi.getText());

        if (kolmePelaajaa.isEnabled()) {
            nimet.add(pelaaja3Nimi.getText());
        }
        if (neljaPelaajaa.isEnabled()) {
            nimet.add(pelaaja4Nimi.getText());
        }
        if (viisiPelaajaa.isEnabled()) {
            nimet.add(pelaaja5Nimi.getText());
        }
        if (kuusiPelaajaa.isEnabled()) {
            nimet.add(pelaaja6Nimi.getText());
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AloitusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AloitusGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton kaksiPelaajaa;
    private javax.swing.JRadioButton kolmePelaajaa;
    private javax.swing.JRadioButton kuusiPelaajaa;
    private javax.swing.JRadioButton neljaPelaajaa;
    private javax.swing.JTextField pelaaja1Nimi;
    private javax.swing.JTextField pelaaja2Nimi;
    private javax.swing.JTextField pelaaja3Nimi;
    private javax.swing.JTextField pelaaja4Nimi;
    private javax.swing.JTextField pelaaja5Nimi;
    private javax.swing.JTextField pelaaja6Nimi;
    private javax.swing.JRadioButton viisiPelaajaa;
    // End of variables declaration//GEN-END:variables
    private Aloitus aloitus = new Aloitus();
}
