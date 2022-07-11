package Class;

import java.util.Calendar;

public class NhanPhong {
	private String soPhong;
	private String loaiPhong;
	private String hoTen;
	private Calendar thoiGianNhan;
	public String getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Calendar getThoiGianNhan() {
		return thoiGianNhan;
	}
	public void setThoiGianNhan(Calendar thoiGianNhan) {
		this.thoiGianNhan = thoiGianNhan;
	}
	public NhanPhong(String soPhong, String loaiPhong, String hoTen, Calendar thoiGianNhan) {
		super();
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.hoTen = hoTen;
		this.thoiGianNhan = thoiGianNhan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((soPhong == null) ? 0 : soPhong.hashCode());
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
		NhanPhong other = (NhanPhong) obj;
		if (soPhong == null) {
			if (other.soPhong != null)
				return false;
		} else if (!soPhong.equals(other.soPhong))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhanPhong [soPhong=" + soPhong + ", loaiPhong=" + loaiPhong + ", hoTen=" + hoTen + ", thoiGianNhan="
				+ thoiGianNhan + "]";
	}
	
	
}
