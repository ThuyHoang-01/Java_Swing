/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author ADMIN
 */
public class GUI_DoiMK extends javax.swing.JFrame {

    /**
     * Creates new form GUI_DoiMK
     */
    public GUI_DoiMK() {
        initComponents();
        setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        lbl_hovaten = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_MKcu = new JPasswordField();
        txt_MKmoi = new JPasswordField();
        txt_nhailaiMK = new JPasswordField();
        btn_doi = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("đổi mậ khẩu");
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 1, 18)); 
        jLabel1.setText("Đổi mật khẩu");

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jLabel2.setText("Họ và tên:");

        jLabel3.setText("Mật khẩu cũ:");

        jLabel4.setText("Mật khẩu mới:");

        jLabel5.setText("Nhập lại mật khẩu:");

        btn_doi.setFont(new Font("Tahoma", 1, 13)); 
        btn_doi.setText("Đổi");
        btn_doi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_doiActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nhailaiMK, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(btn_doi)
                    .addComponent(txt_MKcu)
                    .addComponent(txt_MKmoi)
                    .addComponent(lbl_hovaten, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbl_hovaten,GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_MKcu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_MKmoi, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nhailaiMK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btn_doi)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowOpened(WindowEvent evt) {
       lbl_hovaten.setText(BLL.BLL_dangnhap.Doi_MK.getHovaten());
    }

    private void btn_doiActionPerformed(ActionEvent evt) {
      String passcu=String.valueOf(txt_MKcu.getText());
      String passmoi=String.valueOf(txt_MKmoi.getText());
      String nhailaipass=String.valueOf(txt_nhailaiMK.getText());
      boolean kq=BLL.BLL_DoiMK.DoiMK(passcu, passmoi, nhailaipass);
        if (kq) {
           this.dispose();
           
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
            Logger.getLogger(GUI_DoiMK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_DoiMK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_DoiMK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_DoiMK.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_DoiMK().setVisible(true);
            }
        });
    }

   
    private javax.swing.JButton btn_doi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_hovaten;
    private javax.swing.JPasswordField txt_MKcu;
    private javax.swing.JPasswordField txt_MKmoi;
    private javax.swing.JPasswordField txt_nhailaiMK;
    
}
