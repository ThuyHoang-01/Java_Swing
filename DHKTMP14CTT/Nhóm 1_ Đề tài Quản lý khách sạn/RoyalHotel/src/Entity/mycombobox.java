package Entity;

public class mycombobox {
	public Object value;
    public Object text;

    public mycombobox(Object value, Object text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String toString() {
        return text.toString();

    }

}
