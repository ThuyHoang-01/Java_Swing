package baiTapLon;

import java.util.Calendar;

public class DonThuoc {
	private String maKhachHang, maThuoc;
	private int soLuong;
	private String ngayLapDonThuoc;
	public DonThuoc(String maKhachHang, String maThuoc, int soLuong, String ngayLapDonThuoc) {
		super();
		this.maKhachHang = maKhachHang;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
		this.ngayLapDonThuoc = ngayLapDonThuoc;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNgayLapDonThuoc() {
		return ngayLapDonThuoc;
	}
	public void setNgayLapDonThuoc(String ngayLapDonThuoc) {
		this.ngayLapDonThuoc = ngayLapDonThuoc;
	}
	@Override
	public String toString() {
		return "DonThuoc [maKhachHang=" + maKhachHang + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong
				+ ", ngayLapDonThuoc=" + ngayLapDonThuoc + "]";
	}
	
	
	
}
