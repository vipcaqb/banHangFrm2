package bean;

/**
 * @author Ahihi
 *
 */
public class banHangBean {
	private String ma;
	private String ten;
	private long gia;
	private String loaiHang;
	public banHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public banHangBean(String ma, String ten, long gia, String loaiHang) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.gia = gia;
		this.loaiHang = loaiHang;
	}
	
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getLoaiHang() {
		return loaiHang;
	}
	public void setLoaiHang(String loaiHang) {
		this.loaiHang = loaiHang;
	}
	public void xuat() {
		System.out.println(ma+";"+ten+";"+gia+";"+loaiHang);
	}
}
