package entity;

public class ChuyenMon {
	private String maChuyenMon;
	private	String tenChuyenMon;
	

	public ChuyenMon(String maChuyenMon) {
		super();
		this.maChuyenMon = maChuyenMon;
	}
	public ChuyenMon(String maChuyenMon, String tenChuyenMon) {
		super();
		this.maChuyenMon = maChuyenMon;
		this.tenChuyenMon = tenChuyenMon;
	}
	public String getMaChuyenMon() {
		return maChuyenMon;
	}
	public void setMaChuyenMon(String maChuyenMon) {
		this.maChuyenMon = maChuyenMon;
	}
	public String getTenChuyenMon() {
		return tenChuyenMon;
	}
	public void setTenChuyenMon(String tenChuyenMon) {
		this.tenChuyenMon = tenChuyenMon;
	}
	@Override
	public String toString() {
		return tenChuyenMon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maChuyenMon == null) ? 0 : maChuyenMon.hashCode());
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
		ChuyenMon other = (ChuyenMon) obj;
		if (maChuyenMon == null) {
			if (other.maChuyenMon != null)
				return false;
		} else if (!maChuyenMon.equals(other.maChuyenMon))
			return false;
		return true;
	}
	
}
