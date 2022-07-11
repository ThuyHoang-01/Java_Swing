package quanLymuabanXe;

public class Xe {
	private int maXe;
	private String tenXe,nuocSX,loaiXe;
	private int soPK,soKhung,soLuong;
	private String mauXe;
	private double donGia;

	
	public Xe(int maXe, String tenXe, String nuocSX, String loaiXe, int soPK, int soKhung, int soLuong, String mauXe,
			double donGia) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.nuocSX = nuocSX;
		this.loaiXe = loaiXe;
		this.soPK = soPK;
		this.soKhung = soKhung;
		this.soLuong = soLuong;
		this.mauXe = mauXe;
		this.donGia = donGia;
	}

	public  Xe(int maXe) {
		this(maXe, "", "", "", 0, 0, 0, "", 0.0);
	}
	public int getMaXe() {
		return maXe;
	}


	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}


	public String getTenXe() {
		return tenXe;
	}


	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}


	public String getNuocSX() {
		return nuocSX;
	}


	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}


	public String getLoaiXe() {
		return loaiXe;
	}


	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}


	public int getSoPK() {
		return soPK;
	}


	public void setSoPK(int soPK) {
		this.soPK = soPK;
	}


	public int getSoKhung() {
		return soKhung;
	}


	public void setSoKhung(int soKhung) {
		this.soKhung = soKhung;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public String getMauXe() {
		return mauXe;
	}


	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}


	public double getDonGia() {
		return donGia;
	}


	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}


	public Xe() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
