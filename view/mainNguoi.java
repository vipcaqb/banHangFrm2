package view;

import bean.Nguoi;
import bean.sinhVien;

public class mainNguoi {

	public static void main(String[] args) {
			Nguoi n1 = new Nguoi("ha",40);
			n1.hienThi();
			sinhVien sv = new sinhVien("sv1", "Hung", 19, 2.0);
			sv.hienThi();
			Nguoi n2 = new sinhVien("sv2", "Thu", 18, 3.0);
			n2.hienThi();
	}

}
