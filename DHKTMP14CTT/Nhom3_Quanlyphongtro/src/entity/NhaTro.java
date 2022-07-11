package entity;

public class NhaTro {
	private String tenNT, chuTro, soDT;
	private int phongTrong;
	public String getTenNT() {
		return tenNT;
	}
	public void setTenNT(String tenNT) {
		this.tenNT = tenNT;
	}
	public String getChuTro() {
		return chuTro;
	}
	public void setChuTro(String chuTro) {
		this.chuTro = chuTro;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public int getPhongTrong() {
		return phongTrong;
	}
	public void setPhongTrong(int phongTrong) {
		this.phongTrong = phongTrong;
	}
	@Override
	public String toString() {
		return "NhaTro [tenNT=" + tenNT + ", chuTro=" + chuTro + ", soDT=" + soDT + ", phongTrong=" + phongTrong + "]";
	}
	public NhaTro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaTro(String tenNT, String chuTro, String soDT, int phongTrong) {
		super();
		this.tenNT = tenNT;
		this.chuTro = chuTro;
		this.soDT = soDT;
		this.phongTrong = phongTrong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenNT == null) ? 0 : tenNT.hashCode());
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
		NhaTro other = (NhaTro) obj;
		if (tenNT == null) {
			if (other.tenNT != null)
				return false;
		} else if (!tenNT.equals(other.tenNT))
			return false;
		return true;
	}
	
}
