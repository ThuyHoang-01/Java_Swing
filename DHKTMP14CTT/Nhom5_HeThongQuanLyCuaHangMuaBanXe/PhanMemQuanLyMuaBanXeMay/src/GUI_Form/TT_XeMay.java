package GUI_Form;
import Dao.DS_LoaiXe;
import Dao.DS_XeMay;
import Entity.LoaiXe;
import Entity.XeMay;
import Model.XeTableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TT_XeMay extends JPanel {
    DS_LoaiXe lxDao;
    DS_XeMay xeDao;
    GD_Chinh gd;
    XeTableModel tableModel;
    JTable table;
    JLabel lblMa,lblMaLoai,lblSoKhung,lblSoMay,lblMau,lblGia;
    JTextField txtMa,txtML,txtSK,txtSM,txtMau,txtGia;
    JComboBox<String> cbML;
    JButton btnThem,btnXoa,btnSua,btnXoaRong,btnThoat;
    public TT_XeMay(){

        doShow();
    }
    public void doShow() {
        this.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("THÔNG TIN XE MÁY");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(1000,270));
        JPanel pnNhap = new JPanel();
        pnNhap.setPreferredSize(new Dimension(900,200));
        pnNhap.setBorder(new TitledBorder("Nhập Thông Tin Xe Máy:"));

        Box b,b1,b2,b3,b4;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(800,150));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblMa = new JLabel("Mã Xe: "));
        b2.add(txtMa = new JTextField());
        b2.add(Box.createHorizontalStrut(15));
        cbML = new JComboBox<String>();
        lxDao = new DS_LoaiXe();
        for( LoaiXe lx : lxDao.getLS()){
            System.out.println(lx.getMaLoai());
            cbML.addItem(lx.getMaLoai());}
        cbML.setPreferredSize(new Dimension(340,20));

        b2.add(lblMaLoai = new JLabel("Mã Loại:"));
        b2.add(cbML);
        b.add(Box.createVerticalStrut(20));

        b.add(b3 = Box.createHorizontalBox());
        b3.add(lblSoKhung = new JLabel("Số Khung:"));
        b3.add(txtSK = new JTextField());
        b3.add(Box.createHorizontalStrut(15));
        b3.add(lblSoMay = new JLabel("Số Máy:"));
        b3.add(txtSM = new JTextField());
        b.add(Box.createVerticalStrut(20));

        b.add(b4 = Box.createHorizontalBox());
        b4.add(lblMau = new JLabel("Màu Xe:"));
        b4.add(txtMau = new JTextField());
        b4.add(Box.createHorizontalStrut(15));
        b4.add(lblGia = new JLabel("Đơn Giá:"));
        b4.add(txtGia = new JTextField());
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

        xeDao = new DS_XeMay();
        JPanel pnSouth = new JPanel();
        tableModel = new XeTableModel(xeDao.getLS());
        table = new JTable(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(900,250));
        pnSouth.add(sc);

        lblMa.setPreferredSize(lblSoKhung.getPreferredSize());
        lblMau.setPreferredSize(lblSoKhung.getPreferredSize());

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
                    if(tableModel.getValueAt(r,1).toString().equals("LX01")){
                        cbML.setSelectedIndex(0);
                    }else if(tableModel.getValueAt(r,1).toString().equals("LX02")){
                        cbML.setSelectedIndex(1);
                    }else if(tableModel.getValueAt(r,1).toString().equals("LX03")){
                        cbML.setSelectedIndex(2);
                    }
                    txtSK.setText(tableModel.getValueAt(r,2).toString());
                    txtSM.setText(tableModel.getValueAt(r,3).toString());
                    txtMau.setText(tableModel.getValueAt(r,4).toString());
                    txtGia.setText(tableModel.getValueAt(r,5).toString());

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
                    XeMay xm = new XeMay(txtMa.getText().trim(), cbML.getSelectedItem().toString(),
                            Integer.parseInt(txtSK.getText().toString()),
                            Integer.parseInt(txtSM.getText().toString()),
                            txtMau.getText().trim(),
                            Double.parseDouble(txtGia.getText().trim()));

                    if(xeDao.addXeMay(xm)) {
                        table.setModel(new XeTableModel(xeDao.getLS()));
                    }
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
                        if (xeDao.deleteXe(maX)) {
                            table.setModel(new XeTableModel(xeDao.getLS()));
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
                int r = table.getSelectedRow();
                if (r != -1){
                    String maS = tableModel.getValueAt(r, 0).toString();
                    XeMay khSua = new XeMay(maS, cbML.getSelectedItem().toString(),
                            Integer.parseInt(txtSK.getText().toString()),
                            Integer.parseInt(txtSM.getText().toString()),
                            txtMau.getText().trim(),
                            Double.parseDouble(txtGia.getText().trim()));
                    if(xeDao.updateXeMay(maS,khSua)) {
                        table.setModel(new XeTableModel(xeDao.getLS()));
                    }
                    clearTextFields();

                }else {
                    JOptionPane.showMessageDialog(null,"Bạn chưa chọn dòng cần sửa!");
                }
            }
        });
    }
    private void clearTextFields() {
        txtMa.setText("");
        cbML.setSelectedIndex(0);
        txtSK.setText("");
        txtSM.setText("");
        txtMau.setText("");
        txtGia.setText("");
        txtMa.requestFocus();
    }
}
