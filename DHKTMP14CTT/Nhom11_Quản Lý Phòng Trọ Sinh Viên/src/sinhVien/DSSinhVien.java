package sinhVien;

import java.io.Serializable;
import java.util.ArrayList;

public class DSSinhVien implements Serializable {
	private ArrayList<SinhVien>list;
	public DSSinhVien() {
		list= new ArrayList<SinhVien>();
	}
	
	public boolean themSV(SinhVien sv) {
		if(list.contains(sv)) 
			return false;	
		list.add(sv);
		return true;
	}
	public boolean xoaSV(int maSV) {
		SinhVien sv = new SinhVien(maSV);
		if(list.contains(sv)) {
			list.remove(sv);
			return true;
		}
		return false;
	}
	public SinhVien timKiem(int maSV) {
		SinhVien sv= new SinhVien(maSV);
		if(list.contains(sv)) {
			return list.get(list.indexOf(sv));
		}
		return null;
	}

	public ArrayList<SinhVien> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	public int tong() {
		// TODO Auto-generated method stub
		return list.size();
	}
	public SinhVien getSinhVien(int i) {
		// TODO Auto-generated method stub
		if(i>=0 && i<list.size())
			return list.get(i);
		return null;
	}
	
	
}
