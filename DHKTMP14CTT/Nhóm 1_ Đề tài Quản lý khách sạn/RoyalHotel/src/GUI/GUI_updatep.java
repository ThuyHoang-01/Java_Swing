
package GUI;

import Entity.Phong;
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
public class GUI_updatep extends javax.swing.JFrame {

   
    public GUI_updatep() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        cbb_gioitinh = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KH = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Khách hàng");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Cập Nhật Phòng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tên Phòng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Trạng Thái");

        cbb_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưathuê", "Đangthuê" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/thêm.jpg"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/xóa.png"))); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/sửa.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setEnabled(false);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btn_sua)
                .addContainerGap())
        );

        tbl_KH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên phòng", "Trạng thái"
            }
        ));
        tbl_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txt_ten)
                    .addComponent(cbb_gioitinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbb_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   

    }                                  

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
    	BLL.BLL_dodulieuPhong.dodulieuPhong(tbl_KH);
    }                                 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Entity.Phong kh = new Entity.Phong();
        kh.setTenPhong(txt_ten.getText());
        
        kh.setTrangthai(cbb_gioitinh.getSelectedItem().toString()); 
        String tenphong = toString();
        DAO.Phong.themP(kh, tenphong);
        
        
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_KH.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                int maphong = Integer.parseInt(tbl_KH.getValueAt(cacdong[i], 1).toString());
                DAO.Phong.xoaP(maphong);
            }
            
        }
    }                                        

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (tbl_KH.getSelectedRowCount() != 1) {
            thongbao.thongbao("chỉ chọn 1 dòng để sửa", "thông báo");
            return;
        } else {
            int vitri = tbl_KH.getSelectedRow();

            Entity.Phong kh_sua = new Entity.Phong();
            kh_sua.setTenPhong(txt_ten.getText());
            
            kh_sua.setTrangthai(cbb_gioitinh.getSelectedItem().toString());
           
            String tenphong = toString();
            String maphong=tbl_KH.getValueAt(vitri, 1).toString();
            DAO.Phong.suaP(kh_sua, tenphong);
            BLL.BLL_dodulieuKH.dodulieuKH(tbl_KH);
           
        }
    }                                       

    private void tbl_KHMouseClicked(java.awt.event.MouseEvent evt) {                                    
        int dongchon = tbl_KH.getSelectedRowCount();
        if (dongchon == 1) {
            btn_sua.setEnabled(true);
            int vitri = tbl_KH.getSelectedRow();
            txt_ten.setText(tbl_KH.getValueAt(vitri, 1).toString());
            
            cbb_gioitinh.setSelectedItem(tbl_KH.getValueAt(vitri, 2));
           

         /*   DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_loaiKH.getModel();
            for (int i = 0; i < cbb_loaiKH.getItemCount(); i++) {
                DTO.mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
                String tenLoai = mb.text.toString();
                if (tenLoai.equals(tbl_KH.getValueAt(vitri, 2))) {
                    cbb_loaiKH.setSelectedIndex(i);
                }
            }*/
        } else {
            btn_sua.setEnabled(false);
        }
    }                                   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_updatep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_updatep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_updatep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_updatep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_updatep().setVisible(true);
            }
        });
    }

   /* private void loadData_loaiKH() {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_loaiKH.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.DAO_khachhang.loaiKH();
        try {
            while (rs.next()) {
                Object tenLoai = rs.getString("tenloaiKH");
                Object maLoai = rs.getInt("maloaiKH");
                DTO.mycombobox mb = new mycombobox(maLoai, tenLoai);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {

        }
    }*/

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_sua;
    private javax.swing.JComboBox<String> cbb_gioitinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_KH;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration                   
}
