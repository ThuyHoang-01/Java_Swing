import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable{

	private String ma;
	private String tua;
	private String tacGia;
	private int namXB;
	private String nhaXB;
	private int soStrang;
	private double donGia;
	private String isbm;

	public Sach(String ma, String tua, String tacGia, int namXB, String nhaXB, int soStrang, double donGia,
			String isbm) {
		super();
		this.ma = ma;
		this.tua = tua;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.nhaXB = nhaXB;
		this.soStrang = soStrang;
		this.donGia = donGia;
		this.isbm = isbm;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTua() {
		return tua;
	}

	public void setTua(String tua) {
		this.tua = tua;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public int getSoStrang() {
		return soStrang;
	}

	public void setSoStrang(int soStrang) {
		this.soStrang = soStrang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getIsbm() {
		return isbm;
	}

	public void setIsbm(String isbm) {
		this.isbm = isbm;
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
		Sach other = (Sach) obj;
		return Objects.equals(ma, other.ma);
	}

}