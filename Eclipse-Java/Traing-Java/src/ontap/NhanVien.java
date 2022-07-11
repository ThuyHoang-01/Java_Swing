package ontap;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String ma;
	private String ho;
	private String ten;
	private String phongBan;
	private double tienLuong;

	public NhanVien(String ma, String ho, String ten, String phongBan, double tienLuong) {
		super();
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.phongBan = phongBan;
		this.tienLuong = tienLuong;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
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

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	

	@Override
	public String toString() {
		return "NhanVien [ma=" + ma + ", ho=" + ho + ", ten=" + ten + ", phongBan=" + phongBan + ", tienLuong="
				+ tienLuong + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ma);
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
		return Objects.equals(ma, other.ma);
	}

}
