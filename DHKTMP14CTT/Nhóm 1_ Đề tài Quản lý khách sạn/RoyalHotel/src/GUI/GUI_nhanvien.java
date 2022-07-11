/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.NhanVien;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ADMIN
 */
public class GUI_nhanvien extends JFrame {

    /**
     * Creates new form GUI_nhanvien
     */
    public GUI_nhanvien() {
        initComponents();
        setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        txt_ten = new JTextField();
        cbb_gioitinh = new JComboBox<>();
        txt_sdt = new JTextField();
        txt_ngaylam = new JTextField();
        txt_luong = new JTextField();
        txt_diachi = new JTextField();
        txt_ghichu = new JTextField();
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        btn_sua = new JButton();
        jScrollPane1 = new JScrollPane();
        tbl_nhanvien = new JTable();
        txt_ngaysinh = new JTextField();
        jLabel10 = new JLabel();
        

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhân viên");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 0, 36)); 
        jLabel1.setText("Quản lý nhân viên");

        jLabel2.setFont(new Font("Tahoma", 0, 18)); 
        jLabel2.setText("Tên nhân viên:");

        jLabel3.setFont(new Font("Tahoma", 0, 18)); 
        jLabel3.setText("Giới tính:");

        jLabel4.setFont(new Font("Tahoma", 0, 18)); 
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new Font("Tahoma", 0, 18)); 
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new Font("Tahoma", 0, 18)); 
        jLabel6.setText("Ngày làm:");

        jLabel7.setFont(new Font("Tahoma", 0, 18)); 
        jLabel7.setText("Lương:");

        jLabel8.setFont(new Font("Tahoma", 0, 18)); 
        jLabel8.setText("Địa chỉ:");

        jLabel9.setFont(new Font("Tahoma", 0, 18)); 
        jLabel9.setText("Ghi chú:");

        cbb_gioitinh.setModel(new DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        txt_luong.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txt_luongKeyReleased(evt);
            }
        });

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setFont(new Font("Tahoma", 0, 18)); 
        jButton1.setIcon(new ImageIcon(getClass().getResource("/hinh/thêm.jpg"))); 
        jButton1.setText("Thêm");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new Color(255, 255, 255));
        jButton2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new ImageIcon(getClass().getResource("/hinh/xóa.png"))); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new Color(255, 255, 255));
        btn_sua.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        btn_sua.setIcon(new ImageIcon(getClass().getResource("/hinh/sửa.png"))); // NOI18N
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
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1,GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sua, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(54, 54, 54)
                .addComponent(jButton2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btn_sua)
                .addContainerGap())
        );

        tbl_nhanvien.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "Ngày làm", "Lương", "Địa chỉ", "Ghi chú"
            }
        ));
        tbl_nhanvien.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanvien);

       

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ten)
                            .addComponent(cbb_gioitinh, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sdt)
                            .addComponent(txt_ngaylam)
                            .addComponent(txt_luong)
                            .addComponent(txt_diachi)
                            .addComponent(txt_ghichu, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(txt_ngaysinh))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbb_gioitinh,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_ngaysinh,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_ngaylam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_luong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_diachi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_ghichu, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    )
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
       
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        BLL.BLL_dodulieuNV.dodulieuNV(tbl_nhanvien);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	Entity.NhanVien nv = new NhanVien();
        nv.setTen(txt_ten.getText());
        nv.setGioitinh(cbb_gioitinh.getSelectedItem().toString());
        nv.setNgaysinh(txt_ngaysinh.getText());
        nv.setSdt(txt_sdt.getText());
        nv.setNgaylam(txt_ngaylam.getText());
        
        nv.setLuong(ChuyenDoi.ChuyenSangSo(txt_luong.getText()));
        nv.setDiachi(txt_diachi.getText());
        nv.setGhichu(txt_ghichu.getText());
        boolean kt = BLL.BLL_NV.ktNV(nv);
        if (kt) {
        	DAO.NhanVien.themNV(nv);
            BLL.BLL_dodulieuNV.dodulieuNV(tbl_nhanvien);
        } else {
            
        }
    }

    private void txt_luongKeyReleased(java.awt.event.KeyEvent evt) {
        
        String chuoi = txt_luong.getText();
        double so = BLL.ChuyenDoi.ChuyenSangSo(chuoi);
        String sotien = BLL.ChuyenDoi.DinhDangSo(so);
        txt_luong.setText(sotien);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_nhanvien.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                int maNV = Integer.parseInt(tbl_nhanvien.getValueAt(cacdong[i], 1).toString());
                DAO.NhanVien.xoaNV(maNV);
            }
            BLL.BLL_dodulieuNV.dodulieuNV(tbl_nhanvien);
        }
    }
    public String maNV;
    private void tbl_nhanvienMouseClicked(MouseEvent evt) {
        if (tbl_nhanvien.getSelectedRowCount() == 1) {
            btn_sua.setEnabled(true);
            int vitri = tbl_nhanvien.getSelectedRow();
            txt_ten.setText(tbl_nhanvien.getValueAt(vitri, 2).toString());
            cbb_gioitinh.setSelectedItem(tbl_nhanvien.getValueAt(vitri, 3));
            txt_ngaysinh.setText(tbl_nhanvien.getValueAt(vitri, 4).toString());
            txt_sdt.setText(tbl_nhanvien.getValueAt(vitri, 5).toString());
            txt_ngaylam.setText(tbl_nhanvien.getValueAt(vitri, 6).toString());
            txt_luong.setText(tbl_nhanvien.getValueAt(vitri, 7).toString());
            txt_diachi.setText(tbl_nhanvien.getValueAt(vitri, 8).toString());
            txt_ghichu.setText(tbl_nhanvien.getValueAt(vitri, 9).toString());
            maNV = tbl_nhanvien.getValueAt(vitri, 1).toString();
        } else {
            btn_sua.setEnabled(false);
        }
    }

    private void btn_suaActionPerformed(ActionEvent evt) {
        if (tbl_nhanvien.getSelectedRowCount() != 1) {
            thongbao.thongbao("chỉ chọn 1 dòng để sửa", "thông báo");
        } else {
        	Entity.NhanVien nv_sua = new NhanVien();
            nv_sua.setTen(txt_ten.getText());
            nv_sua.setGioitinh(cbb_gioitinh.getSelectedItem().toString());
            nv_sua.setNgaysinh(txt_ngaysinh.getText());
            nv_sua.setSdt(txt_sdt.getText());
            nv_sua.setNgaylam(txt_ngaylam.getText());
            nv_sua.setLuong(ChuyenDoi.ChuyenSangSo(txt_luong.getText()));
            nv_sua.setDiachi(txt_diachi.getText());
            nv_sua.setGhichu(txt_ghichu.getText());
            boolean kt = BLL.BLL_NV.ktNV_sua(nv_sua);
            if (kt) {
            	DAO.NhanVien.suaNV(nv_sua, maNV);
                BLL.BLL_dodulieuNV.dodulieuNV(tbl_nhanvien);
                lammoi();
            } else {
            }
        }
    }

   
    private void lammoi() {
        txt_diachi.setText("");
        txt_ghichu.setText("");
        txt_luong.setText("");
        txt_ngaylam.setText("");
        txt_ngaysinh.setText("");
        txt_sdt.setText("");
        txt_ten.setText("");
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
            Logger.getLogger(GUI_nhanvien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_nhanvien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_nhanvien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_nhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_nhanvien().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btn_sua;
    private javax.swing.JComboBox<String> cbb_gioitinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_ghichu;
    private javax.swing.JTextField txt_luong;
    private javax.swing.JTextField txt_ngaylam;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;

   
}
