package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import enTiTy.CarriageTrip;
import ketNoiSQL.DataBase;
import thucThi.DaoKhachHang_SauDN;
import thucThi.DaoNV_SauDN;

public class KH_Main_Frm extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4693340488951533494L;
	public JTextField txtTimKiem;
	public JLabel lblTimKiem,lblTitle;
	public JButton btnTimKiem, btnDangNhap,btnDangKiTK,btnThoat,btnQuayLai;
	public JTable table;
	public DefaultTableModel tableModel;
	DaoKhachHang_SauDN dskh = new DaoKhachHang_SauDN();
	public KH_Main_Frm() {
		super("Main Form Khách Hàng");
		setSize(1200, 600);
		setLocation(100,50);
		setResizable(false);
		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("TOUR DU LỊCH"));
		lblTitle.setFont(new Font("Time news Roman",Font.BOLD,20));
		lblTitle.setForeground(Color.BLUE);
		add(pNorth,BorderLayout.NORTH);
		
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		add(split, BorderLayout.CENTER);
		
		Box pTop = Box.createHorizontalBox();
		Box b1,b2,b3;

		pTop.add(b1 = Box.createHorizontalBox());
		b1.add(lblTimKiem = new JLabel("Nhập mã muốn tìm: "));
		b1.add(txtTimKiem = new JTextField(10));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnTimKiem = new JButton("Tìm Kiếm"));
		btnTimKiem.setBackground(Color.yellow);
		b1.add(Box.createHorizontalStrut(20));
		
		pTop.add(b2 = Box.createHorizontalBox());
		b2.add(btnDangNhap = new JButton("Đăng Nhập"));
		btnDangNhap.setBackground(Color.yellow);
		b2.add(Box.createHorizontalStrut(20));
		
		pTop.add(b3 = Box.createHorizontalBox());
		b3.add(btnDangKiTK = new JButton("Đăng ký tài khoản"));
		btnDangKiTK.setBackground(Color.yellow);

		pTop.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
		split.add(pTop);
		
		JPanel pBottom = new JPanel();
		pBottom.setLayout(new BoxLayout(pBottom, BoxLayout.Y_AXIS));
		String[] headers = "Mã Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		pBottom.add(scroll);
		
		pBottom.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
		split.add(pBottom);
		
		JPanel pSouth= new JPanel();
		pSouth.add(btnQuayLai = new JButton("Quay Lại"));
		btnQuayLai.setBackground(Color.green);
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.green);
		add(pSouth,BorderLayout.SOUTH);
		
		btnTimKiem.addActionListener(this);
		btnDangKiTK.addActionListener(this);
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		btnQuayLai.addActionListener(this);
		
		DataBase.getInstance().connect();
		update();
	
	}

	public void update() {
		List<CarriageTrip> ls = dskh.docTT();
		for(CarriageTrip c : ls) {
			String []data = {c.getId()+"",c.getName(), c.getCompayid()+"", c.getNgayBatDau(), c.getNgayKetThuc()
					,c.getPlace(), c.getAddress(), c.getDonGia()+""};
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnTimKiem)) {
			String nhap = txtTimKiem.getText();
			if(nhap.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã muốn tìm!");
				return;
			}else {
			DaoNV_SauDN nv = new DaoNV_SauDN();
			List<CarriageTrip> ls = nv.Search(txtTimKiem.getText());
			for(CarriageTrip c : ls) {
				String []data = {c.getId()+"",c.getName(), c.getCompayid()+"", c.getNgayBatDau(), c.getNgayKetThuc()
						,c.getPlace(), c.getAddress(), c.getDonGia()+""};
				tableModel.setRowCount(0);
				tableModel.addRow(data);
			}
			table.setModel(tableModel);
			}
		}
			
			
		if(obj.equals(btnDangNhap)) {
			setVisible(false);
			new KH_DangNhapCS().setVisible(true);
		}
			
		if(obj.equals(btnDangKiTK)) {
			new KH_DangKy().setVisible(true);;
		}
		
		if(obj.equals(btnThoat)) {
			System.exit(0);
			setVisible(false);
			new Main_Frm().setVisible(true);
			
		}
		if(obj.equals(btnQuayLai)) {
			setVisible(false);
			new KH_Main_Frm().setVisible(true);
		}
	}

	public static void main(String[] args) {
		KH_Main_Frm kh= new KH_Main_Frm();
		kh.setVisible(true);
	}

	
}
