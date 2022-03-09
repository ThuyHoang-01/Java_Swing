package week4ThongtinNV.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import week4ThongtinNV.entity.Nhanvien;

public class NVTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Nhanvien> dsNV;
	String[] cols = {
			"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền Lương"
	};
	
	public void setdsNV(ArrayList<Nhanvien> dsNV) {
		this.dsNV = dsNV;
	}

	@Override
	public int getRowCount() {
		return dsNV.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Nhanvien nv = dsNV.get(rowIndex);
		switch (columnIndex) {
			case 0: return nv.getManv();
			case 1: return nv.getHo();
			case 2: return nv.getTen();
			case 3: return nv.isPhai();
			case 4: return nv.getTuoi();
			case 5: return nv.getTienluong();
			default:
					return nv;
		}
	}
	
}
