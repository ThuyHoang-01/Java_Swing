package entity;

import java.sql.Date;

public class QuanLy {
	private String maQuanLy;
	private String tenQuanLy;
	private Date ngaySinh;
	private String soDienThoai;
	private String matKhau;
	public String getMaQuanLy() {
		return maQuanLy;
	}
	public void setMaQuanLy(String maQuanLy) {
		this.maQuanLy = maQuanLy;
	}
	public String getTenQuanLy() {
		return tenQuanLy;
	}
	public void setTenQuanLy(String tenQuanLy) {
		this.tenQuanLy = tenQuanLy;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public QuanLy(String maQuanLy, String tenQuanLy, Date ngaySinh, String soDienThoai, String matKhau) {
		super();
		this.maQuanLy = maQuanLy;
		this.tenQuanLy = tenQuanLy;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.matKhau = matKhau;
	}
	public QuanLy(String maQuanLy, String tenQuanLy, String matKhau) {
		super();
		this.maQuanLy = maQuanLy;
		this.tenQuanLy = tenQuanLy;
		this.matKhau = matKhau;
	}
	public QuanLy(String maQuanLy) {
		super();
		this.maQuanLy = maQuanLy;
	}
	
}
