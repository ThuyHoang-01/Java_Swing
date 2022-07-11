
package GUI;

import Entity.PhieuThue;
import Entity.Phong;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUI_phieuThue extends JFrame {

    
  
	private static final long serialVersionUID = 1L;

	public GUI_phieuThue() {
        initComponents();
        setSize(600,700);
    }
    public static LocalDate date = LocalDate.now();

    
    @SuppressWarnings("unchecked")
                       
    private void initComponents() {

        scrollbar1 = new Scrollbar();
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        btn_hoanthanh = new JButton();
        jLabel2 = new JLabel();
        lbl_maphong = new JLabel();
        jLabel3 = new JLabel();
        lbl_tenphong = new JLabel();
        jLabel4 = new JLabel();
        lbl_tennhanvien = new JLabel();
        jLabel5 = new JLabel();
        lbl_giaphong = new JLabel();
        jLabel6 = new JLabel();
        txt_tenKH = new JTextField();
        jLabel7 = new JLabel();
        spn_tuoi = new JSpinner();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        txt_sdt = new JTextField();
        txt_CMND = new JTextField();
        jLabel10 = new JLabel();
        spn_songay = new JSpinner();
        lbl_maNV = new JLabel();
        jLabel11 = new JLabel();
        lbl_ngaythue = new JLabel();
        btn_thue = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Phiếu thuê");
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setBackground(new Color(204, 255, 255));
        jLabel1.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new Color(0, 102, 102));
        jLabel1.setText("PHIẾU THUÊ");

        jPanel1.setBackground(new Color(255, 255, 255));

        btn_hoanthanh.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        btn_hoanthanh.setText("Hoàn thành");
        btn_hoanthanh.setEnabled(false);
        btn_hoanthanh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_hoanthanhActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Mã phòng:");

        jLabel3.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Tên phòng:");

        jLabel4.setText("Tên user:");

        jLabel5.setText("Giá phòng:");

        jLabel6.setText("Tên khách thuê:");

        txt_tenKH.setEnabled(false);
        txt_tenKH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txt_tenKHActionPerformed(evt);
            }
        });

        jLabel7.setText("Tuổi:");

        spn_tuoi.setEnabled(false);

        jLabel8.setText("Số điện thoại:");

        jLabel9.setText("Số CMND:");

        txt_sdt.setEnabled(false);
        txt_sdt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        txt_CMND.setEnabled(false);
        txt_CMND.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txt_CMNDActionPerformed(evt);
            }
        });

        jLabel10.setText("Số ngày thuê:");

        spn_songay.setEnabled(false);

        jLabel11.setText("Ngày thuê:");

        btn_thue.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        btn_thue.setText("Thuê");
        btn_thue.setEnabled(false);
        btn_thue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_thueActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_maphong, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_tennhanvien, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_giaphong, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tenKH, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_tuoi, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_CMND, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_songay, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_hoanthanh)
                                        .addComponent(lbl_ngaythue, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tenphong, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(lbl_maNV, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btn_thue, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(lbl_maNV, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_tenphong, GroupLayout.PREFERRED_SIZE, 23,GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addComponent(lbl_maphong, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lbl_tennhanvien, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_giaphong, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(spn_tuoi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txt_CMND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(lbl_ngaythue, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(spn_songay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thue, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hoanthanh, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        if (GUI.GUI_phong.trangthai.equals("Đangthuê")) {
            spn_songay.setEnabled(true);
            btn_hoanthanh.setEnabled(true);
        } else {
            txt_tenKH.setEnabled(true);
            txt_sdt.setEnabled(true);
            txt_CMND.setEnabled(true);
            spn_tuoi.setEnabled(true);
            btn_thue.setEnabled(true);
            spn_songay.setEnabled(true);
        }

        ResultSet rs = DAO.Phong.laydulieu_Theoten(GUI.GUI_phong.tenPhong);
        try {
            if (rs.next()) {
                lbl_maphong.setText(rs.getString("maphong"));
                lbl_tenphong.setText(rs.getString("tenphong"));
                lbl_giaphong.setText(rs.getString("gia"));
            }
        } catch (SQLException ex) {
            thongbao.thongbao("lỗi dữ liệu", "thông báo");
        }
        lbl_tennhanvien.setText(BLL.BLL_dangnhap.hovaten);
        lbl_ngaythue.setText(date.toString());

    }                                 

    private void btn_thueActionPerformed(java.awt.event.ActionEvent evt) {                                         
        PhieuThue pt = new PhieuThue();
        try {
            pt.setMaphong(Integer.parseInt(lbl_maphong.getText()));
            
            pt.setTenphong(lbl_tenphong.getText());
           
            pt.setTenuser(lbl_tennhanvien.getText());
           
            pt.setGiaphong(Double.parseDouble(lbl_giaphong.getText()));
           
            pt.setTenKH(txt_tenKH.getText());
            pt.setTuoi(Integer.parseInt(spn_tuoi.getValue().toString()));
            pt.setSdt(txt_sdt.getText());
            pt.setCMND(txt_CMND.getText());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

            pt.setNgaythue(formatter.parse(lbl_ngaythue.getText()));
        } catch (ParseException ex) {
            thongbao.thongbao("lỗi", "");
        }
        DAO.PhieuThue.them(pt);

    }                                        

    private void btn_hoanthanhActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void txt_tenKHActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txt_CMNDActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

   
    public static void main(String args[]) throws ParseException {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_phieuThue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_phieuThue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_phieuThue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_phieuThue.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_phieuThue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_hoanthanh;
    private javax.swing.JButton btn_thue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_giaphong;
    private javax.swing.JLabel lbl_maNV;
    private javax.swing.JLabel lbl_maphong;
    private javax.swing.JLabel lbl_ngaythue;
    private javax.swing.JLabel lbl_tennhanvien;
    private javax.swing.JLabel lbl_tenphong;
    private java.awt.Scrollbar scrollbar1;
    private javax.swing.JSpinner spn_songay;
    private javax.swing.JSpinner spn_tuoi;
    private javax.swing.JTextField txt_CMND;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenKH;
    // End of variables declaration                   
}
