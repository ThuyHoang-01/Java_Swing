/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.KhachHang;
import Entity.mycombobox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class GUI_timkiemKH extends javax.swing.JFrame {

    /**
     * Creates new form GUI_khachhang
     */
    public GUI_timkiemKH() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KH = new javax.swing.JTable();
        txt_timkiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tìm Kiếm Khách Hàng");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Tìm Kiếm Khách Hàng");

        tbl_KH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã KH", "Loại KH", "Tên", "Tuổi", "Giới tính", "Số điện thoại", "Số CMND"
            }
        ));
       /* tbl_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KHMouseClicked(evt);
            }
        });*/
        jScrollPane1.setViewportView(tbl_KH);

        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyReleased(evt);
            }
        });

        jLabel8.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(300, 300, 300))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   

    }                                  

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        loadData_loaiKH();

        BLL.BLL_dodulieuKH.dodulieuKH(tbl_KH);
    }                                 

  /*  private void tbl_KHMouseClicked(java.awt.event.MouseEvent evt) {                                    
        int dongchon = tbl_KH.getSelectedRowCount();
        if (dongchon == 1) {
            btn_sua.setEnabled(true);
            int vitri = tbl_KH.getSelectedRow();
            txt_ten.setText(tbl_KH.getValueAt(vitri, 3).toString());
            spn_tuoi.setValue(tbl_KH.getValueAt(vitri, 4));
            cbb_gioitinh.setSelectedItem(tbl_KH.getValueAt(vitri, 5));
            txt_sdt.setText(tbl_KH.getValueAt(vitri, 6).toString());
            txt_cmnd.setText(tbl_KH.getValueAt(vitri, 7).toString());

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_loaiKH.getModel();
            for (int i = 0; i < cbb_loaiKH.getItemCount(); i++) {
                DTO.mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
                String tenLoai = mb.text.toString();
                if (tenLoai.equals(tbl_KH.getValueAt(vitri, 2))) {
                    cbb_loaiKH.setSelectedIndex(i);
                }
            }
        } else {
            btn_sua.setEnabled(false);
        }
    }      */                             

    private void txt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {                                        
      String tuKhoa=txt_timkiem.getText();
      BLL.BLL_dodulieuKH.dodulieuTimKiem(tbl_KH, tuKhoa);
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
            java.util.logging.Logger.getLogger(GUI_timkiemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_timkiemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_timkiemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_timkiemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_timkiemKH().setVisible(true);
            }
        });
    }

    private void loadData_loaiKH() {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_loaiKH.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.KhachHang.loaiKH();
        try {
            while (rs.next()) {
                Object tenLoai = rs.getString("tenloaiKH");
                Object maLoai = rs.getInt("maloaiKH");
                Entity.mycombobox mb = new mycombobox(maLoai, tenLoai);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {

        }
    }

    // Variables declaration - do not modify  
    private javax.swing.JComboBox<String> cbb_loaiKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbl_KH;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration                   
}
