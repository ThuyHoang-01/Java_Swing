package thiThuLan1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	public boolean LuuFile(Object obj, String FilePath) throws Exception{
		ObjectOutputStream oos= null;
		oos= new ObjectOutputStream(new FileOutputStream(FilePath));
		oos.writeObject(obj);;
		oos.flush();
		oos.close();
		return true;
	}
	public Object DocFile(String FilePath) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath));
		Object o= ois.readObject();
		ois.close();
		return o;
		
	}
}
