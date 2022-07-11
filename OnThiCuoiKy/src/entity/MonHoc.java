package entity;
//25 18092291 TranMinhNhut
public class MonHoc {
	private String maMon;
	private String tenMon;
	private BoMon bm;
	private int soTiet;
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public BoMon getBm() {
		return bm;
	}
	public void setBm(BoMon bm) {
		this.bm = bm;
	}
	public int getSoTiet() {
		return soTiet;
	}
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonHoc(String maMon, String tenMon, BoMon bm, int soTiet) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.bm = bm;
		this.soTiet = soTiet;
	}
	
}
