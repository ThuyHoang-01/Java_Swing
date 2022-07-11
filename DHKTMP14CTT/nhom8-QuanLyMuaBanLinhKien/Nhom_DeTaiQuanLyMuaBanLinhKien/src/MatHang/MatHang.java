package MatHang;

public class MatHang {
	private String maH,tenH,nhaCC;
	private double gia;
	private int soLuong;
	public MatHang(String maH, String tenH, String nhaCC, double gia, int soLuong) {
		super();
		this.maH = maH;
		this.tenH = tenH;
		this.nhaCC = nhaCC;
		this.gia = gia;
		this.soLuong = soLuong;
	}
	
	public MatHang(String maH) {
		this(maH,"","",0,0);
	}
	
	public MatHang() {
		
	}
	
	public String getMaH() {
		return maH;
	}

	public void setMaH(String maH) {
		this.maH = maH;
	}

	public String getTenH() {
		return tenH;
	}

	public void setTenH(String tenH) {
		this.tenH = tenH;
	}

	public String getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(String nhaCC) {
		this.nhaCC = nhaCC;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maH == null) ? 0 : maH.hashCode());
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
		MatHang other = (MatHang) obj;
		if (maH == null) {
			if (other.maH != null)
				return false;
		} else if (!maH.equals(other.maH))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return maH + ";" + tenH + ";" + nhaCC + ";" + gia + ";" + soLuong + ";";
	}
}
