package ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entity.Nhanvien;

// bài này k phải sv làm bài này của ông Thắng 1 năm trc ổng gửi t down về á

public class NVTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Nhanvien> dsNV;
	String[] cols = {
			"MÃ NV", "HỌ", "TÊN", "PHÁI", "TUỔI", "TIỀN LƯƠNG"
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
