package hoangThiToThuy_19432541;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame implements ActionListener {
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	ManageProduct dom = new ManageProduct();
	private JButton buttonAdd, buttonDelete, buttonUpdate, buttonSave;

	public Gui() {
		// Frame
		this.setTitle("-.-");
		this.setSize(1200, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// Layout

		// North
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		JLabel labelTitle = new JLabel("THONG TIN SINH VIEN");
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b1.add(labelTitle);
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(10, 20)));
		this.add(b, BorderLayout.NORTH);

		// Center
		String[] header = { "ID", "Ten", "Lop", "Noi sinh", "Mon hoc"};
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		this.add(scroll, BorderLayout.CENTER);
		loadTable();

		// South
		Box boxSouth = Box.createVerticalBox();
		Box boxSouth1 = Box.createHorizontalBox();
		boxSouth1.add(buttonAdd = new JButton("Add"));
		boxSouth1.add(Box.createRigidArea(new Dimension(30, 10)));
		boxSouth1.add(buttonDelete = new JButton("Delete"));
		boxSouth1.add(Box.createRigidArea(new Dimension(30, 10)));
		boxSouth1.add(buttonUpdate = new JButton("Update"));
		boxSouth1.add(Box.createRigidArea(new Dimension(30, 10)));
		boxSouth1.add(buttonSave = new JButton("Save"));
		boxSouth.add(boxSouth1);
		this.add(boxSouth, BorderLayout.SOUTH);

		this.buttonAdd.addActionListener(this);
		this.buttonDelete.addActionListener(this);
		this.buttonUpdate.addActionListener(this);
		this.buttonSave.addActionListener(this);
	}

	public static void main(String[] args) {
		new Gui().setVisible(true);
	}

	public void loadTable() {
		while (table.getRowCount() != 0) {
			model.removeRow(0);
		}
		ArrayList<Sinhvien> list = dom.getAllProduct();
		for (Sinhvien p : list) {
			String[] row = { p.getId(), p.getTen(), p.getLop(),p.getNoisinh(),p.getMonhoc()};
			model.addRow(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(buttonAdd)) {
			String id = JOptionPane.showInputDialog("Nhap vao ma");
			String name = JOptionPane.showInputDialog("Nhap vao ten");
			Sinhvien p = new Sinhvien(id, name, "DHKHMT","CAN THO","HSK");
			dom.addProduct(p);
			JOptionPane.showMessageDialog(this, " Them thanh cong");
			loadTable();

		}
		
		if (o.equals(buttonDelete)) {
			int r = table.getSelectedRow();
			if (r != -1) {
				String id = (String) table.getValueAt(r, 0);
				dom.deleteProduct(id);
				loadTable();
			}
		}

		if (o.equals(buttonUpdate)) {
			String id = JOptionPane.showInputDialog("Nhap vao id sv can update ");
			String lop = JOptionPane.showInputDialog("Nhap vao lop moi = ");
			dom.updatePrice(id, lop);
			loadTable();
		}
		
		if (o.equals(buttonSave)) {
			dom.writeXMLFile();
			JOptionPane.showMessageDialog(this, " Luu file thanh cong");
		}
		

	}

}
