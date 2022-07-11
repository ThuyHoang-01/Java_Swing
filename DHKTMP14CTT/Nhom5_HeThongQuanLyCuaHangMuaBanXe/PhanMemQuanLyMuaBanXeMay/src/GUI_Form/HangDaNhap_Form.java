package GUI_Form;

import Dao.DS_CT_PhieuNhap;
import Dao.DS_CT_PhieuXuat;
import Dao.DS_PhieuNhap;
import Dao.DS_PhieuXuat;
import Model.CT_HD_TableModel;
import Model.CT_PN_TableModel;
import Model.PhieuNhapModel;
import Model.PhieuXuatModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangDaNhap_Form extends JPanel {
    Box b,b3,b4;
    JTable table,table1;
    CT_PN_TableModel tableModel1;
    PhieuNhapModel tableModel;
    public HangDaNhap_Form() throws Exception {
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lbTieuDe = new JLabel("DANH SÁCH HÀNG ĐÃ NHẬP");
        pnNorth.add(lbTieuDe);
        lbTieuDe.setFont(new Font("Arial",Font.BOLD,25));
        lbTieuDe.setForeground(Color.RED);

        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(700,400));
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(700,350));
        b.add(Box.createVerticalStrut(10));
        b.add(b3 = Box.createHorizontalBox());
        table = new JTable();
        DS_PhieuNhap pnDao = new DS_PhieuNhap();
        tableModel = new PhieuNhapModel(pnDao.getLS());
        table.setModel(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(350,150));
        b3.add(sc);
        b.add(Box.createVerticalStrut(30));

        b.add(b4 = Box.createHorizontalBox());


        DS_CT_PhieuNhap ctpnDao = new DS_CT_PhieuNhap();

        table1 = new JTable();
        tableModel1 = new CT_PN_TableModel(ctpnDao.getLS());
        table1.setModel(tableModel1);
        JScrollPane sp = new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(350,150));
        b4.add(sp);
        pnCenter.add(b);

        JPanel pnSouth = new JPanel();
        JButton btnThoat = new JButton("Thoát");
        pnSouth.add(btnThoat);
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


        this.add(pnNorth,BorderLayout.NORTH);
        this.add(pnCenter,BorderLayout.CENTER);
        this.add(pnSouth,BorderLayout.SOUTH);
    }

}
