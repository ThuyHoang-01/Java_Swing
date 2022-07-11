package fileText;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class dsSinhVien  {
	private ArrayList<SinhVien> dsSV;

	public dsSinhVien() {
		dsSV = new ArrayList<SinhVien>();
	}

	public ArrayList<SinhVien> getDsSV() {
		return dsSV;
	}

	public void napDulieuTuFile() throws IOException {
		dsSV=LuuTru_Character.DocFile();
	}

	public Boolean themSV(SinhVien sv) {

		if (dsSV.contains(sv))
			return false;
		dsSV.add(sv);
		return true;
	}
	public int getSize() {
		return dsSV.size();
	}
	
	public SinhVien getElement(int index) {
		if (index<0 || index>dsSV.size())
			return null;
		return dsSV.get(index);
	}
}
