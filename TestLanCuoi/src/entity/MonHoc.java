package entity;

public class MonHoc {
	   
	  private String maMon;
	  private String tenMon;
	  private BoMonChuQuan bm;
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
	public BoMonChuQuan getBm() {
		return bm;
	}
	public void setBm(BoMonChuQuan bm) {
		this.bm = bm;
	}
	public int getSoTiet() {
		return soTiet;
	}
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
	public MonHoc(String maMon, String tenMon, BoMonChuQuan bm, int soTiet) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.bm = bm;
		this.soTiet = soTiet;
	}
	@Override
	public String toString() {
		return "MonHoc [maMon=" + maMon + ", tenMon=" + tenMon + ", bm=" + bm + ", soTiet=" + soTiet + "]";
	}
	  
	  
	  
	  
}
