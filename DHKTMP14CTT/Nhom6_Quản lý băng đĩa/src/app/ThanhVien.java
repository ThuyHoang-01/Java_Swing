package app;

public class ThanhVien {
	private String cmnd,hoTen,gioiTinh,sDT,diaChi;

	
	public ThanhVien(String cmnd, String hoTen, String gioiTinh, String sDT, String diaChi) {
		super();
		this.cmnd = cmnd;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.diaChi = diaChi;
	}


	public ThanhVien() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmnd == null) ? 0 : cmnd.hashCode());
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
		ThanhVien other = (ThanhVien) obj;
		if (cmnd == null) {
			if (other.cmnd != null)
				return false;
		} else if (!cmnd.equals(other.cmnd))
			return false;
		return true;
	}
	public ThanhVien(String cmnd) {
		this(cmnd,"","","","");
	}

	public String getCmnd() {
		return cmnd;
	}


	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getsDT() {
		return sDT;
	}


	public void setsDT(String sDT) {
		this.sDT = sDT;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	


	@Override
	public String toString() {
		return cmnd +";"+ hoTen + ";" + gioiTinh + ";" + sDT +";" + diaChi;
	}
	
}
