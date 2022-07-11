package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Database {
	private static final String FILENAME_BD = "BangDia.txt";
	private static final String FILENAME_NV = "NhanVien.txt";
	private static final String FILENAME_TV = "ThanhVien.txt";
	private static final String FILENAME_C = "Cart.txt";
	static QuanLyBangDia qlbd = new QuanLyBangDia();
	static QuanLyBDCart qlbdc = new QuanLyBDCart();
	static QuanLyNhanVien qlnv = new QuanLyNhanVien();
	static QuanLyThanhVien qltv = new QuanLyThanhVien();

	public static void loadDataBaseBD() {
		BufferedReader br = null;

		try {
			if (new File(FILENAME_BD).exists()) {
				br = new BufferedReader(new FileReader(FILENAME_BD));
				br.readLine();
				while (br.ready()) {
					String line = br.readLine();
					if (line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						BangDia cd = new BangDia(a[0], a[1], a[2], a[3], a[4], a[5],Double.parseDouble(a[6]), Integer.parseInt(a[7]));
						QuanLyBangDia.themBangDia(cd);
						FrmDanhMucBangDia.tableModel.addRow(a);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void loadDataBaseBDKH() {
		BufferedReader br = null;

		try {
			if (new File(FILENAME_BD).exists()) {
				br = new BufferedReader(new FileReader(FILENAME_BD));
				br.readLine();
				while (br.ready()) {
					String line = br.readLine();
					if (line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						BangDia cd = new BangDia(a[0], a[1], a[2], a[3], a[4], a[5],Double.parseDouble(a[6]),Integer.parseInt(a[7]));
						QuanLyBangDia.themBangDia(cd);
						FrmBangDiaKhachHang.tableModel.addRow(a);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void SaveDatabaseBD(ArrayList<BangDia> dsBD) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILENAME_BD));
			bw.write("MaBD;TenBD;TheLoai;HangSX;TinhTrang;GhiChu;Gia\n");
			for (BangDia cd : dsBD) {
				bw.write(cd.toString() + "\n");
			}
			bw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
//	public static void loadDataBaseBD1KH(String filename) {
//		BufferedReader br = null;
//
//		try {
//			if (new File(filename).exists()) {
//				br = new BufferedReader(new FileReader(filename));
//				br.readLine();
//				while (br.ready()) {
//					String line = br.readLine();
//					if (line != null && !line.trim().equals("")) {
//						String[] a = line.split(";");
//						BangDia cd = new BangDia(a[0], a[1], a[2], a[3], a[4], a[5]);
//						QuanLyBangDia.themBangDia(cd);
//						FrmBangDiaKhachHang.tableModel.addRow(a);
//					}
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//	public static void SaveDatabaseBD1KH(ArrayList<BangDia> dsBD, String filename) {
//		BufferedWriter bw;
//		try {
//			bw = new BufferedWriter(new FileWriter(filename));
//			bw.write("MaBD;TenBD;TheLoai;HangSX;TinhTrang;GhiChu\n");
//			for (BangDia cd : dsBD) {
//				bw.write(cd.toString() + "\n");
//			}
//			bw.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}

	public static void loadDataBaseBD_C() {
		BufferedReader brBDC;
		try {
			if (new File(FILENAME_C).exists()) {
				brBDC = new BufferedReader(new FileReader(FILENAME_C));
				brBDC.readLine();
				while (brBDC.ready()) {
					String line = brBDC.readLine();
					if (line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						BangDia cd = new BangDia(a[0], a[1], a[2], a[3], a[4], a[5],Double.parseDouble(a[6]),Integer.parseInt(a[7]));
						QuanLyBDCart.themBangDiaC(cd);
						FrmDatHang.tableModel.addRow(a);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void DeleteCart() {
		try {
			File file = new File("Cart.txt");
			if(file.delete()) System.out.println("xoa");;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void SaveDatabaseBD_C(ArrayList<BangDia> arrayList) {
		BufferedWriter bwBDC = null;
		try {
			bwBDC = new BufferedWriter(new FileWriter(FILENAME_C));
			bwBDC.write("MaBD;TenBD;TheLoai;HangSX;TinhTrang;GhiChu;Gia\n");
			for (BangDia cd : arrayList) {
				bwBDC.write(cd.toString() + "\n");
			}
			bwBDC.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void loadDataBaseNV() {
		BufferedReader brNV = null;

		try {
			if (new File(FILENAME_NV).exists()) {
				brNV = new BufferedReader(new FileReader(FILENAME_NV));
				brNV.readLine();
				while (brNV.ready()) {
					String line = brNV.readLine();
					if (line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						NhanVien nv = new NhanVien(a[0], a[1], a[2], a[3]);
						QuanLyNhanVien.themNhanVien(nv);
						FrmNhanVien.tableModel.addRow(a);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void SaveDatabaseNV(ArrayList<NhanVien> dsNV) {
		BufferedWriter bwNV;
		try {
			bwNV = new BufferedWriter(new FileWriter(FILENAME_NV));
			bwNV.write("MaNV;TenNV;SDT;MoTa\n");
			for (NhanVien nv : dsNV) {
				bwNV.write(nv.toString() + "\n");
			}
			bwNV.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void loadDataBaseTV() {
		BufferedReader brTV = null;

		try {
			if (new File(FILENAME_TV).exists()) {
				brTV = new BufferedReader(new FileReader(FILENAME_TV));
				brTV.readLine();
				while (brTV.ready()) {
					String line = brTV.readLine();
					if (line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						ThanhVien tv = new ThanhVien(a[0], a[1], a[2], a[3], a[4]);
						QuanLyThanhVien.themThanhVien(tv);
						//FrmNhanVien.tableModel.addRow(a);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static boolean checkTV(String cm) {
		BufferedReader brTV = null;

		try {
			if (new File(FILENAME_TV).exists()) {
				brTV = new BufferedReader(new FileReader(FILENAME_TV));
				brTV.readLine();
				while (brTV.ready()) {
					String line = brTV.readLine();
					if (line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						ThanhVien tv = new ThanhVien(a[0], a[1], a[2], a[3],a[4]);
//						QuanLyThanhVien.themThanhVien(tv);
					//	FrmNhanVien.tableModel.addRow(a);
						if(cm.equalsIgnoreCase(a[0])) return true;
					}
				}return false;
			}return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static void SaveDatabaseTV(ArrayList<ThanhVien> dsTV) {
		BufferedWriter bwTV;
		try {
			bwTV = new BufferedWriter(new FileWriter(FILENAME_TV));
			bwTV.write("CMND;TenTV;GioiTinh;SDT;DiaChi\n");
			for (ThanhVien tv : dsTV) {
				bwTV.write(tv.toString() + "\n");
			}
			bwTV.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
