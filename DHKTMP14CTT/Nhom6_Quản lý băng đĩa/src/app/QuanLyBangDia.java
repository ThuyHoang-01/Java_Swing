package app;

import java.util.ArrayList;

public class QuanLyBangDia {
	private static ArrayList<BangDia> dsBD;

	public QuanLyBangDia() {
		dsBD = new ArrayList<BangDia>(10);
	}

	public static boolean themBangDia(BangDia cd) {
		if (dsBD.contains(cd))
			return false;
		dsBD.add(cd);
		return true;
	}
	
	public static BangDia getBangDia(int index) {
		if (index >= 0 && index <= dsBD.size()) {
			return dsBD.get(index);
		}
		return null;
	}

	public static boolean xoaBangDia(int index) {
		if (index >= 0 && index <= dsBD.size()) {
			dsBD.remove(index);
			return true;
		}
		return false;
	}

	public static ArrayList<BangDia> getDsBangDia() {
		return dsBD;
	}

	

	public static BangDia timKiem(String maBD) {
		BangDia cd = new BangDia(maBD);
		if (dsBD.contains(cd)) {
			return dsBD.get(dsBD.indexOf(cd));
		}
		return null;
	}

	public static boolean capNhatBangDia(String maCDOld, BangDia CDNew) {
		BangDia CDOld = new BangDia(maCDOld);
		if (dsBD.contains(CDOld)) {
			CDOld = dsBD.get(dsBD.indexOf(CDOld));
			CDOld.setTenBangDia(CDNew.getTenBangDia());
			CDOld.setTheLoai(CDNew.getTheLoai());
			CDOld.setHangSX(CDNew.getHangSX());
			CDOld.setTinhTrang(CDNew.getTinhTrang());
			CDOld.setGhiChu(CDNew.getGhiChu());
			CDOld.setGia(CDNew.getGia());
			
			return true;
		}
		return false;
	}
}
