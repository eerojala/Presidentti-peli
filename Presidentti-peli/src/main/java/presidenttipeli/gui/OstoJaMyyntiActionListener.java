
package presidenttipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import presidenttipeli.logiikka.OstoJaMyynti;
 
public class OstoJaMyyntiActionListener implements ActionListener{
    private JButton myyLiike;
    private JButton myyMokki;
    private JButton okButton;
    private JButton ostaLiike;
    private JButton ostaMokki;
    private JComboBox pelaajanLiikkeet;
    private JComboBox pelaajanMokit;
    private JFrame frame;
    private OstoJaMyynti ostoJaMyynti;

    public OstoJaMyyntiActionListener(JButton myyLiike, JButton myyMokki, JButton okButton, JButton ostaLiike, JButton ostaMokki, JComboBox pelaajanLiikkeet, JComboBox pelaajanMokit, JFrame frame, OstoJaMyynti ostoJaMyynti) {
        this.myyLiike = myyLiike;
        this.myyMokki = myyMokki;
        this.okButton = okButton;
        this.ostaLiike = ostaLiike;
        this.ostaMokki = ostaMokki;
        this.pelaajanLiikkeet = pelaajanLiikkeet;
        this.pelaajanMokit = pelaajanMokit;
        this.frame = frame;
        this.ostoJaMyynti = ostoJaMyynti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myyLiike) {
            myyLiike();
        } else if (e.getSource() == myyMokki) {
            myyMokki();
        } else if (e.getSource() == ostaLiike) {
            ostaLiike();
        } else if (e.getSource() == ostaMokki) {
            ostaMokki();
        } else if (e.getSource() == okButton) {
            ostoJaMyynti.vieLiikePinonPohjalle();
            ostoJaMyynti.vieMokkiPinonPohjalle();
        }
        frame.dispose();
    }
    
    private void myyLiike() {
        ostoJaMyynti.myyLiike(pelaajanLiikkeet.getSelectedIndex());
    } 
    
    private void myyMokki() {
        ostoJaMyynti.myyMokki(pelaajanLiikkeet.getSelectedIndex());
    }
    
    private void ostaLiike() {
        ostoJaMyynti.ostaLiike(ostoJaMyynti.getPaallimmainenLiike());
    }
    
    private void ostaMokki() {
        ostoJaMyynti.ostaMokki(ostoJaMyynti.getPaallimmainenMokki());
    }
    
    
}
