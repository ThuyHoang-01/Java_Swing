package baiTapLon;

public class Phong {
	private int maPhong;
	private String name;
	private String type;
	private float Price;
	private String tinhTrang;
	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public Phong(int maPhong) {
		this(maPhong,"","",0,"");
	}
	public Phong() {
		super();
	}
	public Phong(int maPhong, String name, String type, float price, String tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.name = name;
		this.type = type;
		Price = price;
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", name=" + name + ", type=" + type + ", Price=" + Price + ", tinhTrang="
				+ tinhTrang + "]";
	}
	
}
