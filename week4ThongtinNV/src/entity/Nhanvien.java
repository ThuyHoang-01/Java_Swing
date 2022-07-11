package entity;

public class Nhanvien {

	public int manv;
	public String ten, ho;
	public int tuoi;
	String phai;
	int tienluong;
	
	public Nhanvien() {
		super();
	}
	
	public Nhanvien(int manv, String ho, String ten, String phai,int tuoi,  int tienluong ) {
		this.manv = manv;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tienluong = tienluong;
		this.tuoi= tuoi;
	}

	public Nhanvien(int manv) {
		super();
		this.manv = manv;
		this.ho = "";
		this.ten = "";
		this.phai = "";
		this.tienluong = 0;
	}

	public int getManv() {
		return manv;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String isPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public int getTienluong() {
		return tienluong;
	}

	public void setTienluong(int tienluong) {
		this.tienluong = tienluong;
	}

	@Override
	public String toString() {
		return manv + ";" + ho + ";" + ten + ";" + phai + ";" + tuoi+ ";" + tienluong  ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + manv;
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
		Nhanvien other = (Nhanvien) obj;
		if (manv != other.manv)
			return false;
		return true;
	}
	
	
	
}
