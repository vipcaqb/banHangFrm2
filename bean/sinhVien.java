package bean;

public class sinhVien extends Nguoi {
	private String ma;
	private Double dtb;
	public void hienThi() {
		System.out.println("Sv : "+ma +":"+hoten);
	}
	public sinhVien(String ma, String hoten, int tuoi, Double dtb) {
		super(hoten, tuoi);
		this.ma = ma;
		this.dtb = dtb;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public Double getDtb() {
		return dtb;
	}
	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}
	
}
