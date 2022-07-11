package GUI_Form;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GD_Chinh extends JFrame{
    TrangChu pn;
    TimXe timXe;
    TimNhanVien timNV;
    TimKhachHang timKH;
    TimNhaCC timNCC;
    TT_KhachHang ttKH;
    TT_NhanVien ttNV;
    TT_NhaCC ttNCC;
    TT_XeMay ttXe;
    PhieuNhap_Form pNhap;
    PhieuXuat_Form pXuat;
    JPanel pnCenter;
    public GD_Chinh(){
        setSize(1300,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Quản Lý Mua Bán Xe");

        Container cp = getContentPane();
        JMenuBar menuBar = new JMenuBar();

        JMenu menuTrangChu = new JMenu("TRANG CHỦ");
        menuTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png")));
        menuTrangChu.setBackground(Color.PINK);
        menuTrangChu.setFont(new Font("Arial",Font.BOLD,16));



        JMenu menuHeThong = new JMenu("HỆ THỐNG");
        menuHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/heThong.png")));

        menuHeThong.setForeground(Color.RED);
        Font fontMenu = new Font("Arial",Font.BOLD,16);
        menuHeThong.setFont(fontMenu);
        JMenuItem qlnd,dmk,dx,t;
        menuHeThong.add(qlnd = new JMenuItem("Quản lý người dùng"));
        qlnd.setPreferredSize(new Dimension(200,40));
        menuHeThong.add(dmk = new JMenuItem("Đổi mật khẩu"));
        dmk.setPreferredSize(new Dimension(200,40));
        menuHeThong.add(dx = new JMenuItem("Đăng xuất"));
        dx.setPreferredSize(new Dimension(200,40));
        dx.setMnemonic(KeyEvent.VK_O);
        dx.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                ActionEvent.CTRL_MASK));
        dx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login lg = new Login();
                lg.setVisible(true);
                setVisible(false);
            }
        });
        menuHeThong.add(t = new JMenuItem("Thoát"));
        t.setPreferredSize(new Dimension(200,40));
        t.setMnemonic(KeyEvent.VK_T);
        t.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
                ActionEvent.CTRL_MASK));
        t.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        JMenu menuQuanLy = new JMenu("QUẢN LÝ");
        menuQuanLy.setForeground(Color.RED);
        menuQuanLy.setFont(fontMenu);
        JMenuItem kh,nv,ncc,xm;
        menuQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png")));
        menuQuanLy.add(kh = new JMenuItem("Khách Hàng"));
        kh.setPreferredSize(new Dimension(200,40));
        menuQuanLy.add(nv = new JMenuItem("Nhân viên"));
        nv.setPreferredSize(new Dimension(200,40));
        menuQuanLy.add(ncc = new JMenuItem("Nhà cung cấp"));
        ncc.setPreferredSize(new Dimension(200,40));
        menuQuanLy.add(xm = new JMenuItem("Xe máy"));
        xm.setPreferredSize(new Dimension(200,40));


        JMenu menuNhapHang = new JMenu("NHẬP-BÁN HÀNG");
        menuNhapHang.setForeground(Color.RED);
        menuNhapHang.setFont(fontMenu);
        JMenuItem nh,xh;
        menuNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banHang.png")));
        menuNhapHang.add(nh = new JMenuItem("Nhập xe máy"));
        nh.setPreferredSize(new Dimension(200,40));
        menuNhapHang.add(xh = new JMenuItem("Xuất xe máy"));
        xh.setPreferredSize(new Dimension(200,40));

        JMenu menuBaoCao = new JMenu("BÁO CÁO-THỐNG KÊ");
        menuBaoCao.setForeground(Color.RED);
        menuBaoCao.setFont(fontMenu);
        JMenuItem hdx,hdn,htk,dt,hbc;
        menuBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baoCao.png")));
        menuBaoCao.add(hdx = new JMenuItem("Hàng đã xuất"));
        hdx.setPreferredSize(new Dimension(240,40));
        menuBaoCao.add(hdn = new JMenuItem("Hàng đã nhập"));
        hdn.setPreferredSize(new Dimension(240,40));
        menuBaoCao.add(htk = new JMenuItem("Hàng tồn kho"));
        htk.setPreferredSize(new Dimension(240,40));
        menuBaoCao.add(dt = new JMenuItem("Doanh thu"));
        dt.setPreferredSize(new Dimension(240,40));
        dt.setMnemonic(KeyEvent.VK_D);
        dt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                ActionEvent.CTRL_MASK));
        menuBaoCao.add(hbc = new JMenuItem("Hàng bán chạy"));
        hbc.setPreferredSize(new Dimension(240,40));

        JMenuItem kikh,knv,kncc,kxe;
        JMenu menuBaoHanh = new JMenu("TÌM KIẾM");
        menuBaoHanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/timKiem.png")));
        menuBaoHanh.setForeground(Color.RED);
        Font fontBaoHanh = new Font("Arial",Font.BOLD,16);
        menuBaoHanh.setFont(fontBaoHanh);
        menuBaoHanh.add(kikh = new JMenuItem("Khách Hàng"));
        kikh.setPreferredSize(new Dimension(280,40));
        menuBaoHanh.add(knv = new JMenuItem("Nhân Viên"));
        knv.setPreferredSize(new Dimension(280,40));
        menuBaoHanh.add(kncc = new JMenuItem("Nhà Cung Cấp"));
        kncc.setPreferredSize(new Dimension(280,40));
        menuBaoHanh.add(kxe = new JMenuItem("Xe Máy"));
        kxe.setPreferredSize(new Dimension(280,40));

        JMenu menuTroGiup = new JMenu("TRỢ GIÚP");
        menuTroGiup.setForeground(Color.RED);
        menuTroGiup.setFont(fontMenu);
        menuTroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png")));


        menuBar.add(menuTrangChu);
        menuBar.add(menuHeThong);
        menuBar.add(menuQuanLy);
        menuBar.add(menuNhapHang);
        menuBar.add(menuBaoCao);
        menuBar.add(menuBaoHanh);
        menuBar.add(menuTroGiup);

        JPanel pnWest = new JPanel();
        pnWest.setLayout(new BoxLayout(pnWest,BoxLayout.Y_AXIS));
        Border borderWest = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        pnWest.setBorder(borderWest);

        JPanel pnl1 = new JPanel();
        pnl1.setLayout(new GridLayout(2,2));
        pnl1.setBorder(new TitledBorder("Tìm Kiếm"));
        pnl1.setFont(new Font("Arial",Font.BOLD,20));
        JButton btnTimKH = new JButton("Khách hàng");
        btnTimKH.setBorder(null);
        btnTimKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png")));
        JButton btnTimNV = new JButton("Nhân viên");
        btnTimNV.setBorder(null);
        btnTimNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/male.png")));
        JButton btnTimNCC = new JButton("Nhà cung cấp");
        btnTimNCC.setBorder(null);
        btnTimNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier.png")));
        JButton btnTimX = new JButton("Xe máy");
        btnTimX.setBorder(null);
        btnTimX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/motorsport.png")));
        pnl1.add(btnTimKH);pnl1.add(btnTimNV);pnl1.add(btnTimNCC);pnl1.add(btnTimX);

        JPanel pnl2 = new JPanel();
        pnl2.setLayout(new GridLayout(2,2));
        pnl2.setBorder(new TitledBorder("Danh Mục"));
        pnl1.setBorder(new TitledBorder("Tìm Kiếm"));
        JButton dmKH = new JButton("Khách hàng");
        dmKH.setBorder(null);
        dmKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png")));
        JButton dmNV = new JButton("Nhân viên");
        dmNV.setBorder(null);
        dmNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/male.png")));
        JButton dmNCC = new JButton("Nhà cung cấp");
        dmNCC.setBorder(null);
        dmNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier.png")));
        JButton dmXe = new JButton("Xe máy");
        dmXe.setBorder(null);
        dmXe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/motorsport.png")));
        pnl2.add(dmKH);pnl2.add(dmNV);pnl2.add(dmNCC);pnl2.add(dmXe);

        JPanel pnl3 = new JPanel();
        pnl3.setBorder(new TitledBorder("Nhập Hàng"));
        JButton nhNhapHang = new JButton("Nhập Xe Máy");
        pnl3.setLayout(new GridLayout(2,1));
        pnl3.setPreferredSize(new Dimension(0,50));
        pnl3.add(nhNhapHang);
        nhNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export.png")));

        JPanel pnl4 = new JPanel();
        pnl4.setBorder(new TitledBorder("Bán Hàng"));
        pnl4.setLayout(new GridLayout(2,1));
        pnl4.setPreferredSize(new Dimension(0,50));
        JButton nhBanHang = new JButton("Bán Xe Máy");
        pnl4.add(nhBanHang);
        nhBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sell.png")));

        JPanel pnl5 = new JPanel();
        pnl5.setBorder(new TitledBorder("Báo cáo"));
        pnl5.setLayout(new GridLayout(2,2));
        JButton nhDoanhThu = new JButton("Doanh Thu");
        pnl5.add(nhDoanhThu);
        nhDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/income.png")));
        JButton nhHangTon = new JButton("Hàng Tồn Kho");
        pnl5.add(nhHangTon);
        nhHangTon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventory.png")));
        pnWest.add(pnl1);pnWest.add(pnl2);pnWest.add(pnl3);pnWest.add(pnl4);pnWest.add(pnl5);


        //JPanel pnCenter;
        trangChu();

        JPanel pnSouth = new JPanel();
        JLabel lblTen = new JLabel("Nguyễn Văn Hùng - Lê Khắc Trung - Nguyễn Văn Anh");
        lblTen.setFont(new Font("Arial",Font.ITALIC,18));
        pnSouth.setPreferredSize(new Dimension(0,40));
        pnSouth.setBackground(Color.LIGHT_GRAY);
        pnSouth.add(lblTen);


        cp.add(menuBar,BorderLayout.NORTH);
        //cp.add(pnWest,BorderLayout.WEST);
        cp.add(pnCenter,BorderLayout.CENTER);
        cp.add(pnSouth,BorderLayout.SOUTH);

        menuTrangChu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Trang Chủ"));
                JLabel lblTieuDe = new JLabel("PHẦN MỀM QUẢN LÝ CỬA HÀNG MUA BÁN XE MÁY");
                lblTieuDe.setFont(new Font("Arial",Font.BOLD,27));
                lblTieuDe.setForeground(Color.BLUE);
                JLabel imgLabel = new JLabel(new ImageIcon(getClass().getResource("/images/trangchu.png")));
                imgLabel.setPreferredSize(new Dimension(1000,600));
                pnCenter.add(lblTieuDe);
                pnCenter.add(imgLabel);
                pnCenter.validate();
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
        kh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin khách hàng:"));
                try {
                    pnCenter.add(ttKH = new TT_KhachHang());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pnCenter.validate();
            }
        });
        nv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin nhân viên:"));
                pnCenter.add(ttNV = new TT_NhanVien());
                pnCenter.validate();
            }
        });
        ncc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin nhà cung cấp:"));
                pnCenter.add(ttNCC = new TT_NhaCC());
                pnCenter.validate();
            }
        });
        xm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin xe:"));
                pnCenter.add(ttXe = new TT_XeMay());
                pnCenter.validate();
            }
        });
        nh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Nhập hàng:"));
                pnCenter.add(pNhap = new PhieuNhap_Form());
                pnCenter.validate();
            }
        });
        xh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Bán Hàng:"));
                try {
                    pnCenter.add(pXuat = new PhieuXuat_Form());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pnCenter.validate();
            }
        });
        dt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Doanh Thu:"));
                try {
                    Form_DoanhThu dtForm;
                    pnCenter.add(dtForm = new Form_DoanhThu());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pnCenter.validate();
            }
        });
        kikh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    pnCenter.removeAll();
                    pnCenter.setBorder(new TitledBorder("Tìm Khách Hàng:"));
                    try {
                        pnCenter.add(timKH = new TimKhachHang());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    pnCenter.validate();
            }
        });
        knv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Tìm Nhân Viên:"));
                pnCenter.add(timNV = new TimNhanVien());
                pnCenter.validate();
            }
        });
        kncc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Tìm Nhà Cung Cấp:"));
                pnCenter.add(timNCC = new TimNhaCC());
                pnCenter.validate();
            }
        });
        kxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Tìm Xe Máy:"));
                pnCenter.add(timXe = new TimXe());
                pnCenter.validate();
            }
        });
        dmKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin khách hàng:"));
                try {
                    pnCenter.add(ttKH = new TT_KhachHang());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pnCenter.validate();
            }
        });
        dmNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin nhân viên:"));
                pnCenter.add(ttNV = new TT_NhanVien());
                pnCenter.validate();
            }
        });
        dmNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin nhà cung cấp:"));
                pnCenter.add(ttNCC = new TT_NhaCC());
                pnCenter.validate();
            }
        });
        dmXe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Thông tin xe:"));
                pnCenter.add(ttXe = new TT_XeMay());
                pnCenter.validate();
            }
        });
        nhNhapHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Nhập hàng:"));
                pnCenter.add(pNhap = new PhieuNhap_Form());
                pnCenter.validate();
            }
        });
        nhBanHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Bán Hàng:"));
                try {
                    pnCenter.add(pXuat = new PhieuXuat_Form());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pnCenter.validate();
            }
        });
        hdx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Hàng Đã Xuất:"));
                HangDaBan_Form pnDX;
                try {
                    pnCenter.add(pnDX = new HangDaBan_Form());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pnCenter.validate();
            }
        });
        hdn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.setBorder(new TitledBorder("Hàng Đã Nhập:"));
                HangDaNhap_Form pnDN;
                try {
                    pnCenter.add(pnDN = new HangDaNhap_Form());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pnCenter.validate();
            }
        });
    }

    public static void main(String[] args) {
        GD_Chinh test = new GD_Chinh();
        test.setVisible(true);
    }
    public void trangChu(){
        pn = new TrangChu();
        pnCenter = pn;
    }
    public void PhieuNhap(){
        pnCenter.removeAll();
        pnCenter.setBorder(new TitledBorder("Nhập hàng:"));
        pnCenter.add(pNhap = new PhieuNhap_Form());
        pnCenter.validate();
    }
}
