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

public class KH_DatTour extends JFrame implements ActionListener,MouseListener {
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
	public KH_DatTour() {
		
		super("Main Form Khách Hàng Sau Khi đăng nhập thành công");
			
		setSize(1200, 600);
		setLocation(100, 50);
		setResizable(false);

		JPanel pNorth = new JPanel();
		pNorth.add(lblTitle = new JLabel("TOUR DU LỊCH"));
		
		lblTitle.setFont(new Font("Time news Roman",Font.BOLD,20));
		lblTitle.setForeground(Color.BLUE);
		
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
		add(pBottom);
		
		JPanel pSouth= new JPanel();
		pSouth.add(btnDatTour = new JButton("Đặt Tour"));
		btnDatTour.setBackground(Color.pink);
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.pink);
		pSouth.add(btnLogOut = new JButton("Đăng Xuất"));
		btnLogOut.setBackground(Color.pink);
		add(pSouth,BorderLayout.SOUTH);
		
		btnDatTour.addActionListener(this);
		btnThoat.addActionListener(this);
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
			
		if(obj.equals(btnThoat)) {
			setVisible(false);
			new Menu().setVisible(true);
		}
		if(obj.equals(btnLogOut)) {
			setVisible(false);
			new KH_DangNhapDT().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		
		if(System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
			KH_DangNhapDT redirectLogin = new KH_DangNhapDT();
			redirectLogin.setVisible(true);	
			return;
		}
		KH_DatTour na =new KH_DatTour();
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
