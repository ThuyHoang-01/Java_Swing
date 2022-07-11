package ontap;

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

public class Gui extends JFrame implements ActionListener {

	private JLabel labelMa, labelHo, labelTen, labelPhongBan, labelTienLuong;
	private JTextField textFieldMa, textFieldHo, textFieldTen, textFieldTienLuong;
	private JComboBox comboBoxPB;
	private JButton buttonThem, buttonXoa, buttonXoaTrang, buttonLuu;
	private JTable table;
	private DefaultTableModel tableModel;
	private NhanVien nv;
	private ListNhanVien list;
	private Database database = new Database();

	public Gui() {

		// Frame
		this.setTitle("On tap");
		this.setSize(500, 500);
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

		box1.add(labelMa = new JLabel("Ma nhan vien:"));
		box1.add(textFieldMa = new JTextField());

		box2.add(labelHo = new JLabel("Ho:"));
		box2.add(textFieldHo = new JTextField());

		box3.add(labelTen = new JLabel("Ten nhan vien:"));
		box3.add(textFieldTen = new JTextField());

		box4.add(labelPhongBan = new JLabel("Phong ban:"));
		box4.add(comboBoxPB = new JComboBox());
		comboBoxPB.addItem("1.Phong to chuc");
		comboBoxPB.addItem("2.Phong ky thuat");
		comboBoxPB.addItem("3.Phong nhan su");
		comboBoxPB.addItem("4.Phong tai vu");
		box4.add(Box.createRigidArea(new Dimension(250, 10)));

		box5.add(labelTienLuong = new JLabel("Tien luong:"));
		box5.add(textFieldTienLuong = new JTextField());

		labelHo.setPreferredSize(new Dimension(labelTen.getPreferredSize()));
		labelMa.setPreferredSize(new Dimension(labelTen.getPreferredSize()));
		labelTienLuong.setPreferredSize(new Dimension(labelTen.getPreferredSize()));
		labelPhongBan.setPreferredSize(new Dimension(labelTen.getPreferredSize()));

		box.add(Box.createRigidArea(new Dimension(10, 30)));
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

		panelCenter.add(buttonThem = new JButton("Them"));
		panelCenter.add(buttonXoa = new JButton("Xoa"));
		panelCenter.add(buttonXoaTrang = new JButton("Xoa Trang"));
		panelCenter.add(buttonLuu = new JButton("Luu"));

		// South

		JPanel panelSouth = new JPanel();
		this.add(panelSouth, BorderLayout.SOUTH);

		String[] header = { "Ma nhan vien", "Ho", "Ten nhan vien", "Phong ban", "Tien luong" };

		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(480, 225));

		panelSouth.add(scrollPane);

		// Sukien

		buttonThem.addActionListener(this);
		buttonXoa.addActionListener(this);
		buttonXoaTrang.addActionListener(this);
		buttonLuu.addActionListener(this);

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
				textFieldMa.setText(table.getValueAt(row, 0).toString());
				textFieldHo.setText(table.getValueAt(row, 1).toString());
				textFieldTen.setText(table.getValueAt(row, 2).toString());
				String pb = table.getValueAt(row, 3).toString();
				textFieldTienLuong.setText(table.getValueAt(row, 4).toString());
				textFieldMa.requestFocus();

			}
		});

		if (new File("NhanVienOnTap.txt").exists()) {
			try {
				loadData();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			list = new ListNhanVien();
		}

	}

	public static void main(String[] args) {
		new Gui().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(buttonThem)) {
			if (textFieldMa.getText().equals("") || textFieldHo.getText().equals("")
					|| textFieldTen.getText().equals("")) {
				JOptionPane.showInternalMessageDialog(null, "Phai nhap day du thong tin vao!!!");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
				them();
			}
		} else if (o.equals(buttonXoaTrang)) {
			xoaTrang();
		} else if (o.equals(buttonXoa)) {
			xoa();
		} else {
			try {
				luu();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				e2.getMessage();
			}
		}

	}

	public void loadData() throws Exception {
		list = null;
		list = (ListNhanVien) database.readFile("NhanVienOnTap.txt");
		for (NhanVien x : list.getLs()) {
			String[] row = { x.getMa(), x.getHo(), x.getTen(), x.getPhongBan(), x.getTienLuong() + "" };
			tableModel.addRow(row);
		}
	}

	public void them() {

		String ma = textFieldMa.getText();
		String ho = textFieldHo.getText();
		String ten = textFieldTen.getText();
		String pb = comboBoxPB.getSelectedItem().toString();
		String string = "";
		if (pb.equals("1.Phong to chuc")) {
			string = "Phong to chuc";
		} else if (pb.equals("2.Phong ky thuat")) {
			string = "Phong ky thuat";
		} else if (pb.equals("3.Phong nhan su")) {
			string = "Phong nhan su";
		} else if (pb.equals("4.Phong tai vu")) {
			string = "Phong tai vu";
		}
		String tienLuong = textFieldTienLuong.getText();
		nv = new NhanVien(ma, ho, ten, string, Double.parseDouble(tienLuong));
		list.addNhanVien(nv);

		String[] row = { ma, ho, ten, string, tienLuong };
		tableModel.addRow(row);
	}

	public void xoaTrang() {
		textFieldMa.setText("");
		textFieldHo.setText("");
		textFieldTen.setText("");
		comboBoxPB.setSelectedItem(null);
		textFieldTienLuong.setText("");
		textFieldMa.requestFocus();
	}

	public void xoa() {
		int c = table.getSelectedRow();
		if (c == -1) {
			JOptionPane.showMessageDialog(null, "Khong co du lieu de xoa!!!");
		} else {
			int chon = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon xoa khong?", "delete",
					JOptionPane.YES_NO_OPTION);
			if (chon == JOptionPane.YES_OPTION) {
				tableModel.removeRow(c);
			}
		}
	}

	public void luu() throws Exception {
		
		if (!list.toString().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Luu thanh cong!!!");
			database.writeFile("NhanVienOnTap.txt", list);
			
		} else {
			JOptionPane.showMessageDialog(null, "Lưu file thất bại");
		}
	}

}
