package GUI_Form;

import Dao.DS_CT_PhieuXuat;
import Dao.DS_PhieuXuat;
import Entity.CT_PhieuXuat;
import Entity.PhieuXuat;
import Model.CT_HD_TableModel;
import Model.PhieuXuatModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Form_DoanhThu extends JPanel {
    DS_PhieuXuat pxDao;
    DS_CT_PhieuXuat ctpxDao;
    JTable table1,table;
    PhieuXuatModel tableModel;
    CT_HD_TableModel tableModel1;
    Box b2,b3,b4,b5,b6,b7,b8,b9;
    JLabel lblLuaChon,lblChonThang,lblchonNam,lblChonQuy,lblDoanhThu;
    JTextField txtDoanhThu;
    JComboBox<String> cbcLuaChon,cbcChonThang,cbcChonNam,cbcChonQuy;
    JButton btnXem;
    public Form_DoanhThu(){
        doShow();
    }
    public void doShow(){
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("XEM DOANH THU CỦA CỬA HÀNG");
        lblTieuDe.setForeground(Color.RED);
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,25));
        pnNorth.add(lblTieuDe);


        JPanel pnCenter = new JPanel();
        Box b, b1;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(800,500));
        b.add(b1 = Box.createHorizontalBox());
        b1.setPreferredSize(new Dimension(300,30));
        b1.add(lblLuaChon = new JLabel("Bạn Muốn Xem Doanh Thu Theo: "));
        cbcLuaChon = new JComboBox<>();
        cbcLuaChon.addItem("Tháng");
        cbcLuaChon.addItem("Quý");
        cbcLuaChon.addItem("Năm");
        b1.add(cbcLuaChon);
        b.add(Box.createVerticalStrut(10));

        b.add(b2 = Box.createHorizontalBox());
        cbcChonThang = new JComboBox<>();
        for(int i = 1; i <= 12; i++){
            cbcChonThang.addItem(Integer.toString(i));
        }
        b2.add(lblChonThang = new JLabel("Chọn Tháng:"));
        lblChonThang.setPreferredSize(lblLuaChon.getPreferredSize());
        b2.add(cbcChonThang);
        b.add(Box.createVerticalStrut(10));

        b.add(b5 = Box.createHorizontalBox());
        cbcChonQuy = new JComboBox<>();
        for(int i = 1; i <= 4; i++){
            cbcChonQuy.addItem(Integer.toString(i));
        }
        b5.add(lblChonQuy = new JLabel("Chọn Quý:"));
        lblChonQuy.setPreferredSize(lblLuaChon.getPreferredSize());
        b5.add(cbcChonQuy);
        b.add(Box.createVerticalStrut(10));

        b.add(b6 = Box.createHorizontalBox());
        cbcChonNam = new JComboBox<>();
        for(int i = 2018; i <= 2050; i++){
            cbcChonNam.addItem(Integer.toString(i));
        }
        b6.add(lblchonNam = new JLabel("Chọn Năm:"));
        lblchonNam.setPreferredSize(lblLuaChon.getPreferredSize());
        b6.add(cbcChonNam);
        b.add(Box.createVerticalStrut(10));

        b.add(b9 = Box.createHorizontalBox());
        b9.add(btnXem = new JButton("Xem Doanh Thu"));
        btnXem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbcLuaChon.getSelectedItem().equals("Tháng")){
                    DS_PhieuXuat pxDao = new DS_PhieuXuat();
                    String thang = cbcChonThang.getSelectedItem().toString();
                    String nam = cbcChonNam.getSelectedItem().toString();
                    table.setModel(new PhieuXuatModel(pxDao.TimKiemThang(thang,nam)));
                    table.selectAll();
                    System.out.println(table.getRowCount());

                    DS_CT_PhieuXuat ds = new DS_CT_PhieuXuat();
                    List<CT_PhieuXuat> ls1 = new ArrayList<>();

                    for(int i = 0; i < table.getRowCount();i++){
                        ls1.add(ds.TimKiemPX(table.getValueAt(i,0).toString()));
                    }
                    try {
                        table1.setModel(new CT_HD_TableModel(ls1));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    Double tong = 0.0;
                    for(int i = 0; i < table.getRowCount();i++){
                        tong += (ds.TimKiemPX(table.getValueAt(i,0).toString()).getXeMay().getDonGia()+
                                ds.TimKiemPX(table.getValueAt(i,0).toString()).getThue());
                    }
                    txtDoanhThu.setText(tong.toString());
                }
                else if(cbcLuaChon.getSelectedItem().equals("Quý")){
                    DS_PhieuXuat pxDao = new DS_PhieuXuat();
                    String quy = cbcChonQuy.getSelectedItem().toString();
                    String nam = cbcChonNam.getSelectedItem().toString();
                    table.setModel(new PhieuXuatModel(pxDao.TimKiemQuy(quy,nam)));
                    table.selectAll();
                    System.out.println(table.getRowCount());

                    DS_CT_PhieuXuat ds = new DS_CT_PhieuXuat();
                    List<CT_PhieuXuat> ls1 = new ArrayList<>();

                    for(int i = 0; i < table.getRowCount();i++){
                        ls1.add(ds.TimKiemPX(table.getValueAt(i,0).toString()));
                    }
                    try {
                        table1.setModel(new CT_HD_TableModel(ls1));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    Double tong = 0.0;
                    for(int i = 0; i < table.getRowCount();i++){
                        tong += (ds.TimKiemPX(table.getValueAt(i,0).toString()).getXeMay().getDonGia()+
                                ds.TimKiemPX(table.getValueAt(i,0).toString()).getThue());
                    }
                    txtDoanhThu.setText(tong.toString());
                }
            }
        });

        b.add(Box.createVerticalStrut(10));
        b.add(b3 = Box.createHorizontalBox());
        table = new JTable();
        java.util.List<PhieuXuat> ls = new ArrayList<>();
        tableModel = new PhieuXuatModel(ls);
        table.setModel(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(350,130));
        b3.add(sc);
        b.add(Box.createVerticalStrut(10));

        b.add(b4 = Box.createHorizontalBox());


        List<CT_PhieuXuat> ls1;
        ls1 = new ArrayList<>();
        table1 = new JTable();
        tableModel1 = new CT_HD_TableModel(ls1);
        table1.setModel(tableModel1);
        JScrollPane sp = new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(350,130));
        b4.add(sp);

        b.add(Box.createVerticalStrut(50));
        b.add(b7 = Box.createHorizontalBox());
        b7.add(Box.createHorizontalStrut(400));
        b7.add(lblDoanhThu = new JLabel("Tổng Doanh Thu: "));
        lblDoanhThu.setFont(new Font("Arial",Font.BOLD,20));
        b.add(Box.createVerticalStrut(20));
        b.add(b8 = Box.createHorizontalBox());
        b8.add(Box.createHorizontalStrut(550));
        b8.add(txtDoanhThu = new JTextField());
        b8.add(Box.createHorizontalStrut(20));
        b8.add(new JLabel("VNĐ"));
        txtDoanhThu.setBorder(null);
        txtDoanhThu.setForeground(Color.RED);
        txtDoanhThu.setFont(new Font("Arial",Font.BOLD,18));
        txtDoanhThu.setEditable(false);

        Box b99;
        JButton btnThoat;
        b.add(b99 = Box.createHorizontalBox());
        b99.add(btnThoat = new JButton("Thoát"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
        btnThoat.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.setBackground(Color.RED);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //pn =new TrangChu();
                //gd = new GD_Chinh();
                //gd.trangChu();
            }
        });



        cbcLuaChon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(cbcLuaChon.getSelectedItem().equals("Tháng")){
                   cbcChonQuy.setEnabled(false);
                }else if(cbcLuaChon.getSelectedItem().equals("Quý")){
                    cbcChonThang.setEnabled(false);
                    cbcChonQuy.setEnabled(true);
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


        pnCenter.add(b);
        add(pnNorth,BorderLayout.NORTH);
        add(pnCenter,BorderLayout.CENTER);
    }
}
