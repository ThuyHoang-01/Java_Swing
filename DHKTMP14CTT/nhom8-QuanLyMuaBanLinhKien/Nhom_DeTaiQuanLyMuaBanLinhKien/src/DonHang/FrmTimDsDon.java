package DonHang;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmTimDsDon extends JFrame implements ActionListener{
	private JTable tabletim;
	public static DefaultTableModel tableModeltim;
	private JTextField txtTimKiem;
	private JLabel lbltimkiem;
	private JButton btnTim,btnThoat,btnCapNhat;
	
	public FrmTimDsDon() {
		super("Danh sách các mặt hàng");
		setSize(900, 500);
		setLocation(50, 100);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Box btim = Box.createVerticalBox();
		Box btim1,btim2;
		
		btim.add(btim1 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(15));
		btim1.add(lbltimkiem = new JLabel("Nhập đơn hàng muốn tìm:"));
		btim1.add(Box.createHorizontalStrut(35));
		btim1.add(txtTimKiem = new JTextField());
		btim1.add(btnTim = new JButton("Tìm"));
		//btim1.add(btnCapNhat = new JButton("Cập nhật"));
		btim1.add(btnThoat = new JButton("Thoát"));
		
		btim.add(btim2 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(10));
		
		String [] headertim ="Số hoá đơn; Mã khách hàng; Mã nhân viên; Ngày đặt hàng;Ngày chuyển hàng;Nơi giao hàng".split(";");
		tableModeltim = new DefaultTableModel(headertim,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabletim = new JTable(tableModeltim));
		tabletim.setRowHeight(25);
		tabletim.setAutoCreateRowSorter(true);
		tabletim.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		btim2.add(scroll);
		btim.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));
		add(btim,BorderLayout.CENTER);
		
		btnThoat.addActionListener(this);
		btnCapNhat.addActionListener(this);
		//DataBase.getInstance().connect();
		//updateTableData();
	}
	
//	private void updateTableData() {
//		ListDonHang ds = new ListDonHang();
//		ArrayList<DonHang> list = ds.docTuBang();
//		for (DonHang dh : list) {
//			String [] rowData = {dh.getSoHD(),dh.getMaKH(),dh.getMaNV(),dh.getNgayDH(),dh.getNgayCH,dh.getNoiGiaoHang()+""};
//			tableModeltim.addRow(rowData);
//		}
//		tabletim.setModel(tableModeltim);
//		tabletim.setEnabled(false);
//		
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		if(o.equals(btnCapNhat)) {
			new FrmDonHang().setVisible(true);
			//FrmDonHang.btnBuocTiep.setEnabled(false);
			//FrmDonHang.btnThoat.setEnabled(false);
		}
	}
	public static void main(String[] args) {
		new FrmTimDsDon().setVisible(true);;
	}


}
