package entity;

import java.sql.Date;

public class LaoDong {
	private String maLaoDong;
	private String tenLaoDong;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String CMND;
	private DiaChi diaChi;
	private ChuyenMon chuyenMon;
	private String SDT;
	private boolean trangThai;

	public LaoDong() {
		super();
	}

	public LaoDong(String maLaoDong, String tenLaoDong, Date ngaySinh, boolean gioiTinh, String cMND, DiaChi diaChi,
			ChuyenMon chuyenMon, String sDT, boolean trangThai) {
		super();
		this.maLaoDong = maLaoDong;
		this.tenLaoDong = tenLaoDong;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		CMND = cMND;
		this.diaChi = diaChi;
		this.chuyenMon = chuyenMon;
		SDT = sDT;
		this.trangThai = trangThai;
	}

	public LaoDong(String maLaoDong) {
		this.maLaoDong = maLaoDong;
	}

	public String getMaLaoDong() {
		return maLaoDong;
	}

	public void setMaLaoDong(String maLaoDong) {
		this.maLaoDong = maLaoDong;
	}

	public String getTenLaoDong() {
		return tenLaoDong;
	}

	public void setTenLaoDong(String tenLaoDong) {
		this.tenLaoDong = tenLaoDong;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	public ChuyenMon getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(ChuyenMon chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLaoDong == null) ? 0 : maLaoDong.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaoDong other = (LaoDong) obj;
		if (maLaoDong == null) {
			if (other.maLaoDong != null)
				return false;
		} else if (!maLaoDong.equals(other.maLaoDong))
			return false;
		return true;
	}

}
