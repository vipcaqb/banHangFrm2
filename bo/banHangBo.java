package bo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.banHangBean;
import dao.banHangDao;

public class banHangBo {
	banHangDao bh = new banHangDao();
	ArrayList<banHangBean> ds;
	public ArrayList<banHangBean> getBanHang(){
		ds= bh.getBanHang();
		return ds;
	}
	public ArrayList<banHangBean> get_bo(){
		return ds;
	}
	public ArrayList<banHangBean> them(Object ob[]) {
		banHangBean tam = new banHangBean();
		tam.setMa(ob[0].toString());
		tam.setTen(ob[1].toString());
		tam.setGia(Long.parseLong(ob[2].toString()));
		tam.setLoaiHang(ob[3].toString());
		ds.add(tam);
		return ds;
	}
	public void xoa(String xoaBanHang){
		//String stXoa = new String();
		for(banHangBean hh: ds)
			if(hh.getMa().equalsIgnoreCase(xoaBanHang)){
				ds.remove(hh);
				break;
			}
	}
	public void sua(banHangBean hhCanSua,banHangBean hhThayThe){
		for(int i=0; i<ds.size(); i++)
			if(hhCanSua.getMa().equalsIgnoreCase(ds.get(i).getMa())){
				ds.set(i,hhThayThe);
				break;
			}
	}
	public String timKiem(String timMa){
		for(banHangBean hh: ds)
			if(hh.getMa().equalsIgnoreCase(timMa)){
				return (hh.getMa()+";"+hh.getTen()+";"+hh.getGia()+";"+hh.getLoaiHang());
			}
		//System.out.println(timMa);
		return "khong tim thay";
	}
	public void luu(){
		try {
			FileWriter f = new FileWriter("input.txt");
			PrintWriter write = new PrintWriter(f);
			for(banHangBean hh: ds){
				String st = hh.getMa()+";"+hh.getTen()+";"+hh.getGia()+";"+hh.getLoaiHang();
				write.println(st);
			}
			f.close();
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lưu thất bại!");
		}
	}
}
