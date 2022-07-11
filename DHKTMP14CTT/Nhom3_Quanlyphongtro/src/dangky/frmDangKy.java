package dangky;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

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

public class frmDangKy extends JFrame implements ActionListener, MouseListener{
	DanhSachTaiKhoan dao;  
	List<TaiKhoan> list;
	JTable table;
	JTextField txtmaTaiKhoan,txtTaiKhoan,txtMatKhau;
	JButton btnThem,btnXoaT,btnXoa,btnLuu;
	DefaultTableModel tableModel;
	private static final String FILENAME = "dulieu.txt";

	public frmDangKy(DanhSachTaiKhoan dao) {
		// TODO Auto-generated constructor stub
		setTitle("Quản lý Nhà trọ");
		setSize(700,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);


		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe;

		pNorth.add(lblTieuDe = new JLabel("Đăng Ký"));
		lblTieuDe.setFont(new Font("Arial",Font.BOLD,20));
		lblTieuDe.setForeground(Color.CYAN);
		Box b = Box.createVerticalBox();
		Box b1,b2,b5;
		JLabel lblmaTaiKhoan,lblTaiKhoan,lblMatKhau = new JLabel();
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblmaTaiKhoan = new JLabel("Mã Tài Khoản:"));
		b1.add(txtmaTaiKhoan = new JTextField());


		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTaiKhoan = new JLabel("Tài Khoản:"));
		b2.add(txtTaiKhoan = new JTextField());

		b2.add(lblMatKhau = new JLabel("Mật Khẩu:"));
		b2.add(txtMatKhau = new JTextField());

		lblTaiKhoan.setPreferredSize(lblmaTaiKhoan.getPreferredSize());
		lblMatKhau.setPreferredSize(lblmaTaiKhoan.getPreferredSize());

		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));

		String[] headers = "Mã Tài Khoản;Tài Khoản;Mật Khẩu".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table= new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);;
		b5.add(scroll);
		add(b,BorderLayout.CENTER);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split,BorderLayout.SOUTH);

		JPanel pEast = new JPanel();
		JPanel pWest = new JPanel();
		split.add(pWest);
		split.add(pEast);
	

		pEast.add(btnThem = new JButton("Thêm"));

		pEast.add(btnXoaT = new JButton("Xóa Trắng"));

		pEast.add(btnXoa = new JButton("Xóa"));

		pEast.add(btnLuu = new JButton("Lưu "));
		LoadDatabase();

		btnThem.addActionListener(this);
		btnXoaT.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtmaTaiKhoan.setText(table.getValueAt(row, 0).toString());
		txtTaiKhoan.setText(table.getValueAt(row, 1).toString());
		txtMatKhau.setText(table.getValueAt(row, 2).toString());
		
	
		
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
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object o = e.getSource();
		if(o.equals(btnThem))
			themActions();
		if (o.equals(btnXoa))
			xoaActions();
		if(o.equals(btnXoaT))
	        xoaTrangActions();
		if(o.equals(btnLuu))
			SaveDatabase(dao.getList());
	}
	private void xoaTrangActions() {
		txtmaTaiKhoan.setText("");
		txtTaiKhoan.setText("");
		txtMatKhau.setText("");
		txtmaTaiKhoan.requestFocus();
		
	}
	private void themActions() {
		try {
		int maTaiKhoan = Integer.parseInt(txtmaTaiKhoan.getText());
		String taiKhoan = txtTaiKhoan.getText();
		String matKhau = txtMatKhau.getText();
		TaiKhoan tk = new TaiKhoan(maTaiKhoan, taiKhoan, matKhau);


		if (dao.themNhanVien(tk)){
			String[]row = {Integer.toString(maTaiKhoan),taiKhoan,matKhau+""};
			tableModel.addRow(row);
			xoaTrangActions();
		}
		else{

			JOptionPane.showMessageDialog(null, "Trùng mã tài khoản");
			txtmaTaiKhoan.selectAll();
			txtmaTaiKhoan.requestFocus();
		}
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi Nhập Liệu");
		return;
	}
	}
	private void xoaActions() {

		int row = table.getSelectedRow();
		if(row != -1){
			int maTaiKhoan = Integer.parseInt((String)table.getModel().getValueAt(row,0));
			int hoinhac = JOptionPane.showConfirmDialog(this, "Chắc Chắn xóa không?","Chú ý", JOptionPane.YES_NO_CANCEL_OPTION);
			if (hoinhac== JOptionPane.YES_OPTION)
				if(dao.xoaTaiKhoan(maTaiKhoan))
					tableModel.removeRow(row);
		}
		
	}

	private void SaveDatabase(ArrayList<TaiKhoan> dstk) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILENAME));
					bw.write("Mã Tài Khoản,Tài Khoản\n");
					for(TaiKhoan tk: dstk) {
						bw.write(tk.toString()+"\n");
					}
					bw.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
		
	
	void LoadDatabase() {
		BufferedReader br = null;
		dao = new DanhSachTaiKhoan();
		try {
			if (new File(FILENAME).exists()) {
				br = new BufferedReader (new FileReader(FILENAME));
				br.readLine();
				
			}while(br.ready()) 
			{
				String line = br.readLine();
				if(line !=null &&! line.trim().equals("")) {
					String[]a = line.split(";");
					TaiKhoan tk = new TaiKhoan(Integer.parseInt(a[0]),a[1],a[2]);
					dao.themNhanVien(tk);
					tableModel.addRow(a);
				}
			}
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
	}


	
	
}
