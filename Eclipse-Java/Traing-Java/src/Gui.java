import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame implements ActionListener{
	private JLabel lbMa, lbTua, lbTacGia, lbNamXB, lbNhaXB, lbSoTrang, lbDonGia, lbISBM, lbTim;
	private JTextField txtMa, txtTua, txtTacGia, txtNamXB, txtNhaXB, txtSoTrang, txtDonGia, txtISBM;
	private JButton btnThem, btnXoaRong, btnSua, btnXoa, btnLuu;
	private JComboBox comboBoxTim;
	private DefaultTableModel tableModel;
	private JTable table;
	private Sach sach;
	private ListSach list;
	private Database database = new Database();

	public Gui() {

		// frame
		this.setTitle("Demo01");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// layout

		// North
		Box box = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		Box box5 = Box.createHorizontalBox();

		box1.add(lbMa = new JLabel("Ma sach:"));
		box1.add(txtMa = new JTextField());
		box1.add(Box.createRigidArea(new Dimension(400, 10)));

		box2.add(lbTua = new JLabel("Tua sach:"));
		box2.add(txtTua = new JTextField());
		box2.add(Box.createRigidArea(new Dimension(10, 10)));
		box2.add(lbTacGia = new JLabel("Tac gia:"));
		box2.add(txtTacGia = new JTextField());

		box3.add(lbNamXB = new JLabel("Nam xuat ban:"));
		box3.add(txtNamXB = new JTextField());
		box3.add(Box.createRigidArea(new Dimension(10, 10)));
		box3.add(lbNhaXB = new JLabel("Nha xuat ban:"));
		box3.add(txtNhaXB = new JTextField());

		box4.add(lbSoTrang = new JLabel("So trang:"));
		box4.add(txtSoTrang = new JTextField());
		box4.add(Box.createRigidArea(new Dimension(10, 10)));
		box4.add(lbDonGia = new JLabel("Don gia:"));
		box4.add(txtDonGia = new JTextField());

		box5.add(lbISBM = new JLabel("International Standard Book Number (ISBM):"));
		box5.add(txtISBM = new JTextField());
		box5.add(Box.createRigidArea(new Dimension(400, 10)));

		lbMa.setPreferredSize(new Dimension(lbNhaXB.getPreferredSize()));
		lbTua.setPreferredSize(new Dimension(lbNhaXB.getPreferredSize()));
		lbSoTrang.setPreferredSize(new Dimension(lbNhaXB.getPreferredSize()));
		lbTacGia.setPreferredSize(new Dimension(lbNamXB.getPreferredSize()));
		lbDonGia.setPreferredSize(new Dimension(lbNamXB.getPreferredSize()));
		box.setBorder(BorderFactory.createTitledBorder("Records Editor"));

		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(box1);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(box2);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(box3);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(box4);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(box5);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		this.add(box, BorderLayout.NORTH);

		// Center
		JPanel panelCenter = new JPanel();
		this.add(panelCenter, BorderLayout.CENTER);

		panelCenter.add(btnThem = new JButton("Them"));
		panelCenter.add(btnXoaRong = new JButton("Xoa rong"));
		panelCenter.add(btnXoa = new JButton("Xoa"));
		panelCenter.add(btnSua = new JButton("Sua"));
		panelCenter.add(btnLuu = new JButton("Luu"));
		panelCenter.add(Box.createRigidArea(new Dimension(30, 10)));
		panelCenter.add(lbTim = new JLabel("Tim theo ma sach:"));
		panelCenter.add(comboBoxTim = new JComboBox());
		comboBoxTim.addItem("A001");
		comboBoxTim.addItem("J002");
		comboBoxTim.addItem("H003");

		// South
		JPanel panelSouth = new JPanel();
		this.add(panelSouth,BorderLayout.SOUTH);
		panelSouth.setPreferredSize(new Dimension(800,300));
		panelSouth.setBorder(BorderFactory.createTitledBorder("Danh sach cac cuon sach"));

		String[] header = { "Ma sach", "Tua sach", "Tac gia", "Nam xuat ban", "Nha xuat ban", "So trang", "Don gia",
				"ISBM" };
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		table.setPreferredSize(new Dimension(770,280));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(770,280));
		panelSouth.add(scrollPane);
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txtMa.setText(tableModel.getValueAt(row, 0).toString());
				txtTua.setText(tableModel.getValueAt(row, 1).toString());
				txtTacGia.setText(tableModel.getValueAt(row, 2).toString());
				txtNamXB.setText(tableModel.getValueAt(row, 3).toString());
				txtNhaXB.setText(tableModel.getValueAt(row, 4).toString());
				txtSoTrang.setText(tableModel.getValueAt(row, 5).toString());
				txtDonGia.setText(tableModel.getValueAt(row, 6).toString());
				txtISBM.setText(tableModel.getValueAt(row, 7).toString());
				txtMa.requestFocus();
			}
		});
		
		if(new File("Sach.txt").exists()) {
			try {
				loadData();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			list = new ListSach();
		}

	}

	public static void main(String[] args) {
		new Gui().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if(object.equals(btnThem)){
			if(txtMa.getText().equals("") || txtTua.getText().equals("") || txtTacGia.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Phai nhap thong tin truoc khi them vao!!!");
				txtMa.requestFocus();
			}else {
				JOptionPane.showMessageDialog(null, "Them thanh cong!!!");
				them();
			}
		}else if(object.equals(btnLuu)) {
			try {
				luu();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
	}
	public void loadData() throws Exception{
		list = null;
		list = (ListSach) database.readFile("Sach.txt");
		for(Sach x : list.getLs()) {
			String[] row = {x.getMa(),x.getTua(),x.getTacGia(),x.getNamXB()+"",x.getNhaXB(),x.getSoStrang()+"",x.getDonGia()+"",x.getIsbm()};
			tableModel.addRow(row);
		}
	}
	
	public void them() {
		String ma = txtMa.getText();
		String tua = txtTua.getText();
		String tacGia = txtTacGia.getText();
		String namXB = txtNamXB.getText();
		String nhaXB = txtNhaXB.getText();
		String soTrang = txtSoTrang.getText();	
		String donGia = txtDonGia.getText();
		String isbm = txtISBM.getText();
		
		String []rowStrings = {ma,tua,tacGia,namXB,nhaXB,soTrang,donGia,isbm};
		tableModel.addRow(rowStrings);
		
	}
	
	public void luu() throws Exception{
		String ma = txtMa.getText();
		String tua = txtTua.getText();
		String tacGia = txtTacGia.getText();
		String namXB = txtNamXB.getText();
		String nhaXB = txtNhaXB.getText();
		String soTrang = txtSoTrang.getText();	
		String donGia = txtDonGia.getText();
		String isbm = txtISBM.getText();
		
		sach = new Sach(ma, tua, tacGia, Integer.parseInt(namXB), nhaXB, Integer.parseInt(soTrang), Double.parseDouble(donGia), isbm);
		
		if(!list.addSach(sach)) {
			JOptionPane.showInternalMessageDialog(null, "Khong the them do trung ma!!!");
		}else {
			JOptionPane.showMessageDialog(null, "Luu thanh cong");
			String []rowStrings = {ma,tua,tacGia,namXB,nhaXB,soTrang,donGia,isbm};
			tableModel.addRow(rowStrings);
			database.writeFile("Sach.txt", list);
		}
		
	}
	
	
	
}
