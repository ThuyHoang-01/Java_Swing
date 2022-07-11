package giaoDienBT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import enTiTy.KhachHang;
import ketNoiSQL.DataBase;
import thucThi.DaoThongTin;

public class KH_ChinhSuaTTCN extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField  txtID,txtHoTen,txtSdt,txtEmail,txtUser, txtPw;
	public JButton btnThoat,btnChinhSua;
	public JLabel lblHoTen,lblSdt,lblEmail, lblID, lblUser, lblPw;
	DefaultTableModel tableModel;
	public JTable table;
	DaoThongTin tt = new DaoThongTin();
	public KH_ChinhSuaTTCN() {
		super("Chỉnh sửa thông tin cá nhân");
		setSize(600, 500);
		setLocation(200, 100);
		setResizable(false);
		JLabel lblTitl;
		JPanel pNorth;
		
		add(pNorth = new JPanel(),BorderLayout.NORTH);
		pNorth.add(lblTitl = new JLabel("Thông tin cá nhân"));
		lblTitl.setFont(new Font("Arial",Font.BOLD,20));
		lblTitl.setForeground(Color.BLUE);
		
		Box b = Box.createVerticalBox();
		Box  b1,b2,b3,b4, b5,b6,b7;
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblID = new JLabel("ID:  "));
		b5.add(txtID = new JTextField());
		txtID.setEditable(false);
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblHoTen = new JLabel("Họ Tên:  "));
		b1.add(txtHoTen = new JTextField());
	
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblEmail = new JLabel("Email:  "));
		b3.add(txtEmail = new JTextField());
	
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblSdt = new JLabel("Phone:       "));
		b2.add(txtSdt= new JTextField());
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(lblUser = new JLabel("User: "));
		b6.add(txtUser= new JTextField());
		
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b7.add(lblSdt = new JLabel("Password "));
		b7.add(txtPw= new JTextField());	
		lblID.setPreferredSize(lblSdt.getPreferredSize());
		
		lblHoTen.setPreferredSize(lblSdt.getPreferredSize());
		lblEmail.setPreferredSize(lblSdt.getPreferredSize());
		lblUser.setPreferredSize(lblSdt.getPreferredSize());
	
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		
		String[] headers = "ID;Họ Tên;Email;Số Điện Thoại;User;Password".split(";");
		tableModel = new DefaultTableModel(headers,0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b4.add(scroll);
		b.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		add(b,BorderLayout.CENTER);
		
		JPanel pSouth= new JPanel();
		pSouth.add(btnChinhSua= new JButton("Chỉnh Sửa"));
		btnChinhSua.setBackground(Color.orange);
		pSouth.add(btnThoat = new JButton("Thoát"));
		btnThoat.setBackground(Color.orange);
		add(pSouth,BorderLayout.SOUTH);
		
		btnChinhSua.addActionListener(this);
		btnThoat.addActionListener(this);
		table.addMouseListener(this);
		
		DataBase.getInstance().connect();
		Doc();
	}	
	public void Doc() {
			DaoThongTin tt = new DaoThongTin();
			List<KhachHang> ls = tt.doctuBang();
			for (KhachHang h : ls) {
				String []row = {h.getID()+"",h.getLastName(), h.getEmail(),h.getPhone(),h.getUser(),h.getPassword()};
				tableModel.addRow(row);
				txtID.setText(h.getID() + "");
				txtHoTen.setText(h.getLastName() +"");
				txtEmail.setText(h.getEmail()+"");
				txtSdt.setText(h.getPhone()+"");
				txtUser.setText(h.getUser()+"");
				txtPw.setText(h.getPassword()+"");
			}
			table.setModel(tableModel);		
		}
	
	 public static void main(String[] args) {
		 if(System.getProperty("tour.userId") == null || System.getProperty("tour.userId") == "") {
				KH_DangNhapCS redirectLogin = new KH_DangNhapCS();
				redirectLogin.setVisible(true);			;		
				return;
			
			}
		KH_ChinhSuaTTCN tt= new KH_ChinhSuaTTCN();
		tt.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnChinhSua)) {
			int row = table.getSelectedRow();
			if(row >=0) {
				if(tt.update(Integer.parseInt(txtID.getText()),txtHoTen.getText(), txtEmail.getText(), txtSdt.getText(),
						txtUser.getText(), txtPw.getText()));
				table.setValueAt(txtID.getText(), row, 0);
				table.setValueAt(txtHoTen.getText(), row, 1);
				table.setValueAt(txtEmail.getText(), row, 2);
				table.setValueAt(txtSdt.getText(), row, 3);
				table.setValueAt(txtUser.getText(), row, 4);
				table.setValueAt(txtPw.getText(), row, 5);
				
			}
		}
			
		if(obj.equals(btnThoat)) {
			setVisible(false);
			new Main_Frm();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtID.setText(table.getValueAt(row, 0).toString());
		txtHoTen.setText(table.getValueAt(row, 1).toString());
		txtEmail.setText(table.getValueAt(row, 2).toString());
		txtSdt.setText(table.getValueAt(row, 3).toString());
		txtUser.setText(table.getValueAt(row, 4).toString());
		txtPw.setText(table.getValueAt(row, 5).toString());
	
		
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
