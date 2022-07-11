package quanLyPT;

import javax.swing.JFrame;
import sinhVien.SinhVienForm;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UnsupportedLookAndFeelException;

import dangKi.DangKyForm;
import phongTro.PhongTroForm;
import sinhVien.SinhVienForm;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class GiaoDienChinh extends javax.swing.JFrame {

    private JButton jButtonsinhvien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
	public GiaoDienChinh(){
        initComponents();
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonsinhvien = new javax.swing.JButton();
        jButtonsinhvien.setForeground(Color.MAGENTA);
        jButtonsinhvien.setFont(new Font("Tahoma", Font.BOLD, 15));
        jButton3 = new javax.swing.JButton();
        jButton3.setForeground(Color.MAGENTA);
        jButton3.setFont(new Font("Tahoma", Font.BOLD, 15));
        jButton1 = new javax.swing.JButton();
        jButton1.setForeground(Color.MAGENTA);
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(Color.RED);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(Color.LIGHT_GRAY);

        jButtonsinhvien.setBackground(new java.awt.Color(255, 255, 255));
        jButtonsinhvien.setText("SinhVien");
        jButtonsinhvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsinhvienActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Phòng Trọ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }

			
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Đăng Ký Trọ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

			
        });

        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 25));
        jLabel1.setText("Quản Lý Thông Tin Ở Trọ Của Sinh Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jButtonsinhvien, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
        					.addComponent(jButton3)
        					.addGap(41)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        					.addGap(30))))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(36)
        			.addComponent(jLabel1)
        			.addGap(94)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButtonsinhvien, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        			.addGap(218))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jButtonsinhvienActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here
       SinhVienForm svf = new SinhVienForm();
        svf.setVisible(true);
        svf.pack();
       svf.setLocationRelativeTo(null);
        svf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonnhanvienActionPerformed

    private void jButton3ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	PhongTroForm svf = new PhongTroForm();
        svf.setVisible(true);
        svf.pack();
        svf.setLocationRelativeTo(null);
        svf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    
    private void jButton1ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	DangKyForm svf = new DangKyForm();
        svf.setVisible(true);
        svf.pack();
        svf.setLocationRelativeTo(null);
        svf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienChinh().setVisible(true);
            }
        });
    }
}
