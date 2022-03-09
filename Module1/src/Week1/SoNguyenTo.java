package Week1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoNguyenTo extends JFrame implements ActionListener {

	JTextField txtNhapso ;
	JButton btnGenerate;
	JTextArea tvArray;
	
	public SoNguyenTo() {
		super("Primes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		addControlls();
		setVisible(true);
	
	}
	public void addControlls() {
		
		//pNorth
		JPanel pNor = new JPanel();
		pNor.add(txtNhapso = new JTextField(20));
		pNor.add(btnGenerate = new JButton("Generate"));
		add(pNor,BorderLayout.NORTH);
		
		//pCen
		JPanel pCen = new JPanel();
		pCen.add(tvArray = new JTextArea(12 , 30));
		add(pCen,BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 300);
		setVisible(true);
		setResizable(false);
		
		btnGenerate.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new SoNguyenTo();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object soure = e.getSource();
		
		
		
	}

}
