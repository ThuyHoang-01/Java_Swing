package app;

import java.util.ArrayList;

public class QuanLyNhanVien {
	private static ArrayList<NhanVien> dsNV;

	public QuanLyNhanVien() {
		dsNV = new ArrayList<NhanVien>(10);
	}

	public static boolean themNhanVien(NhanVien nv) {
		if (dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}

	public static boolean xoaNhanVien(int index) {
		if (index >= 0 && index <= dsNV.size()) {
			dsNV.remove(index);
			return true;
		}
		return false;
	}

	public static ArrayList<NhanVien> getDsNhanVien() {
		return dsNV;
	}

	public NhanVien getNhanVien(int index) {
		if (index < 0 || index > dsNV.size())
			return null;
		return dsNV.get(index);
	}

	public static NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if (dsNV.contains(nv)) {
			return dsNV.get(dsNV.indexOf(nv));
		}
		return null;
	}

	public static boolean capNhatNhanVien(String maNVOld, NhanVien NVNew) {
		NhanVien NVOld = new NhanVien(maNVOld);
		if (dsNV.contains(NVOld)) {
			NVOld = dsNV.get(dsNV.indexOf(NVOld));
			NVOld.setTenNV(NVNew.getTenNV());
			NVOld.setMaNV(NVNew.getMaNV());
			NVOld.setsDT(NVNew.getsDT());
			NVOld.setMoTa(NVNew.getMoTa());
			return true;
		}
		return false;
	}
}
