package hoangThiToThuy_19432541;

public class Sinhvien {

	private String id;
	private String ten;
	private String lop;
	private String noisinh;
	private String monhoc;
	public Sinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sinhvien(String id, String ten, String lop, String noisinh, String monhoc) {
		super();
		this.id = id;
		this.ten = ten;
		this.lop = lop;
		this.noisinh = noisinh;
		this.monhoc = monhoc;
	}
	@Override
	public String toString() {
		return "Sinhvien [id=" + id + ", ten=" + ten + ", lop=" + lop + ", noisinh=" + noisinh + ", monhoc=" + monhoc
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getNoisinh() {
		return noisinh;
	}
	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}
	public String getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}
	
	  
}
