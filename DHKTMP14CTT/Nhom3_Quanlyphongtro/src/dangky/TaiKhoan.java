package dangky;


public class TaiKhoan {
	public TaiKhoan(String taiKhoan) {
		super();
		this.taiKhoan = taiKhoan;
	}
	private int maTaiKhoan;
	private String taiKhoan;
	private String matKhau;
	
	public TaiKhoan(int maTaiKhoan) 
	{
		this(maTaiKhoan,"","");
		
	}
		
	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public TaiKhoan(int maTaiKhoan, String taiKhoan, String matKhau) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	
	public TaiKhoan(String taiKhoan, String matKhau) {
		this(103,taiKhoan,matKhau);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maTaiKhoan;
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maTaiKhoan != other.maTaiKhoan)
			return false;
		return true;
	}
	public String toString() {
		return maTaiKhoan+";"+ taiKhoan + ";" + matKhau;
	}

}
