package baiTapLon;

import java.util.Calendar;
import java.util.Date;

public class KhachHangCoKeDon extends KhachHang {
	private String tenKhachHang, soDienThoai, diaChi, nguyenNhanBenh, ngayDenQuayThuoc;
	public KhachHangCoKeDon(String maKhachHang, String tenKhachHang, String soDienThoai, String diaChi,
			String nguyenNhanBenh, String ngayDenQuayThuoc) {
		super(maKhachHang);
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.nguyenNhanBenh = nguyenNhanBenh;
		this.ngayDenQuayThuoc = ngayDenQuayThuoc;
	}
	
	public KhachHangCoKeDon(String maKhachHang) {
		super(maKhachHang);
		this.tenKhachHang = "";
		this.soDienThoai = "";
		this.diaChi = "";
		this.nguyenNhanBenh = "";
		this.ngayDenQuayThuoc = "";
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getNguyenNhanBenh() {
		return nguyenNhanBenh;
	}
	public void setNguyenNhanBenh(String nguyenNhanBenh) {
		this.nguyenNhanBenh = nguyenNhanBenh;
	}
	
	public String getNgayDenQuayThuoc() {
		return ngayDenQuayThuoc;
	}
	public void setNgayDenQuayThuoc(String ngayDenQuayThuoc) {
		this.ngayDenQuayThuoc = ngayDenQuayThuoc;
	}
	@Override
	public String toString() {
		return "KhachHangCoKeDon [tenKhachHang=" + tenKhachHang + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi
				+ ", nguyenNhanBenh=" + nguyenNhanBenh + ", ngayDenQuayThuoc=" + ngayDenQuayThuoc + "]";
	}

	
	
}
