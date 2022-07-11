package sesion05.JTableWithCustomDataXXX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	public boolean serialObject(Object obj, String filePath) throws Exception{
		ObjectOutputStream oos = null;
		//try {
			oos = new ObjectOutputStream(new FileOutputStream(filePath));

			oos.writeObject(obj); // ghi

			oos.flush();
			oos.close();
			return true;
		/*} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//return false;
	}

	public Object deserialObject(String filePath) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				filePath));
		Object o = ois.readObject();
		ois.close();
		return o;
	}
}
