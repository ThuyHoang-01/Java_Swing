package app;

import java.util.Calendar;

public class BangDia {
	private String maBD;
	private String tenBD;
	private String theLoai;
	private String hangSX;
	private String tinhTrang;
	private String ghiChu;
	private double gia;
	private int soLuong;

	public BangDia(String maBD, String tenBD, String theLoai, String hangSX, String tinhTrang, String ghiChu, double gia, int soLuong) {
		super();
		this.maBD = maBD;
		this.tenBD = tenBD;
		this.theLoai = theLoai;
		this.hangSX = hangSX;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
		this.gia = gia;
		this.soLuong = soLuong;
	}
	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soL) {
		this.soLuong = soL;
	}

	public String getMaBangDia() {
		return maBD;
	}

	public void setMaBangDia(String maBD) {
		this.maBD = maBD;
	}

	public String getTenBangDia() {
		return tenBD;
	}

	public void setTenBangDia(String ten) {
		this.tenBD = ten;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theloai) {
		this.theLoai = theloai;
	}

	public String getHangSX() {
		return hangSX;
	}

	public void setHangSX(String hang) {
		this.hangSX = hang;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tt) {
		this.tinhTrang = tt;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String gChu) {
		this.ghiChu = gChu;
	}

	public BangDia(String maBD) {
		this(maBD, "", "", "", "", "", 0.0,0);
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maBD == null) ? 0 : maBD.hashCode());
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
		BangDia other = (BangDia) obj;
		if (maBD == null) {
			if (other.maBD != null)
				return false;
		} else if (!maBD.equals(other.maBD))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return maBD + ";" + tenBD + ";" + theLoai + ";" + hangSX + ";" + tinhTrang + ";" + ghiChu +";"+ gia +";"+soLuong;
	}

}
