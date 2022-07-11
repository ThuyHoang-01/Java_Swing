package DoiTuong;

public class PhongBan {
    private String ID,ten;
    
    

    public PhongBan(String iD, String ten) {
		super();
		ID = iD;
		this.ten = ten;
	}

	public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    
}