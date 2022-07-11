package Table.java;

import java.io.Serializable;

public class NhanVien implements Serializable {

	private String  Ho, Ten;
	private int Ma;
	private boolean Phai;
	private int Tuoi;
	private double Luong;
	public NhanVien(String ho, String ten, int ma, boolean phai, int tuoi, double luong) {
		super();
		Ho = ho;
		Ten = ten;
		Ma = ma;
		Phai = phai;
		Tuoi = tuoi;
		Luong = luong;
	}
	public NhanVien(int ma2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NhanVien [Ho=" + Ho + ", Ten=" + Ten + ", Ma=" + Ma + ", Phai=" + Phai + ", Tuoi=" + Tuoi + ", Luong="
				+ Luong + "]";
	}
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ho == null) ? 0 : Ho.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Luong);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Ma;
		result = prime * result + (Phai ? 1231 : 1237);
		result = prime * result + ((Ten == null) ? 0 : Ten.hashCode());
		result = prime * result + Tuoi;
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
		if (Ho == null) {
			if (other.Ho != null)
				return false;
		} else if (!Ho.equals(other.Ho))
			return false;
		if (Double.doubleToLongBits(Luong) != Double.doubleToLongBits(other.Luong))
			return false;
		if (Ma != other.Ma)
			return false;
		if (Phai != other.Phai)
			return false;
		if (Ten == null) {
			if (other.Ten != null)
				return false;
		} else if (!Ten.equals(other.Ten))
			return false;
		if (Tuoi != other.Tuoi)
			return false;
		return true;
	}
	public boolean getPhai() {
		return Phai;
	}
	public void setPhai(boolean phai) {
		Phai = phai;
	}
	public String getHo() {
		return Ho;
	}
	public void setHo(String ho) {
		Ho = ho;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public int getMa() {
		return Ma;
	}
	public void setMa(int ma) {
		Ma = ma;
	}
	
	public int getTuoi() {
		return Tuoi;
	}
	public void setTuoi(int tuoi) {
		Tuoi = tuoi;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) {
		Luong = luong;
	}
	
	
	
}
