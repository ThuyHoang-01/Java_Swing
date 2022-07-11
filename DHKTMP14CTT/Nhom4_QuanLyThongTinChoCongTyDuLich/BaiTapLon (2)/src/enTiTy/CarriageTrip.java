package enTiTy;



public class CarriageTrip {
	int id;
	String name;
	int  compayid;
	String ngayBatDau, ngayKetThuc, place,address;
	Double donGia;
	
	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getCompayid() {
		return compayid;
	}




	public void setCompayid(int compayid) {
		this.compayid = compayid;
	}




	public String getNgayBatDau() {
		return ngayBatDau;
	}




	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}




	public String getNgayKetThuc() {
		return ngayKetThuc;
	}




	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}




	public String getPlace() {
		return place;
	}




	public void setPlace(String place) {
		this.place = place;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public Double getDonGia() {
		return donGia;
	}




	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}




	public CarriageTrip(int id, String name, int compayid, String ngayBatDau, String ngayKetThuc, String place,
			String address, Double donGia) {
		super();
		this.id = id;
		this.name = name;
		this.compayid = compayid;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.place = place;
		this.address = address;
		this.donGia = donGia;
	}




	public CarriageTrip() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "ID" + id  + "Name" + name + "CompanyID"+compayid+ "Ngay di " + ngayBatDau + "Ngay Ket Thuc " + ngayKetThuc
				
			+"Place" + place+"Address" +address	+"Đơn Giá" + donGia;
	}
}
