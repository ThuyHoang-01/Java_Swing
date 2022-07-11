package NhanVien;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmTimNhanVien extends JFrame implements ActionListener{
	
	private JTable tabletim;
	public static DefaultTableModel tableModeltim;
	private JTextField txtTimKiem;
	private JLabel lbltimkiem;
	private JButton btnTim,btnThoat;
	private DanhSachNV dsnv = new DanhSachNV();
	public FrmTimNhanVien() {
		super("Tìm theo nhân viên");
		setSize(800, 400);
		setLocation(50, 100);
		//setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Box btim = Box.createVerticalBox();
		Box btim1,btim2;
		
		btim.add(btim1 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(15));
		btim1.add(lbltimkiem = new JLabel("Nhập thông tin nhân viên muốn tìm:"));
		btim1.add(Box.createHorizontalStrut(35));
		btim1.add(txtTimKiem = new JTextField());
		btim1.add(btnTim = new JButton("Tìm"));
		btim1.add(btnThoat = new JButton("Thoát"));
		
		btim.add(btim2 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(10));
		
		
		String [] headertim ="Mã NV;Tên NV; Tiền lương".split(";");
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
		btnTim.addActionListener(this);
		DataBase.getInstance().connect();
		updateTableData();
		
		
	}
	
	
	private void updateTableData() {
		DanhSachNV ds = new DanhSachNV();
		ArrayList<NhanVien> list = ds.docTuBang();
		for (NhanVien nv : list) {
			String [] rowData = {nv.getMaNV(),nv.getHoTen(),nv.getTienLuong()+""};
			tableModeltim.addRow(rowData);
		}
		tabletim.setModel(tableModeltim);
		tabletim.setEnabled(false);
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}else if(o.equals(btnTim)) {
			String nhap = txtTimKiem.getText();
			if(nhap.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu");
				return;
			}else {
				try {
					NhanVien nv = dsnv.timKiem(nhap);
					if(nv == null) {
						JOptionPane.showMessageDialog(null,"Không tìm thấy");
						txtTimKiem.selectAll();
						txtTimKiem.requestFocus();
					}else {
						String [] datarow = {nv.getMaNV(),nv.getHoTen(),nv.getTienLuong()+""};
						tableModeltim.setRowCount(0);
						tableModeltim.addRow(datarow);
						txtTimKiem.setText("");
						
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new FrmTimNhanVien().setVisible(true);;
	}
	
	

	
	

}
