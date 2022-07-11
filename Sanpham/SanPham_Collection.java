package thiThuLan1;

import java.io.Serializable;
import java.util.ArrayList;

public class SanPham_Collection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<SanPham> dsSP;
	public SanPham_Collection() {
		dsSP = new ArrayList<SanPham>();
	}
	public boolean themSP(SanPham sp) {
		for (SanPham sanPham : dsSP) {
			if(sanPham.getMaSP().equals(sp.getMaSP())==true)
				return false;
		}
		dsSP.add(sp);
		return true;
	}
	public ArrayList<SanPham> getDsSP(){
		return dsSP;
	}
	public void setDsSP(ArrayList<SanPham> dsSP) {
		this.dsSP=dsSP;
	}
	public SanPham getElement(int index) {
		if(index<0 || index>dsSP.size())
			return null;
		return dsSP.get(index);
			
	}
	public int getSize() {
		return dsSP.size();
	}
	public boolean XoaSP(String maSP) {
		
		SanPham sp = new SanPham();
		for (SanPham sanPham : dsSP) {
			if(sanPham.getMaSP().equals(maSP)==true) {
				dsSP.remove(sanPham); 
				return true;
			}
			
		}
		return false;
	}
}
