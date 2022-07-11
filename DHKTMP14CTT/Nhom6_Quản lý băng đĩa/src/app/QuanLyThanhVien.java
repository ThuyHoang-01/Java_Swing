package app;

import java.util.ArrayList;

public class QuanLyThanhVien {
	private static ArrayList<ThanhVien> dsTV;

	public QuanLyThanhVien() {
		dsTV = new ArrayList<ThanhVien>(10);
	}

	public static boolean themThanhVien(ThanhVien tv) {
		if (dsTV.contains(tv))
			return false;
		dsTV.add(tv);
		return true;
	}
	public static boolean xoaThanhVien(int index) {
		if (index >= 0 && index <= dsTV.size()) {
			dsTV.remove(index);
			return true;
		}
		return false;
	}
	public static ThanhVien getTV(String CMND) {
		ThanhVien tv = new ThanhVien(CMND);
		return dsTV.get(dsTV.indexOf(tv));
	}
	public static ArrayList<ThanhVien> getDsThanhVien() {
		return dsTV;
	}

	public ThanhVien getThanhVien(int index) {
		if (index < 0 || index > dsTV.size())
			return null;
		return dsTV.get(index);
	}

	public static ThanhVien timKiem(String cmnd) {
		ThanhVien tv = new ThanhVien(cmnd);
		if (dsTV.contains(tv)) {
			return dsTV.get(dsTV.indexOf(tv));
		}
		return null;
	}
}
