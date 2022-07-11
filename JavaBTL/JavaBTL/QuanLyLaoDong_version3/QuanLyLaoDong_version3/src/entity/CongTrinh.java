package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.crypto.Data;

public class CongTrinh {
	private String maCongTrinh;
	private String tenCongTrinh;
	private String loaiCongTrinh;
	private DiaChi diaChi;
	private Date ngayKhoiCong;
	private Date ngayDKHoanThanh;
	private String trangThai;
	public CongTrinh(String maCongTrinh, String tenCongTrinh, String loaiCongTrinh, DiaChi diaChi, Date ngayKhoiCong,
			Date ngayDKHoanThanh, String trangThai) {
		super();
		this.maCongTrinh = maCongTrinh;
		this.tenCongTrinh = tenCongTrinh;
		this.loaiCongTrinh = loaiCongTrinh;
		this.diaChi = diaChi;
		this.ngayKhoiCong = ngayKhoiCong;
		this.ngayDKHoanThanh = ngayDKHoanThanh;
		this.trangThai = trangThai;
	}
	
	public CongTrinh(String maCongTrinh) {
		super();
		this.maCongTrinh = maCongTrinh;
	}

	public String getMaCongTrinh() {
		return maCongTrinh;
	}
	public void setMaCongTrinh(String maCongTrinh) {
		this.maCongTrinh = maCongTrinh;
	}
	public String gettenCongTrinh() {
		return tenCongTrinh;
	}
	public void settenCongTrinh(String tenCongTrinh) {
		this.tenCongTrinh = tenCongTrinh;
	}
	public String getLoaiCongTrinh() {
		return loaiCongTrinh;
	}
	public void setLoaiCongTrinh(String loaiCongTrinh) {
		this.loaiCongTrinh = loaiCongTrinh;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgayKhoiCong() {
		return ngayKhoiCong;
	}
	public void setNgayKhoiCong(Date ngayKhoiCong) {
		this.ngayKhoiCong = ngayKhoiCong;
	}
	public Date getNgayDKHoanThanh() {
		return ngayDKHoanThanh;
	}
	public void setNgayDKHoanThanh(Date ngayDKHoanThanh) {
		this.ngayDKHoanThanh = ngayDKHoanThanh;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "CongTrinh [maCongTrinh=" + maCongTrinh + ", tenCongTrinh=" + tenCongTrinh + ", loaiCongTrinh="
				+ loaiCongTrinh + ", diaChi=" + diaChi + ", ngayKhoiCong=" + ngayKhoiCong + ", ngayDKHoanThanh="
				+ ngayDKHoanThanh + ", trangThai=" + trangThai + "]";
	}
	
}
