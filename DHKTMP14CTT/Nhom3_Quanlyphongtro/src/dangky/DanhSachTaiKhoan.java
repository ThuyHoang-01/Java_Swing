package dangky;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DanhSachTaiKhoan {
	 public ArrayList<TaiKhoan> list;
	
	 public   DanhSachTaiKhoan() 
	 {
		 list = new ArrayList<TaiKhoan>();
	 }
	 public boolean themNhanVien(TaiKhoan tk) 
	 {
		 if (list.contains(tk))
			 return false;
		 list.add(tk);
		 return true;
	 }
	 public boolean xoaTaiKhoan(int maTaiKhoan) {
		   TaiKhoan tk = new TaiKhoan(maTaiKhoan);
		   System.out.println(tk);
			System.out.println(list.contains(tk));
		if(list.contains(tk)) {
			list.remove(tk);
			return true;
		}
		return false;
		}
		public ArrayList<TaiKhoan> getList(){
			return list;
		}
		
	
		public boolean timUserandPass(String text, String text2) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
//				System.out.println(text);
//				System.out.println(list.get(i).getTaiKhoan());
				boolean retall=(list.get(i).getTaiKhoan().equalsIgnoreCase(text)&&list.get(i).getMatKhau().equalsIgnoreCase(text2));
				//retall=true;
				if (retall) {
					
					return true;  
				}
			}
			return false;
		}

}
		

