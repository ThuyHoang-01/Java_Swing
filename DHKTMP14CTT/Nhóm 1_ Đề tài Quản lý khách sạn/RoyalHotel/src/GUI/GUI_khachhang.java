
package GUI;

import Entity.KhachHang;
import Entity.mycombobox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
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


public class GUI_khachhang extends javax.swing.JFrame {

    
    public GUI_khachhang() {
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
        txt_ten = new JTextField();
        txt_sdt = new JTextField();
        txt_cmnd = new JTextField();
        spn_tuoi = new JSpinner();
        cbb_gioitinh = new JComboBox<>();
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        btn_sua = new JButton();
        jScrollPane1 = new JScrollPane();
        tbl_KH = new JTable();
        jLabel7 = new JLabel();
        cbb_loaiKH = new JComboBox<>();
        
        jLabel8 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Khách hàng");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 0, 36)); 
        jLabel1.setText("Khách hàng");

        jLabel2.setFont(new Font("Tahoma", 0, 18)); 
        jLabel2.setText("Tên khách hàng:");

        jLabel3.setFont(new Font("Tahoma", 0, 18)); 
        jLabel3.setText("Tuổi:");

        jLabel4.setFont(new Font("Tahoma", 0, 18)); 
        jLabel4.setText("Giới tính:");

        jLabel5.setFont(new Font("Tahoma", 0, 18)); 
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new Font("Tahoma", 0, 18)); 
        jLabel6.setText("Số CMND:");

        spn_tuoi.setModel(new SpinnerNumberModel(1, null, null, 1));

        cbb_gioitinh.setModel(new DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setFont(new Font("Tahoma", 0, 18)); 
        jButton1.setIcon(new ImageIcon(getClass().getResource("/hinh/thêm.jpg"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/xóa.png"))); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2,GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btn_sua)
                .addContainerGap())
        );

        tbl_KH.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã KH", "Loại KH", "Tên", "Tuổi", "Giới tính", "Số điện thoại", "Số CMND"
            }
        ));
        tbl_KH.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tbl_KHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KH);

        jLabel7.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Loại KH:");

       

      

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        ))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txt_ten)
                    .addComponent(txt_sdt)
                    .addComponent(txt_cmnd, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(cbb_gioitinh, 0, 242, Short.MAX_VALUE)
                    .addComponent(spn_tuoi)
                    .addComponent(cbb_loaiKH, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(spn_tuoi,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbb_gioitinh,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_cmnd, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(cbb_loaiKH,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 154,GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void formWindowClosing(WindowEvent evt) {

    }

    private void formWindowOpened(WindowEvent evt) {
        loadData_loaiKH();

        BLL.BLL_dodulieuKH.dodulieuKH(tbl_KH);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
    	Entity.KhachHang kh = new KhachHang();
        kh.setTenKH(txt_ten.getText());
        kh.setTuoi(Integer.parseInt(spn_tuoi.getModel().getValue().toString()));
        kh.setGioitinh(cbb_gioitinh.getSelectedItem().toString());
        kh.setSdt(txt_sdt.getText());
        kh.setCMND(txt_cmnd.getText());
        Entity.mycombobox mb = (Entity.mycombobox) cbb_loaiKH.getSelectedItem();
        String maloaiKH = mb.value.toString();
        boolean kt = BLL.BLL_KH.ktKH(kh);
        if (kt) {
            DAO.KhachHang.themKH(kh, maloaiKH);
            BLL.BLL_dodulieuKH.dodulieuKH(tbl_KH);
        } else {

        }
    }

    private void tbl_KHMouseClicked(MouseEvent evt) {
        int dongchon = tbl_KH.getSelectedRowCount();
        if (dongchon == 1) {
            btn_sua.setEnabled(true);
            int vitri = tbl_KH.getSelectedRow();
            txt_ten.setText(tbl_KH.getValueAt(vitri, 3).toString());
            spn_tuoi.setValue(tbl_KH.getValueAt(vitri, 4));
            cbb_gioitinh.setSelectedItem(tbl_KH.getValueAt(vitri, 5));
            txt_sdt.setText(tbl_KH.getValueAt(vitri, 6).toString());
            txt_cmnd.setText(tbl_KH.getValueAt(vitri, 7).toString());

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_loaiKH.getModel();
            for (int i = 0; i < cbb_loaiKH.getItemCount(); i++) {
                Entity.mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
                String tenLoai = mb.text.toString();
                if (tenLoai.equals(tbl_KH.getValueAt(vitri, 2))) {
                    cbb_loaiKH.setSelectedIndex(i);
                }
            }
        } else {
            btn_sua.setEnabled(false);
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_KH.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                int maKH = Integer.parseInt(tbl_KH.getValueAt(cacdong[i], 1).toString());
                DAO.KhachHang.xoaKH(maKH);
            }
            BLL.BLL_dodulieuKH.dodulieuKH(tbl_KH);
        }
    }

    private void btn_suaActionPerformed(ActionEvent evt) {
        if (tbl_KH.getSelectedRowCount() != 1) {
            thongbao.thongbao("chỉ chọn 1 dòng để sửa", "thông báo");
            return;
        } else {
            int vitri = tbl_KH.getSelectedRow();

            Entity.KhachHang kh_sua = new KhachHang();
            kh_sua.setTenKH(txt_ten.getText());
            kh_sua.setTuoi(Integer.parseInt(spn_tuoi.getModel().getValue().toString()));
            kh_sua.setGioitinh(cbb_gioitinh.getSelectedItem().toString());
            kh_sua.setSdt(txt_sdt.getText());
            kh_sua.setCMND(txt_cmnd.getText());
            Entity.mycombobox mb = (Entity.mycombobox) cbb_loaiKH.getSelectedItem();
            String maloaiKH = mb.value.toString();
            String maKH=tbl_KH.getValueAt(vitri, 1).toString();
            boolean kt = BLL.BLL_KH.ktKH(kh_sua);
            if (kt) {
                DAO.KhachHang.suaKH(kh_sua, maloaiKH, maKH);
                BLL.BLL_dodulieuKH.dodulieuKH(tbl_KH);
            } else {

            }
        }
    }

   

   
    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info :UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(GUI_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           Logger.getLogger(GUI_khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_khachhang().setVisible(true);
            }
        });
    }

    private void loadData_loaiKH() {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_loaiKH.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.KhachHang.loaiKH();
        try {
            while (rs.next()) {
                Object tenLoai = rs.getString("tenloaiKH");
                Object maLoai = rs.getInt("maloaiKH");
                Entity.mycombobox mb = new mycombobox(maLoai, tenLoai);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {

        }
    }

    
    private javax.swing.JButton btn_sua;
    private javax.swing.JComboBox<String> cbb_gioitinh;
    private javax.swing.JComboBox<String> cbb_loaiKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spn_tuoi;
    public javax.swing.JTable tbl_KH;
    private javax.swing.JTextField txt_cmnd;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    
    
}
