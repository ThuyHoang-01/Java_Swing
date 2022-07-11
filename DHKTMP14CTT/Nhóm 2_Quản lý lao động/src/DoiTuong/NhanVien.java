package DoiTuong;

import java.sql.Date;

public class NhanVien {
    private String IDNhanVien,hoTen,IDPhongBan,CMND,diaChi,email,gioiTinh,soDT;
    private Integer IDTinhTrang;
    private Date ngaySinh,ngayLamViec;
	public NhanVien(String iDNhanVien, String hoTen, String iDPhongBan, String cMND, String diaChi, String email,
			String gioiTinh, String soDT, Integer iDTinhTrang, Date ngaySinh, Date ngayLamViec) {
		super();
		IDNhanVien = iDNhanVien;
		this.hoTen = hoTen;
		IDPhongBan = iDPhongBan;
		CMND = cMND;
		this.diaChi = diaChi;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		IDTinhTrang = iDTinhTrang;
		this.ngaySinh = ngaySinh;
		this.ngayLamViec = ngayLamViec;
	}
	public String getIDNhanVien() {
		return IDNhanVien;
	}
	public void setIDNhanVien(String iDNhanVien) {
		IDNhanVien = iDNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getIDPhongBan() {
		return IDPhongBan;
	}
	public void setIDPhongBan(String iDPhongBan) {
		IDPhongBan = iDPhongBan;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public Integer getIDTinhTrang() {
		return IDTinhTrang;
	}
	public void setIDTinhTrang(Integer iDTinhTrang) {
		IDTinhTrang = iDTinhTrang;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayLamViec() {
		return ngayLamViec;
	}
	public void setNgayLamViec(Date ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
	}
	@Override
	public String toString() {
		return "NhanVien [IDNhanVien=" + IDNhanVien + ", hoTen=" + hoTen + ", IDPhongBan=" + IDPhongBan + ", CMND="
				+ CMND + ", diaChi=" + diaChi + ", email=" + email + ", gioiTinh=" + gioiTinh + ", soDT=" + soDT
				+ ", IDTinhTrang=" + IDTinhTrang + ", ngaySinh=" + ngaySinh + ", ngayLamViec=" + ngayLamViec + "]";
	}
    
}