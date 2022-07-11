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

public class TT_NhanVien extends JPanel {
    GD_Chinh gd;
    TrangChu pn;
    NVTableModel tableModel;
    JTable table;
    JLabel lblMa,lblTen,lbldiaChi,lblDT,lblE,lblGT,lblCV,lblCMND,lblNS,lblNgayVao;
    JTextField txtMa,txtTen,txtdiaChi,txtDT,txtE,txtCMND,txtNS,txtNgayVao;
    JButton btnThem,btnXoa,btnSua,btnXoaRong,btnThoat;
    DS_NhanVien nvDao;
    JComboBox<String> cbcGT,cbcCV;
    public TT_NhanVien(){

        doShow();
    }
    public void doShow() {
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(1000,330));
        JPanel pnNhap = new JPanel();
        pnNhap.setPreferredSize(new Dimension(900,270));
        pnNhap.setBorder(new TitledBorder("Nhập Thông Tin NV:"));

        Box b,b1,b2,b3,b4,b5;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(800,230));
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lblMa = new JLabel("Mã Nhân Viên: "));
        b1.add(txtMa = new JTextField());
        b1.add(Box.createHorizontalStrut(10));
        b1.add(lblDT = new JLabel("Số Điện Thoại:    "));
        b1.add(txtDT = new JTextField());
        b.add(Box.createVerticalStrut(15));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblTen = new JLabel("Tên Nhân Viên: "));
        b2.add(txtTen = new JTextField());
        b2.add(Box.createHorizontalStrut(10));
        b2.add(lblCV = new JLabel("Chức Vụ:           "));
        cbcCV = new JComboBox<String>();
        cbcCV.addItem("Quản Lý");
        cbcCV.addItem("Nhân Viên");
        cbcCV.setPreferredSize(new Dimension(305,20));
        b2.add(cbcCV);
        b.add(Box.createVerticalStrut(15));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(lblGT = new JLabel("Giới Tính: "));
        cbcGT = new JComboBox<>();
        cbcGT.addItem("Nam");
        cbcGT.addItem("Nữ");
        cbcGT.setPreferredSize(new Dimension(305,20));
        b3.add(cbcGT);
        b3.add(Box.createHorizontalStrut(10));
        b3.add(lblCMND = new JLabel("Số CMND:          "));
        b3.add(txtCMND = new JTextField());
        b.add(Box.createVerticalStrut(15));

        b.add(b4 = Box.createHorizontalBox());
        b4.add(lblNS = new JLabel("Ngày Sinh: "));
        b4.add(txtNS = new JTextField());
        b4.add(Box.createHorizontalStrut(10));
        b4.add(lblNgayVao = new JLabel("Ngày Vào Làm:   "));
        b4.add(txtNgayVao = new JTextField());
        b.add(Box.createVerticalStrut(15));

        b.add(b5 = Box.createHorizontalBox());
        b5.add(lbldiaChi = new JLabel("Địa Chỉ: "));
        b5.add(txtdiaChi = new JTextField());
        b5.add(Box.createHorizontalStrut(10));
        b5.add(lblE = new JLabel("Lương:                "));
        b5.add(txtE = new JTextField());
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


        nvDao = new DS_NhanVien();
        JPanel pnSouth = new JPanel();
        table = new JTable();
        tableModel = new NVTableModel(nvDao.getLS());
        table.setModel(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(900,240));
        pnSouth.add(sc);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtMa.getText().toString().equals("")){
                NhanVien nv = new NhanVien(txtMa.getText().trim(), txtTen.getText().trim(),
                        cbcGT.getSelectedItem().toString(),
                        Integer.parseInt(txtDT.getText().trim().toString()),
                        Integer.parseInt(txtCMND.getText().trim().toString()),
                        txtNS.getText(),
                        txtNgayVao.getText(),
                        cbcCV.getSelectedItem().toString(),
                        txtdiaChi.getText().trim(),
                        Double.parseDouble(txtE.getText().trim()));
                if(nvDao.addNhanVien(nv))
                    table.setModel(new NVTableModel(nvDao.getLS()));
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
                        if (nvDao.deleteNV(maX))
                            table.setModel(new NVTableModel(nvDao.getLS()));
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
                    NhanVien nvSua = new NhanVien(maS, txtTen.getText().trim(),
                            cbcGT.getSelectedItem().toString(),
                            Integer.parseInt(txtDT.getText().trim().toString()),
                            Integer.parseInt(txtCMND.getText().trim().toString()),
                            txtNS.getText(),
                            txtNgayVao.getText(),
                            cbcCV.getSelectedItem().toString(),
                            txtdiaChi.getText().trim(),
                            Double.parseDouble(txtE.getText().trim()));
                    if(nvDao.updateNhanVien(maS,nvSua)) {
                        table.setModel(new NVTableModel(nvDao.getLS()));
                        tableModel.fireTableDataChanged();
                    }
                    clearTextFields();

                }else {
                    JOptionPane.showMessageDialog(null,"Bạn chưa chọn dòng cần sửa!");
                }
            }
        });
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
                    txtDT.setText(tableModel.getValueAt(r,3).toString());
                    txtCMND.setText(tableModel.getValueAt(r,4).toString());
                    txtNS.setText(tableModel.getValueAt(r,5).toString());
                    txtNgayVao.setText(tableModel.getValueAt(r,6).toString());
                    if(tableModel.getValueAt(r,7).toString().equals("Quản Lý"))
                        cbcCV.setSelectedIndex(0);
                    else if(tableModel.getValueAt(r,7).toString().equals("Nhân Viên"))
                        cbcCV.setSelectedIndex(1);
                    txtdiaChi.setText(tableModel.getValueAt(r,8).toString());
                    txtE.setText(tableModel.getValueAt(r,9).toString());

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
        lblNS.setPreferredSize(lblTen.getPreferredSize());
        lblNgayVao.setPreferredSize(lblTen.getPreferredSize());
        lbldiaChi.setPreferredSize(lblTen.getPreferredSize());


    }
    private void clearTextFields() {
        txtMa.setText("");
        txtTen.setText("");
        cbcGT.setSelectedIndex(0);
        txtDT.setText("");
        txtdiaChi.setText("");
        txtE.setText("");
        txtMa.requestFocus();
        txtCMND.setText("");
        txtNS.setText("");
        txtNgayVao.setText("");
        cbcCV.setSelectedIndex(0);
    }
}
