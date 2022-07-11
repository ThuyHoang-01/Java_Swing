package manage;

import java.util.ArrayList;

//import db.database;
import entity.Nhanvien;

public class DanhsachNV {
	ArrayList<Nhanvien> dsNV ;
	
	public DanhsachNV() {
		dsNV = new ArrayList<Nhanvien>();
	}
	
	public boolean themNV(Nhanvien nv) {
		if(dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}

	public boolean xoaNV(int index) {
		if( index < 0 || index > dsNV.size())
			return false;
		dsNV.remove(index);
		return true;
	}

	public int timkiem(int manv) {
		Nhanvien nv = new Nhanvien(manv);
		if (dsNV.contains(nv)) {
			return dsNV.indexOf(nv);
		}
		return -1;
	}
	public ArrayList<Nhanvien> getdsNV() {
		return dsNV;
	}

	public int getSize() {
		return dsNV.size()	;
	}
	
	public void setdsNV(ArrayList<Nhanvien> dsNV) {
		this.dsNV = dsNV;
	}

	public Nhanvien getElement(int index) {
		return dsNV.get(index);
	}
	
//	public void Docfile() {
//		dsNV = database.docTuFile();
//	}

}
