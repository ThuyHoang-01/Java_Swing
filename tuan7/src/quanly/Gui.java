package quanly;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame{
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	ManageProduct manageProduct = new ManageProduct();
	public Gui() {
		//Frame
		this.setTitle("-.-");
		this.setSize(1200,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//Layout
		
		//North
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		JLabel labelTitle = new JLabel("THONG TIN SAN PHAM");
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b1.add(labelTitle);
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(10,20)));
		this.add(b,BorderLayout.NORTH);
		
		//Center
		String[] header = {"ProductID","Name","Manufacture","Description","SName","Country","Website","price"};
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		this.add(scroll,BorderLayout.CENTER);
		loadTable();
		
 	}
	public static void main(String[] args) {
		new Gui().setVisible(true);
	}
	
	public void loadTable() {
		ArrayList<Product> list = manageProduct.getAllProduct();
		for(Product p : list) {
			String[] row = {p.getProductID(),p.getName(),p.getManufacture(),p.getDescription(),p.getSupplier().getName(),p.getSupplier().getCountry(),p.getSupplier().getWebsite(),p.getPrice()+""};
			model.addRow(row);
		}
	}

}
