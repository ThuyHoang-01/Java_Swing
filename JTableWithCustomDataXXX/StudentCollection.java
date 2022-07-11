package sesion05.JTableWithCustomDataXXX;

import java.io.Serializable;
import java.util.*;

public class StudentCollection implements Serializable {
	private Vector<Student> collection;

	// -----------------------------------------------------------------
	// Creates an initially empty collection.
	// -----------------------------------------------------------------
	public StudentCollection() {
		collection = new Vector<Student>();
	}

	// -----------------------------------------------------------------
	// Adds a rectangle to the collection
	// 
	// -----------------------------------------------------------------
	public void addStudent(String ma, String hoten, boolean gt, String ml) {
		collection.add(new Student(ma, hoten, gt, ml));
	}

	public boolean addStudent(Student r) {
		if (collection.contains(r))
			return false;
		collection.add(r);
		return true;
	}

	public boolean removeStudent(int index) {
		if (index < 0 || index >= collection.size())
			return false;
		collection.remove(index);
		return true;
	}

	public Student getElement(int index) {
		if (index < 0 || index >= collection.size())
			return null;
		return collection.get(index);
	}

	public int getSize() {
		return collection.size();
	}
}