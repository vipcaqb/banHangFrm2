package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.OBJ_ADAPTER;

import bean.banHangBean;
import bo.banHangBo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Window;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class FrmBanHang extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBanHang frame = new FrmBanHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	DefaultTableModel dfTab;
	banHangBo bh = new banHangBo();
	void napBang(ArrayList<banHangBean> ds) {
		 dfTab = new DefaultTableModel();
		dfTab.addColumn("Ma hang");
		dfTab.addColumn("Ten hang");
		dfTab.addColumn("Gia hang");
		dfTab.addColumn("Loai hang");
		for(banHangBean t:ds) {
			Object []tam = new Object[4];
			tam[0]=t.getMa();
			tam[1]=t.getTen();
			tam[2]=t.getGia();
			tam[3]=t.getLoaiHang();
			dfTab.addRow(tam);
		}
		table.setModel(dfTab);
	}
	public FrmBanHang() {
		TextField txtMa = new TextField();
		TextField txtLoai = new TextField();
		TextField txtTen = new TextField();
		TextField txtGia = new TextField();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				napBang(bh.getBanHang());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 483);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 165, 434, 271);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Ban Hang", null, scrollPane, null);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dl = table.getSelectedRow();
				txtMa.setText(table.getValueAt(dl, 0).toString());
				txtTen.setText(table.getValueAt(dl, 1).toString());
				txtGia.setText(table.getValueAt(dl, 2).toString());
				txtLoai.setText(table.getValueAt(dl, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		Label label = new Label("MaHang");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(10, 47, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("TenHang");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(10, 75, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("GiaHang");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(10, 103, 62, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("LoaiHang");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(10, 131, 62, 22);
		contentPane.add(label_3);
		
		
		txtMa.setBounds(78, 47, 158, 22);
		contentPane.add(txtMa);
		
		
		txtTen.setBounds(78, 75, 158, 22);
		contentPane.add(txtTen);
		
		
		txtGia.setBounds(78, 103, 158, 22);
		contentPane.add(txtGia);
		
		txtLoai.setBounds(78, 131, 158, 22);
		contentPane.add(txtLoai);
		
		Button btnThem = new Button("Thêm");
		btnThem.setFont(new Font("Dialog", Font.PLAIN, 14));
		//button Them
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Object []tam = new Object[4];
					tam[0]=txtMa.getText();
					tam[1]=txtTen.getText();
					tam[2]=txtGia.getText();
					tam[3]= txtLoai.getText();
					bh.them(tam);
					((DefaultTableModel)table.getModel()).addRow(tam);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Xin hãy nhập đủ dữ liệu!");
				}
			}
		});
		btnThem.setBounds(267, 47, 70, 22);
		contentPane.add(btnThem);
		
		Button btnXoa = new Button("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int row = table.getSelectedRow();
					bh.xoa(dfTab.getValueAt(row, 0).toString());
					dfTab.removeRow(table.getSelectedRow());
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Chọn phần hàng cần xóa!");
				}
			}
		});
		btnXoa.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnXoa.setBounds(361, 47, 70, 22);
		contentPane.add(btnXoa);
		
		Button btnTimKiem = new Button("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MAhh_tim = txtMa.getText().trim();
				String kq = bh.timKiem(MAhh_tim);
				//System.out.println(kq);
				if (!kq.equalsIgnoreCase("KHONG TIM THAY")){
					String[] st = kq.split("[;]");
							txtMa.setText(st[0]);
							txtTen.setText(st[1]);
							txtGia.setText(st[2]);
							txtLoai.setText(st[3]);
					int row = table.getSelectedRow();
				}
				else JOptionPane.showMessageDialog(null, "Không tìm thấy");
			}
		});
		btnTimKiem.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnTimKiem.setBounds(267, 131, 70, 22);
		contentPane.add(btnTimKiem);
		
		Button btnLuu = new Button("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bh.luu();
				JOptionPane.showMessageDialog(null, "Đã Lưu");
			}
		});
		btnLuu.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnLuu.setBounds(309, 90, 70, 22);
		contentPane.add(btnLuu);
		
		Button btnSua = new Button("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				banHangBean hhThayThe = new banHangBean();
				hhThayThe.setMa(txtMa.getText().trim());
				hhThayThe.setTen(txtTen.getText().trim());
				hhThayThe.setGia(Long.parseLong(txtGia.getText().trim()));
				hhThayThe.setLoaiHang(txtLoai.getText().trim());
				banHangBean hhCanThay = new banHangBean();
				hhCanThay.setMa(dfTab.getValueAt(row, 0).toString());
				hhCanThay.setTen(dfTab.getValueAt(row, 1).toString());
				hhCanThay.setGia(Long.parseLong(dfTab.getValueAt(row, 2).toString()));
				hhCanThay.setLoaiHang(dfTab.getValueAt(row, 3).toString());
				bh.sua(hhCanThay, hhThayThe);
				napBang(bh.get_bo());
			}
		});
		btnSua.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnSua.setBounds(361, 131, 70, 22);
		contentPane.add(btnSua);
		
		JLabel lblNewLabel = new JLabel("Thông tin hàng hóa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(38, 11, 168, 22);
		contentPane.add(lblNewLabel);
	}
}


