package entity;

public class NhanVien {

	private int MaNV;
	private String HoNV;
	private String TenNV;
	private String PhongBan;
	private Double TienLuong;
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getHoNV() {
		return HoNV;
	}
	public void setHoNV(String hoNV) {
		HoNV = hoNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public String getPhongBan() {
		return PhongBan;
	}
	public void setPhongBan(String phongBan) {
		PhongBan = phongBan;
	}
	public Double getTienLuong() {
		return TienLuong;
	}
	public void setTienLuong(Double tienLuong) {
		TienLuong = tienLuong;
	}
	public NhanVien(int maNV, String hoNV, String tenNV, String phongBan, Double tienLuong) {
		super();
		MaNV = maNV;
		HoNV = hoNV;
		TenNV = tenNV;
		PhongBan = phongBan;
		TienLuong = tienLuong;
	}
	
	
	@Override
	public String toString() {
		return "NhanVien [MaNV=" + MaNV + ", HoNV=" + HoNV + ", TenNV=" + TenNV + ", PhongBan=" + PhongBan
				+ ", TienLuong=" + TienLuong + "]";
	}
	
	
	
}
