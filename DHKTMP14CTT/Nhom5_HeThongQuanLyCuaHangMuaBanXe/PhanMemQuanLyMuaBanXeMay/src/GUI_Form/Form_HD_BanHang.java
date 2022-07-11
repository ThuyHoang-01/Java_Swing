package GUI_Form;

import Dao.*;
import Entity.*;
import Model.LoaiXeTableModel;
import Model.XeTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Form_HD_BanHang extends JFrame {
    JTable table,table1;
    XeTableModel tableModel;
    LoaiXeTableModel tableModel1;
    JLabel lbMPX,lblNgayX,lblNV,lblKH,lblDC,lblDT,lblEmail,lblCTH,lblTienThue,lblTongTien;
    JTextField txtpX,txtNgayX,txtNV,txtKH,txtDT,txtEmail,txtDC,txtCTH,txtTienThue,txtTongTien;
    JComboBox<String> cbcMa;
    public Form_HD_BanHang(){
        setSize(600,800);
        setTitle("Hóa đơn bán hàng");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        Container cp = getContentPane();
        JPanel pnNorth = new JPanel();
        pnNorth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pnNorth.setPreferredSize(new Dimension(500,160));
        Box td = Box.createHorizontalBox();
        td.setPreferredSize(new Dimension(200,20));
        cbcMa = new JComboBox<>();
        DS_PhieuXuat pxDao = new DS_PhieuXuat();
        try {
            for(PhieuXuat px : pxDao.getLS()){
                System.out.println(px.getMaPX());
                cbcMa.addItem(px.getMaPX());
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
        b11.add(lbMPX = new JLabel("Mã Phiếu Xuất: "));
        b11.add(txtpX = new JTextField(10));
        //txtpN.setEditable(false);
        //txtpN.setBorder(null);

        b1.add(Box.createVerticalStrut(5));
        b1.add(b12 = Box.createHorizontalBox());
        //b1.setPreferredSize(new Dimension(500,20));
        b12.add(Box.createHorizontalStrut(300));
        b12.add(lblNgayX = new JLabel("Ngày Xuất: "));
        lblNgayX.setPreferredSize(lbMPX.getPreferredSize());
        b12.add(txtNgayX = new JTextField(30));
        //txtNgayN.setEditable(false);
        //txtNgayN.setBorder(null);
        b1.add(Box.createVerticalStrut(20));
        pnNorth.add(td);
        pnNorth.add(btd);
        pnNorth.add(b1);


        JPanel pnCenter = new JPanel();
        JPanel pnNorthC = new JPanel();
        pnCenter.setLayout(new BorderLayout());
        JLabel lblTieuDe = new JLabel("Hóa Đơn Bán Hàng");
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
        b4.add(lblKH = new JLabel("Tên Khách Hàng: "));
        b4.add(txtKH = new JTextField());
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
        List<XeMay> ls = new ArrayList<>();
        tableModel = new XeTableModel(ls);
        table.setModel(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(350,70));
        b8.add(sc);
        List<LoaiXe> ls1;
        ls1 = new ArrayList<>();
        table1 = new JTable();
        tableModel1 = new LoaiXeTableModel(ls1);
        table1.setModel(tableModel1);
        JScrollPane sp = new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(350,70));
        Box b66;
        bct.add(b66 = Box.createHorizontalBox());
        b66.add(sp);
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
        pnL.add(new JLabel("Khách Hàng"));
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

        lblKH.setPreferredSize(lblNV.getPreferredSize());
        lblDC.setPreferredSize(lblNV.getPreferredSize());
        lblNgayX.setPreferredSize(lblNV.getPreferredSize());
        lblDT.setPreferredSize(lblNV.getPreferredSize());
        lblEmail.setPreferredSize(lblNV.getPreferredSize());

        cbcMa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String ma = cbcMa.getSelectedItem().toString();
                PhieuXuat px = new PhieuXuat();
                DS_PhieuXuat dspx = new DS_PhieuXuat();
                px = dspx.TimKiemPX(ma);
                System.out.println(px);
                txtpX.setText(ma);
                txtNgayX.setText(px.getNgayXuat());
                txtNV.setText(px.getNhanVien().getTenNV());
                txtKH.setText(px.getKhachHang().getTenKH());
                txtDC.setText(px.getKhachHang().getDiaChi());
                int dt = px.getKhachHang().getDienThoai();
                txtDT.setText(dt+"");
                txtEmail.setText(px.getKhachHang().geteMail());
                DS_CT_PhieuXuat dsctpx = new DS_CT_PhieuXuat();
                CT_PhieuXuat ctpx = dsctpx.TimKiemPX(ma);
                DS_XeMay xeDao = new DS_XeMay();
                if(ctpx != null)
                    table.setModel(new XeTableModel(xeDao.TimKiem(ctpx.getXeMay().getMaXe())));
                else
                    JOptionPane.showMessageDialog(null,"Không tồn tại CT_HD");

                DS_LoaiXe lxDao = new DS_LoaiXe();
                table1.setModel(new LoaiXeTableModel(lxDao.TimKiem(ctpx.getXeMay().getMaLoai())));
                Double thue = ctpx.getThue();
                Double tienHang = ctpx.getXeMay().getDonGia();
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
        Form_HD_BanHang test = new Form_HD_BanHang();
        test.setVisible(true);
    }
}
