package GUI_Form;

import Dao.DS_LoaiXe;
import Dao.DS_XeMay;
import Entity.LoaiXe;
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

public class ChonXe_Form extends JFrame {
    DS_LoaiXe lxDao;
    XeTableModel tableModel;
    LoaiXeTableModel tableModel1;
    JTable table,table1;
    JButton btnChonXe,btnThoat;
    public ChonXe_Form(){
        doShow();
    }
    public void doShow(){
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Chọn Xe Mua");


        Container cp = getContentPane();
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("CHỌN XE KHÁCH HÀNG CẦN MUA");
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,22));
        lblTieuDe.setForeground(Color.magenta);
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        Box b,b1,b2,b5,b4;
        b = Box.createVerticalBox();
        b.add(b1 = Box.createHorizontalBox());
        b1.add(new JLabel("Danh Sách Xe Trong Cửa Hàng:"));
        b.add(Box.createVerticalStrut(5));

        b.add(b2 = Box.createHorizontalBox());
        DS_XeMay xeDao = new DS_XeMay();
        tableModel = new XeTableModel(xeDao.getLS());
        table = new JTable(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(600,150));
        b2.add(sc);
        b.add(Box.createVerticalStrut(30));

        b.add(b5 = Box.createHorizontalBox());
        b5.add(new JLabel("Thông Tin Loại Xe:"));
        b.add(Box.createVerticalStrut(5));

        b.add(b4 = Box.createHorizontalBox());
        lxDao = new DS_LoaiXe();
        table1 = new JTable();
        List<LoaiXe> ls;
        ls = new ArrayList<>();
        tableModel1 = new LoaiXeTableModel(ls);
        table1.setModel(tableModel1);
        JScrollPane sp = new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(600,100));
        b4.add(sp);
        pnCenter.add(b);


        JPanel pnSouth = new JPanel();
        pnSouth.setPreferredSize(new Dimension(0,70));
        Box b3 = Box.createHorizontalBox();
        pnSouth.add(b3);
        b3.add(btnChonXe = new JButton("Mua Xe"));
        btnChonXe.setFont(new Font("Arial",Font.CENTER_BASELINE,17));
        btnChonXe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        b3.add(Box.createHorizontalStrut(80));
        b3.add(btnThoat = new JButton("Thoát"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
        btnThoat.setBackground(Color.RED);
        btnThoat.setFont(new Font("Arial",Font.CENTER_BASELINE,17));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        cp.add(pnNorth,BorderLayout.NORTH);
        cp.add(pnCenter,BorderLayout.CENTER);
        cp.add(pnSouth,BorderLayout.SOUTH);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                table1.setModel(new LoaiXeTableModel(lxDao.TimKiem(table.getValueAt(row,1).toString())));
                System.out.println("OK");
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
        ChonXe_Form test = new ChonXe_Form();
        test.setVisible(true);
    }
}
