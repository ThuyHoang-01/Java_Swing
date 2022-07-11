package enTiTy;

public class Config {
	int id;
	String  name;
	int companyID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Config(int id, String name, int companyID) {
		super();
		this.id = id;
		this.name = name;
		this.companyID = companyID;
	}
	@Override
	public String toString() {
		return "ID" + id + "Name" + name+ "CompanyID" + companyID;
	}
}
