package NhanVien;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class FrmNhanVien extends JFrame implements ActionListener,MouseListener{
	
	private JTable table;
	public static DefaultTableModel tableModel;
	private JButton btnTimKiem,btnThem,btnSua,btnXoa,btnXoaTrang,btnLuu,btnThoat;
	private JTextField txtMaNV,txtTenNV,txtTienLuong,txtTimKiem;
	private DanhSachNV dsnv = new DanhSachNV();
	
	public FrmNhanVien() {
		super("Danh sách nhân viên");
		setSize(700, 400);
		//setLocationRelativeTo(null);
		setLocation(50, 100);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//this.addWindowListener(this);
		
		JLabel  lblTitile ,lblMaNV, lblTenNV,lblTienLuong,lblTimKiem;
		JPanel pnorth = new JPanel();
		add(pnorth,BorderLayout.NORTH);
		pnorth.add(lblTitile = new JLabel("Danh Sach Nhan Vien"));
		lblTitile.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5;
		
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b1.add(lblMaNV = new JLabel("Mã NV:"));
		b1.add(Box.createHorizontalStrut(35));
		b1.add(txtMaNV = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b2.add(lblTenNV = new JLabel("Tên NV:"));
		b2.add(Box.createHorizontalStrut(35));
		b2.add(txtTenNV = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b3.add(lblTienLuong = new JLabel("Tiền Lương:"));
		b3.add(Box.createHorizontalStrut(35));
		b3.add(txtTienLuong = new JTextField());
		
		lblMaNV.setPreferredSize(lblTienLuong.getPreferredSize());
		lblTenNV.setPreferredSize(lblTienLuong.getPreferredSize());
		
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(Box.createHorizontalStrut(103));
		
		String [] header ="Mã NV;Tên NV; Tiền lương".split(";");
		tableModel = new DefaultTableModel(header,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b4.add(scroll);
		b.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));
		add(b,BorderLayout.CENTER);
		
		JPanel psouth = new JPanel();
		add(psouth,BorderLayout.SOUTH);
		psouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		//psouth.add(btnThem = new JButton("Thêm"));
		psouth.add(btnLuu = new JButton("Lưu Nhân viên"));
		psouth.add(btnSua = new JButton("Sửa Thông tin"));
		psouth.add(btnXoa = new JButton("Xóa Nhân viên"));
		psouth.add(btnXoaTrang = new JButton("Xóa trắng"));
		psouth.add(btnThoat = new JButton("Thoát"));
		
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThoat.addActionListener(this);
		table.addMouseListener(this);
		DataBase.getInstance().connect();
		updateTableDatatim();
		
		
		
		
	}
	
	private void xoaRongTextfields() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtTienLuong.setText("");
		txtMaNV.requestFocus();
		
		
	}
	
	private void updateTableDatatim() {
		DanhSachNV ds = new DanhSachNV();
		ArrayList<NhanVien> list = ds.docTuBang();
		for (NhanVien nv : list) {
			String [] rowData = {nv.getMaNV(),nv.getHoTen(),nv.getTienLuong()+""};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
		
		
	}
	
	String maNV,tenMV,luong;
	float tienLuong;
	
	private NhanVien kiemTraDL() {
		maNV = txtMaNV.getText().trim();
		tenMV = txtTenNV.getText().trim();
		luong = txtTienLuong.getText().trim();
		tienLuong = luong.length()==0 ? 0 : Float.parseFloat(luong);
		return new NhanVien(maNV, tenMV, tienLuong);
	}
	
	
	

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		if(o.equals(btnXoaTrang)) {
			xoaRongTextfields();
			txtMaNV.setEditable(true);
		}
		if(o.equals(btnLuu)) {
			NhanVien nv = kiemTraDL();
			try {
				Double.parseDouble(txtTienLuong.getText().trim());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Tiền lương phải là số");
				return;
			}
			if(!(maNV.length()>0)) {
				JOptionPane.showMessageDialog(null,"Không được để trống mã");
				return;
			}else if(!(tenMV.length()>0)) {
				JOptionPane.showMessageDialog(null, "Không được để trống tên");
				return;
			}else {
				if(dsnv.create(txtMaNV.getText(), txtTenNV.getText(),Float.parseFloat(txtTienLuong.getText()))) {
					Object []rowData = {txtMaNV.getText(),txtTenNV.getText(),txtTienLuong.getText()+""};
					tableModel.addRow(rowData);
					JOptionPane.showMessageDialog(null, "Lưu thành công");
					xoaRongTextfields();
					
				}else {
					JOptionPane.showMessageDialog(null, "Trùng mã");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
				}
			}
			
			
		}
		
		if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(row>=0) {
				int hoinhac = JOptionPane.showConfirmDialog(null,"Bạn có chắc không","Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					if(dsnv.update(txtMaNV.getText(), txtTenNV.getText(), Float.parseFloat(txtTienLuong.getText()))) {
						table.setValueAt(txtTenNV.getText(), row,1);
						table.setValueAt(Float.parseFloat(txtTienLuong.getText()), row, 2);
						JOptionPane.showMessageDialog(null,"Đã sửa thành công");
				}
				
					
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên muốn sửa");
			}
		}
		
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row >=0 ) {
				int hoinhac = JOptionPane.showConfirmDialog(null,"Bạn có chắc không","Chú ý",JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					String manv = (String) table.getValueAt(row,0);
					if(dsnv.delete(manv)) {
						tableModel.removeRow(row);
						xoaRongTextfields();
				}
				JOptionPane.showMessageDialog(null,"Đã xóa thành công");
				
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên muốn xóa");
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaNV.setText(table.getValueAt(row, 0).toString());
		txtMaNV.setEditable(false);
		txtTenNV.setText(table.getValueAt(row, 1).toString());
		txtTienLuong.setText(table.getValueAt(row, 2).toString());
		
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
	
	
	public static void main(String[] args) {
		new FrmNhanVien().setVisible(true);
	}

	
	

}
