package app;

public class NhanVien {
	private String maNV, moTa, tenNV, sDT;

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public NhanVien(String maNV, String tenNV, String sDT, String moTa) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sDT = sDT;
		this.moTa = moTa;
	
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		return result;
	}
	public NhanVien(String maNV) {
		this(maNV, "", "", "");
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
		return maNV + ";" + tenNV +";" + sDT + ";" + moTa;
	}
	
}
