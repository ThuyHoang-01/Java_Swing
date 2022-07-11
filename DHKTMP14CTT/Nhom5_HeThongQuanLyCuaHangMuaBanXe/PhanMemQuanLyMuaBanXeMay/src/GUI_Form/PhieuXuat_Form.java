package GUI_Form;

import Dao.*;
import Entity.*;
import Model.LoaiXeTableModel;
import Model.XeTableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuXuat_Form extends JPanel {
    DS_PhieuXuat pxDao;
    DS_CT_PhieuXuat ctPXDao;
    ChonXe_Form cx;
    JTable table;
    XeTableModel tableModel;
    JPanel pnHienThi;
    DS_KhachHang khDao;
    DS_NhanVien nvDao;
    DS_XeMay xeDao;
    JButton btnThem,btnXoa,btnSua,btnHuy,btnIn,btnThoat,btnNhap;
    JLabel lblMaPX,lblMaKH,lblMaNV,lblNgayXuat,lblMaXe,lblThue;
    JTextField txtMaPX,txtThue,txtNgayXuat;
    JComboBox<String> cbcMaNV,cbcMaKH,cbcMX;
    public PhieuXuat_Form(){
        doShow();
    }
    public void doShow(){
        this.setLayout(new BorderLayout());
        //Tiêu đề
        JPanel pnNorth = new JPanel();
        pnNorth.setPreferredSize(new Dimension(1000,50));
        JLabel lblTieuDe = new JLabel("BÁN HÀNG");
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        //Center
        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(1000,520));
        pnCenter.setBorder(new TitledBorder("Chọn tác vụ:"));
        JPanel pnPNhap = new JPanel();
        pnPNhap.setBorder(new TitledBorder("Phiếu Xuất"));
        pnPNhap.setPreferredSize(new Dimension(950,170));
        Box b1,b11,b12,b13;
        b1 = Box.createVerticalBox();
        b1.add(Box.createVerticalStrut(10));
        b1.setPreferredSize(new Dimension(900,150));
        b1.add(b11 = Box.createHorizontalBox());
        b11.add(lblMaPX = new JLabel("Mã Phiếu Xuất:"));
        b11.add(txtMaPX = new JTextField());
        b11.add(Box.createHorizontalStrut(20));
        b11.add(lblMaKH = new JLabel("Mã Khách Hàng:"));
        cbcMaKH = new JComboBox<>();
        khDao = new DS_KhachHang();
        try {
            for(KhachHang kh : khDao.getLS()){
                System.out.println(kh.getMaKH());
                cbcMaKH.addItem(kh.getMaKH());}
        } catch (Exception e) {
            e.printStackTrace();
        }
        cbcMaKH.setPreferredSize(new Dimension(400,20));
        b11.add(cbcMaKH);
        b1.add(Box.createVerticalStrut(20));
        b1.add(b12 = Box.createHorizontalBox());
        b12.add(lblNgayXuat = new JLabel("Ngày Xuất:"));
        lblNgayXuat.setPreferredSize(lblMaPX.getPreferredSize());
        b12.add(txtNgayXuat = new JTextField("YYYY-MM-DD"));
        txtNgayXuat.setForeground(Color.GRAY);
        txtNgayXuat.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNgayXuat.getText().equals("YYYY-MM-DD")) {
                    txtNgayXuat.setText("");
                    txtNgayXuat.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtNgayXuat.getText().isEmpty()) {
                    txtNgayXuat.setForeground(Color.GRAY);
                    txtNgayXuat.setText("YYYY-MM-DD");
                }
            }
        });
        b12.add(Box.createHorizontalStrut(20));
        b12.add(lblMaNV = new JLabel("Mã Nhân Viên:"));
        cbcMaNV = new JComboBox<>();
        nvDao = new DS_NhanVien();
        for(NhanVien nv : nvDao.getLS()){
            System.out.println(nv.getMaNV());
            cbcMaNV.addItem(nv.getMaNV());}
        cbcMaNV.setPreferredSize(new Dimension(400,20));
        b12.add(cbcMaNV);
        b1.add(Box.createVerticalStrut(10));
        b1.add(b13 = Box.createHorizontalBox());
        b13.add(btnNhap = new JButton("Chọn Xe"));
        btnNhap.setFont(new Font("Arial",Font.BOLD,17));
        btnNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nhapHang.png")));
        btnNhap.setForeground(Color.WHITE);
        btnNhap.setBackground(Color.GREEN);
        b1.add(Box.createVerticalStrut(15));
        pnPNhap.add(b1);



        JPanel pnCTPNhap = new JPanel();
        pnCTPNhap.setBorder(new TitledBorder("CT - Phiếu Xuất"));
        pnCTPNhap.setPreferredSize(new Dimension(950,80));
        Box b2,b21,b22;
        b2 = Box.createVerticalBox();
        b2.setPreferredSize(new Dimension(900,60));
        b2.add(Box.createVerticalStrut(10));
        b2.add(b21 = Box.createHorizontalBox());

        b21.add(lblMaPX = new JLabel("Mã Xe: "));
        //lblMaXe.setPreferredSize(new Dimension(50,20));
        cbcMX = new JComboBox<String>();
        xeDao = new DS_XeMay();
        for(XeMay xe : xeDao.getLS()){
            System.out.println(xe.getMaLoai());
            cbcMX.addItem(xe.getMaXe());
        }
        cbcMX.setPreferredSize(new Dimension(350,20));
        b21.add(cbcMX);
        cbcMX.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cbcMX.removeAllItems();;
                xeDao = new DS_XeMay();
                for(XeMay xe : xeDao.getLS()){
                    System.out.println(xe.getMaLoai());
                    cbcMX.addItem(xe.getMaXe());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        b21.add(Box.createHorizontalStrut(20));
        b21.add(lblThue = new JLabel("Thuế: "));
        lblThue.setPreferredSize(lblMaKH.getPreferredSize());
        b21.add(txtThue = new JTextField());
        txtThue.setPreferredSize(new Dimension(110,20));
        b2.add(Box.createVerticalStrut(20));
        pnCTPNhap.add(b2);

        pnHienThi = new JPanel();
        pnHienThi.setPreferredSize(new Dimension(950,200));
        pnHienThi.setBorder(new TitledBorder("Thông Tin Xe Mua"));
        xeDao = new DS_XeMay();
        table = new JTable();
        List<XeMay> ls;
        ls = new ArrayList<>();
        tableModel = new XeTableModel(ls);
        table.setModel(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(900,150));
        pnHienThi.add(sc);



        pnCenter.add(pnPNhap);
        pnCenter.add(pnCTPNhap);
        pnCenter.add(pnHienThi);
        btnNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cx = new ChonXe_Form();
                cx.setVisible(true);
            }
        });
        //Chức vụ
        JPanel pnSouth  = new JPanel();
        Box bcv = Box.createHorizontalBox();
        pnSouth.add(bcv);
        pnSouth.setPreferredSize(new Dimension(1000,70));
        pnSouth.setBorder(new TitledBorder("Chọn tác vụ:"));
        bcv.add(btnThem = new JButton("Thêm"));
        btnThem.setFont(new Font("Arial",Font.BOLD,17));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnXoa = new JButton("Xóa"));
        btnXoa.setFont(new Font("Arial",Font.BOLD,17));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnSua = new JButton("Sửa"));
        btnSua.setFont(new Font("Arial",Font.BOLD,17));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sua.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnHuy = new JButton("Hủy"));
        btnHuy.setFont(new Font("Arial",Font.BOLD,17));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/huy.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnIn = new JButton("In Hóa Đơn"));
        btnIn.setFont(new Font("Arial",Font.BOLD,17));
        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inHoaDon.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnThoat = new JButton("Thoát"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
        btnThoat.setBackground(Color.RED);
        btnThoat.setFont(new Font("Arial",Font.CENTER_BASELINE,17));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                GD_Chinh gd = new GD_Chinh();
                gd.trangChu();
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pxDao = new DS_PhieuXuat();
                ctPXDao = new DS_CT_PhieuXuat();
                if(!txtMaPX.getText().equals("")){
                    try {
                        boolean kq = kt();
                        if(kq == true) {
                            JOptionPane.showMessageDialog(null, "Mã phiếu xuất đã tồn tại!");
                        }else if(kq == false){
                            if(!txtNgayXuat.getText().equals("YYYY-MM-DD")) {
                                if (!txtThue.getText().equals("")) {
                                    PhieuXuat px = taoPhieuXuat();
                                    CT_PhieuXuat ct = taoCT_PhieuXuat();
                                    System.out.println(px);
                                    System.out.println(ct);
                                    if (pxDao.addPhieuXuat(px) && ctPXDao.addPhieuXuat(ct)) {
                                        xeDao = new DS_XeMay();
                                        table.setModel(new XeTableModel(xeDao.TimKiem(cbcMX.getSelectedItem().toString())));

                                    }
                                } else
                                    JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Giá Trị Thuế!");
                            }else
                                JOptionPane.showMessageDialog(null,"Bạn Chưa Nhập Ngày!");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }else
                    JOptionPane.showMessageDialog(null,"Bạn chưa nhập thông tin!");
            }
        });
        btnIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Form_HD_BanHang hdbh = new Form_HD_BanHang();
                hdbh.setVisible(true);
            }
        });

        txtMaPX.setPreferredSize(txtMaPX.getPreferredSize());
        lblMaNV.setPreferredSize(lblMaKH.getPreferredSize());
        txtThue.setPreferredSize(cbcMaKH.getPreferredSize());
        this.add(pnSouth,BorderLayout.SOUTH);
        this.add(pnCenter,BorderLayout.CENTER);
        this.add(pnNorth,BorderLayout.NORTH);
    }
    public PhieuXuat taoPhieuXuat(){
        String ma = txtMaPX.getText();
        KhachHang kh = new KhachHang(cbcMaKH.getSelectedItem().toString());
        NhanVien nv = new NhanVien(cbcMaNV.getSelectedItem().toString());
        String ngay = txtNgayXuat.getText();
        PhieuXuat px = new PhieuXuat(ma,ngay);
        px.setKhachHang(kh);
        px.setNhanVien(nv);
        return px;
    }
    public CT_PhieuXuat taoCT_PhieuXuat(){
        Double thue = Double.parseDouble(txtThue.getText());
        XeMay lx = new XeMay(cbcMX.getSelectedItem().toString());
        PhieuXuat px = new PhieuXuat(txtMaPX.getText());
        CT_PhieuXuat ct = new CT_PhieuXuat(thue);
        ct.setXeMay(lx);
        ct.setpXuat(px);
        return ct;
    }
    public boolean kt() throws Exception {
        for(PhieuXuat pnq : pxDao.getLS()) {
            if(txtMaPX.getText().equals(pnq.getMaPX()))
                return true;
        }
        return false;
    }
}
