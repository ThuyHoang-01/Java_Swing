package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enTiTy.XemTT;
import ketNoiSQL.DataBase;
import thucThi.DaoXemTourDaDat;
import java.util.List;

public class KH_XemDatTour extends JFrame  implements ActionListener{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		DefaultTableModel tableModel;
		JTable table;
		private JLabel lblTitle;
		private JButton btnthoat;
		DaoXemTourDaDat ld = new DaoXemTourDaDat();
		public KH_XemDatTour () {
			super("Xem thông tin đặt tour");
			setSize(1000, 400);
			setLocation(120, 100);
			setResizable(false);
			JPanel pnNorth = new JPanel();
			add(pnNorth, BorderLayout.NORTH);
			pnNorth.add(lblTitle = new JLabel("Thông Tin Tour Đã Đặt"));
			lblTitle.setFont(new Font("Times New Roman",Font.BOLD , 24));
			lblTitle.setForeground(Color.BLUE);
			pnNorth.setBackground(Color.PINK);
			
			
			JPanel pnCen = new JPanel();
			pnCen.setLayout(new BoxLayout(pnCen, BoxLayout.Y_AXIS));
			String[] headers = "Mã Đặt Tour;Tuyến;Mã Công Ty;Ngày khởi hành;Ngày kết thúc;Tỉnh/Thành Phố; Địa Điểm;Đơn Giá".split(";");
			tableModel = new DefaultTableModel(headers,0);
			JScrollPane scroll = new JScrollPane();
			scroll.setViewportView(table = new JTable(tableModel));

			table.setRowHeight(25);
			table.setAutoCreateRowSorter(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			 pnCen.add(scroll);
			pnCen.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
			add(pnCen, BorderLayout.CENTER);
			
			JPanel pnSouth = new JPanel();
			add(pnSouth, BorderLayout.SOUTH);
			pnSouth.add(btnthoat = new JButton("Thoát"));
			pnSouth.setBackground(Color.yellow);
			
			btnthoat.addActionListener(this);
			DataBase.getInstance().connect();
			xemThongTin();
			
		}
		public static void main(String[] args) {
			if(System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
				KH_DangNhapXem redirectLogin = new KH_DangNhapXem();
				redirectLogin.setVisible(true);					
				return;
			}
			KH_XemDatTour t = new KH_XemDatTour();
			t.setVisible(true);
		}
		public void xemThongTin() {
			List<XemTT> kn = ld.docTTDatTour();
			for(XemTT c: kn) {
				String [] data = {c.getId()+"",c.getName() ,c.getCompayID()+"",c.getNgaybatDau(), c.getNgayKetThuc()
						,c.getAddress(),c.getPlace(),  c.getDonGia()+""};
				tableModel.addRow(data);
			}
				table.setModel(tableModel);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o.equals(btnthoat)) {
				setVisible(false);
				
		}
			
		}
}
