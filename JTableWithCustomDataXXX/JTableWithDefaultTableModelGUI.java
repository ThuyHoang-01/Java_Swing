package sesion05.JTableWithCustomDataXXX;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sesion05.JTableWithCustomDataXXX.Student;

public class JTableWithDefaultTableModelGUI extends JFrame implements
		ActionListener {
	private String[] colsNames = { "Ma sinh vien", "Ten sinh vien", "Phai",
			"Ma Lop" };
	private JTable studentTable;
	private DefaultTableModel studentModel;

	ArrayList<Student> ds=new ArrayList<Student>();
	private JButton b;

	public JTableWithDefaultTableModelGUI() {

		studentModel = new DefaultTableModel(colsNames, 0);
		studentTable = new JTable(studentModel);
		add(new JScrollPane(studentTable));

		b = new JButton("Thêm");
		add(b, BorderLayout.SOUTH);

		b.addActionListener(this);

		// // add student 1
		// Object[] obj = new Object[4];
		// obj[0] = "0001";
		// obj[1] = "Nguyen Van A";
		// obj[2] = Boolean.TRUE;
		// obj[3] = "CDTH10K";
		// studentModel.addRow(obj);
		// // add student 2
		// obj = new Object[4];
		// obj[0] = "0002";
		// obj[1] = "Nguyen Thi B";
		// obj[2] = Boolean.FALSE;
		// obj[3] = "CDTH10K";
		// studentModel.addRow(obj);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		// validate();
	}

	public static void main(String[] args) {
		new JTableWithDefaultTableModelGUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Student d = new Student("0003", "Tran Thi C", false, "CDTH10K");
		Object[] obj = { d.getID(), d.getName(), d.getGender(), d.getClassID() };
		studentModel.addRow(obj);
	}
}
