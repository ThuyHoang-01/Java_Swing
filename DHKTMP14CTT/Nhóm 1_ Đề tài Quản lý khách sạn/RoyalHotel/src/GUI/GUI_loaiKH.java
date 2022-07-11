/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;

import javax.swing.JButton;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.LayoutStyle;


import javax.swing.UIManager;
import javax.swing.WindowConstants;



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
public class GUI_loaiKH extends JFrame {

    /**
     * Creates new form GUI_loaiKH
     */
    public GUI_loaiKH() {
        initComponents();
        setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        txt_tenLoai = new JTextField();
        txt_mota = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tbl_loaiKH = new JTable();
        jButton1 = new JButton();
        jButton2 = new JButton();
        btn_sua = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 1, 24)); 
        jLabel1.setText("Loại khách hàng");

        jPanel1.setBackground(new Color(204, 255, 204));

        jLabel2.setText("Tên loại");

        jLabel3.setText("Mô tả");

        tbl_loaiKH.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã loại", "Tên loại", "Mô tả"
            }
        ));
        tbl_loaiKH.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tbl_loaiKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_loaiKH);
        if (tbl_loaiKH.getColumnModel().getColumnCount() > 0) {
            tbl_loaiKH.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_loaiKH.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_loaiKH.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_loaiKH.getColumnModel().getColumn(1).setMinWidth(100);
            tbl_loaiKH.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_loaiKH.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jButton1.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_sua.setFont(new Font("Tahoma", 1, 13)); // NOI18N
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(146, 146, 146))
            .addComponent(jScrollPane1)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txt_tenLoai, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(207, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sua)
                    .addComponent(txt_mota, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tenLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btn_sua))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        String tenloai = txt_tenLoai.getText();
        String mota = txt_mota.getText();
        boolean kt = BLL.BLL_KH.ktLoaiKH(tenloai, mota);
        if (kt) {
            DAO.KhachHang.themLOaiKH(tenloai, mota);
        } else {
        }
        BLL.BLL_dodulieuLoai.dodulieuLoai(tbl_loaiKH);
    }

    private void formWindowOpened(WindowEvent evt) {
        BLL.BLL_dodulieuLoai.dodulieuLoai(tbl_loaiKH);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_loaiKH.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                int maLoaiKH = Integer.parseInt(tbl_loaiKH.getValueAt(cacdong[i], 1).toString());
                DAO.KhachHang.xoaLoaiKH(maLoaiKH);
            }
            BLL.BLL_dodulieuLoai.dodulieuLoai(tbl_loaiKH);
        }
    }
    public static int malOaiKH;
    private void tbl_loaiKHMouseClicked(MouseEvent evt) {
        if (tbl_loaiKH.getSelectedRowCount() == 1) {
            btn_sua.setEnabled(true);
            int vitri = tbl_loaiKH.getSelectedRow();
            txt_tenLoai.setText(tbl_loaiKH.getValueAt(vitri, 2).toString());
            txt_mota.setText(tbl_loaiKH.getValueAt(vitri, 3).toString());
            malOaiKH = (int) tbl_loaiKH.getValueAt(vitri, 1);
        } else {
        }
    }

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {
        if (tbl_loaiKH.getSelectedRowCount() != 1) {
            thongbao.thongbao("chỉ chọn 1 dòng để sửa", "thông báo");
        } else {
            
            String tenloai = txt_tenLoai.getText();
            String mota = txt_mota.getText();
            boolean kt = BLL.BLL_KH.ktLoaiKH(tenloai, mota);
            if (kt) {
                DAO.KhachHang.updateLoai(malOaiKH, tenloai, mota);
            } else {
            }
            BLL.BLL_dodulieuLoai.dodulieuLoai(tbl_loaiKH);
            txt_mota.setText("");
            txt_tenLoai.setText("");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                   UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(GUI_loaiKH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_loaiKH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_loaiKH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_loaiKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_loaiKH().setVisible(true);
            }
        });
    }

   
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_loaiKH;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_tenLoai;
    
}
