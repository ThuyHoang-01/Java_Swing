package quanLymuabanXe;

public class KhachHang {
	private String maKH,tenKH,DiaChi;
	private int soDienThoai;
	public KhachHang(String maKH, String tenKH, String diaChi, int soDienThoai) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		DiaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH) {
		this(maKH, "", "", 0);
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	
}
