package phongTro;

import java.io.Serializable;

public class PhongTro implements Serializable {
	private int maPT;
	private String diaChi, chuNha, Sdt;
	
	
	
	public int getMaPT() {
		return maPT;
	}
	public void setMaPT(int maPT) {
		this.maPT = maPT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChuNha() {
		return chuNha;
	}
	public void setChuNha(String chuNha) {
		this.chuNha = chuNha;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	
	
	public PhongTro(int maPT, String diaChi, String chuNha, String sdt) {
		super();
		this.maPT = maPT;
		this.diaChi = diaChi;
		this.chuNha = chuNha;
		Sdt = sdt;
	}
	
	public PhongTro(int maPT) {
		this(maPT,"","","");
	}
	public PhongTro() {
		this(0);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maPT;
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
		PhongTro other = (PhongTro) obj;
		if (maPT != other.maPT)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return maPT + ";" + diaChi + ";" + chuNha + ";" + Sdt +"\n";
	}
}
