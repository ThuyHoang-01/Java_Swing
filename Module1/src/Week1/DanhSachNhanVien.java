package Table.java;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachNhanVien implements Serializable {

	private ArrayList<NhanVien> dsNV;
	
	public ArrayList<NhanVien> getDsNV() {
		return dsNV;
	}
	
	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	
	public NhanVien getElement(int index) {
		if(index < 0 || index >= dsNV.size()) {
			return null;
		}
		return dsNV.get(index);
	}
	
	public int getSize() {
		return dsNV.size();
	}
	
	public boolean themNV(NhanVien nv) {
		if(dsNV.contains(nv)) {
			return false;
		}
		dsNV.add(nv);
		return true;
	}
	
	public DanhSachNhanVien() {
		dsNV = new ArrayList<NhanVien>();
	}

	public boolean xoaNV(int ma) {
		NhanVien nv = new NhanVien(ma);
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	
	public NhanVien timKiem(int ma) {
		NhanVien nv = new NhanVien(ma);
		if(dsNV.contains(nv)) {
			return dsNV.get(dsNV.indexOf(nv));
		}
		return null;
	}
	
	
}
