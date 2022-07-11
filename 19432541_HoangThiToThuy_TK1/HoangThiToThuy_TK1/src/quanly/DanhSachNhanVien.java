package quanly;

import java.util.ArrayList;



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
}
