package chiTietHoaDon;

public class ChiTietHoaDon {
	private String maHD,maHang;
	private double giaBan;
	private int soLuong;
	private double mucGiamGia;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getMucGiamGia() {
		return mucGiamGia;
	}
	public void setMucGiamGia(double mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}
	public ChiTietHoaDon(String maHD) {
		super();
		this.maHD = maHD;
		this.maHang = maHang;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.mucGiamGia = mucGiamGia;
	}
	public ChiTietHoaDon(String maHD2, String maMH1, double gia, int sl, double sale) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(giaBan);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
		result = prime * result + ((maHang == null) ? 0 : maHang.hashCode());
		temp = Double.doubleToLongBits(mucGiamGia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + soLuong;
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
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		if (Double.doubleToLongBits(giaBan) != Double.doubleToLongBits(other.giaBan))
			return false;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		if (maHang == null) {
			if (other.maHang != null)
				return false;
		} else if (!maHang.equals(other.maHang))
			return false;
		if (Double.doubleToLongBits(mucGiamGia) != Double.doubleToLongBits(other.mucGiamGia))
			return false;
		if (soLuong != other.soLuong)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return maHD+";"+maHang+";"+giaBan+";"+soLuong+";"+mucGiamGia;
	}
	
	
	
}
