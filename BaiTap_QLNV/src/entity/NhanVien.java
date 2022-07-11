package entity;

public class NhanVien {

	private int maNv;
	private String hoNV;
	private String tenNv;
	private int tuoi;
	private boolean Phai;
	private double luong;
	
	private PhongBan phong;
	public Object getMaPhongBan;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int maNv, String hoNV, String tenNv, int tuoi, boolean phai, double luong, PhongBan phong) {
		super();
		this.maNv = maNv;
		this.hoNV = hoNV;
		this.tenNv = tenNv;
		this.tuoi = tuoi;
		Phai = phai;
		this.luong = luong;
		this.phong = phong;
	}

	public int getMaNv() {
		return maNv;
	}

	public void setMaNv(int maNv) {
		this.maNv = maNv;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return Phai;
	}

	public void setPhai(boolean phai) {
		Phai = phai;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public PhongBan getPhong() {
		return phong;
	}

	public void setPhong(PhongBan phong) {
		this.phong = phong;
	}

	@Override
	public String toString() {
		return "NhanVien [maNv=" + maNv + ", hoNV=" + hoNV + ", tenNv=" + tenNv + ", tuoi=" + tuoi + ", Phai=" + Phai
				+ ", luong=" + luong + ", phong=" + phong + "]";
	}
	
	
	
}
