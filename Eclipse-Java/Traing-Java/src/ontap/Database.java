package ontap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Database {
	public void writeFile(String fileName, Object o) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(fileName);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(o);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showInternalMessageDialog(null, "Erorr OutputFile!!!");
		}
	}

	public Object readFile(String fileName) {
		Object o = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			objectInputStream = new ObjectInputStream(fileInputStream);
			o = objectInputStream.readObject();
			objectInputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showInternalMessageDialog(null, "Erorr InputFile!!!");
		}
		return o;
	}

}
