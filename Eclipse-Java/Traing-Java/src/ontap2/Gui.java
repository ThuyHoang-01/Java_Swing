package ontap2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Gui extends JFrame implements ActionListener {
	private JLabel labelTitle, labelCountry, labelCapital, labelPopulation, labelSelect;
	private JTextField textFieldCountry, textFieldCapital, textFieldPopulation;
	private JComboBox comboBox;
	private JButton buttonAdd, buttonClear, buttonUpdate, buttonDelete, buttonSearch;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private JCheckBox checkBox;

	public Gui() {

		// Frame
		this.setTitle("Using JTable Component & IO Stream");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// Layout

		// North
		Box box = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		Box box5 = Box.createHorizontalBox();

		box1.add(labelTitle = new JLabel("Using JTable Component"));
		labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
		labelTitle.setForeground(Color.BLUE);

		box2.add(labelCountry = new JLabel("Enter Country:"));
		box2.add(textFieldCountry = new JTextField());
		box2.add(Box.createRigidArea(new Dimension(350, 10)));

		box3.add(labelCapital = new JLabel("Enter Cappital:"));
		box3.add(textFieldCapital = new JTextField());

		box4.add(labelPopulation = new JLabel("Enter Population:"));
		box4.add(textFieldPopulation = new JTextField());

		box5.add(labelSelect = new JLabel("Select Democracy:"));
		box5.add(comboBox = new JComboBox());
		comboBox.addItem("true");
		comboBox.addItem("false");
		box5.add(Box.createRigidArea(new Dimension(350, 10)));

		labelCountry.setPreferredSize(new Dimension(labelSelect.getPreferredSize()));
		labelCapital.setPreferredSize(new Dimension(labelSelect.getPreferredSize()));
		labelPopulation.setPreferredSize(new Dimension(labelSelect.getPreferredSize()));

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

		// center

		String[] header = { "Country", "Capital", "Population", "Democracy" };
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		TableColumn genderColumn = table.getColumnModel().getColumn(3);
		checkBox = new JCheckBox();
		checkBox.setSelected(true);
		genderColumn.setCellEditor(new DefaultCellEditor(checkBox));
		this.add(scrollPane, BorderLayout.CENTER);

		// South

		Box boxSouth = Box.createHorizontalBox();
		boxSouth.add(Box.createRigidArea(new Dimension(175, 10)));
		boxSouth.add(buttonAdd = new JButton("Add"));
		boxSouth.add(Box.createRigidArea(new Dimension(5, 10)));
		boxSouth.add(buttonClear = new JButton("Clear"));
		boxSouth.add(Box.createRigidArea(new Dimension(5, 10)));
		boxSouth.add(buttonUpdate = new JButton("Update"));
		boxSouth.add(Box.createRigidArea(new Dimension(5, 10)));
		boxSouth.add(buttonDelete = new JButton("Delete"));
		boxSouth.add(Box.createRigidArea(new Dimension(5, 10)));
		boxSouth.add(buttonSearch = new JButton("Search"));

		this.add(boxSouth, BorderLayout.SOUTH);

		// Events
		buttonAdd.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonDelete.addActionListener(this);
		buttonSearch.addActionListener(this);
		buttonUpdate.addActionListener(this);
		

	}

	public static void main(String[] args) {
		new Gui().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(buttonAdd)) {
			if(textFieldCountry.getText().equals("") || textFieldCapital.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Phai nhap thong tin vao!!!");
			}else {
				add();
			}
		}else if (o.equals(buttonClear)) {
			clear();
			
		}else if (o.equals(buttonDelete)) {
			delete();
		}else if (o.equals(buttonSearch)) {
			String string =  JOptionPane.showInputDialog(null,"Nhap vao ten:");
			if(string != null) {
				JOptionPane.showMessageDialog(null, string);
			}
		}

	}
	public void add() {
		String country = textFieldCountry.getText();
		String capital = textFieldCapital.getText();
		String population = textFieldPopulation.getText();
		String[] row = {country,capital,population};
		tableModel.addRow(row);
		
	}
	public void clear() {
		textFieldCountry.setText("");
		textFieldCapital.setText("");
		textFieldPopulation.setText("");
		comboBox.setSelectedItem("false");
		textFieldCountry.requestFocus();
	}
	
	public void delete() {
		int x = table.getSelectedRow();
		if(x == -1) {
			JOptionPane.showMessageDialog(null, "Phai chon dong de xoa!!!");
		}else {
			int k = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon xoa dong nay khong?","delete",JOptionPane.YES_NO_OPTION);
			if(k == JOptionPane.YES_OPTION) {
				tableModel.removeRow(x);
			}
		
		}
	}
	
}
