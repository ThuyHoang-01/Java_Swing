package entity;

public class DiaChi {
	private String tinhTP;
	private String quanHuyen;
	private String phuongXa;
	public DiaChi(String tinhTP, String quanHuyen, String phuongXa) {
		super();
		this.tinhTP = tinhTP;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
	}
	public String getTinhTP() {
		return tinhTP;
	}
	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}
	public String getQuanHuyen() {
		return quanHuyen;
	}
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	public String getPhuongXa() {
		return phuongXa;
	}
	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}
	@Override
	public String toString() {
		return phuongXa + ", " + quanHuyen + ", " + tinhTP;
	}
	
	
}
