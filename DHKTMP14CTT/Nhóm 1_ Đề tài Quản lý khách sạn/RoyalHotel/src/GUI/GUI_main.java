
package GUI;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author ADMIN
 */
public class GUI_main extends JFrame {

  
   
	public GUI_main() {
        initComponents();
        setResizable(false);
       
    }

    private void initComponents() {

       
        jLabel5 = new JLabel();
        
        jMenuBar1 = new JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem6 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem7 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem8 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem9 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem10 = new JCheckBoxMenuItem();
        jCheckBoxMenuItem11 = new JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMenu4 = new javax.swing.JMenu();
        jCheckBoxMenuItem12 = new JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        
        

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PHẦN MÊM QUẢN LÝ KHÁCH SẠN ROYAL");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        

     

        
        
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/hinh1/32.jpg"))); 
        JPanel pnCenter;
		add(pnCenter = new JPanel(),BorderLayout.CENTER);
		pnCenter.add(jLabel5);
        
		
        
  
       /* jButton1.setText("Loại khách hàng");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });*/

        jMenu1.setText("Tài Khoản");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Đăng xuất");
        jCheckBoxMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Đổi mật khẩu");
        jCheckBoxMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem2);
     
		jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("Sửa tài khoản");
        jCheckBoxMenuItem3.setEnabled(false);
        jCheckBoxMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem3);
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Khách Hàng");
        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("Cập Nhật Khách Hàng");
        jCheckBoxMenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem4);
        jCheckBoxMenuItem5.setSelected(true);
        jCheckBoxMenuItem5.setText("Loại Khách Hàng");
        jCheckBoxMenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem5);
        
        jCheckBoxMenuItem6.setSelected(true);
        jCheckBoxMenuItem6.setText("Tìm Kiếm Khách Hàng");
        jCheckBoxMenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem6);
        jMenu3.setText("Phòng");
        jCheckBoxMenuItem7.setSelected(true);
        jCheckBoxMenuItem7.setText("Thuê Phòng");
        jCheckBoxMenuItem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem7);
        jCheckBoxMenuItem8.setSelected(true);
        jCheckBoxMenuItem8.setText("Cập Nhật Phòng");
        jCheckBoxMenuItem8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem8);
        jCheckBoxMenuItem9.setSelected(true);
        jCheckBoxMenuItem9.setText("Trả Phòng");
        jCheckBoxMenuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem9);
        
        JMenu4.setText("Nhân Viên");
        JMenu4.setEnabled(false);
        jCheckBoxMenuItem10.setSelected(true);
        jCheckBoxMenuItem10.setText("Cập Nhật Nhân Viên");
        jCheckBoxMenuItem10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem10ActionPerformed(evt);
            }
        });
        JMenu4.add(jCheckBoxMenuItem10);
        jCheckBoxMenuItem11.setSelected(true);
        jCheckBoxMenuItem11.setText("Tìm kiếm nhân viên");
        jCheckBoxMenuItem11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	JCheckBoxMenuItem11ActionPerformed(evt);
            }
        });
        JMenu4.add(jCheckBoxMenuItem11);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(JMenu4);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                           )
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            ))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        
                        .addGap(104, 104, 104)
                       )
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            )
                        .addGap(55, 55, 55)
                        ))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            	.addGap(150,150,150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                    
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    )
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    )
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void JCheckBoxMenuItem4ActionPerformed(ActionEvent evt) {
        GUI_khachhang frm = new GUI_khachhang();
        frm.setVisible(true);
    }

    private void JCheckBoxMenuItem7ActionPerformed(ActionEvent evt) {
        GUI_phong frm = new GUI_phong();
        frm.setVisible(true);
    }

    private void JCheckBoxMenuItem10ActionPerformed(ActionEvent evt) {
        GUI_nhanvien frm = new GUI_nhanvien();
        frm.setVisible(true);
    }

    private void JCheckBoxMenuItem3ActionPerformed(ActionEvent evt) {
        GUI_taikhoan frm = new GUI_taikhoan();
        frm.setVisible(true);
    }
    private void JCheckBoxMenuItem8ActionPerformed(ActionEvent evt) {
        GUI_updatep frm = new GUI_updatep();
        frm.setVisible(true);
    }
    private void formWindowOpened(WindowEvent evt) {
        if (GUI_dangnhap.quyen.equals("quanly")) {
            JMenu4.setEnabled(true);
            jCheckBoxMenuItem3.setEnabled(true);
        } else {
        	
        }
        

    }

    private void formWindowClosing(WindowEvent evt) {
        int nutbam = JOptionPane.showConfirmDialog(this, "bạn chắc chắn muốn thoát", "THOÁT", JOptionPane.OK_CANCEL_OPTION);
        if (nutbam == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else {
        }
    }

    private void jCheckBoxMenuItem1ActionPerformed(ActionEvent evt) {
        this.dispose();
        GUI_dangnhap frm = new GUI_dangnhap();
        frm.setVisible(true);
    }
    private void JCheckBoxMenuItem6ActionPerformed(ActionEvent evt) {
        
        GUI_timkiemKH frm = new GUI_timkiemKH();
        frm.setVisible(true);
    }
 private void JCheckBoxMenuItem11ActionPerformed(ActionEvent evt) {
        
        GUI_timkiemNV frm = new GUI_timkiemNV();
        frm.setVisible(true);
    }

    private void jCheckBoxMenuItem2ActionPerformed(ActionEvent evt) {
        GUI_DoiMK frm = new GUI_DoiMK();
        frm.setVisible(true);
    }

    private void JCheckBoxMenuItem5ActionPerformed(ActionEvent evt) {
        GUI_loaiKH frm = new GUI_loaiKH();
        frm.setVisible(true);
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
            Logger.getLogger(GUI_main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_main().setVisible(true);
            }
        });
    }

    
   
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2,jCheckBoxMenuItem3,jCheckBoxMenuItem4,jCheckBoxMenuItem5;
   
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2, jMenu3, JMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem9;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem10;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem11;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem12;
   
}
