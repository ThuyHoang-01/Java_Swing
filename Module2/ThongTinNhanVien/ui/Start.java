package week4ThongtinNV.ui;
import javax.swing.SwingUtilities;

public class Start {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				thongtinnhanvien nv = new thongtinnhanvien();
				nv.setVisible(true);
			}
		});
	}
}
