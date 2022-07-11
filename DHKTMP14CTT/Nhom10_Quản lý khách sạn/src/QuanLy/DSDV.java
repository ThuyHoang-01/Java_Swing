package QuanLy;

import java.util.ArrayList;
import Class.DichVu;
public class DSDV {
	private static ArrayList<DichVu> dsSach;

	public DSDV() {
		dsSach = new ArrayList<DichVu>();
	}
	public static boolean themSach(DichVu s) {
		if (dsSach.contains(s))
			return false;
		dsSach.add(s);
		return true;
	}

	public static boolean xoa1CuonSach(int index) {
		if (index >= 0 && index <= dsSach.size()) {
			dsSach.remove(index);
			return true;
		}
		return false;
	}

	public static ArrayList<DichVu> getDsSach() {
		return dsSach;
	}

	public DichVu getSach(int index) {
		if (index < 0 || index > dsSach.size())
			return null;
		return dsSach.get(index);
	}

	public static DichVu timKiem(String dVu) {
		DichVu s = new DichVu(dVu);
		if (dsSach.contains(s)) {
			return dsSach.get(dsSach.indexOf(s));
		}
		return null;
	}

	
}
