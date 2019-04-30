package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JLabel;

public class frmTimKiem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTimKiem frame = new frmTimKiem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmTimKiem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("MaHang");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(93, 103, 62, 22);
		contentPane.add(label);
		
		TextField txtMa = new TextField();
		txtMa.setBounds(161, 103, 158, 22);
		contentPane.add(txtMa);
		
		TextField txtTen = new TextField();
		txtTen.setBounds(161, 131, 158, 22);
		contentPane.add(txtTen);
		
		Label label_1 = new Label("TenHang");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(93, 131, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("GiaHang");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(93, 159, 62, 22);
		contentPane.add(label_2);
		
		TextField txtGia = new TextField();
		txtGia.setBounds(161, 159, 158, 22);
		contentPane.add(txtGia);
		
		TextField txtLoai = new TextField();
		txtLoai.setBounds(161, 187, 158, 22);
		contentPane.add(txtLoai);
		
		Label label_3 = new Label("LoaiHang");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(93, 187, 62, 22);
		contentPane.add(label_3);
		
		JLabel lblNewLabel = new JLabel("Tim Kiem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(161, 51, 73, 27);
		contentPane.add(lblNewLabel);
	}
}
