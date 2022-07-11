package ontap2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

public class Database {

	public void writeFile(String fileName,Object o) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Loi ghi file!!!");
		}
	}
	public Object readFile(String fileName) {
		Object o = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Loi doc file!!!");
		}
		return o;
 	}
}
