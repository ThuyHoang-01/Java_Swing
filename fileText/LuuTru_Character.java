package fileText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LuuTru_Character {
   public static final String FILENAME="data/dssv_ch.txt";
   
	public void LuuFile(ArrayList<SinhVien> dssv) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILENAME));
			for (SinhVien sinhVien : dssv) {
				bw.write(sinhVien.toString() + "\n");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<SinhVien> DocFile() throws IOException {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		BufferedReader br=null;
		if (new File(FILENAME).exists())
		{
			br = new BufferedReader(new FileReader(FILENAME));
			while(br.ready()) {		
				String line= br.readLine();
				String []s= line.split(";");
				SinhVien sv = new SinhVien(s[0], s[1], s[2]);
				ds.add(sv);
			}
		}
		return ds;
		
		//111;nguyen;=thanh
		//222;ly;=thong
	}
}
