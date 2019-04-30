package bean;

public class nhanVien extends Nguoi{
	private String ma;
	private String tenDv;
	public void hienThi() {
		System.out.println("Nhan vien "+ ma + ":"+ tenDv);
	}
	public nhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhanVien(String hoten, int tuoi) {
		super(hoten, tuoi);
		// TODO Auto-generated constructor stub
	}
	public nhanVien(String ma, String tenDv) {
		super();
		this.ma = ma;
		this.tenDv = tenDv;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTenDv() {
		return tenDv;
	}
	public void setTenDv(String tenDv) {
		this.tenDv = tenDv;
	}
	
	
	
}
