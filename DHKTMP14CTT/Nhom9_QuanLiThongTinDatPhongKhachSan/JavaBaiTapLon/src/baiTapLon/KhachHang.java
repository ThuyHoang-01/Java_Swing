package baiTapLon;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private String cMND;
	private String qT;
	private String gioiTinh;
	private int tuoi;
	private String sDT;
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getcMND() {
		return cMND;
	}
	public void setcMND(String cMND) {
		this.cMND = cMND;
	}
	public String getqT() {
		return qT;
	}
	public void setqT(String qT) {
		this.qT = qT;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int maKH, String tenKH, String cMND, String qT, String gioiTinh, int tuoi, String sDT) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.cMND = cMND;
		this.qT = qT;
		this.gioiTinh = gioiTinh;
		this.tuoi = tuoi;
		this.sDT = sDT;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", cMND=" + cMND + ", qT=" + qT + ", gioiTinh="
				+ gioiTinh + ", tuoi=" + tuoi + ", sDT=" + sDT + "]";
	}
	
}
