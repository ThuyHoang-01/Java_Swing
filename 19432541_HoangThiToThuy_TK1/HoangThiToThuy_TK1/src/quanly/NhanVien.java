package quanly;


public class NhanVien {

	private String maNV;
	private String hoTen;
	private String diaChi;
	private int Tuoi;
	private String email;

	public NhanVien(String maNV, String hoTen, String diaChi, int tuoi,
			String email) {
		
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		Tuoi = tuoi;
		this.email = email;
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getTuoi() {
		return Tuoi;
	}
	public void setTuoi(int tuoi) {
		Tuoi = tuoi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equalsIgnoreCase(other.maNV))
			return false;
		return true;
	}
	
	//Mỗi giá trị trong dòng ngăn cách bằng dấu ;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return maNV + ";" + hoTen + ";"
				+ diaChi + ";" + Tuoi + ";" + email
				+ ";"  ;
	}
}//end class
