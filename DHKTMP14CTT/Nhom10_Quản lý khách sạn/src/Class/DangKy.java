package Class;

import java.util.Calendar;

public class DangKy {
	private String maKH;
	private String Hoten;
	private Calendar NgayThue;
	private Calendar NgayTra;
	private String slPhong;
	private String loaiPhong;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public Calendar getNgayThue() {
		return NgayThue;
	}
	public void setNgayThue(Calendar ngayThue) {
		NgayThue = ngayThue;
	}
	public Calendar getNgayTra() {
		return NgayTra;
	}
	public void setNgayTra(Calendar ngayTra) {
		NgayTra = ngayTra;
	}
	public String getSlPhong() {
		return slPhong;
	}
	public void setSlPhong(String slPhong) {
		this.slPhong = slPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public DangKy(String maKH, String hoten, Calendar ngayThue, Calendar ngayTra, String slPhong, String loaiPhong) {
		super();
		this.maKH = maKH;
		this.Hoten = hoten;
		this.NgayThue = ngayThue;
		this.NgayTra = ngayTra;
		this.slPhong = slPhong;
		this.loaiPhong = loaiPhong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Hoten == null) ? 0 : Hoten.hashCode());
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
		DangKy other = (DangKy) obj;
		if (Hoten == null) {
			if (other.Hoten != null)
				return false;
		} else if (!Hoten.equals(other.Hoten))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DangKy [maKH=" + maKH + ", Hoten=" + Hoten + ", NgayThue=" + NgayThue + ", NgayTra=" + NgayTra
				+ ", slPhong=" + slPhong + ", loaiPhong=" + loaiPhong + "]";
	}
	
	
}
