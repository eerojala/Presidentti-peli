package presidenttipeli.gui;

import presidenttipeli.logiikka.Presidentinvaalienhallinta;

/**
 *  GUI jonka avulla pelaaja pystyy hallitsemaan vaalikampanjaan käytettäviä varoja.
 */
public class PresidentinvaalienhallintaGUI extends javax.swing.JFrame implements Runnable {

    public PresidentinvaalienhallintaGUI(Presidentinvaalienhallinta hallinta, PeliGUI peligui) {
        this.hallinta = hallinta;
        this.peligui = peligui;
    }

    @Override
    public void run() {
        initComponents();
        asetaOikeatTiedotNakyviin();
        listener = new PresidentiinvaalienhallintaActionListener(okButton,
                liikkeet, mokit, vaihtoehto1, vaihtoehto2, vaihtoehto3, this,
                rootPane, peligui, hallinta);
        lisaaNappuloilleActionListener();
    }

    private void lisaaNappuloilleActionListener() {
        okButton.addActionListener(listener);
        vaihtoehto1.addActionListener(listener);
        vaihtoehto2.addActionListener(listener);
        vaihtoehto3.addActionListener(listener);
    }

    private void asetaOikeatTiedotNakyviin() {
        if (hallinta.getPelaaja().isKansanedustaja()) {
            asetaKansanedustajanTiedotNakyviin();
        } else {
            asetaJohtajanTiedotNakyviin();
        }
    }

    private void asetaKansanedustajanTiedotNakyviin() {
        vaihtoehto1.setText("40000 mk");
        vaihtoehto1Aanimaara.setText("100");
        vaihtoehto2.setText("30000 mk sekä liike tai mökki");
        vaihtoehto2Aanimaara.setText("90");
        vaihtoehto3.setText("10000 mk + tutkinto sekä liike tai mökki");
        vaihtoehto3Aanimaara.setText("75");
        otaPoisKansanedustajanVaihtoehtoja();
    }

    private void asetaJohtajanTiedotNakyviin() {
        vaihtoehto1.setText("50000 mk");
        vaihtoehto1Aanimaara.setText("110");
        vaihtoehto2.setText("40000 mk sekä liike tai mökki");
        vaihtoehto2Aanimaara.setText("100");
        vaihtoehto3.setText("20000 mk + tukinto sekä liike tai mökki");
        vaihtoehto3Aanimaara.setText("85");
        otaPoisJohtajanVaihtoehtoja();
    }

    private void otaPoisKansanedustajanVaihtoehtoja() {
        if (hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon1() == false) {
            vaihtoehto1.setEnabled(false);
            vaihtoehto1Aanimaara.setEnabled(false);
        }
        if (hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon2() == false) {
            vaihtoehto2.setEnabled(false);
            vaihtoehto2Aanimaara.setEnabled(false);
        }
        if (hallinta.pelaajaKykeneeKansanedustajanVaihtoehtoon3() == false) {
            vaihtoehto3.setEnabled(false);
            vaihtoehto3Aanimaara.setEnabled(false);
        }
    }

    private void otaPoisJohtajanVaihtoehtoja() {
        if (hallinta.pelaajaKykeneeJohtajanVaihtoehtoon1() == false) {
            vaihtoehto1.setEnabled(false);
            vaihtoehto1Aanimaara.setEnabled(false);
        }
        if (hallinta.pelaajaKykeneeJohtajanVaihtoehtoon2() == false) {
            vaihtoehto2.setEnabled(false);
            vaihtoehto2Aanimaara.setEnabled(false);
        }
        if (hallinta.pelaajaKykeneeJohtajanVaihtoehtoon3() == false) {
            vaihtoehto3.setEnabled(false);
            vaihtoehto3Aanimaara.setEnabled(false);
        }
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
        jLabel1 = new javax.swing.JLabel();
        pelaajanNimi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pelaajanRahat = new javax.swing.JLabel();
        vaihtoehto1 = new javax.swing.JRadioButton();
        vaihtoehto2 = new javax.swing.JRadioButton();
        vaihtoehto3 = new javax.swing.JRadioButton();
        mokit = new javax.swing.JComboBox();
        liikkeet = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        vaihtoehto1Aanimaara = new javax.swing.JLabel();
        vaihtoehto2Aanimaara = new javax.swing.JLabel();
        vaihtoehto3Aanimaara = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                sulje(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Pelaaja:");

        pelaajanNimi.setText(hallinta.getPelaaja().getNimi());

        jLabel3.setText("Rahat:");

        pelaajanRahat.setText(hallinta.getPelaaja().getRahat() + " mk");

        buttonGroup1.add(vaihtoehto1);
        vaihtoehto1.setText("jRadioButton1");

        buttonGroup1.add(vaihtoehto2);
        vaihtoehto2.setText("jRadioButton1");

        buttonGroup1.add(vaihtoehto3);
        vaihtoehto3.setText("jRadioButton2");

        mokit.setModel(new javax.swing.DefaultComboBoxModel(hallinta.getMokit()));

        liikkeet.setModel(new javax.swing.DefaultComboBoxModel(hallinta.getLiikkeet()));

        jLabel5.setText("Vaihtoehdot:");

        jLabel6.setText("Tarvittavat äänimäärät:");

        okButton.setText("OK");

        vaihtoehto1Aanimaara.setText("jLabel7");

        vaihtoehto2Aanimaara.setText("jLabel7");

        vaihtoehto3Aanimaara.setText("jLabel7");

        jLabel2.setText("Pelaajan mökit:");

        jLabel4.setText("Pelaajan liikkeet:");

        cancelButton.setText("Peruuta");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(vaihtoehto2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vaihtoehto2Aanimaara))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(vaihtoehto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vaihtoehto1Aanimaara))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pelaajanNimi)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(liikkeet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pelaajanRahat)
                                                .addGap(12, 12, 12))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(okButton)
                                                .addGap(87, 87, 87))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(vaihtoehto3)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(vaihtoehto3Aanimaara)))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mokit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pelaajanNimi))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pelaajanRahat)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaihtoehto1)
                    .addComponent(vaihtoehto1Aanimaara))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaihtoehto2)
                    .addComponent(vaihtoehto2Aanimaara))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaihtoehto3)
                    .addComponent(vaihtoehto3Aanimaara))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mokit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(liikkeet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void sulje(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_sulje
        peligui.setVisible(true);
        peligui.setEnabled(true);
    }//GEN-LAST:event_sulje


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox liikkeet;
    private javax.swing.JComboBox mokit;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel pelaajanNimi;
    private javax.swing.JLabel pelaajanRahat;
    private javax.swing.JRadioButton vaihtoehto1;
    private javax.swing.JLabel vaihtoehto1Aanimaara;
    private javax.swing.JRadioButton vaihtoehto2;
    private javax.swing.JLabel vaihtoehto2Aanimaara;
    private javax.swing.JRadioButton vaihtoehto3;
    private javax.swing.JLabel vaihtoehto3Aanimaara;
    // End of variables declaration//GEN-END:variables
    private Presidentinvaalienhallinta hallinta;
    private PresidentiinvaalienhallintaActionListener listener;
    private PeliGUI peligui;
}
