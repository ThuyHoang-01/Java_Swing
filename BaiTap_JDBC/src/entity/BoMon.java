package entity;
//25 18092291 TranMinhNhut
public class BoMon {
	private String maMon;
	private String tenMon;
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
	public BoMon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoMon(String maMon, String tenMon) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
	}
	public BoMon(String maMon) {
		super();
		this.maMon = maMon;
	}
	
}
