
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class CalisanEkrani extends javax.swing.JDialog {
    DefaultTableModel model;
    CalisanIslemleri islemler = new CalisanIslemleri();
    /**
     * Creates new form CalisanEkrani
     */
    public CalisanEkrani(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel)calisanTablosu.getModel();
        calisanGoruntule();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        calisanTablosu = new javax.swing.JTable();
        aramaCubugu = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        adAlani = new javax.swing.JTextField();
        soyadAlani = new javax.swing.JTextField();
        departmanAlani = new javax.swing.JTextField();
        maasAlani = new javax.swing.JTextField();
        calisanEkle = new javax.swing.JButton();
        mesajYazisi = new javax.swing.JLabel();
        guncelle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(600, 100));

        calisanTablosu.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Ad", "Soyad", "Departman", "Maaş"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calisanTablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calisanTablosuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(calisanTablosu);
        if (calisanTablosu.getColumnModel().getColumnCount() > 0) {
            calisanTablosu.getColumnModel().getColumn(0).setResizable(false);
            calisanTablosu.getColumnModel().getColumn(1).setResizable(false);
            calisanTablosu.getColumnModel().getColumn(2).setResizable(false);
            calisanTablosu.getColumnModel().getColumn(3).setResizable(false);
            calisanTablosu.getColumnModel().getColumn(4).setResizable(false);
        }

        aramaCubugu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramaCubuguKeyReleased(evt);
            }
        });

        jLabel1.setText("Ad:");

        jLabel2.setText("Soyad:");

        jLabel3.setText("Departman:");

        jLabel4.setText("Maaş:");

        calisanEkle.setText("Yeni Çalışan Ekle");
        calisanEkle.addActionListener(this::calisanEkleActionPerformed);

        mesajYazisi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesajYazisi.setForeground(new java.awt.Color(255, 0, 51));

        guncelle.setText("Çalışan Güncelle");
        guncelle.addActionListener(this::guncelleActionPerformed);

        jButton1.setText("Çalışan Sil");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1)
                                                        .addComponent(aramaCubugu))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(mesajYazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(jLabel1))
                                                        .addComponent(jLabel2))
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(soyadAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(departmanAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(maasAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(calisanEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(adAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(departmanAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(calisanEkle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4)
                                                .addComponent(soyadAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(maasAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(guncelle)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(12, 12, 12)
                                .addComponent(mesajYazisi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    public void dinamikAra(String ara) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        calisanTablosu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(ara));
    }
    private void aramaCubuguKeyReleased(java.awt.event.KeyEvent evt) {
        String ara = aramaCubugu.getText();

        dinamikAra(ara);
    }

    private void calisanEkleActionPerformed(java.awt.event.ActionEvent evt) {
        mesajYazisi.setText("");

        String ad = adAlani.getText();
        String soyad = soyadAlani.getText();
        String departman = departmanAlani.getText();
        String maas = maasAlani.getText();

        islemler.calisanEkle(ad, soyad, departman, maas);
        calisanGoruntule();
        mesajYazisi.setForeground(Color.GREEN);
        mesajYazisi.setText("Yeni çalışan başarıyla eklendi!");
    }

    private void calisanTablosuMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = calisanTablosu.getSelectedRow();

        adAlani.setText(model.getValueAt(selectedRow, 1).toString());
        soyadAlani.setText(model.getValueAt(selectedRow, 2).toString());
        departmanAlani.setText(model.getValueAt(selectedRow, 3).toString());
        maasAlani.setText(model.getValueAt(selectedRow, 4).toString());
    }

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {
        mesajYazisi.setForeground(Color.red);
        String ad = adAlani.getText();
        String soyad = soyadAlani.getText();
        String departman = departmanAlani.getText();
        String maas = maasAlani.getText();

        int selectedRow = calisanTablosu.getSelectedRow();

        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                mesajYazisi.setText("Çalışanlar tablosunda herhangi bir veri bulunmamaktadır.");
            }
            else {
                mesajYazisi.setText("Lütfen güncellenecek bir çalışan seçin.");
            }
        }
        else {
            int id = (int)model.getValueAt(selectedRow, 0);

            islemler.calisanGuncelle(id, ad, soyad, departman, maas);
            calisanGoruntule();
            mesajYazisi.setForeground(Color.GREEN);
            mesajYazisi.setText("Çalışan başarıyla güncellendi.");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        mesajYazisi.setForeground(Color.red);
        mesajYazisi.setText("");

        int selectedRow = calisanTablosu.getSelectedRow();

        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                mesajYazisi.setText("Çalışanlar tablosunda şu anda herhangi bir veri bulunmamaktadır.");
            }
            else {
                mesajYazisi.setText("Lütfen silinecek bir çalışan seçin.");
            }

        }
        else {
            int id = (int)model.getValueAt(selectedRow, 0);

            islemler.calisanSil(id);
            calisanGoruntule();
            mesajYazisi.setForeground(Color.GREEN);
            mesajYazisi.setText("Çalışan başarıyla silindi.");
        }
    }


    public void calisanGoruntule() {
        model.setRowCount(0);
        ArrayList<Calisan> calisanlar;
        calisanlar = islemler.calisanlariGetir();

        if (!calisanlar.isEmpty()) {
            for (Calisan calisan : calisanlar) {
                Object[] eklenecek = {calisan.getId(), calisan.getAd(), calisan.getSoyad(), calisan.getDepartman(), calisan.getMaas()};
                model.addRow(eklenecek);
            }
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
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalisanEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            CalisanEkrani dialog = new CalisanEkrani(new JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField adAlani;
    private javax.swing.JTextField aramaCubugu;
    private javax.swing.JButton calisanEkle;
    private javax.swing.JTable calisanTablosu;
    private javax.swing.JTextField departmanAlani;
    private javax.swing.JButton guncelle;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField maasAlani;
    private javax.swing.JLabel mesajYazisi;
    private javax.swing.JTextField soyadAlani;
    // End of variables declaration
}
