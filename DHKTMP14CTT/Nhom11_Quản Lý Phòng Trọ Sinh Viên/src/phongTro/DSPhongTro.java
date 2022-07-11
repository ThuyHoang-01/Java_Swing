package phongTro;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;

public class DSPhongTro implements Serializable {
	private ArrayList<PhongTro>list;
	public DSPhongTro() {
		list= new ArrayList<PhongTro>();
	}
	
	public boolean themPT(PhongTro pt) {
		if(list.contains(pt)) 
			return false;	
		list.add(pt);
		return true;
	}
	public boolean xoaPT(int maPT) {
		PhongTro pt = new PhongTro(maPT);
		if(list.contains(pt)) {
			list.remove(pt);
			return true;
		}
		return false;
	}
	public PhongTro timKiem(int maPT) {
		PhongTro pt= new PhongTro(maPT);
		if(list.contains(pt)) {
			return list.get(list.indexOf(pt));
		}
		return null;
	}

	public ArrayList<PhongTro> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	public int tong() {
		// TODO Auto-generated method stub
		return list.size();
	}
	public PhongTro getphongTro(int i) {
		// TODO Auto-generated method stub
		if(i>=0 && i<list.size())
			return list.get(i);
		return null;
	}

	
	
}
