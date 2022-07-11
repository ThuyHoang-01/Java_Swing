/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ADMIN
 */
public class GUI_suataikhoan extends javax.swing.JFrame {

    
    public GUI_suataikhoan() {
        initComponents();
        setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        txt_pass = new JPasswordField();
        cbb_quyen = new JComboBox<>();
        txt_hovaten = new JTextField();
        txt_email = new JTextField();
        btn_sua = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Sửa tài khoản");

        jLabel3.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        jLabel4.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Quyền:");

        jLabel5.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Họ và tên:");

        jLabel6.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Email:");

        cbb_quyen.setModel(new DefaultComboBoxModel<>(new String[] { "quanly", "nhanvien", "none" }));

        btn_sua.setBackground(new java.awt.Color(255, 255, 0));
        btn_sua.setText("SỬA");
        btn_sua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(185, 185, 185))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, GroupLayout.Alignment.TRAILING))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_pass)
                        .addComponent(cbb_quyen, 0, 194, Short.MAX_VALUE)
                        .addComponent(txt_hovaten)
                        .addComponent(txt_email)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbb_quyen, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_hovaten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_email,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
        setLocationRelativeTo(null);
    }
public static String passtheoten;
    private void formWindowOpened(WindowEvent evt) {
        ResultSet rs = DAO.User.layUser_theoTen(GUI_taikhoan.tendangnhap);                                                           
        try {
            if (rs.next()) {

                txt_email.setText(rs.getString("email"));
                txt_hovaten.setText(rs.getString("hovaten"));
                cbb_quyen.setSelectedItem(rs.getString("role"));
                 passtheoten = rs.getString("password");
           
            }
             
        } catch (SQLException ex) {
            thongbao.thongbao("lỗi ", "thông báo");
        }
    }

    private void btn_suaActionPerformed(ActionEvent evt) {
        String pass = String.valueOf(txt_pass.getPassword());
        String quyen = cbb_quyen.getSelectedItem().toString();
        String hovaten = txt_hovaten.getText();
        String email = txt_email.getText();
      boolean kt= BLL.BLL_dangky.kt_SuaTK(pass, quyen, email, hovaten);
        if (kt) {
            txt_email.setText("");
            txt_hovaten.setText("");
            
        }else{}
    }

    private void formWindowClosed(WindowEvent evt) {
       GUI_taikhoan frm=new GUI_taikhoan();
       frm.setVisible(true);
    }

    
    public static void main(String args[]) {
       
        try {
            for (UIManager.LookAndFeelInfo info :UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                   UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_suataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_suataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
           Logger.getLogger(GUI_suataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_suataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_suataikhoan().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btn_sua;
    private javax.swing.JComboBox<String> cbb_quyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hovaten;
    private javax.swing.JPasswordField txt_pass;
    
}
