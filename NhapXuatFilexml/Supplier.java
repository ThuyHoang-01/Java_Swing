package NhapXuatFilexml;

public class Supplier {
	private String name;
	private String country;
	private String website;
	
	
	public Supplier(String name, String country, String website) {
		super();
		this.name = name;
		this.country = country;
		this.website = website;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "Supplier [name=" + name + ", country=" + country + ", website=" + website + "]";
	}
	
	
}
