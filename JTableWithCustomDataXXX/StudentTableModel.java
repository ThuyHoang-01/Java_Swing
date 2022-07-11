package sesion05.JTableWithCustomDataXXX;


import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentCollection collection;
	private String[] colsNames = { "Ma sinh vien", "Ten sinh vien", "Phai",
			"Ma Lop" };
	

	public StudentTableModel(StudentCollection data) {
		super();
		collection = data;
	}

	public int getColumnCount() {
		return colsNames.length;
	}

	public int getRowCount() {
		return collection.getSize();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Student st = (Student) (collection.getElement(row));
		switch (col) {
		case 0:
			return st.getID();
		case 1:
			return st.getName();
		case 2:
			return st.getGender() ? Boolean.TRUE : Boolean.FALSE;
		case 3:
			return st.getClassID();
		}
		return new String();
	}

	public void setValueAt(Object value, int row, int col) {
		Student st = (Student) (collection.getElement(row));
		switch (col) {
		case 0:
			st.setID((String) value);
			break;
		case 1:
			st.setName((String) value);
			break;
		case 2:
			st.setGender((Boolean) value);
			break;
		case 3:
			st.setClassID((String) value);
			break;
		}
	}


	public String getColumnName(int col) {
		return colsNames[col];
	}

	// tạo checkbox
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

//	/*
//	 * Don't need to implement this method unless your table's editable.
//	 */
//	public boolean isCellEditable(int row, int col) {
//		// Note that the data/cell address is constant,
//		// no matter where the cell appears onscreen.
//		if (col < 2) {
//			return false;
//		} else {
//			return true;
//		}
//	}
}
