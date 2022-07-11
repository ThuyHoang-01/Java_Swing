package NhanVien;

public class NhanVien {
	private String maNV;
	private String hoTen;
	private float tienLuong;
	public NhanVien(String maNV, String hoTen, float tienLuong) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.tienLuong = tienLuong;
	}
	
	public NhanVien(String maNV) {
		this(maNV,"ho ten",0);
	}
	
	

	public NhanVien() {
		
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

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(float tienLuong) {
		this.tienLuong = tienLuong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return maNV + ";" + hoTen + ";" + tienLuong;
	}
	
	
	
	
	
}
