package sinhVien;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private int maSV;
	private String ho, ten, lop, que;
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public SinhVien(int maSV, String ho, String ten, String lop, String que) {
		super();
		this.maSV = maSV;
		this.ho = ho;
		this.ten = ten;
		this.lop = lop;
		this.que = que;
	}
	
	public SinhVien(int maSV) {
		this(maSV,"","","","");
	}
	public SinhVien() {
		this(0);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maSV;
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
		SinhVien other = (SinhVien) obj;
		if (maSV != other.maSV)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return maSV + ";" + ho + ";" + ten + ";" + lop + ";" + que +"\n";
	}
}
