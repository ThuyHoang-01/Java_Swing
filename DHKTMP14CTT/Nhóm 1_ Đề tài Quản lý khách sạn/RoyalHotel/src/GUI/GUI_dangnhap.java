
package GUI;

import java.awt.Color;
import DAO.connection;
import Entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class GUI_dangnhap extends javax.swing.JFrame {
    public static String quyen;
    public static DAO.connection con = new connection();

    
    public GUI_dangnhap() {
        initComponents();
        this.getRootPane().setDefaultButton(btn_dangnhap);
        setResizable(false);
    }

   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txt_tendangnhap = new JTextField();
        txt_mk = new JPasswordField();
        btn_dangnhap = new JButton();
        btn_dk = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        
        
        jLabel1.setFont(new Font("Arial", 1, 40));
        
        jLabel1.setForeground(new Color(246, 71, 71));
        jLabel1.setText("ĐĂNG NHẬP");

        jPanel1.setBackground(new Color(246, 71, 71));
        jPanel1.setForeground(Color.black);

        jLabel2.setFont(new Font("Tahoma", 0, 18)); 
        jLabel2.setText("Tên đăng nhập:");

        jLabel3.setFont(new Font("Tahoma", 0, 18)); 
        jLabel3.setText("Mật khẩu:");

        txt_tendangnhap.setFont(new Font("Tahoma", 1, 13)); 

        txt_mk.setFont(new Font("Tahoma", 1, 13));

        btn_dangnhap.setFont(new Font("Tahoma", 0, 18)); 
        btn_dangnhap.setText("Đăng nhập");
        btn_dangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangnhapActionPerformed(evt);
            }
        });

        btn_dk.setFont(new Font("Tahoma", 0, 10)); 
        btn_dk.setText("Đăng ký tài khoản mới");
        btn_dk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dkActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_dangnhap)
                    .addComponent(txt_tendangnhap, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(txt_mk))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_dk, GroupLayout.PREFERRED_SIZE, 175,GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tendangnhap, GroupLayout.PREFERRED_SIZE, 50,GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_mk, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btn_dangnhap)
                .addGap(18, 18, 18)
                .addComponent(btn_dk)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel1)
                .addContainerGap(156, Short.MAX_VALUE))
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

    @SuppressWarnings("deprecation")
	private void btn_dangnhapActionPerformed(ActionEvent evt) {
        User DN = new User();
        DN.setTendangnhap(txt_tendangnhap.getText());
        DN.setMk(String.valueOf(txt_mk.getText()));
        boolean kt=BLL.BLL_dangnhap.Ktra_DN(DN);
        if (kt) {
            this.dispose();
            GUI_main frm=new GUI_main();
            frm.setVisible(true);
        }else{}
    }

    private void btn_dkActionPerformed(ActionEvent evt) {
        GUI_dangky frm = new GUI_dangky();
        frm.setVisible(true);
        this.dispose();
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
           Logger.getLogger(GUI_dangnhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_dangnhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
           Logger.getLogger(GUI_dangnhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_dangnhap.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_dangnhap().setVisible(true);
            }
        });
    }

   
    private javax.swing.JButton btn_dangnhap;
    private javax.swing.JButton btn_dk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_mk;
    private javax.swing.JTextField txt_tendangnhap;
   
}
