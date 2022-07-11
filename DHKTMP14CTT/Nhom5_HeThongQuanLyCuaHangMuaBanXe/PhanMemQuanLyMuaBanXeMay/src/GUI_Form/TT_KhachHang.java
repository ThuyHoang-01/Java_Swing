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
public class TT_KhachHang extends JPanel {
    DS_KhachHang khDao;
    GD_Chinh gd;
    TrangChu pn;
    KHTableModel tableModel;
    JTable table;
    JLabel lblMa,lblTen,lbldiaChi,lblDT,lblE,lblGT;
    JTextField txtMa,txtTen,txtdiaChi,txtDT,txtE;
    JButton btnThem,btnXoa,btnSua,btnXoaRong,btnThoat;
    JComboBox<String> cbcGT;
    public TT_KhachHang() throws Exception {

        doShow();
    }
    public void doShow() throws Exception {
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("THÔNG TIN KHÁCH HÀNG");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(1000,270));
        JPanel pnNhap = new JPanel();
        pnNhap.setPreferredSize(new Dimension(900,200));
        pnNhap.setBorder(new TitledBorder("Nhập Thông Tin KH:"));

        Box b,b1,b2,b3;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(800,150));
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lblMa = new JLabel("Mã Khách Hàng: "));
        b1.add(txtMa = new JTextField());
        b1.add(Box.createHorizontalStrut(20));
        b1.add(lbldiaChi = new JLabel("Địa Chỉ:    "));
        b1.add(txtdiaChi = new JTextField());
        b.add(Box.createVerticalStrut(20));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblTen = new JLabel("Tên Khách Hàng: "));
        b2.add(txtTen = new JTextField());
        b2.add(Box.createHorizontalStrut(15));
        b2.add(lblDT = new JLabel("Điện Thoại: "));
        b2.add(txtDT = new JTextField());
        b.add(Box.createVerticalStrut(20));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(lblGT = new JLabel("Giới Tính: "));
        cbcGT = new JComboBox<>();
        cbcGT.addItem("Nam");
        cbcGT.addItem("Nữ");
        cbcGT.setPreferredSize(new Dimension(310,20));
        b3.add(cbcGT);
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

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cbcGT.getSelectedItem().toString());
                if(!txtMa.getText().toString().equals("")){
                    KhachHang kh = new KhachHang(txtMa.getText().trim(), txtTen.getText().trim(),
                            cbcGT.getSelectedItem().toString(),
                            txtdiaChi.getText().trim(),
                            Integer.parseInt(txtDT.getText().toString()),
                            txtE.getText().trim());
                    if(khDao.addKhachHang(kh)) {
                        try {
                            table.setModel(new KHTableModel(khDao.getLS()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                       // tableModel.fireTableDataChanged();
                }
                else
                    JOptionPane.showMessageDialog(null,"Bạn chưa nhập thông tin !");
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
                        if (khDao.deleteKH(maX)) {
                            try {
                                table.setModel(new KHTableModel(khDao.getLS()));
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
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
                System.out.println(cbcGT.getSelectedItem().toString());
                int r = table.getSelectedRow();
                if (r != -1){
                    String maS = tableModel.getValueAt(r, 0).toString();
                    KhachHang khSua = new KhachHang(maS, txtTen.getText(), cbcGT.getSelectedItem().toString(), txtdiaChi.getText(),
                            Integer.parseInt(txtDT.getText().toString()), txtE.getText());
                    System.out.println(khSua);
                    if(khDao.updateKhachHang(maS,khSua)) {
                        try {
                            table.setModel(new KHTableModel(khDao.getLS()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    clearTextFields();

                }else {
                    JOptionPane.showMessageDialog(null,"Bạn chưa chọn dòng cần sửa!");
                }
            }
        });
        khDao = new DS_KhachHang();
        JPanel pnSouth = new JPanel();
        tableModel = new KHTableModel(khDao.getLS());
        table = new JTable(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(900,250));
        pnSouth.add(sc);


        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                if(r != -1){
                    txtMa.setText(tableModel.getValueAt(r,0).toString());
                    txtTen.setText(tableModel.getValueAt(r,1).toString());
                    if(tableModel.getValueAt(r,2).toString().equals("Nam"))
                        cbcGT.setSelectedIndex(0);
                    else if(tableModel.getValueAt(r,2).toString().equals("Nữ"))
                        cbcGT.setSelectedIndex(1);
                    txtDT.setText(tableModel.getValueAt(r,4).toString());
                    txtdiaChi.setText(tableModel.getValueAt(r,3).toString());
                    txtE.setText(tableModel.getValueAt(r,5).toString());

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


        pnCenter.add(pnNhap);
        pnCenter.add(pnChucVu);
        this.add(pnCenter,BorderLayout.CENTER);
        this.add(pnNorth, BorderLayout.NORTH);
        this.add(pnSouth,BorderLayout.SOUTH);


        lblMa.setPreferredSize(lblTen.getPreferredSize());
        lblGT.setPreferredSize(lblTen.getPreferredSize());
    }
    private void clearTextFields() {
        txtMa.setText("");
        txtTen.setText("");
        cbcGT.setSelectedIndex(0);
        txtDT.setText("");
        txtdiaChi.setText("");
        txtE.setText("");
        txtMa.requestFocus();
    }
}
