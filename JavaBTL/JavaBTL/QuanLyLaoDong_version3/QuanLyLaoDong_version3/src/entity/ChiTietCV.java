package entity;

import java.sql.Date;

public class ChiTietCV {
	private CongTrinh congTrinh;
	private CongViec congViec;
	private LaoDong laoDong;
	private Date ngayThucHien;
	private Date ngayHoanThanh;
	private boolean trangThai;
	private QuanLy quanLy;

	public ChiTietCV() {
		// TODO Auto-generated constructor stub

	}

	public ChiTietCV(CongTrinh congTrinh, CongViec congViec, LaoDong laoDong, Date ngayThucHien, Date ngayHoanThanh,
			boolean trangThai, QuanLy quanLy) {
		super();
		this.congTrinh = congTrinh;
		this.congViec = congViec;
		this.laoDong = laoDong;
		this.ngayThucHien = ngayThucHien;
		this.ngayHoanThanh = ngayHoanThanh;
		this.trangThai = trangThai;
		this.quanLy = quanLy;
	}

	public ChiTietCV(CongTrinh congTrinh, LaoDong laoDong, Date ngayThucHien, Date ngayHoanThanh) {
		super();
		this.congTrinh = congTrinh;
		this.laoDong = laoDong;
		this.ngayThucHien = ngayThucHien;
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public ChiTietCV(CongTrinh congTrinh, CongViec congViec, LaoDong laoDong, Date ngayThucHien, Date ngayHoanThanh) {
		super();
		this.congTrinh = congTrinh;
		this.congViec = congViec;
		this.laoDong = laoDong;
		this.ngayThucHien = ngayThucHien;
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public CongTrinh getCongTrinh() {
		return congTrinh;
	}

	public void setCongTrinh(CongTrinh congTrinh) {
		this.congTrinh = congTrinh;
	}

	public CongViec getCongViec() {
		return congViec;
	}

	public void setCongViec(CongViec congViec) {
		this.congViec = congViec;
	}

	public LaoDong getLaoDong() {
		return laoDong;
	}

	public void setLaoDong(LaoDong laoDong) {
		this.laoDong = laoDong;
	}

	public Date getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(Date ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

	public Date getNgayHoanThanh() {
		return ngayHoanThanh;
	}

	public void setNgayHoanThanh(Date ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public QuanLy getQuanLy() {
		return quanLy;
	}

	public void setQuanLy(QuanLy quanLy) {
		this.quanLy = quanLy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((congTrinh == null) ? 0 : congTrinh.hashCode());
		result = prime * result + ((congViec == null) ? 0 : congViec.hashCode());
		result = prime * result + ((laoDong == null) ? 0 : laoDong.hashCode());
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
		ChiTietCV other = (ChiTietCV) obj;
		if (congTrinh == null) {
			if (other.congTrinh != null)
				return false;
		} else if (!congTrinh.equals(other.congTrinh))
			return false;
		if (congViec == null) {
			if (other.congViec != null)
				return false;
		} else if (!congViec.equals(other.congViec))
			return false;
		if (laoDong == null) {
			if (other.laoDong != null)
				return false;
		} else if (!laoDong.equals(other.laoDong))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChiTietCV [congTrinh=" + congTrinh.getMaCongTrinh() + ", congViec=" + congViec.getMaCongViec() + ", laoDong=" + laoDong.getMaLaoDong()
				+ ", ngayThucHien=" + ngayThucHien + ", ngayHoanThanh=" + ngayHoanThanh + ", trangThai=" + trangThai
				+ ", quanLy=" + quanLy + "]";
	}
	
}
