package enTiTy;

public class NV_SauDN {
	int id;
	String tuyen;
	String ngayBatDau, ngayKetThuc, place, address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTuyen() {
		return tuyen;
	}
	public void setTuyen(String tuyen) {
		this.tuyen = tuyen;
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
	public NV_SauDN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NV_SauDN(int id, String tuyen, String ngayBatDau, String ngayKetThuc, String place,
			String address) {
		super();
		this.id = id;
		this.tuyen = tuyen;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.place = place;
		this.address = address;
	}
	
	public String toString() {
		return "ID" + id + "Tuyến" + tuyen  + "Ngày Bắt đầu" + ngayBatDau + "Ngày kết thúc" +ngayKetThuc+
				"Place" + place + "Địa Chỉ" + address;
	}
}
