package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

//import db.database;
import entity.Nhanvien;
import manage.DanhsachNV;

public class thongtinnhanvien extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	JLabel lbltitle, lblManv, lblHo, lblTen, lblTuoi, lblTienluong, lblTimkiem, lblPhai;
	JButton btnTimkiem, btnThem, btnXoatrang, btnXoa, btnLuu;
	JRadioButton rbtnPhai;
	JTextField txtManv, txtHo, txtTen, txtTuoi, txtTienluong, txtTimkiem;
	DefaultTableModel defaultTableModel;
	JTable jTable;
	TableColumn gioitinh;
	JComboBox<Object> cboxPhai;
	DanhsachNV ds = new DanhsachNV();
	
	public thongtinnhanvien() {
		setTitle("ThÃ´ng tin nhÃ¢n viÃªn");
		//setFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addControll();	
		setSize(600,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new thongtinnhanvien();
	}
	
	private void addControll() {
		//title
		JPanel pNorth = new JPanel(); 
		pNorth.add(lbltitle = new JLabel("THÔNG TIN NHÂN VIÊN "));
		 
		Font fp = new Font("Times new Roman", Font.BOLD, 30); 
		lbltitle.setFont(fp); 
		pNorth.setBackground (Color.BLUE); 
		add(pNorth, BorderLayout.NORTH);
		
		//pCen: nháº­p vÃ  jList
		int height = 30;
		JPanel pCen = new JPanel();
		//dÃ²ng 1
		pCen.add(lblManv = new JLabel("Mã nhân viên:"));
		lblManv.setBounds(15, 15, 90, height);
		
		pCen.add(txtManv = new JTextField());
		txtManv.setBounds(100, 15, 400, height);
		//dÃ²ng 2
		pCen.add(lblHo = new JLabel("Họ:"));
		//y+= 35;
		lblHo.setBounds(15, 50, 30,height);
		
		pCen.add(txtHo = new JTextField());
		txtHo.setBounds(100, 50, 110, height);
		
		pCen.add(lblTen = new JLabel("Tên:"));
		lblTen.setBounds(230, 50, 50,height);
		pCen.add(txtTen = new JTextField());
		txtTen.setBounds(290, 50, 210, height);
		//dÃ²ng 3
		//y+35
		pCen.add(lblTuoi = new JLabel("Tuổi:"));
		lblTuoi.setBounds(15, 85, 30, height);
		pCen.add(txtTuoi = new JTextField());
		txtTuoi.setBounds(100, 85, 110, height);
		
		pCen.add(lblPhai = new JLabel("Nam:"));
		lblPhai.setBounds(230, 85 ,70, height );
		pCen.add(rbtnPhai= new JRadioButton("Nữ¯"));
		rbtnPhai.setBounds(280, 85, 70, height);
		
		//dÃ²ng 4
		pCen.add(lblTienluong = new JLabel("Tiền Lương :"));
		lblTienluong.setBounds(15, 120, 90, height);
		pCen.add(txtTienluong = new JTextField());
		txtTienluong.setBounds(100, 120, 110, height);
		
		//Pháº§n jtable
			// tÃªn má»¥c 
		String[] cols = {
				"MÃ NV", "HỌ", "TÊN", "PHÁI", "TUỔI", "TIỀN LƯƠNG"
		};
		
		docfile();
		
		defaultTableModel = new DefaultTableModel(cols,0);
		jTable = new JTable(defaultTableModel);
		
		//ThÃªm combobox vÃ o column
		cboxPhai = new JComboBox<Object> ( new Object[] {
				"Nam", "Nu"
		});
		
		DefaultCellEditor cellEditor =  new DefaultCellEditor(cboxPhai);
		
		jTable.getColumnModel().getColumn(3).setCellEditor(cellEditor);
		jTable.setRowHeight(20);
		JScrollPane pane = new JScrollPane(jTable);
		pCen.add(pane);
		pane.setBounds(10, 160,  550, 200);
		
		add(pCen, BorderLayout.CENTER);
		pCen.setLayout(null);
		//káº¿t thÃºc pCen

		//trÃ¡i
		JPanel pleft = new JPanel();
		pleft.add(lblTimkiem =  new JLabel("Nhâp mã nv:"));
		pleft.add(txtTimkiem =  new JTextField(8));
		pleft.add(btnTimkiem =  new JButton("Tìm"));
		
		//pháº£i
		JPanel pRight =  new JPanel();
		pRight.add(btnThem = new JButton("Thêm"));
		pRight.add(btnXoatrang = new JButton("Xóa Trắng"));
		pRight.add(btnXoa = new JButton("Xóa"));
		pRight.add(btnLuu = new JButton("Lưu"));
		
		//south
		JSplitPane psouth = new JSplitPane(SwingConstants.VERTICAL, pleft, pRight);
		add(psouth, BorderLayout.SOUTH);
		
		
		
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnTimkiem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoatrang.addActionListener(this);
		jTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row= jTable.getSelectedRow();
				txtManv.setText(defaultTableModel.getValueAt(row, 0).toString());
				txtHo.setText(defaultTableModel.getValueAt(row, 1).toString());
				txtTen.setText(defaultTableModel.getValueAt(row, 2).toString());
				txtTuoi.setText(defaultTableModel.getValueAt(row, 4).toString());
				rbtnPhai.setSelected(defaultTableModel.getValueAt(row, 3).toString() == "Nam" ? false: true);
				// so sanh cai hop combo box xem laf tru hay false, 
				txtTienluong.setText(defaultTableModel.getValueAt(row, 5).toString());
			}
		});
		
		docfile();
		capnhat();
//	    database dub=new database();
//	    try {defaultTableModel.getValueAt(row, 3).toString() == "Nu" ? true : false
//			ds = (DanhsachNV) db.DocFile("data/NhanVien.txt");
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "KhÃ´ng tÃ¬m tháº¥y.");
//		}
//	    
//	    dataTodtm();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//them
		if(src.equals(btnThem)) {
			try {
				//get dá»¯ liá»‡u
				int manv = Integer.parseInt(txtManv.getText().trim());
				String ho = txtHo.getText().trim();
				String ten= txtTen.getText().trim();
				//náº¿u phÃ¡i check lÃ  ná»¯, khÃ´ng check lÃ  nam
				String phai;
				if(rbtnPhai.isSelected()) {
					phai= "Nu";
				} else {
					phai = "Nam";
				}
					
				int tuoi = Integer.parseInt(txtTuoi.getText().trim());
				//náº¿u phÃ¡i check lÃ  ná»¯, khÃ´ng check lÃ  nam
				int tienluong = Integer.parseInt(txtTienluong.getText().trim());

				Nhanvien nvtemp = new  Nhanvien(manv, ho, ten, phai,tuoi,  tienluong);
				if(!ds.themNV(nvtemp)) {
					JOptionPane.showMessageDialog(null, "Mã nhân viên này đã có rồi nhé !");
				}else {
					defaultTableModel.addRow(new Object[] {
							nvtemp.getManv(), nvtemp.getHo(), nvtemp.getTen(), phai, nvtemp.getTuoi(), nvtemp.getTienluong()				
							});
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng ");
			}
		} 
		//xÃ³a tráº¯ng
		if( src.equals(btnXoatrang)) {
			xoatrang();
		}
		
		//xÃ³a 
		if(src.equals(btnXoa)) {
			if(jTable.getSelectedRow() != -1) {
	               // remove selected row from the model
					int index = jTable.getSelectedRow();
	               defaultTableModel.removeRow(index);
	               if(!ds.xoaNV(index))
	            	   JOptionPane.showMessageDialog(null, "Xóa không thành công ");
	               else {
	            	   JOptionPane.showMessageDialog(null, " Xóa không thành công");
	            	   xoatrang();
	               }
	            }
			else {
				JOptionPane.showMessageDialog(null, "Chọn 1 dòng để xóa");
			}
		}
		
		//tÃ¬m kiáº¿m mÃ£ nhÃ¢n viÃªn
		if(src.equals(btnTimkiem)) {
			jTable.clearSelection();
			try {
				int manv = Integer.parseInt(txtTimkiem.getText().trim());
				int index = ds.timkiem(manv);
				if( index != -1) {
					jTable.addRowSelectionInterval(index, index);
					JOptionPane.showInternalMessageDialog(null, "Đã tìm thấy mã nhân viên.");
				}
				else{
					JOptionPane.showInternalMessageDialog(null, "Không tìm thấy mã nhân viên.");
				}
			}
			catch (Exception e1) {
				JOptionPane.showInternalMessageDialog(null, "Vui lòng tìm kiếm đúng định dạng");
			}
		}
		if(src.equals(btnLuu)) {
//			database.ghiXuongFile(ds.getdsNV());
			JOptionPane.showInternalMessageDialog(null, "Thanh cong.");
		}
	}
	
	private void docfile() {
	//	 ds.Docfile();
		 for(int i = 0; i <ds.getSize(); i++) {
				Nhanvien nvtemp = ds.getElement(i);
				System.out.print(nvtemp.toString());
		 }
	}
	
	public void capnhat() {
		for(int i = 0; i <ds.getSize(); i++) {
			Nhanvien nvtemp = ds.getElement(i);
			defaultTableModel.addRow(new Object[] {
					nvtemp.getManv(), nvtemp.getHo(), nvtemp.getTen(),nvtemp.isPhai(), nvtemp.getTuoi(), nvtemp.getTienluong()				
					});
		}
	}
	
	private void xoatrang() {
		txtHo.setText("");
		txtManv.setText("");
		txtTen.setText("");
		txtTienluong.setText("");
		txtTuoi.setText("");
	}
}
