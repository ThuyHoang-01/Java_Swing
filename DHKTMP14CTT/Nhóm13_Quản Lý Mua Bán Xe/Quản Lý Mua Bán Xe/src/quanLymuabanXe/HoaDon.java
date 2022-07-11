package quanLymuabanXe;

public class HoaDon {
	private int hoaDon,maXe,soLanTra;
	private String maKH,tenNV,tenXe,ngayGD;
	private double tongTien;
	public HoaDon(int hoaDon, int maXe, int soLanTra, String maKH, String tenNV, String tenXe, String ngayGD, double tongTien) {
		super();
		this.hoaDon = hoaDon;
		this.maXe = maXe;
		this.soLanTra = soLanTra;
		this.maKH = maKH;
		this.tenNV = tenNV;
		this.tenXe = tenXe;
		this.ngayGD = ngayGD;
		this.tongTien = tongTien;
	}
	
	public  HoaDon(int hoaDon) {
		this(hoaDon, 0, 0, "", "", "", "", 0.0);
	}
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(int hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public int getSoLanTra() {
		return soLanTra;
	}

	public void setSoLanTra(int soLanTra) {
		this.soLanTra = soLanTra;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getNgayGD() {
		return ngayGD;
	}

	public void setNgayGD(String ngayGD) {
		this.ngayGD = ngayGD;
	}


	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
}
