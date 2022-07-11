package GUI_Form;

import Dao.DS_NhanVien;
import Entity.NhanVien;
import Model.NVTableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class TimNhanVien extends JPanel {
    DS_NhanVien nvDao;
    JComboBox cbcGT;
    GD_Chinh gd;
    NVTableModel tableModel;
    JTable table;
    public TimNhanVien(){
        doShow();
    }
    public void doShow(){
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("TÌM THÔNG TIN NHÂN VIÊN");
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(850,300));
        pnCenter.setBorder(new TitledBorder("Nhập Thông Tin: "));
        Box b, b1, b2, b3, b4;

        JLabel lblNhapMa,lblNhapTen;
        JTextField txtMa,txtTen,txtThongBao;
        JButton btnTimKiem,btnThoat;
        b = Box.createVerticalBox();
        b.add(Box.createVerticalStrut(40));
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lblNhapMa = new JLabel("Tìm Kiếm Nhân Viên Theo: "));
        b1.add(Box.createHorizontalStrut(30));
        JComboBox<String> cbcMaNV;
        cbcMaNV = new JComboBox<>();
            cbcMaNV.addItem("Tên");
            cbcMaNV.addItem("Giới Tính");
        cbcMaNV.setPreferredSize(new Dimension(400,20));
        b1.add(cbcMaNV);
        b.add(Box.createVerticalStrut(20));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblNhapTen = new JLabel());
        lblNhapTen.setPreferredSize(lblNhapMa.getPreferredSize());
        b2.add(Box.createHorizontalStrut(30));
        b2.add(txtTen = new JTextField());
        txtTen.setPreferredSize(new Dimension(400,20));
        b.add(Box.createVerticalStrut(10));

        cbcGT = new JComboBox<>();
        cbcGT.addItem("Nam");
        cbcGT.addItem("Nữ");
        b2.add(cbcGT);
        cbcGT.setVisible(false);
        cbcMaNV.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(cbcMaNV.getSelectedItem().equals("Tên")){
                    lblNhapTen.setText("Nhập Tên Nhân Viên Cần Tìm:");
                    txtTen.setPreferredSize(new Dimension(400,20));
                    txtTen.setVisible(true);
                    cbcGT.setVisible(false);
                }
                else if(cbcMaNV.getSelectedItem().equals("Giới Tính")){
                    lblNhapTen.setText("Chọn Giới Tính:");
                    txtTen.setVisible(false);
                    cbcGT.setVisible(true);
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

        b.add(b3 = Box.createHorizontalBox());
        b3.add(Box.createHorizontalStrut(200));
        b3.add(txtThongBao = new JTextField(50));
        txtThongBao.setBorder(null);
        txtThongBao.setEditable(false);
        txtThongBao.setForeground(Color.RED);
        txtThongBao.setFont(new Font("Arial",Font.ITALIC,14));
        //txtThongBao.setText("Lỗi!");

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
                if(cbcMaNV.getSelectedItem().equals("Tên")) {
                    txtThongBao.setText("Tìm thành công!");
                    DS_NhanVien nvDao = new DS_NhanVien();
                    tableModel = new NVTableModel(nvDao.TimKiemTen(txtTen.getText().toString()));
                    table.setModel(tableModel);
                }
                else if(cbcMaNV.getSelectedItem().equals("Giới Tính")){
                    txtThongBao.setText("Tìm thành công!");
                    DS_NhanVien nvDao = new DS_NhanVien();
                    tableModel = new NVTableModel(nvDao.TimKiemGT(cbcGT.getSelectedItem().toString()));
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

        List<NhanVien> ds;
        ds = new ArrayList<NhanVien>();
        JPanel pnSouth = new JPanel();
        tableModel = new NVTableModel(ds);
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
