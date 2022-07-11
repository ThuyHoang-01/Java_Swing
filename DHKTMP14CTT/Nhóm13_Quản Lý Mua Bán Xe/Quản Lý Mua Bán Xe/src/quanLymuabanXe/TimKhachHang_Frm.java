package quanLymuabanXe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class TimKhachHang_Frm extends JFrame implements ActionListener {

	private JTextField txtTimKiem;
	private JLabel lblTimKiem,lblTieuDe;
	private JButton btnTim;
	private JTable tableTimNV;
	private DefaultTableModel dtmTImNV;
	DanhSachKhachHang dskh = new DanhSachKhachHang();
	public  TimKhachHang_Frm() {
		setTitle("^_^");
		setSize(600,580);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		JPanel pNorth =new JPanel();
		pNorth.setLayout(null);
		pNorth.add(lblTimKiem=new JLabel("Ten Khach Hang:"));
		pNorth.add(txtTimKiem=new JTextField());
		pNorth.add(btnTim = new JButton("Tim "));
		lblTimKiem.setBounds(50, 20, 150, 20);
		txtTimKiem.setBounds(180,20 , 300, 20);
		btnTim.setBounds(480,20 , 70, 20);
		add(pNorth,BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(0, 70));
	
		String [] headers = "Ma Khach Hang;Ten Khach Hang;Dia Chi;So Dien Thoai". split(";");
		dtmTImNV=new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll. setViewportView(tableTimNV = new JTable(dtmTImNV));
		tableTimNV. setRowHeight(25);
		tableTimNV. setAutoCreateRowSorter(true);
		tableTimNV. setAutoResizeMode(JTable. AUTO_RESIZE_NEXT_COLUMN);
		add(scroll,BorderLayout.CENTER);
		DataBase.getInstance().connect();
		updateTableData();
		btnTim.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceEvent = e.getSource();
		if (sourceEvent.equals(btnTim)) {
			KhachHang nv = dskh.search(txtTimKiem.getText());
			try {
			if(nv==null) {
				JOptionPane.showMessageDialog(this, "Khong tim thay");
			}else {
				String [] datarow = {
						nv.getMaKH(),
						nv.getTenKH(),
						nv.getDiaChi(),
						nv.getSoDienThoai()+"",
					};
				dtmTImNV.setRowCount(0);
				dtmTImNV.addRow(datarow);
			}
			} catch (Exception e1) {
			e1.printStackTrace();
		}
		}
			
		
	}
	private void updateTableData() {
		DanhSachKhachHang ds = new DanhSachKhachHang();
		ArrayList<KhachHang> list = ds.docTuBang();
		for (KhachHang s : list) {
			String [] rowData = {s.getMaKH(),s.getTenKH(),s.getDiaChi(),s.getSoDienThoai()+""};
			dtmTImNV.addRow(rowData);
		}
		tableTimNV.setModel(dtmTImNV);
		
	}
	
	public static void main(String[] args) {
		new TimKhachHang_Frm();
	}
	
}
