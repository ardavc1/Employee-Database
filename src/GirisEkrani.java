
import javax.swing.*;
import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Arda Avcı
 */
public class GirisEkrani extends javax.swing.JFrame {
    CalisanIslemleri islemler = new CalisanIslemleri();
    /**
     * Creates new form GirisEkrani
     */
    public GirisEkrani() {
        initComponents();
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kullaniciAdiAlani = new javax.swing.JTextField();
        parolaAlani = new javax.swing.JPasswordField();
        giris = new javax.swing.JButton();
        mesajYazisi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(600, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel1.setText("Kullanıcı Adı:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel2.setText("Parola:");

        giris.setText("Giriş Yap");
        giris.addActionListener(this::girisActionPerformed);

        mesajYazisi.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(mesajYazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(77, 77, 77)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1)
                                                                .addComponent(jLabel2))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(kullaniciAdiAlani)
                                                                .addComponent(parolaAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(205, 205, 205)
                                                        .addComponent(giris, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(kullaniciAdiAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(parolaAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(mesajYazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(giris, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }

    private void girisActionPerformed(java.awt.event.ActionEvent evt) {
        mesajYazisi.setText("");
        String kullaniciAdi = kullaniciAdiAlani.getText();
        String parola = new String(parolaAlani.getPassword());

        boolean girisBasarili = islemler.girisYap(kullaniciAdi, parola);

        if (girisBasarili) {
            CalisanEkrani calisanEkrani = new CalisanEkrani(this, true);
            setVisible(false);
            calisanEkrani.setVisible(true);
            System.exit(0);
        }
        else {
            mesajYazisi.setForeground(Color.red);
            mesajYazisi.setText("Giriş başarısız! Lütfen tekrar deneyin.");
        }
    }


    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GirisEkrani().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton giris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField kullaniciAdiAlani;
    private javax.swing.JLabel mesajYazisi;
    private javax.swing.JPasswordField parolaAlani;
    // End of variables declaration
}
