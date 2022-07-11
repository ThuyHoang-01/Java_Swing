package enTiTy;

public class XemTT {
	int id, CompayID;
	String Name, ngaybatDau, ngayKetThuc,address, place;
	double donGia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCompayID() {
		return CompayID;
	}
	public void setCompayID(int compayID) {
		CompayID = compayID;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getNgaybatDau() {
		return ngaybatDau;
	}
	public void setNgaybatDau(String ngaybatDau) {
		this.ngaybatDau = ngaybatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public XemTT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XemTT(int id, int compayID, String name, String ngaybatDau,
			String ngayKetThuc, String address, String place, double donGia) {
		super();
		this.id = id;
		CompayID = compayID;
		Name = name;
		this.ngaybatDau = ngaybatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.address = address;
		this.place = place;
		this.donGia = donGia;
	}
	
	
}
