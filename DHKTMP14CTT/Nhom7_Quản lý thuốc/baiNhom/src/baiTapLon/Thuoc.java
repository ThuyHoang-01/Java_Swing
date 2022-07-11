package baiTapLon;

import java.util.Calendar;

public class Thuoc {
	private String maThuoc, tenThuoc, donViThuoc, nhaCungCap;
	private double donGia;
	private String hanSuDung;
	public Thuoc(String maThuoc, String tenThuoc, String donViThuoc, String nhaCungCap, double donGia,
			String hanSuDung) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.donViThuoc = donViThuoc;
		this.nhaCungCap = nhaCungCap;
		this.donGia = donGia;
		this.hanSuDung = hanSuDung;
	}
	public Thuoc(String maThuoc) {
		this(maThuoc, "", "", "", 0.0, null);
	}
	public Thuoc() {
		this("maThuoc");
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getDonViThuoc() {
		return donViThuoc;
	}
	public void setDonViThuoc(String donViThuoc) {
		this.donViThuoc = donViThuoc;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getHanSuDung() {
		return hanSuDung;
	}
	public void setHanSuDung(String hanSuDung) {
		this.hanSuDung = hanSuDung;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc other = (Thuoc) obj;
		if (maThuoc == null) {
			if (other.maThuoc != null)
				return false;
		} else if (!maThuoc.equals(other.maThuoc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", donViThuoc=" + donViThuoc + ", nhaCungCap="
				+ nhaCungCap + ", donGia=" + donGia + ", hanSuDung=" + hanSuDung + "]";
	}
}
