package Class;

public class Phong {
	private String soPhong;
	private String loaiPhong;
	private double donGia;
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
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public Phong(String soPhong, String loaiPhong, double donGia) {
		super();
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.donGia = donGia;
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
		Phong other = (Phong) obj;
		if (soPhong == null) {
			if (other.soPhong != null)
				return false;
		} else if (!soPhong.equals(other.soPhong))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Phong [soPhong=" + soPhong + ", loaiPhong=" + loaiPhong + ", donGia=" + donGia + "]";
	}
	
}
