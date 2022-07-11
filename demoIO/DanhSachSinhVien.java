package dhKTPM14A.demoIO;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachSinhVien implements Serializable {
	private ArrayList<SinhVien> dsSV;
	public DanhSachSinhVien() {
		// TODO Auto-generated constructor stub
		dsSV = new ArrayList<SinhVien>();
	}
	
	public Boolean themSinhVien(SinhVien sv) {
		if(dsSV.contains(sv))
			return false;
		dsSV.add(sv);
		return true;
	}
	
	public SinhVien getElement(int index) {
		if(index<0 || index>dsSV.size())
			return null;
		return dsSV.get(index);
	}
	
	
	public int getSize() {
		return dsSV.size();
	}
	
}
