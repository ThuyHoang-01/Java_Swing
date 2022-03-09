package week4ThongtinNV.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import week4ThongtinNV.entity.*;

public class database {
	
	private static final String FILENAME = "data/NhanVien.txt";
	
	public static void ghiXuongFile(ArrayList<Nhanvien> ds) {
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(FILENAME));
			for(Nhanvien nvtemp : ds){
				bw.write(nvtemp.toString() + "\n");
			}
			bw.close();
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ghi lỗi");
		}
	}

	public static ArrayList<Nhanvien> docTuFile() {
		ArrayList<Nhanvien> ds= new ArrayList<Nhanvien>();
		BufferedReader br = null;
		try{
			if(new File(FILENAME).exists()){
				br  = new BufferedReader(new FileReader(FILENAME));
				while(br.ready()){
					String line = br.readLine();
					if(line != null && !line.trim().equals("")){
						String[] a = line.split(";");
						try {
							Nhanvien nvtemp = new Nhanvien(Integer.parseInt(a[0]), a[1], a[2], a[3], Integer.parseInt(a[4]), Integer.parseInt(a[5]) );
							ds.add(nvtemp);
						}catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				br.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ds;
	}
}
