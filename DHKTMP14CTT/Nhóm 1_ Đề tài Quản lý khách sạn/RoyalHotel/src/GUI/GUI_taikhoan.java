/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ADMIN
 */
public class GUI_taikhoan extends javax.swing.JFrame {

   
    public GUI_taikhoan() {
        initComponents();
        
        setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tbl_user = new JTable();
        jPanel1 = new JPanel();
        jButton2 = new JButton();
        btn_sua = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tài khoản");
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 0, 36)); 
        jLabel1.setText("Quản lý tài khoản");

        tbl_user.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên đăng nhập", "Họ và tên ", "Email"
            }
        ));
        tbl_user.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jButton2.setBackground(new Color(255, 255, 255));
        jButton2.setFont(new Font("Tahoma", 0, 18));
        jButton2.setIcon(new ImageIcon(getClass().getResource("/hinh/xóa.png"))); 
        jButton2.setText("Xóa");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new Color(255, 255, 255));
        btn_sua.setFont(new Font("Tahoma", 0, 18)); 
        btn_sua.setIcon(new ImageIcon(getClass().getResource("/hinh/sửa.png"))); 
        btn_sua.setText("Sửa");
        btn_sua.setEnabled(false);
        btn_sua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btn_sua))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1)
                        .addGap(0, 294, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowOpened(WindowEvent evt) {
        BLL.BLL_dodulieu_TaiKhoan.dodulieu(tbl_user);
    }
public static String tendangnhap;
    private void tbl_userMouseClicked(MouseEvent evt) {
        if (tbl_user.getSelectedColumnCount() == 1) {
            btn_sua.setEnabled(true);
            int  vitri=tbl_user.getSelectedRow();
            tendangnhap=tbl_user.getValueAt(vitri, 1).toString();
            
        } else {
        }
    }

    private void btn_suaActionPerformed(ActionEvent evt) {

this.dispose();
GUI_suataikhoan frm=new GUI_suataikhoan();
            frm.setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
     int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam==JOptionPane.YES_OPTION) {
            int cacdong[]=tbl_user.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                String tenUser=(String)tbl_user.getValueAt(cacdong[i], 1);
                DAO.User.Xoauser(tenUser);
            }
            BLL.BLL_dodulieu_TaiKhoan.dodulieu(tbl_user);
        }
        
     
    }
   
    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_taikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_taikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_taikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_taikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_taikhoan().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbl_user;
    
}
