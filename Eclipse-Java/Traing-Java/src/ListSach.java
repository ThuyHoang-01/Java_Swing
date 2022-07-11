import java.io.Serializable;
import java.util.ArrayList;

public class ListSach implements Serializable{
	private ArrayList<Sach> list;

	public ListSach() {
		list = new ArrayList<Sach>();
	}

	public boolean addSach(Sach x) {
		if (list.contains(x))
			return false;
		list.add(x);
		return true;
	}

	public ArrayList<Sach> getLs() {
		return list;
	}
}
