package Class;

public class DichVu {
	private String dVu;
	private int sLuong;
	private double dGia;
	public String getdVu() {
		return dVu;
	}
	public void setdVu(String dVu) {
		this.dVu = dVu;
	}
	public int getsLuong() {
		return sLuong;
	}
	public void setsLuong(int sLuong) {
		this.sLuong = sLuong;
	}
	public double getdGia() {
		return dGia;
	}
	public void setdGia(double dGia) {
		this.dGia = dGia;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dVu == null) ? 0 : dVu.hashCode());
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
		DichVu other = (DichVu) obj;
		if (dVu == null) {
			if (other.dVu != null)
				return false;
		} else if (!dVu.equals(other.dVu))
			return false;
		return true;
	}
	public DichVu(String dVu, int sLuong, double dGia) {
		super();
		this.dVu = dVu;
		this.sLuong = sLuong;
		this.dGia = dGia;

	}
	public DichVu(String dVu) {
        this(dVu,0,0.0);
    }
	@Override
	public String toString() {
		return "DichVu [dVu=" + dVu + ", sLuong=" + sLuong + ", dGia=" + dGia + ", tTPhong=" + "]";
	}
	
}
	
