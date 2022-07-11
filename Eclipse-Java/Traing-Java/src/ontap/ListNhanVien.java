package ontap;

import java.io.Serializable;
import java.util.ArrayList;

public class ListNhanVien implements Serializable {

	private ArrayList<NhanVien> list;

	public ListNhanVien() {
		list = new ArrayList<NhanVien>();
	}

	public boolean addNhanVien(NhanVien x) {
		if (list.contains(x))
			return false;
		list.add(x);
		return true;
	}
	
	public ArrayList<NhanVien> getLs() {
		return list;
	}

	@Override
	public String toString() {
		return "ListNhanVien [list=" + list + "]";
	}
	
//	public boolean removeNhanVien(String ma) {
//		for(NhanVien x:list) {
//			if(x.getMa().equals(ma)) {
//				list.remove(x);
//				return true;
//			}
//		}
//		return false;
//	}
	
}
