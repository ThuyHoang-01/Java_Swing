package KhachHang;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class FrmTimKH extends JFrame implements ActionListener{
	private JTable tabletim;
	public static DefaultTableModel tableModeltim;
	private JTextField txtTim;
	private JLabel lblTim;
	private JButton btnTim,btnThoat;
	private ListKH dsnv = new ListKH();
	public FrmTimKH() {
		super("Tìm khách hàng");
		setSize(600, 500);
		setLocation(50, 100);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Box btim = Box.createVerticalBox();
		Box btim1,btim2;
		
		btim.add(btim1 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(15));
		btim1.add(lblTim = new JLabel("Nhập thông tin khách hàng cần tìm"));
		btim1.add(Box.createHorizontalStrut(35));
		btim1.add(txtTim = new JTextField());
		btim1.add(btnTim = new JButton("Tìm"));
		btim1.add(btnThoat = new JButton("Thoát"));
		
		btim.add(btim2 = Box.createHorizontalBox());
		btim.add(Box.createVerticalStrut(10));
		
		
		String [] headertim ="Mã KH; Tên KH; Email; Địa chỉ; Số DT".split(";");
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
		Database.getInstance().connect();
		updateTableData();
		
		
	}
	
	
	private void updateTableData() {
		ListKH ds = new ListKH();
		ArrayList<KhachHang> list = ds.docTuBang();
		for (KhachHang kh : list) {
			String [] rowData = {kh.getMaKH(),kh.getTenKH(),kh.getEmail(),kh.getDiaChi(),kh.getSoDT()+""};
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
		}/*else if(o.equals(btnTim)) {
			String nhap = txtTim.getText();
			if(nhap.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu");
				return;
			}else {
				try {
					KhachHang kh = dsnv.timKiem(nhap);
					if(kh == null) {
						JOptionPane.showMessageDialog(null,"Không tìm thấy");
						txtTim.selectAll();
						txtTim.requestFocus();
					}else {
						String [] datarow = {kh.getMaKH(),kh.getTenKH(),kh.getEmail(),kh.getDiaChi(),kh.getSoDT()+""};
						tableModeltim.setRowCount(0);
						tableModeltim.addRow(datarow);
						txtTim.setText("");
						
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		*/
	}
	
	public static void main(String[] args) {
		new FrmTimKH().setVisible(true);;
	}
	
	


}

	

