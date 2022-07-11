package thiThuLan1;

import java.io.Serializable;

public class SanPham implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSP;
	private String TenSP;
	private String Loai;
	private int soLuongSP;
	private float giaSP;
	
	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public String getLoai() {
		return Loai;
	}

	public void setLoai(String loai) {
		Loai = loai;
	}

	public int getSoLuongSP() {
		return soLuongSP;
	}

	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}

	public float getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(float giaSP) {
		this.giaSP = giaSP;
	}

	public SanPham() {
		super();
	}

	public SanPham(String maSP, String tenSP, String loai, int soLuongSP, float giaSP) {
		setGiaSP(giaSP);
		setLoai(loai);
		setMaSP(maSP);
		setSoLuongSP(soLuongSP);
		setTenSP(tenSP);
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
