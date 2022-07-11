package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import enTiTy.CarriageTrip;
import ketNoiSQL.DataBase;
import thucThi.DaoNV_SauDN;

public class NV_ThemTour extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	public JTextField txtTimKiem,txtMaTour,txtTuyen,txtMaCongTy,txtNgayKhoiHanh,txtNgayKetThuc,txtTinh,txtDiaDiem,txtDonGia;
	public JLabel lblTimKiem,lblTitle,lblMaTour,lblTuyen,lblMaCongTy,lblNgayKhoiHanh,lblNgayKetThuc,lblTinh,lblDiaDiem,lblDonGia;
	public JButton btnTimKiem,btnThem,btnThoat, btnXoa, btnXoaTrang,btnChinhSua, btnQuayLai,btnDangXuat;
	public JTable table;
	public DefaultTableModel tableModel;
	DaoNV_SauDN dstour = new DaoNV_SauDN();
	
	public NV_ThemTour() {
		super("Main Form Nhân viên Sau Khi đăng nhập thành công");
		setSize(1000, 600);
		setResizable(false);
		setLocation(100, 30);
		setResizable(false);
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("TOUR DU LỊCH"));
		lblTitle.setFont(new Font("Time news Roman",Font.BOLD,20));
		lblTitle.setForeground(Color.BLUE);
		pNorth.setBackground(Color.yellow);
		add(pNorth,BorderLayout.NORTH);
		
		
		Box c = Box.createVerticalBox();
		Box c1,c2,c3,c4,c5,c6,c7,c8,c9;
		
		c.add(c1 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c1.add(lblMaTour = new JLabel("Mã Tour: "));
		c1.add(txtMaTour= new JTextField());
		
		c.add(c2 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c2.add(lblTuyen = new JLabel("Tuyến: "));
		c2.add(txtTuyen = new JTextField());
		c.add(c3 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c3.add(lblMaCongTy = new JLabel("Mã công ty: "));
		c3.add(txtMaCongTy= new JTextField());
		c.add(c4 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c4.add(lblNgayKhoiHanh = new JLabel("Ngày khởi hành: "));
		c4.add(txtNgayKhoiHanh = new JTextField());
		c.add(c5 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c5.add(lblNgayKetThuc = new JLabel("Ngày kết thúc: "));
		c5.add(txtNgayKetThuc = new JTextField());
		
		c.add(c6 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c6.add(lblTinh = new JLabel("Tỉnh / Thành phố: "));
		c6.add(txtTinh= new JTextField());
		
		c.add(c7 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c7.add(lblDiaDiem = new JLabel("Địa điểm: "));
		c7.add(txtDiaDiem = new JTextField());
		
		c.add(c8 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		c8.add(lblDonGia = new JLabel("Đơn giá: "));
		c8.add(txtDonGia = new JTextField());
		
		lblTuyen.setPreferredSize(lblTinh.getPreferredSize());
		lblDiaDiem.setPreferredSize(lblTinh.getPreferredSize());
		lblDonGia.setPreferredSize(lblTinh.getPreferredSize());
		lblNgayKhoiHanh.setPreferredSize(lblTinh.getPreferredSize());
		lblNgayKetThuc.setPreferredSize(lblTinh.getPreferredSize());
		lblMaTour.setPreferredSize(lblTinh.getPreferredSize());
		lblMaCongTy.setPreferredSize(lblTinh.getPreferredSize());
		
		c.add(c9 = Box.createHorizontalBox());
		c.add(Box.createVerticalStrut(10));
		String[] headers = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		c.add(scroll);
		c.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		add(c);
		
		JPanel pSouth= new JPanel();
		pSouth.add(btnThem = new JButton("Thêm"));
		btnThem.setBackground(Color.red);
		pSouth.add(btnXoaTrang = new JButton("Xóa Trắng"));
		btnXoaTrang.setBackground(Color.green);
		pSouth.add(btnQuayLai = new JButton("Quay Lại"));
		btnQuayLai.setBackground(Color.green);
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.green);
		pSouth.setBackground(Color.LIGHT_GRAY);
		add(pSouth,BorderLayout.SOUTH);
		
		
		
		btnThem.addActionListener(this);		
		btnThoat.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		table.addMouseListener(this);
		DataBase.getInstance().connect();
		updataTableData();
		txtMaTour.setEditable(false);
	
	}
	private void updataTableData() {
		DaoNV_SauDN nv = new DaoNV_SauDN();
		List<CarriageTrip> ls = nv.docTT();
		for(CarriageTrip c : ls) {
			String []data = {c.getId()+"",c.getName(), c.getCompayid()+"", c.getNgayBatDau(), c.getNgayKetThuc()
					,c.getPlace(), c.getAddress(), c.getDonGia()+""};
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
		
	}
	public void xoaTrang() {
		txtMaTour.setText("");
		txtTuyen.setText("");
		txtMaCongTy.setText("");
		txtNgayKhoiHanh.setText("");
		txtNgayKetThuc.setText("");
		txtTinh.setText("");
		txtDiaDiem.setText("");
		txtDonGia.setText("");
		
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			if(dstour.create( txtTuyen.getText(),Integer.parseInt( txtMaCongTy.getText()), txtNgayKhoiHanh.getText(), 
					txtNgayKetThuc.getText(),txtTinh.getText(), txtDiaDiem.getText(), Double.parseDouble(txtDonGia.getText()))) {
				Object[] rowData = {txtTuyen.getText(),Integer.parseInt( txtMaCongTy.getText()), txtNgayKhoiHanh.getText(), 
						txtNgayKetThuc.getText(),txtTinh.getText(), txtDiaDiem.getText(), Double.parseDouble(txtDonGia.getText())};
				tableModel.addRow(rowData);
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
				setVisible(false);
				new NV_ThemTour().setVisible(true);
			}
			
		}else if(obj.equals(btnXoaTrang)) {
			xoaTrang();
			
		}else if(obj.equals(btnThoat)) {
			setVisible(false);
			new Menu().setVisible(true);
		}
	
	}

	public static void main(String[] args) {
		NV_ThemTour fm = new NV_ThemTour();
		fm.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaTour.setText(table.getValueAt(row, 0).toString());
		txtTuyen.setText(table.getValueAt(row, 1).toString());
		txtMaCongTy.setText(table.getValueAt(row, 2).toString());
		txtNgayKhoiHanh.setText(table.getValueAt(row, 3).toString());
		txtNgayKetThuc.setText(table.getValueAt(row, 4).toString());
		txtTinh.setText(table.getValueAt(row, 5).toString());
		txtDiaDiem.setText(table.getValueAt(row,6).toString());
		txtDonGia.setText(table.getValueAt(row, 7).toString());	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
