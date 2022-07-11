package dao;

import java.util.ArrayList;
import java.util.Iterator;

import entity.NhanVien;

public class DanhSachNhanVien {

	// Tao ds nhan vien
	static ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();

	// ham them nhan vien
	public boolean addNV(NhanVien nv /* dua doi tuong nhan vien */) {

		for (NhanVien nhanVien : dsNhanVien) {
			if (nv.getMaNV() == nhanVien.getMaNV()) {
				return false;
			}
		}
		dsNhanVien.add(nv);
		return true;

	}

	public boolean xoaNV(int id) {
		for (NhanVien nhanVien : dsNhanVien) {
			if (id == nhanVien.getMaNV()) {
				dsNhanVien.remove(nhanVien);
				return true;
			}
		}
		return false;
	

}
	public ArrayList<NhanVien> getDS() {
		return dsNhanVien;
	}
}
