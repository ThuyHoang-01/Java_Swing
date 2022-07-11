import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Database {
	public void writeFile(String fileName, Object o) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erorr OutputFile!!!");
			return;
		}
	}

	public Object readFile(String fileName) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object o = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erorr InputFile!!!");
		}
		return o;
	}
}
