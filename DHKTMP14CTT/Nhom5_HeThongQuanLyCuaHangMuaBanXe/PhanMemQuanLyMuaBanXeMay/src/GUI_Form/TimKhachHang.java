package GUI_Form;

import Dao.DS_KhachHang;
import Entity.KhachHang;
import Model.KHTableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class TimKhachHang extends JPanel {
    DS_KhachHang khDao;
    GD_Chinh gd;
    KHTableModel tableModel;
    JTable table;
    JComboBox cbcGT;
    public TimKhachHang() throws Exception {
        doShow();
    }
    public void doShow() throws Exception {
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("TÌM THÔNG TIN KHÁCH HÀNG");
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(850,300));
        pnCenter.setBorder(new TitledBorder("Nhập Thông Tin: "));
        Box b, b1, b2, b3, b4;

        JLabel lblNhapMa,lblNhapTen;
        JTextField txtTen,txtThongBao;
        JComboBox<String> cbcMa;
        JButton btnTimKiem,btnThoat;
        b = Box.createVerticalBox();
        b.add(Box.createVerticalStrut(40));
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lblNhapMa = new JLabel("Tìm Kiếm Khách Hàng Theo: "));
        b1.add(Box.createHorizontalStrut(30));
        cbcMa = new JComboBox<>();
            cbcMa.addItem("Tên");
            cbcMa.addItem("Giới Tính");
        cbcMa.setPreferredSize(new Dimension(400,20));
        b1.add(cbcMa);
        b.add(Box.createVerticalStrut(20));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblNhapTen = new JLabel());
        lblNhapTen.setPreferredSize(lblNhapMa.getPreferredSize());
        b2.add(Box.createHorizontalStrut(30));
        b2.add(txtTen = new JTextField());
        txtTen.setPreferredSize(new Dimension(400,20));
        cbcGT = new JComboBox<>();
        cbcGT.addItem("Nam");
        cbcGT.addItem("Nữ");
        b2.add(cbcGT);
        cbcGT.setVisible(false);
        cbcMa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(cbcMa.getSelectedItem().equals("Giới Tính")){
                    lblNhapTen.setText("Chọn Giới Tính:");
                    txtTen.setVisible(false);
                    cbcGT.setVisible(true);

                }else if(cbcMa.getSelectedItem().equals("Tên")){
                    lblNhapTen.setText("Nhập Tên Khách Hàng Cần Tìm:");
                    cbcGT.setVisible(false);
                    txtTen.setVisible(true);
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

        b.add(Box.createVerticalStrut(10));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(Box.createHorizontalStrut(220));
        b3.add(txtThongBao = new JTextField(50));
        txtThongBao.setBorder(null);
        txtThongBao.setEditable(false);
        txtThongBao.setForeground(Color.RED);
        txtThongBao.setFont(new Font("Arial",Font.ITALIC,14));

        b.add(Box.createVerticalStrut(40));
        b.add(b4 = Box.createHorizontalBox());
        b4.add(btnTimKiem = new JButton("Tìm Kiếm"));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graph.png")));
        btnTimKiem.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setBackground(Color.ORANGE);

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbcMa.getSelectedItem().equals("Tên")) {
                    txtThongBao.setText("Tìm thành công!");
                    DS_KhachHang khDao = new DS_KhachHang();
                    tableModel = new KHTableModel(khDao.TimKiemTen(txtTen.getText().toString()));
                    table.setModel(tableModel);
                }
                else if(cbcMa.getSelectedItem().equals("Giới Tính")){
                    txtThongBao.setText("Tìm thành công!");
                    DS_KhachHang khDao = new DS_KhachHang();
                    System.out.println(cbcGT.getSelectedItem().toString());
                    System.out.println(khDao.TimKiemGT(cbcGT.getSelectedItem().toString()));
                    tableModel = new KHTableModel(khDao.TimKiemGT(cbcGT.getSelectedItem().toString()));
                    table.setModel(tableModel);
                }

            }
        });


        b4.add(Box.createHorizontalStrut(200));


        b4.add(btnThoat = new JButton("Thoát"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
        btnThoat.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.setBackground(Color.RED);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //pn =new TrangChu();
                gd = new GD_Chinh();
                gd.trangChu();
            }
        });


        List<KhachHang> ds;
        ds = new ArrayList<KhachHang>();
        JPanel pnSouth = new JPanel();
        tableModel = new KHTableModel(ds);
        table = new JTable(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(850,250));
        pnSouth.add(sc);


        b1.setPreferredSize(new Dimension(600,30));
        b2.setPreferredSize(new Dimension(600,30));
        b3.setPreferredSize(new Dimension(600,30));


        pnCenter.add(b);
        this.add(pnNorth,BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnSouth,BorderLayout.SOUTH);
    }
}
