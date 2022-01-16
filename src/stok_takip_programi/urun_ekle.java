/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_takip_programi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CASPER
 */
public class urun_ekle extends javax.swing.JFrame {

    /**
     * Creates new form urun_ekle
     */
    private void UrunListeGuncelle(){
    
     try {
             String baslik[] = new String[]{"Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };  
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();                
            rs = st.executeQuery("select * from urunler");
            rs.last();
           
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    rs.getString("kategori"),  
                    rs.getString("urunadi"),
                    rs.getString("beden"),
                    rs.getString("renk"),  
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("aciklama"), 
                };
                i++;
            }
           
            con.close();
            table_urunler.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    private static JFrame gelenform;
    public urun_ekle() {
        
        super("Ürün Ekleme Formu");       
      
        initComponents();
        
        
        
        UrunListeGuncelle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ekle = new javax.swing.JButton();
        lbl_kategori = new javax.swing.JLabel();
        lbl_adi = new javax.swing.JLabel();
        lbl_renk = new javax.swing.JLabel();
        lbl_fiyat = new javax.swing.JLabel();
        txt_kategori = new javax.swing.JTextField();
        txt_fiyat = new javax.swing.JTextField();
        txt_renk = new javax.swing.JTextField();
        txt_adi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_urunler = new javax.swing.JTable();
        txt_guncelle = new javax.swing.JButton();
        txt_sil = new javax.swing.JButton();
        lbl_renk1 = new javax.swing.JLabel();
        txt_beden = new javax.swing.JTextField();
        lbl_fiyat1 = new javax.swing.JLabel();
        txt_adet = new javax.swing.JTextField();
        lbl_fiyat2 = new javax.swing.JLabel();
        txt_aciklama = new javax.swing.JTextField();
        lbl_filtrele = new javax.swing.JLabel();
        txt_ara = new javax.swing.JTextField();
        btn_ara = new javax.swing.JButton();
        btn_cikis = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(853, 560));
        setPreferredSize(new java.awt.Dimension(853, 560));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btn_ekle.setText("Ürünü Ekle");
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ekle);
        btn_ekle.setBounds(160, 390, 100, 25);

        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori);
        lbl_kategori.setBounds(20, 100, 70, 15);

        lbl_adi.setText("Ürün Adı");
        getContentPane().add(lbl_adi);
        lbl_adi.setBounds(20, 140, 70, 20);

        lbl_renk.setText("Renk");
        getContentPane().add(lbl_renk);
        lbl_renk.setBounds(20, 220, 80, 15);

        lbl_fiyat.setText("Fiyat");
        getContentPane().add(lbl_fiyat);
        lbl_fiyat.setBounds(20, 260, 70, 15);
        getContentPane().add(txt_kategori);
        txt_kategori.setBounds(110, 90, 170, 30);
        getContentPane().add(txt_fiyat);
        txt_fiyat.setBounds(110, 250, 170, 30);
        getContentPane().add(txt_renk);
        txt_renk.setBounds(110, 210, 170, 30);
        getContentPane().add(txt_adi);
        txt_adi.setBounds(110, 130, 170, 30);

        table_urunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_urunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_urunlerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_urunler);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 90, 520, 402);

        txt_guncelle.setText("Güncelle");
        txt_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(txt_guncelle);
        txt_guncelle.setBounds(160, 420, 100, 25);

        txt_sil.setText("Sil");
        txt_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_silActionPerformed(evt);
            }
        });
        getContentPane().add(txt_sil);
        txt_sil.setBounds(160, 450, 100, 25);

        lbl_renk1.setText("Beden");
        getContentPane().add(lbl_renk1);
        lbl_renk1.setBounds(20, 180, 70, 15);
        getContentPane().add(txt_beden);
        txt_beden.setBounds(110, 170, 170, 30);

        lbl_fiyat1.setText("Adet");
        getContentPane().add(lbl_fiyat1);
        lbl_fiyat1.setBounds(20, 300, 70, 15);
        getContentPane().add(txt_adet);
        txt_adet.setBounds(110, 290, 170, 30);

        lbl_fiyat2.setText("Açıklama");
        getContentPane().add(lbl_fiyat2);
        lbl_fiyat2.setBounds(20, 340, 80, 15);
        getContentPane().add(txt_aciklama);
        txt_aciklama.setBounds(110, 330, 170, 30);

        lbl_filtrele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_filtrele.setText("Filtrele");
        getContentPane().add(lbl_filtrele);
        lbl_filtrele.setBounds(400, 50, 50, 17);
        getContentPane().add(txt_ara);
        txt_ara.setBounds(450, 40, 170, 30);

        btn_ara.setText("Ara");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ara);
        btn_ara.setBounds(640, 40, 52, 25);

        btn_cikis.setText("ÇIKIŞ");
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cikis);
        btn_cikis.setBounds(739, 20, 90, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stok_takip_programi/background.jpg"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(850, 550));
        jLabel1.setPreferredSize(new java.awt.Dimension(850, 550));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ekleActionPerformed
                
            String kategori=txt_kategori.getText();
            String adi=txt_adi.getText();
            String beden=txt_beden.getText();
            String renk=txt_renk.getText();
            String fiyat=txt_fiyat.getText();
            String adet=txt_adet.getText();
            String aciklama=txt_aciklama.getText();
                
            try {
                    
                if (kategori.equals("") || adi.equals("") || renk.equals("") || fiyat.equals("")) {

                    JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

                } else {            
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    
                    con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
                    st = con.createStatement();
                    
                    String sql = "INSERT INTO urunler (kategori,urunadi,beden,renk,fiyat,adet,aciklama)" 
                            + " VALUES ('"+kategori+"', '"+adi+"', '"+beden+"', '"+renk+"', '"+fiyat+"', '"+adet+"', '"+aciklama+"')";

                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, adi + "  adlı ürün eklenmiştir.");
                    UrunListeGuncelle();
            
                }
            
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
            }  
            
            
        
    }//GEN-LAST:event_btn_ekleActionPerformed

    private void btn_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_araActionPerformed
        
        String ara =txt_ara.getText();
        String baslik[] = new String[]{"Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" }; 

        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            String sorgu ="select * from urunler where urunadi like '%"+txt_ara.getText()+"%' or"
                    +" kategori like '%"+txt_ara.getText()+"%' or"
                    +" beden like '%"+txt_ara.getText()+"%' or"
                    +" renk like '%"+txt_ara.getText()+"%' ";
            
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
            
            rs.last();
           
            int say = rs.getRow();
            rs.beforeFirst();
 
            
            String sayi = null;                
            sayi = String.valueOf(rs.getRow());                

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Ürün Bulunamadı!");
            }
            else{
                
                Object data[][] = new Object[say][];
                int i = 0;
                
                while (rs.next()) {

                    data[i] = new Object[]{ 
                        
                        rs.getString("kategori"),  
                        rs.getString("urunadi"),
                        rs.getString("beden"),
                        rs.getString("renk"),  
                        rs.getString("fiyat"),
                        rs.getString("adet"),
                        rs.getString("aciklama"),
                    };
                    i++;
                }
                table_urunler.setModel(new DefaultTableModel(data, baslik));
            }
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
    }//GEN-LAST:event_btn_araActionPerformed

    private void table_urunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_urunlerMouseClicked
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement st1 =null;
        
        
        try {
        
            int row = table_urunler.getSelectedRow();
            int satir=row+1;
            String secim_yap=(table_urunler.getValueAt(row, 1).toString());
           
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            String sorgu = "select * from urunler where id='"+satir+"'";
            //st = con.createStatement(); 
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
            
            if(rs.last()){
                
                txt_kategori.setText(rs.getString("kategori"));
                txt_adi.setText(rs.getString("urunadi"));
                txt_beden.setText(rs.getString("beden"));
                txt_renk.setText(rs.getString("renk"));
                txt_fiyat.setText(rs.getString("fiyat"));
                txt_adet.setText(rs.getString("adet"));
                txt_aciklama.setText(rs.getString("aciklama"));
            }
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }

    }//GEN-LAST:event_table_urunlerMouseClicked

    private void txt_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_guncelleActionPerformed
        
        try {
            
            int row = table_urunler.getSelectedRow();            
            String secim=(table_urunler.getValueAt(row, 0).toString());
            int satir=row+1;
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu = "UPDATE urunler SET kategori='"+txt_kategori.getText()+"'"
                    +",urunadi='"+txt_adi.getText()+"'"
                    +",beden='"+txt_beden.getText()+"'"
                    +",renk='"+txt_renk.getText()+"'"
                    +",fiyat='"+txt_fiyat.getText()+"'"
                    +",adet='"+txt_adet.getText()+"'"
                    +",aciklama='"+txt_aciklama.getText()+"' where id='"+satir+"'";
                    
          
            st = con.createStatement();
            st.executeUpdate(sorgu);

            JOptionPane.showMessageDialog(null, "Ürün Güncellemesi Tamamlanmıştır.");

            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        UrunListeGuncelle();
        
    }//GEN-LAST:event_txt_guncelleActionPerformed

    private void btn_cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cikisActionPerformed
        
        urun_ekle a = new urun_ekle();
        a.setVisible(false);
        dispose();
        
    }//GEN-LAST:event_btn_cikisActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        
    }//GEN-LAST:event_formWindowClosing

    private void txt_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_silActionPerformed
        
        try {
            
            int row = table_urunler.getSelectedRow();            
            String secim=(table_urunler.getValueAt(row, 0).toString());
            int satir=row+1;
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu = "delete from urunler where id='"+satir+"'";
                    
          
            st = con.createStatement();
            st.executeUpdate(sorgu);

            JOptionPane.showMessageDialog(null, "Ürün Başarıyla Silinmiştir");

            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        UrunListeGuncelle();
        
    }//GEN-LAST:event_txt_silActionPerformed

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
            java.util.logging.Logger.getLogger(urun_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(urun_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(urun_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(urun_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new urun_ekle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton btn_ekle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_adi;
    private javax.swing.JLabel lbl_filtrele;
    private javax.swing.JLabel lbl_fiyat;
    private javax.swing.JLabel lbl_fiyat1;
    private javax.swing.JLabel lbl_fiyat2;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_renk;
    private javax.swing.JLabel lbl_renk1;
    private javax.swing.JTable table_urunler;
    private javax.swing.JTextField txt_aciklama;
    private javax.swing.JTextField txt_adet;
    private javax.swing.JTextField txt_adi;
    private javax.swing.JTextField txt_ara;
    private javax.swing.JTextField txt_beden;
    private javax.swing.JTextField txt_fiyat;
    private javax.swing.JButton txt_guncelle;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_renk;
    private javax.swing.JButton txt_sil;
    // End of variables declaration//GEN-END:variables
}