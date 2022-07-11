package GUI_Form;

import Dao.DS_NhaCC;
import Entity.NhaCungCap;
import Model.NhaCCTableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TT_NhaCC extends JPanel {
    DS_NhaCC nccDao;
    GD_Chinh gd;
    NhaCCTableModel tableModel;
    JTable table;
    JLabel lblMa,lblTen,lbldiaChi,lblDT,lblE,lblGT;
    JTextField txtMa,txtTen,txtdiaChi,txtDT,txtE,txtGT;
    JButton btnThem,btnXoa,btnSua,btnXoaRong,btnThoat;
    public TT_NhaCC(){

        doShow();
    }
    public void doShow() {
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("THÔNG TIN NHÀ CUNG CẤP");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(1000,270));
        JPanel pnNhap = new JPanel();
        pnNhap.setPreferredSize(new Dimension(900,200));
        pnNhap.setBorder(new TitledBorder("Nhập Thông Tin NCC:"));

        Box b,b1,b2,b3;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(800,150));
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lblMa = new JLabel("Mã Nhà Cung Cấp: "));
        b1.add(txtMa = new JTextField());
        b.add(Box.createVerticalStrut(20));


        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblTen = new JLabel("Tên Nhà Cung Cấp: "));
        b2.add(txtTen = new JTextField());
        b2.add(Box.createHorizontalStrut(15));
        b2.add(lblDT = new JLabel("Điện Thoại: "));
        b2.add(txtDT = new JTextField());
        b.add(Box.createVerticalStrut(20));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(lbldiaChi = new JLabel("Địa Chỉ:    "));
        b3.add(txtdiaChi = new JTextField());

        b3.add(Box.createHorizontalStrut(20));
        b3.add(lblE = new JLabel("Email:       "));
        b3.add(txtE = new JTextField());
        b.add(Box.createVerticalStrut(20));
        pnNhap.add(b);

        JPanel pnChucVu = new JPanel();
        Box bcv  = Box.createHorizontalBox();
        pnChucVu.add(bcv);
        bcv.add(btnThem = new JButton("Thêm"));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png")));
        btnThem.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        bcv.add(Box.createHorizontalStrut(70));
        bcv.add(btnXoa = new JButton("Xóa"));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png")));
        btnXoa.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        bcv.add(Box.createHorizontalStrut(70));
        bcv.add(btnXoaRong = new JButton("Xóa Rỗng"));
        btnXoaRong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoarong.png")));
        btnXoaRong.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        bcv.add(Box.createHorizontalStrut(70));
        bcv.add(btnSua = new JButton("Sửa"));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sua.png")));
        btnSua.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        bcv.add(Box.createHorizontalStrut(70));
        bcv.add(btnThoat = new JButton("Thoát"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
        btnThoat.setBackground(Color.RED);
        btnThoat.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //pn =new TrangChu();
                gd = new GD_Chinh();
                gd.trangChu();
            }
        });

        nccDao = new DS_NhaCC();
        JPanel pnSouth = new JPanel();
        tableModel = new NhaCCTableModel(nccDao.getLS());
        table = new JTable(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(900,250));
        pnSouth.add(sc);


        pnCenter.add(pnNhap);
        pnCenter.add(pnChucVu);
        this.add(pnCenter,BorderLayout.CENTER);
        this.add(pnNorth, BorderLayout.NORTH);
        this.add(pnSouth,BorderLayout.SOUTH);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                if(r != -1){
                    txtMa.setText(tableModel.getValueAt(r,0).toString());
                    txtTen.setText(tableModel.getValueAt(r,1).toString());
                    txtDT.setText(tableModel.getValueAt(r,3).toString());
                    txtdiaChi.setText(tableModel.getValueAt(r,2).toString());
                    txtE.setText(tableModel.getValueAt(r,4).toString());

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

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtMa.getText().toString().equals("")){
                NhaCungCap ncc = new NhaCungCap(txtMa.getText().trim(), txtTen.getText().trim(),
                        txtdiaChi.getText().trim(),
                        Integer.parseInt(txtDT.getText().toString()),
                        txtE.getText().trim());
                if(nccDao.addNhaCungCap(ncc))
                    table.setModel(new NhaCCTableModel(nccDao.getLS()));
                // tableModel.fireTableDataChanged();
            }
                else
                    JOptionPane.showMessageDialog(null,"Bạn chưa nhập thông tin!");
             }
        });
        btnXoaRong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r != -1) {
                    int tb = JOptionPane.showConfirmDialog(null,"Bạn chắc chắn muốn xóa dòng này?","Delete",
                            JOptionPane.YES_NO_OPTION);
                    if(tb == JOptionPane.YES_OPTION) {
                        String maX = tableModel.getValueAt(r, 0).toString();
                        if (nccDao.deleteNCC(maX))
                            table.setModel(new NhaCCTableModel(nccDao.getLS()));
                        clearTextFields();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Bạn chưa chọn dòng cần xóa!");
                }
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if (r != -1){
                    String maS = tableModel.getValueAt(r, 0).toString();
                    NhaCungCap nccSua = new NhaCungCap(maS, txtTen.getText(), txtdiaChi.getText(),
                            Integer.parseInt(txtDT.getText().toString()), txtE.getText());
                    if(nccDao.updateNCC(maS,nccSua))
                        table.setModel(new NhaCCTableModel(nccDao.getLS()));
                    clearTextFields();

                }else {
                    JOptionPane.showMessageDialog(null,"Bạn chưa chọn dòng cần sửa!");
                }
            }
        });



        lblMa.setPreferredSize(lblTen.getPreferredSize());
        lbldiaChi.setPreferredSize(lblTen.getPreferredSize());

    }
    private void clearTextFields() {
        txtMa.setText("");
        txtTen.setText("");
        txtDT.setText("");
        txtdiaChi.setText("");
        txtE.setText("");
        txtMa.requestFocus();
    }
}
