package presidenttipeli.gui;

import presidenttipeli.logiikka.Peli;

/**
 * GUI joka kysyy haluaako pelaaja osallistua ruudun 25 vaaleihin.
 */
public class Ruutu25KyselyGUI extends javax.swing.JFrame implements Runnable {

    public Ruutu25KyselyGUI(PeliGUI peligui, Peli peli) {
        this.peligui = peligui;
        this.peli = peli;
    }

    @Override
    public void run() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pelaajanAmmatti = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ammattiSalliiKansanedustajuuden = new javax.swing.JLabel();
        kyllaButton = new javax.swing.JButton();
        eiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Haluatko osallistua kansanedustajanvaaleihin?");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                sulje(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nykyinen ammattisi:");

        pelaajanAmmatti.setText(peli.getNykyinenPelaaja().getAmmatti().toString());

        jLabel2.setText("Salliiko ammattisi kansanedustajuuden:");

        ammattiSalliiKansanedustajuuden.setText(peli.getNykyinenPelaaja().getAmmatti().salliiKansanedustajuuden() + "");

        kyllaButton.setText("Kyllä");
        kyllaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kyllaButtonActionPerformed(evt);
            }
        });

        eiButton.setText("Ei");
        eiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pelaajanAmmatti))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ammattiSalliiKansanedustajuuden))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(kyllaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eiButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pelaajanAmmatti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ammattiSalliiKansanedustajuuden))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kyllaButton)
                    .addComponent(eiButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kyllaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kyllaButtonActionPerformed
        peli.getVaalienjarjestaja().jarjestaEduskuntavaalit(80, peli.getNykyinenPelaaja());
        peligui.ilmoitaTulos(peli.getNykyinenPelaaja().isKansanedustaja(), 
                peli.getVaalienjarjestaja().getSaadutAanet(),
                peli.getVaalienjarjestaja().getSaadutAanetSummattuna(), 80);
        this.dispose();
    }//GEN-LAST:event_kyllaButtonActionPerformed

    private void sulje(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_sulje
        peligui.setVisible(true);
        peligui.setEnabled(true);
    }//GEN-LAST:event_sulje

    private void eiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eiButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_eiButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ammattiSalliiKansanedustajuuden;
    private javax.swing.JButton eiButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kyllaButton;
    private javax.swing.JLabel pelaajanAmmatti;
    // End of variables declaration//GEN-END:variables
    private PeliGUI peligui;
    private Peli peli;
}
