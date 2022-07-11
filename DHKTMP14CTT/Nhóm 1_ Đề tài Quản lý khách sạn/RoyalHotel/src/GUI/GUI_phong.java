/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
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
public class GUI_phong extends JFrame {

    public GUI_phong() {
        initComponents();
        setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tbl_phong = new JTable();
        txt_thue = new JButton();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Danh sách phòng");

        tbl_phong.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Tên phòng", "Trạng thái"
            }
        ));
        tbl_phong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tbl_phongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_phong);
        if (tbl_phong.getColumnModel().getColumnCount() > 0) {
            tbl_phong.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_phong.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_phong.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        txt_thue.setBackground(new Color(255, 255, 0));
        txt_thue.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        txt_thue.setText("THUÊ");
        txt_thue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txt_thueActionPerformed(evt);
            }
        });

        jButton1.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Hoàn thành");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 709, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(txt_thue)
                        .addGap(77, 77, 77)
                        .addComponent(jButton1)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1,GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1,GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(txt_thue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        BLL.BLL_dodulieuPhong.dodulieuPhong(tbl_phong);
    }

    private void tbl_phongMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }
    public static String tenPhong;
    public static String trangthai;
    private void txt_thueActionPerformed(ActionEvent evt) {
        if (tbl_phong.getSelectedRowCount()!=1) {
            thongbao.thongbao("chọn 1 phòng", "thông báo");
        }else{
        int vitri = tbl_phong.getSelectedRow();
            trangthai = tbl_phong.getValueAt(vitri, 2).toString();
        if (trangthai.equals("Đangthuê")) {
            thongbao.thongbao("Phòng đang thuê", "thông báo");
            return;
        } else {
            tenPhong = tbl_phong.getValueAt(vitri, 1).toString();
            GUI_phieuThue frm=new GUI_phieuThue();
            frm.setVisible(true);
        }
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
         int vitri = tbl_phong.getSelectedRow();
      trangthai = tbl_phong.getValueAt(vitri, 2).toString();
        if (trangthai.equals("Chưathuê")) {
            thongbao.thongbao("Phòng chưa thuê", "thông báo");
            return;
        } else {
            tenPhong = tbl_phong.getValueAt(vitri, 1).toString();
            GUI_phieuThue frm=new GUI_phieuThue();
            frm.setVisible(true);
        }
    }

   
    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(GUI_phong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_phong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_phong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_phong.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_phong().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_phong;
    private javax.swing.JButton txt_thue;
  
}
