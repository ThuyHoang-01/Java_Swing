package giaoDienBT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import enTiTy.CarriageTrip;
import ketNoiSQL.DataBase;
import thucThi.DaoKhachHang_SauDN;
import thucThi.DaoNV_SauDN;
import thucThi.DaoXemTourDaDat;

import java.util.ArrayList;
import java.util.List;

public class KH_SauDangNhap extends JFrame implements ActionListener,MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtTimKiem;
	public JLabel lblTimKiem,lblTitle;
	public JButton btnTimKiem, btnDatTour,btnXemTourDaDat,btnThongTinCN,btnThoat,btnQuayLai,btnLogOut;
	public JTable table;
	public DefaultTableModel tableModel;
	DaoKhachHang_SauDN dskh = new DaoKhachHang_SauDN();
	DaoXemTourDaDat mn = new DaoXemTourDaDat();
	public KH_SauDangNhap() {
		
		super("Main Form Khách Hàng Sau Khi đăng nhập thành công");
			
		setSize(1200, 600);
		setLocation(100, 50);
		setResizable(false);

		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("TOUR DU LỊCH"));
		
		lblTitle.setFont(new Font("Time news Roman",Font.BOLD,20));
		lblTitle.setForeground(Color.BLUE);
		add(pNorth,BorderLayout.NORTH);
		
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		add(split, BorderLayout.CENTER);
		
		Box pTop = Box.createHorizontalBox();
		Box b1,b2,b3,b4;

		pTop.add(b1 = Box.createHorizontalBox());
		b1.add(lblTimKiem = new JLabel("Nhập mã muốn tìm: "));
		b1.add(txtTimKiem = new JTextField(10));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(btnTimKiem = new JButton("Tìm Kiếm"));
		btnTimKiem.setBackground(Color.ORANGE);
		b1.add(Box.createHorizontalStrut(20));
		
		pTop.add(b2 = Box.createHorizontalBox());
		b2.add(btnXemTourDaDat = new JButton("Xem các tour đã đặt"));
		btnXemTourDaDat.setBackground(Color.ORANGE);
		b2.add(Box.createHorizontalStrut(20));
		
		pTop.add(b3 = Box.createHorizontalBox());
		b3.add(btnThongTinCN = new JButton("Thông tin cá nhân"));
		btnThongTinCN.setBackground(Color.ORANGE);
		b3.add(Box.createHorizontalStrut(20));
		
		pTop.add(b4 = Box.createHorizontalBox());
		b4.add(btnLogOut = new JButton("Đăng Xuất"));
		btnLogOut.setBackground(Color.ORANGE);

		
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
		pBottom.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		split.add(pBottom);
		
		JPanel pSouth= new JPanel();
		pSouth.add(btnDatTour = new JButton("Đặt Tour"));
		btnDatTour.setBackground(Color.pink);
		pSouth.add(btnQuayLai = new JButton("Quay Lại"));
		btnQuayLai.setBackground(Color.pink);
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.pink);
		add(pSouth,BorderLayout.SOUTH);
		
		btnTimKiem.addActionListener(this);
		btnDatTour.addActionListener(this);
		btnThongTinCN.addActionListener(this);
		btnXemTourDaDat.addActionListener(this);
		btnThoat.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnLogOut.addActionListener(this);
		
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
			
			
		if(obj.equals(btnDatTour)) {
			int rowSelected = table.getSelectedRow();		
			List<CarriageTrip> ls = new ArrayList<CarriageTrip>();
			
			if(mn.DatTour(Integer.parseInt(table.getValueAt(rowSelected, 0).toString())))  {
				JOptionPane.showMessageDialog(this, "Thành công");
				KH_XemDatTour redirectSuccess = new KH_XemDatTour();
				redirectSuccess.setVisible(true);
				tableModel.removeRow(rowSelected);
			}
			else {
				JOptionPane.showMessageDialog(this, "Không thành công, vui lòng thử lại");
			}
		}
		
		if(obj.equals(btnXemTourDaDat)) {
			KH_XemDatTour l= new KH_XemDatTour();
			l.setVisible(true);
			 
		}
			
		if(obj.equals(btnThongTinCN)) {
			KH_ChinhSuaTTCN z = new KH_ChinhSuaTTCN();
			z.setVisible(true);
		
		}
		
		if(obj.equals(btnThoat)) {
			setVisible(false);
			new Menu().setVisible(true);
		}
		if(obj.equals(btnQuayLai)) {
			setVisible(false);
			new KH_SauDangNhap().setVisible(true);
		}
		if(obj.equals(btnLogOut)) {
			setVisible(false);
			new KH_Main_Frm().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		
		if(System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
			KH_DangNhapCS redirectLogin = new KH_DangNhapCS();
			redirectLogin.setVisible(true);			
			return;
		}
		KH_SauDangNhap na =new KH_SauDangNhap();
		na.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		
		
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
