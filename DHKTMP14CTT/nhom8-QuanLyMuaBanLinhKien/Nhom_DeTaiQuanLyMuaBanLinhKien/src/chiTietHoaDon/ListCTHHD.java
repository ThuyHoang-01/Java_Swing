package chiTietHoaDon;

import java.util.ArrayList;

public class ListCTHHD {
	static ArrayList<ChiTietHoaDon> ct;
	 public ListCTHHD() {
		// TODO Auto-generated constructor stub
		 ct= new ArrayList<ChiTietHoaDon>();
	}
	 public static boolean themCTHD(ChiTietHoaDon maHD) {
			if(ct.contains(maHD)) {
				return false;
			}
			ct.add(maHD);
			return true;
		}
	 public static boolean xoaKH(int vt) {
			if(vt >=0 && vt< ct.size()) {
				ct.remove(vt);
				return true;
			}
			return false;
		}
	 public static ChiTietHoaDon timkiemKH(String maHD) {
		
			ChiTietHoaDon k = new ChiTietHoaDon(maHD);
			if(ct.contains(k)) {
				return ct.get(ct.indexOf(k));
			}
			return null;
			
		}
		public static ChiTietHoaDon getCD(int i) {
			if(i <0|| i > ct.size())
				return null;
				
			return ct.get(i);
			
		}
		public static int tong(){
			return ct.size();
		}
		public static ArrayList<ChiTietHoaDon> getlist(){
			return ct;
		}

}
