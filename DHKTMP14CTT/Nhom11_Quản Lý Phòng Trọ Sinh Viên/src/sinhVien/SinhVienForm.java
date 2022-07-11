package sinhVien;

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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SinhVienForm extends JFrame implements ActionListener,MouseListener{
	//co doc file
	private DSSinhVien dao;
	private ArrayList<SinhVien> list;
	private JTable table;
	private JTextField txtmaSV,txtHo,txtTen,txtTim;
	private JButton btnThem,btnXoa,btnLuu,btnXoaTrang,btnTim;
	private DefaultTableModel tableModel;
	private JTextField txtLop;
	private JTextField txtQue;
	private static final String FILENAME= "Dulieu1.txt";
	
	public  SinhVienForm() {
		// TODO Auto-generated constructor stub
		setTitle("");
		setSize(900,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	
		
		////North
		JPanel pNorth = new JPanel();
		getContentPane().add(pNorth,BorderLayout.NORTH);
		JLabel lblTieude;
		pNorth.add(lblTieude= new JLabel("Thông tin sinh viên"));
		lblTieude.setFont(new Font("Time new Roman",Font.BOLD, 30));
		lblTieude.setForeground(Color.MAGENTA);
		
		Box b= Box.createVerticalBox();
		Box b1,b2,b3,b4,b5;
		JLabel lblmaSV,lblHo,lblTen,lblLop,lblQue;
		
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b1.add(lblmaSV= new JLabel("Ma SV:"));
		b1.add(txtmaSV= new JTextField());
		
		b.add(b2=Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b2.add(lblHo= new JLabel("Ho"));
		b2.add(txtHo= new JTextField());
		b2.add(lblTen= new JLabel("Ten SV:"));
		b2.add(txtTen= new JTextField());
		
		b.add(b3=Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b3.add(lblLop= new JLabel("Lop:"));
		b3.add(txtLop= new JTextField());
		
		b.add(b4=Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b4.add(lblQue= new JLabel("Que Quan:"));
		b4.add(txtQue= new JTextField());
		
		b.add(b5=Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		String [] headers="MaNV;Ho;Ten;Lop;Que".split(";");
		tableModel= new DefaultTableModel(headers,0);
		JScrollPane scroll= new JScrollPane();
		scroll.setViewportView(table= new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b5.add(scroll);
		getContentPane().add(b,BorderLayout.CENTER);
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		getContentPane().add(split,BorderLayout.SOUTH);
		JPanel pnLeft,pnRight;
		split.add(pnLeft= new JPanel());
		split.add(pnRight= new JPanel());
		JLabel lbltim;
		pnLeft.add(lbltim =new JLabel("Nhap ma can tim"));
		pnLeft.add(txtTim= new JTextField(10));
	
	
		pnLeft.add(btnTim=new JButton("Tim"));
		pnRight.add(btnThem= new JButton("Them"));
		pnRight.add(btnXoaTrang= new JButton("Xoa trang"));
		pnRight.add(btnXoa= new JButton("Xoa"));
		pnRight.add(btnLuu= new JButton("Luu"));
		
		
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTim.addActionListener(this);
	
		btnLuu.addActionListener(this);
		
		LoadDatabase();
		
		
		
	}
		public static void main(String []args) {
			DSSinhVien dao=new DSSinhVien();
			new SinhVienForm().setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnThem))
			themActions();
		if(o.equals(btnXoa))
			xoaActions();
		if(o.equals(btnXoaTrang))
			xoaTrangActions();
		if(o.equals(btnLuu))
			SaveDatabase();
		if(o.equals(btnTim))
			TimActions();
			
	}
	private void TimActions() {
		// TODO Auto-generated method stub
		if(txtTim.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "chua nhap du lieu");
			return;
		}else if(txtTim.getText().equals("*")) {
			tableModel.setRowCount(0);
			LoadDatabase();
			return;
		}
		try {
			int maNV=Integer.parseInt(txtTim.getText());
			SinhVien sv =dao.timKiem(maNV);
			if(sv==null)
			{
				JOptionPane.showMessageDialog(this, "khong tim thay");
			}else {
				tableModel.setRowCount(0);
				String[] dataRow = {sv.getMaSV()+"",
									sv.getHo()+"",
									sv.getTen()+"",
									sv.getLop()+"",
									sv.getQue()+"",
									
			};
			
			tableModel.addRow(dataRow);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
			
	}
	private void xoaActions() {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		if(row!=-1) {
			int maNV=Integer.parseInt((String)table.getModel().getValueAt(row, 0));
			int hoiNhac=JOptionPane.showConfirmDialog(this, "Ban chac chan muon xoa khong ?",
					"Chu y",JOptionPane.YES_NO_OPTION);
			if(hoiNhac==JOptionPane.YES_NO_OPTION)
				if(dao.xoaSV(maNV))
					tableModel.removeRow(row);
		}
	}
	private void xoaTrangActions() {
		// TODO Auto-generated method stub
		txtmaSV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtLop.setText("");
		txtQue.setText("");
		txtmaSV.requestFocus();
	}
	private void themActions() {
		// TODO Auto-generated method stub
			try {
				SinhVien sv = null;
				int maSV = Integer.parseInt(txtmaSV.getText());
				String ho = txtHo.getText();
				String ten = txtTen.getText();
				String lop = txtLop.getText();
				String que = txtQue.getText();
				sv = new SinhVien(maSV,ho,ten,lop, que);
	
				if (dao.themSV(sv)) {
					
					String	[]row= { sv.getMaSV()+"",
									sv.getHo(),
									sv.getTen(),
									sv.getLop(),
									sv.getQue()
									};
					tableModel.addRow(row);
					xoaTrangActions();
				}
				else {
					JOptionPane.showMessageDialog(null, "Trung ma");
					txtmaSV.selectAll();
					txtmaSV.requestFocus();
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Loi nhap du lieu");
				return;
			}
		
	}
	void LoadDatabase() {
		if( !new File(FILENAME).exists()) {
			dao = new DSSinhVien();
		}else
			napDanhSach();
		
	}
	private void napDanhSach() {
		// TODO Auto-generated method stub
		try {
			FileInputStream in = new FileInputStream(FILENAME);
			ObjectInputStream ois= new ObjectInputStream(in);
			dao=(DSSinhVien)ois.readObject();
			if(dao!=null) {
				for(int i=0;i<dao.tong();i++) {
					SinhVien sv=dao.getSinhVien(i);
					String[] dataRow = {sv.getMaSV()+"",
							sv.getHo(),
							sv.getTen(),
							sv.getLop(),
							sv.getQue()
							};
					tableModel.addRow(dataRow);
				}
				ois.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
	void SaveDatabase() {
		try {
			FileOutputStream out = new FileOutputStream(FILENAME);
			ObjectOutputStream oos= new ObjectOutputStream(out);
			System.out.println(dao.getList());
			oos.writeObject(dao);
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
