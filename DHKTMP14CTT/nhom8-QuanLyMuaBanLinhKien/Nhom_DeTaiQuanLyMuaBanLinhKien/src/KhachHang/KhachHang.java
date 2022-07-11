package KhachHang;

public class KhachHang {
	private String maKH;
	private String tenKH,email,diaChi;
	private String soDT;
	public KhachHang(String maKH, String tenKH, String email, String diaChi, String soDT) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.email = email;
		this.diaChi = diaChi;
		this.soDT = soDT;
	}
	public KhachHang(String maKH) {
		this(maKH,"ten kh","email","dia chi","so DT");
	}
	public KhachHang() {

	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return maKH +";" + tenKH + ";" + email +";" + diaChi + ";" + soDT;
	}
	
	
	
	
	
	
	
	
	
}
