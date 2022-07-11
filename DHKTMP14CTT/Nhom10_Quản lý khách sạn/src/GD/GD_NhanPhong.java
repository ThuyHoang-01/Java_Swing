package GD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GD_NhanPhong extends JFrame implements ActionListener{
	 private JLabel lblsoP, lblLoai,lblTG,lblHoTen;
	 private JTextField txtsoP, txtLoai, txtTG, txtHoTen, txtMess;
	 private JButton btnThem, btnXoa, btnThoa, btnXoaRong, btnluu, btnMenu;
	 public static DefaultTableModel tableModel;
	private JComboBox<String> cbcloaiphong;
	 private JTable table;
 public GD_NhanPhong() {
	 setTitle("Quản lý khách sạn");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 JPanel pNorth;
			add(pNorth = new JPanel(), BorderLayout.NORTH);
			pNorth.setPreferredSize(new Dimension(0, 150));
			pNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
			pNorth.setLayout(null);
			pNorth.add(lblHoTen = new JLabel("Họ tên: "));
			pNorth.add(lblsoP = new JLabel("Số Phòng: "));
			pNorth.add(lblLoai = new JLabel("Loại phòng: "));
			pNorth.add(lblTG= new JLabel("Thời gian nhận: "));
			
			
		
			DefaultComboBoxModel<String> cbcModel = new DefaultComboBoxModel<String>();
			cbcModel.addElement("VIP-Đôi");
			cbcModel.addElement("VIP-Đơn");
			cbcModel.addElement("Thường-Đôi");
			cbcModel.addElement("Thường-Đơn");
			cbcloaiphong = new JComboBox<String>(cbcModel);
			cbcloaiphong.setEditable(false);
			pNorth.add(cbcloaiphong);
			pNorth.add(txtHoTen = new JTextField());
			pNorth.add(txtsoP = new JTextField(20));
			pNorth.add(txtTG = new JTextField());
			pNorth.add(txtMess = new JTextField());
			txtMess.setEditable(false);
			txtMess.setBorder(null);
			txtMess.setForeground(Color.RED);
			txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

			int w1 = 100, w2 = 300, h = 20;
			lblsoP.setBounds(20, 20, w1, h);
			txtsoP.setBounds(120, 20, 200, h);

			lblLoai.setBounds(20, 70, w1, h);
			cbcloaiphong.setBounds(120, 70, w2, h);
			lblTG.setBounds(20, 95, w1, h);
			txtTG.setBounds(120, 95, w2, h);
			lblHoTen.setBounds(20, 45, w1, h);
			txtHoTen.setBounds(120, 45, w2, h);
			txtMess.setBounds(20, 145, 550, 20);

			JPanel pCen;
			add(pCen = new JPanel(), BorderLayout.CENTER);
			pCen.add(btnThem = new JButton("Thêm"));
			pCen.add(btnXoaRong = new JButton("Xóa rổng"));
			pCen.add(btnluu = new JButton("Lưu"));
			pCen.add(btnMenu = new JButton("Về Menu"));
			JScrollPane scroll;
			String[] headers = "Mã Phòng;Tên phòng;Loại phòng;Tình trạng;Gía phòng;Mã dịch vụ".split(";");
			tableModel = new DefaultTableModel(headers, 0);
			add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
			scroll.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
			table.setRowHeight(20);
			scroll.setPreferredSize(new Dimension(0, 350));
			btnMenu.addActionListener(this);

 }
 
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnMenu)){
			new Menu().setVisible(true);
			this.setVisible(false);
		}
		
	}
	
}
