/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.User;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class GUI_dangky extends JFrame implements ActionListener, ChangeListener {

    /**
     * Creates new form GUI_dangky
     */
    public GUI_dangky() {
        initComponents();
        setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        btn_dk = new JButton();
        btn_huy = new JButton();
        txt_hovaten = new JTextField();
        txt_tendangnhap = new JTextField();
        txt_email = new JTextField();
        txt_mk = new JPasswordField();
        txt_nhailai_mk = new JPasswordField();
        chb_dongy = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Đăng ký");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Đăng Ký Tài Khoản");

        jPanel1.setBackground(new Color(246, 71, 71));

        jLabel2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jLabel3.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên đăng nhập:");

        jLabel4.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mật khẩu:");

        jLabel5.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Nhập lại mật khẩu:");

        jLabel6.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Email:");

        btn_dk.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        btn_dk.setText("Đăng ký");
        btn_dk.setEnabled(false);
        btn_dk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_dkActionPerformed(evt);
            }
        });

        btn_huy.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        chb_dongy.setText("Tôi đồng ý với các điều khoản");
        chb_dongy.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                chb_dongyStateChanged(evt);
            }
        });
        chb_dongy.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                chb_dongyMouseClicked(evt);
            }
        });
        chb_dongy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chb_dongyActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(chb_dongy, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_dk)
                                .addGap(18, 18, 18)
                                .addComponent(btn_huy)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_hovaten, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txt_tendangnhap)
                            .addComponent(txt_email)
                            .addComponent(txt_mk)
                            .addComponent(txt_nhailai_mk))))
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_hovaten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tendangnhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_mk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nhailai_mk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chb_dongy, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dk)
                    .addComponent(btn_huy))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel1)
                .addContainerGap(104, Short.MAX_VALUE))
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowClosing(WindowEvent evt) {
    	GUI_dangnhap frm = new GUI_dangnhap();
        frm.setVisible(true);
        this.dispose();
    }

    private void chb_dongyMouseClicked(MouseEvent evt) {

    }

    private void chb_dongyActionPerformed(ActionEvent evt) {

    }

    private void chb_dongyStateChanged(ChangeEvent evt) {
        if (chb_dongy.isSelected()) {
            btn_dk.setEnabled(true);
        } else {
            btn_dk.setEnabled(false);
        }
    }

    private void btn_dkActionPerformed(ActionEvent evt) {
        User DN1 = new User();
        DN1.setHovaten(txt_hovaten.getText());
        DN1.setTendangnhap(txt_tendangnhap.getText());
        DN1.setMk(String.valueOf(txt_mk.getText()));
        DN1.setEmail(txt_email.getText());
        String nhailai_mk = String.valueOf(txt_nhailai_mk.getText());
        boolean kt = BLL.BLL_dangky.KTra_DK(DN1, nhailai_mk);
        if (kt) {
            this.dispose();
            GUI_dangnhap frm = new GUI_dangnhap();
            frm.setVisible(true);
        }
    }

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        GUI_dangnhap frm = new GUI_dangnhap();
        frm.setVisible(true);
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
            Logger.getLogger(GUI_dangky.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_dangky.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_dangky.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_dangky.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_dangky().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btn_dk;
    private JButton btn_huy;
    private JCheckBox chb_dongy;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JTextField txt_email;
    private JTextField txt_hovaten;
    private JPasswordField txt_mk;
    private JPasswordField txt_nhailai_mk;
    private JTextField txt_tendangnhap;
    // End of variables declaration//GEN-END:variables
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}
