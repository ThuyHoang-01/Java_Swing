package GUI_Form;

import Dao.DS_CT_PhieuNhap;
import Dao.DS_LoaiXe;
import Dao.DS_PhieuNhap;
import Entity.CT_PhieuNhap;
import Entity.LoaiXe;
import Entity.PhieuNhap;
import Model.LoaiXeTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Form_HD_NhapHang extends JFrame {
    JTable table;
    LoaiXeTableModel tableModel;
    JLabel lbMPN,lblNgayN,lblNV,lblNCC,lblDC,lblDT,lblEmail,lblCTH,lblTienThue,lblTongTien;
    JTextField txtpN,txtNgayN,txtNV,txtNCC,txtDT,txtEmail,txtDC,txtCTH,txtTienThue,txtTongTien;
    JComboBox<String> cbcMa;
    public Form_HD_NhapHang(){
        setSize(600,700);
        setTitle("Hóa đơn nhập hàng");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        Container cp = getContentPane();
        JPanel pnNorth = new JPanel();
        pnNorth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pnNorth.setPreferredSize(new Dimension(500,160));
        Box td = Box.createHorizontalBox();
        td.setPreferredSize(new Dimension(200,20));
        cbcMa = new JComboBox<>();
        DS_PhieuNhap pnDao = new DS_PhieuNhap();
        try {
            for(PhieuNhap pn : pnDao.getLS()){
                System.out.println(pn.getMaPN());
                cbcMa.addItem(pn.getMaPN());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cbcMa.setPreferredSize(new Dimension(70,15));
        Box b111;
        b111 = Box.createHorizontalBox();
        b111.setPreferredSize(new Dimension(150,15));
        td.add(b111);
        b111.add(new JLabel("Chọn Mã Cần In: "));
        b111.add(cbcMa);
        Box btd = Box.createVerticalBox();
        btd.add(new JLabel("Cửa Hàng Mua Bán Xe Máy..... "));
        btd.add(new JLabel("Địa Chỉ:....................."));
        btd.add(new JLabel("Chuyên Phân Phối Các Loại Xe Máy Chính Hãng."));

        btd.setPreferredSize(new Dimension(500,70));

        Box b11,b12;
        Box b1 = Box.createVerticalBox();
        b1.add(b11 = Box.createHorizontalBox());
        b1.setPreferredSize(new Dimension(500,50));
        b11.add(Box.createHorizontalStrut(300));
        b11.add(lbMPN = new JLabel("Mã Phiếu Nhập: "));
        b11.add(txtpN = new JTextField(10));
        PhieuNhap_Form pn = new PhieuNhap_Form();
        txtpN.setText(pn.txtMaPN.getText());
        System.out.println(txtpN);
        //txtpN.setEditable(false);
        //txtpN.setBorder(null);

        b1.add(Box.createVerticalStrut(5));
        b1.add(b12 = Box.createHorizontalBox());
        //b1.setPreferredSize(new Dimension(500,20));
        b12.add(Box.createHorizontalStrut(300));
        b12.add(lblNgayN = new JLabel("Ngày Nhập: "));
        lblNgayN.setPreferredSize(lbMPN.getPreferredSize());
        b12.add(txtNgayN = new JTextField(30));
        //txtNgayN.setEditable(false);
        //txtNgayN.setBorder(null);
        b1.add(Box.createVerticalStrut(20));
        pnNorth.add(td);
        pnNorth.add(btd);
        pnNorth.add(b1);


        JPanel pnCenter = new JPanel();
        JPanel pnNorthC = new JPanel();
        pnCenter.setLayout(new BorderLayout());
        JLabel lblTieuDe = new JLabel("Hóa Đơn Nhập Hàng");
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,20));
        pnNorthC.add(lblTieuDe);
        pnCenter.add(pnNorthC,BorderLayout.NORTH);

        Box bct,b3,b4,b5,b6,b7,b8,b9,b20,b21;
        bct = Box.createVerticalBox();
        bct.setPreferredSize(new Dimension(400,200));
        bct.add(b3 = Box.createHorizontalBox());
        b3.add(Box.createHorizontalStrut(30));
        b3.add(lblNV = new JLabel("Nhân Viên Lập Hóa Đơn: "));
        b3.add(txtNV = new JTextField());
        b3.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        bct.add(b4 = Box.createHorizontalBox());
        b4.add(Box.createHorizontalStrut(30));
        b4.add(lblNCC = new JLabel("Tên Nhà Cung Cấp: "));
        b4.add(txtNCC = new JTextField());
        b4.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        bct.add(b5 = Box.createHorizontalBox());
        b5.add(Box.createHorizontalStrut(30));
        b5.add(lblDC = new JLabel("Địa Chỉ: "));
        b5.add(txtDC = new JTextField());
        b5.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        bct.add(b6 = Box.createHorizontalBox());
        b6.add(Box.createHorizontalStrut(30));
        b6.add(lblDT = new JLabel("Điện Thoại: "));
        b6.add(txtDT = new JTextField());
        b6.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        bct.add(b7 = Box.createHorizontalBox());
        b7.add(Box.createHorizontalStrut(30));
        b7.add(lblEmail = new JLabel("Email: "));
        b7.add(txtEmail = new JTextField());
        b7.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        bct.add(b8 = Box.createHorizontalBox());

        table = new JTable();
        List<LoaiXe> ls = new ArrayList<>();
        tableModel = new LoaiXeTableModel(ls);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(400,90));
        b8.add(sc);
        bct.add(Box.createVerticalStrut(10));

        bct.add(b9 = Box.createHorizontalBox());
        b9.add(Box.createHorizontalStrut(30));
        b9.add(Box.createHorizontalStrut(300));
        b9.add(lblCTH = new JLabel("Cộng Tiền Hàng: "));
        b9.add(txtCTH = new JTextField());
        b9.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        bct.add(b20 = Box.createHorizontalBox());
        b20.add(Box.createHorizontalStrut(30));
        b20.add(Box.createHorizontalStrut(300));
        b20.add(lblTienThue = new JLabel("Tiền Thuế: "));
        lblTienThue.setPreferredSize(lblCTH.getPreferredSize());
        b20.add(txtTienThue = new JTextField());
        b20.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        bct.add(b21 = Box.createHorizontalBox());
        b21.add(Box.createHorizontalStrut(30));
        b21.add(Box.createHorizontalStrut(300));
        b21.add(lblTongTien = new JLabel("Tổng Tiền: "));
        lblTongTien.setPreferredSize(lblCTH.getPreferredSize());
        b21.add(txtTongTien = new JTextField());
        b21.add(Box.createHorizontalStrut(30));
        bct.add(Box.createVerticalStrut(10));

        Box b22;
        bct.add(b22 = Box.createHorizontalBox());
        b22.add(Box.createHorizontalStrut(30));
        b22.add(Box.createHorizontalStrut(300));
        JButton btnOK;
        b22.add(btnOK = new JButton("Xác Nhận"));
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        JSplitPane split;
        pnCenter.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT), BorderLayout.SOUTH);
        split.setResizeWeight(0.5);
        JPanel pnL = new JPanel();
        pnL.add(new JLabel("Đại Diện Nhà Cung Cấp"));
        pnL.add(new JLabel("(Ký Tên)"));
        JPanel pnR = new JPanel();
        pnR.add(new JLabel("Người Lập Hóa Đơn"));
        pnR.add(new JLabel("(Ký Tên)"));
        split.add(pnL);
        split.add(pnR);
        split.setPreferredSize(new Dimension(0,70));

        pnCenter.add(bct,BorderLayout.CENTER);
        cp.add(pnNorth,BorderLayout.NORTH);
        cp.add(pnCenter,BorderLayout.CENTER);
        cp.add(split,BorderLayout.SOUTH);

        lblNCC.setPreferredSize(lblNV.getPreferredSize());
        lblDC.setPreferredSize(lblNV.getPreferredSize());
        lblNgayN.setPreferredSize(lblNV.getPreferredSize());
        lblDT.setPreferredSize(lblNV.getPreferredSize());
        lblEmail.setPreferredSize(lblNV.getPreferredSize());

        cbcMa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String ma = cbcMa.getSelectedItem().toString();
                PhieuNhap pn = new PhieuNhap();
                DS_PhieuNhap dspn = new DS_PhieuNhap();
                pn = dspn.TimKiemPN(ma);
                System.out.println(pn);
                txtpN.setText(ma);
                txtNgayN.setText(pn.getNgayNhap());
                txtNV.setText(pn.getNhanVien().getTenNV());
                txtNCC.setText(pn.getNhaCC().getTenNCC());
                txtDC.setText(pn.getNhaCC().getDiaChi());
                int dt = pn.getNhaCC().getDienThoai();
                txtDT.setText(dt+"");
                txtEmail.setText(pn.getNhaCC().geteMail());
                DS_CT_PhieuNhap dsctpn = new DS_CT_PhieuNhap();
                CT_PhieuNhap ctpn = dsctpn.TimKiemPN(ma);
                DS_LoaiXe lxDao = new DS_LoaiXe();
                if(ctpn != null)
                    table.setModel(new LoaiXeTableModel(lxDao.TimKiem(ctpn.getLoaiXe().getMaLoai())));
                else
                    JOptionPane.showMessageDialog(null,"Không tồn tại CT_HD");
                Double thue = ctpn.getThue();
                Double tienHang = ctpn.getLoaiXe().getDonGia()*ctpn.getLoaiXe().getSoLuong();
                txtTienThue.setText(thue.toString());
                txtCTH.setText(tienHang.toString());
                Double tongTien = tienHang + thue;
                txtTongTien.setText(tongTien.toString());
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
    }

    public static void main(String[] args) {
        Form_HD_NhapHang test = new Form_HD_NhapHang();
        test.setVisible(true);
    }
}
