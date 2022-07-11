package DonHang;

import java.util.Date;

public class DonHang {
	private String soHD, maKH, maNV;
	private Date ngayDH, ngayCH;
	private String noiGH;
	
	public DonHang(String soHD, String maKH, String maNV, Date ngayDH, Date ngayCH, String noiGH) {
		super();
		this.soHD = soHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayDH = ngayDH;
		this.ngayCH = ngayCH;
		this.noiGH = noiGH;
	}
	public DonHang(String soHD) {
		this(soHD,"","",null,null,"");
	}
	public DonHang() {
		
	}
	
	public String getSoHD() {
		return soHD;
	}
	public void setSoHD(String soHD) {
		this.soHD = soHD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getNgayDH() {
		return ngayDH;
	}
	public void setNgayDH(Date ngayDH) {
		this.ngayDH = ngayDH;
	}
	public Date getNgayCH() {
		return ngayCH;
	}
	public void setNgayCH(Date ngayCH) {
		this.ngayCH = ngayCH;
	}
	public String getNoiGH() {
		return noiGH;
	}
	public void setNoiGH(String noiGH) {
		this.noiGH = noiGH;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((soHD == null) ? 0 : soHD.hashCode());
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
		DonHang other = (DonHang) obj;
		if (soHD == null) {
			if (other.soHD != null)
				return false;
		} else if (!soHD.equals(other.soHD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return soHD+ ";" + maKH + ";" +maNV +";"+noiGH+";"+ngayDH+";"+ngayCH+";";
	}
}