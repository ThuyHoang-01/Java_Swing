package GUI_Form;

import Dao.DS_XeMay;
import Entity.XeMay;
import Model.XeTableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TimXe extends JPanel {
    GD_Chinh gd;
    DS_XeMay xeDao;
    XeTableModel tableModel;
    JTable table;
    public TimXe(){
        doShow();
    }
    public void doShow(){
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("TÌM THÔNG TIN XE");
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
        b1.add(lblNhapMa = new JLabel("Nhập Mã Xe Cần Tìm: "));
        b1.add(Box.createHorizontalStrut(30));
        JComboBox<String> cbcMaXe;
        cbcMaXe = new JComboBox<>();
        xeDao = new DS_XeMay();
        for(XeMay xe : xeDao.getLS()){
            System.out.println(xe.getMaXe());
            cbcMaXe.addItem(xe.getMaXe());}
        cbcMaXe.setPreferredSize(new Dimension(400,20));
        b1.add(cbcMaXe);

        b.add(Box.createVerticalStrut(20));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblNhapTen = new JLabel("Loại Xe Cần Tìm: "));
        lblNhapTen.setPreferredSize(lblNhapMa.getPreferredSize());
        b2.add(Box.createHorizontalStrut(30));
        b2.add(txtTen = new JTextField(50));
        b.add(Box.createVerticalStrut(10));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(Box.createHorizontalStrut(160));
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
                    txtThongBao.setText("Tìm thành công!");
                    xeDao = new DS_XeMay();
                    tableModel = new XeTableModel(xeDao.TimKiem(cbcMaXe.getSelectedItem().toString()));
                    txtTen.setText(xeDao.TimKiemXe(cbcMaXe.getSelectedItem().toString()).getMaLoai());
                    table.setModel(tableModel);

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

        List<XeMay> ds;
        ds = new ArrayList<XeMay>();
        JPanel pnSouth = new JPanel();
        tableModel = new XeTableModel(ds);
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
