package app;

import java.util.ArrayList;

public class QuanLyBDCart {
	private static  ArrayList<BangDia> dsBDC;
	private static String KhachHang;
	public QuanLyBDCart() {
		dsBDC = new ArrayList<BangDia>(10);
	}
	public static void SetKhachHang(String KH) {
		KhachHang = KH;
	}
	
	public static String GetKhachHang() {
		return KhachHang;
	}

	public static boolean themBangDiaC(BangDia cd) {
		if (dsBDC.contains(cd)) {
			dsBDC.get(dsBDC.indexOf(cd)).setSoLuong(dsBDC.get(dsBDC.indexOf(cd)).getSoLuong()+1);
			return true;
		}
		dsBDC.add(cd);
		dsBDC.get(dsBDC.indexOf(cd)).setSoLuong(1);
		return true;
	}
	public static double tongTien() {
		double S = 0;
		for(int i = 0 ; i< dsBDC.size(); i++) {
			S+=dsBDC.get(i).getGia();
		}
		return S;
	}
	public static double TongTien() {
		double S = 0;
		for(int i = 0; i <= dsBDC.size();i++) {
			S+=dsBDC.get(i).getGia()*dsBDC.get(i).getSoLuong();
		}
		return S;
	}
	
	
	public static BangDia getBangDiaC(int index) {
		if (index >= 0 && index <= dsBDC.size()) {
			return dsBDC.get(index);
		}
		return null;
	}
	
	

	public static boolean xoaBangDiaC(int index) {
		if (index >= 0 && index <= dsBDC.size()) {
			dsBDC.remove(index);
			return true;
		}
		return false;
	}
	
	public static void clearCart() {
		for(int i = 0; i <= dsBDC.size();i++)
			dsBDC.remove(i);
	}

	public static ArrayList<BangDia> getDsBangDiaC() {
		return dsBDC;
	}

	public BangDia getSach(int index) {
		if (index < 0 || index > dsBDC.size())
			return null;
		return dsBDC.get(index);
	}

	public static BangDia timKiemC(String maBD) {
		BangDia cd = new BangDia(maBD);
		if (dsBDC.contains(cd)) {
			return dsBDC.get(dsBDC.indexOf(cd));
		}
		return null;
	}

	public static boolean capNhatBangDiaC(String maCDOld, BangDia CDNew) {
		BangDia CDOld = new BangDia(maCDOld);
		if (dsBDC.contains(CDOld)) {
			CDOld = dsBDC.get(dsBDC.indexOf(CDOld));
			CDOld.setTenBangDia(CDNew.getTenBangDia());
			CDOld.setTheLoai(CDNew.getTheLoai());
			CDOld.setHangSX(CDNew.getHangSX());
			CDOld.setTinhTrang(CDNew.getTinhTrang());
			CDOld.setGhiChu(CDNew.getGhiChu());
			return true;
		}
		return false;
	}
}
