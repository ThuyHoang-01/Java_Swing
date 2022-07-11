package KhachHang;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import MatHang.MatHang;


public class FrmKH extends JFrame implements ActionListener ,MouseListener{

	private JLabel lblMaKH, lblTenKH,lblEmail, lblDiaChi, lblSoDT,lblTim;
	 private JTextField txtMaKH, txtTenKH,txtEmail,txtdiaChi,txtSoDT,txtTim;
	 private JButton btnSua,btnXoa,btnXoaTrang,btnLuu,btnTim,btnThoat, btnQuay;
	 private ListKH dskh = new ListKH();
	 public static DefaultTableModel tableModel;
	 private JTable table;
	
	 public FrmKH() {
		 super("Chương trình quản lý khách hàng");
		 setSize(800,600);
		 setResizable(false);
		 //setDefaultCloseOperation(EXIT_ON_CLOSE);
		 control();
}
	private void control() {
		// TODO Auto-generated method stub
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		pnNorth.setPreferredSize(new Dimension(0, 230));
		pnNorth.setLayout(null);
		
		pnNorth.add(lblMaKH = new JLabel("Mã KH:"));
		pnNorth.add(lblTenKH = new JLabel("Tên KH:"));
		pnNorth.add(lblEmail = new JLabel("Email: "));
		pnNorth.add(lblDiaChi = new JLabel("Địa chỉ:"));
		pnNorth.add(lblSoDT = new JLabel("Số DT:"));
		
		pnNorth.add(txtMaKH = new JTextField());
		pnNorth.add(txtTenKH = new JTextField());
		pnNorth.add(txtEmail = new JTextField());
		pnNorth.add(txtdiaChi = new JTextField());
		pnNorth.add(txtSoDT = new JTextField());
		
		int w1= 100, w2=450, h=30;
		lblMaKH.setBounds(20, 20, w1, h);txtMaKH.setBounds(120, 20, w2, h);
		lblTenKH.setBounds(20, 55, w1, h); txtTenKH.setBounds(120, 55, w2, h);	
		lblEmail.setBounds(20, 90, w1, h);txtEmail.setBounds(120, 90, w2, h);
		lblDiaChi.setBounds(20, 130, w1, h);txtdiaChi.setBounds(120, 130, w2, h);
		lblSoDT.setBounds(20, 170, w1, h);txtSoDT.setBounds(120, 170, w2, h);
		
		
		JPanel pnCen = new JPanel();
		String[] headers ="MaKH;TenKH;Email;DiaChi;SoDT\n".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll;
		pnCen.add(scroll = new JScrollPane(table = new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		 table.setRowHeight(20);
		 scroll.setPreferredSize(new Dimension(450, 300));
		 add(pnCen, BorderLayout.CENTER);
	
		
		JPanel pnSouth = new JPanel();
		//pnSouth.setPreferredSize(new Dimension(0,70));
		pnSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		//pnSouth.add(lblTim = new JLabel("Nhập tên cần tìm: "));
		//pnSouth.add(txtTim = new JTextField(15));
		pnSouth.add(btnLuu = new JButton("Lưu khách hàng"));
		pnSouth.add(btnSua = new JButton("Sửa thông tin"));
		pnSouth.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnSouth.add(btnXoa = new JButton("Xóa khách hàng"));
		pnSouth.add(btnThoat= new JButton("Thoát"));
		//pnSouth.add(btnTim = new JButton("Tìm"));
		//pnSouth.add(btnThem = new JButton("Thêm"));
	
	
	
	
		//pnSouth.add(btnQuay = new JButton("Quay"));
		add(pnSouth, BorderLayout.SOUTH);
		
		//btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
		table.addMouseListener(this);
		btnSua.addActionListener(this);
		Database.getInstance().connect();
		updateTableDatatim();
	}
	String maKH, tenKH,email,diaChi,soDT;
	int ma;
	double DT;
	public KhachHang taoKH() {
		 maKH = txtMaKH.getText().trim().toString();
		 ma = maKH.length()==0 ? 0: Integer.parseInt(soDT);
		 tenKH = txtTenKH.getText().trim().toString();
		 email = txtEmail.getText().trim().toString();
		 diaChi = txtdiaChi.getText().trim().toString();
		 soDT = txtSoDT.getText().trim().toString();
		 DT = soDT.length()==0 ? 0 : Double.parseDouble(soDT);
		
		 
		 return  new KhachHang(maKH,tenKH,email,diaChi,soDT);
	}
	private void updateTableDatatim() {
		ListKH ds = new ListKH();
		ArrayList<KhachHang> list = ds.docTuBang();
		for (KhachHang nv : list) {
			String [] rowData = {nv.getMaKH(),nv.getTenKH(),nv.getEmail(),nv.getDiaChi(),nv.getSoDT()+""};
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
		//TableModel dataModel = null;
		//table.setModel(dataModel);
		
	}
	
	String maKH1,tenKH1;
	
	private KhachHang kiemTraDL() {
		maKH = txtMaKH.getText().trim();
		tenKH = txtTenKH.getText().trim();
		email=txtEmail.getText().trim();
		diaChi=txtdiaChi.getText().trim();
		soDT=txtSoDT.getText().trim();
		return new KhachHang(maKH, tenKH, email,diaChi,soDT);
	}
	public void xoaTrang() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtEmail.setText("");
		txtdiaChi.setText("");
		txtSoDT.setText("");
		txtMaKH.requestFocus();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		if(o.equals(btnXoaTrang)) {
			xoaTrang();
			txtMaKH.setEditable(true);
		}
		if(o.equals(btnLuu)) {
			KhachHang nv = kiemTraDL();
			
			if(!(maKH.length()>0)) {
				JOptionPane.showMessageDialog(null,"Không được để trống mã");
				return;
			}else if(!(tenKH.length()>0)) {
				JOptionPane.showMessageDialog(null, "Không được để trống tên");
				return;
			}else if(!(email.length()>0)){
				JOptionPane.showMessageDialog(null, "Không được để trống email");
				return;
			}else if(!(diaChi.length()>0)){
				JOptionPane.showMessageDialog(null, "Không được để trống địa chỉ");
				return;
			}else if(!(soDT.length()>0)){
				JOptionPane.showMessageDialog(null, "Không được để trống số điện thoại");
				return;
			}else {
			if(dskh.create(txtMaKH.getText(), txtTenKH.getText(),txtEmail.getText(),txtdiaChi.getText(),txtSoDT.getText())) {
					Object []rowData = {txtMaKH.getText(),txtTenKH.getText(),txtEmail.getText(),txtdiaChi.getText(),txtSoDT.getText()+""};
					tableModel.addRow(rowData);
					JOptionPane.showMessageDialog(null, "Lưu thành công");
					xoaTrang();
					
				}else {
					JOptionPane.showMessageDialog(null, "Trùng mã");
					txtMaKH.selectAll();
					txtMaKH.requestFocus();
				}
			}
			
			

		
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row >=0 ) {
				int hoinhac = JOptionPane.showConfirmDialog(null,"Bạn chắc chắn muốn xóa ?","Chú ý",JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					String manv = (String) table.getValueAt(row,0);
					if(dskh.delete(manv)) {
						tableModel.removeRow(row);
						xoaTrang();
				}
				JOptionPane.showMessageDialog(null,"Xóa thành công");
				
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn cần chọn dòng để xóa");
			}
		}
		if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(row>=0) {
				int hoinhac = JOptionPane.showConfirmDialog(null,"Bạn có chắc không","Chú ý",JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					if(dskh.update(txtMaKH.getText(),txtTenKH.getText(),txtEmail.getText(),txtdiaChi.getText(),txtSoDT.getText())) {
						table.setValueAt(txtTenKH.getText(), row,1);
						table.setValueAt(txtEmail.getText(), row,2);
						table.setValueAt(txtdiaChi.getText(), row,3);
						table.setValueAt(txtSoDT.getText(), row,4);
						JOptionPane.showMessageDialog(null,"Sửa thành công");
					}
				}
			}else {
					JOptionPane.showMessageDialog(null,"Bạn chưa chọn khách hàng");
			}
		}
		
		
		}	
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaKH.setText(table.getValueAt(row, 0).toString());
		txtMaKH.setEditable(false);
		txtTenKH.setText(table.getValueAt(row, 1).toString());
		txtEmail.setText(table.getValueAt(row, 2).toString());
		txtdiaChi.setText(table.getValueAt(row, 3).toString());
		txtSoDT.setText(table.getValueAt(row, 4).toString());
		
		
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
		new FrmKH().setVisible(true);
	}

}

