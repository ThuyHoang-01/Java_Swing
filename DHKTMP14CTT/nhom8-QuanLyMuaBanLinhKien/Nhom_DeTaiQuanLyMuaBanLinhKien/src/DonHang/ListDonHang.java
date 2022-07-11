package DonHang;

import java.util.ArrayList;

import MatHang.MatHang;

public class ListDonHang {
	private static ArrayList<DonHang> listDon;
	
	public ListDonHang() {
		listDon = new ArrayList<DonHang>(10);
	}
	
	public static boolean themDonHang(DonHang d) {
		if(listDon.contains(d))
			return false;
		return listDon.add(d);
	}
	public static boolean xoaHang(int id) {
		if(id>=0 && id<listDon.size()) {
			listDon.remove(id);
			return true;
		}
		return false;
	}
	public static DonHang timHang(String soHD) {
		DonHang d = new DonHang(soHD);
		if(listDon.contains(d)) {
			return listDon.get(listDon.indexOf(d));
		}
		return null;
	}
	public static ArrayList<DonHang> getDSDon(){
		return listDon;
	}
}
