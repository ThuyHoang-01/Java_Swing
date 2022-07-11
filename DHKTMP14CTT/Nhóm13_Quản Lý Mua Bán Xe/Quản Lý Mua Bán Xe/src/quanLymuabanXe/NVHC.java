package quanLymuabanXe;

public class NVHC {
	private int maNV;
	private String tenNV, chucVu, phongBan, trinhDoHV;

	public NVHC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NVHC(int maNV, String tenNV, String chucVu, String phongBan, String trinhDoHV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.phongBan = phongBan;
		this.trinhDoHV = trinhDoHV;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getTrinhDoHV() {
		return trinhDoHV;
	}

	public void setTrinhDoHV(String trinhDoHV) {
		this.trinhDoHV = trinhDoHV;
	}

	public NVHC(int maNV) {
		this(maNV, "", "", "", "");
	}
}
