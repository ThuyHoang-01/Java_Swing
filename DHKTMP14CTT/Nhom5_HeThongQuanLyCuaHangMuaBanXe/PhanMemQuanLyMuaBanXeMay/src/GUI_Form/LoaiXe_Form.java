package GUI_Form;

import Dao.DS_LoaiXe;
import Entity.LoaiXe;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoaiXe_Form extends JFrame {
    DS_LoaiXe lxDao;
    JLabel lblMa,lblTen,lblHang,lblSL,lblDT,lblTD,lblDG;
    JTextField txtMa,txtTen,txtHang,txtDG,txtSL;
    JComboBox cbcDT,cbcTD;
    JButton btnXacNhan,btnThoat;
    public LoaiXe_Form(){
        doShow();
    }
    public void doShow(){
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Nhập thông tin loại xe");


        Container cp = getContentPane();
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("NHẬP THÔNG TIN LOẠI XE");
        lblTieuDe.setForeground(Color.BLUE);
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,20));
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        pnCenter.setBorder(new TitledBorder("Nhập thông tin"));
        Box b,b1,b2,b3,b4,b5;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(700,250));
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lblMa = new JLabel("Mã Loại Xe:"));
        b1.add(txtMa = new JTextField());
        b.add(Box.createVerticalStrut(15));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblTen = new JLabel("Tên Loại Xe:"));
        b2.add(txtTen = new JTextField());
        b2.add(Box.createHorizontalStrut(20));
        b2.add(lblHang = new JLabel("Hãng Sản Xuất: "));
        b2.add(txtHang = new JTextField());
        b.add(Box.createVerticalStrut(15));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(lblSL = new JLabel("Số Lượng:"));
        b3.add(txtSL = new JTextField());
        b3.add(Box.createHorizontalStrut(20));
        b3.add(lblDT = new JLabel("Dung Tích:"));
        cbcDT = new JComboBox();
        cbcDT.addItem("50");
        cbcDT.addItem("110");
        cbcDT.addItem("125");
        cbcDT.addItem("135");
        cbcDT.addItem("150");
        cbcDT.setPreferredSize(new Dimension(260,20));
        b3.add(cbcDT);
        b.add(Box.createVerticalStrut(15));

        b.add(b4 = Box.createHorizontalBox());
        b4.add(lblTD = new JLabel("Tốc Độ:"));
        cbcTD = new JComboBox();
        cbcTD.addItem("100");
        cbcTD.addItem("120");
        cbcTD.addItem("150");
        b4.add(cbcTD);
        cbcTD.setPreferredSize(new Dimension(260,20));
        b4.add(Box.createHorizontalStrut(20));
        b4.add(lblDG = new JLabel("Đơn Giá:"));
        b4.add(txtDG = new JTextField());
        b.add(Box.createVerticalStrut(30));


        b.add(b5 = Box.createHorizontalBox());
        b5.add(btnXacNhan = new JButton("Xác Nhận"));
        btnXacNhan.setFont(new Font("Arial",Font.BOLD,18));
        btnXacNhan.setBackground(Color.GREEN);
        btnXacNhan.setForeground(Color.WHITE);
        b5.add(Box.createHorizontalStrut(80));
        b5.add(btnThoat = new JButton("Thoát"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
        btnThoat.setBackground(Color.RED);
        btnThoat.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //pn =new TrangChu();
                //GD_Chinh gd = new GD_Chinh();
                //gd.PhieuNhap();
            }
        });
        pnCenter.add(b);
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtMa.getText().equals("")) {
                    lxDao = new DS_LoaiXe();
                    LoaiXe lx = taoLoaiXe();
                    lxDao.addLoaiXe(lx);
                    System.out.println("Thêm thành công");
                    //PhieuNhap_Form pn = new PhieuNhap_Form();
                    //pn.pnHienThi.setVisible(true);
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!");
                    //PhieuNhap_Form pn = new PhieuNhap_Form();
                    //pn.removeAll();
                    System.out.println("test");
                }
            }
        });

        cp.add(pnNorth,BorderLayout.NORTH);
        cp.add(pnCenter,BorderLayout.CENTER);

        lblDT.setPreferredSize(lblHang.getPreferredSize());
        lblDG.setPreferredSize(lblHang.getPreferredSize());
        lblMa.setPreferredSize(lblTen.getPreferredSize());
        lblSL.setPreferredSize(lblTen.getPreferredSize());
        lblTD.setPreferredSize(lblTen.getPreferredSize());
    }

    public static void main(String[] args) {
        LoaiXe_Form test = new LoaiXe_Form();
        test.setVisible(true);
    }
    public LoaiXe taoLoaiXe(){
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        String hang = txtHang.getText();
        int sl = Integer.parseInt(txtSL.getText());
        int dt = Integer.parseInt(cbcDT.getSelectedItem().toString());
        int td = Integer.parseInt(cbcTD.getSelectedItem().toString());
        double dg = Double.parseDouble(txtDG.getText());

        LoaiXe lx = new LoaiXe(ma,ten,hang,sl,dt,td,dg);
        return lx;
    }
}
