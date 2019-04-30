package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bean.banHangBean;

public class banHangDao {
	public ArrayList<banHangBean> getBanHang(){
		ArrayList<banHangBean> ds= new ArrayList<banHangBean>();
		try {
			FileReader f = new FileReader("input.txt");
			BufferedReader in= new BufferedReader(f);
			while(true) {
				String st = in.readLine();
				if(st==""||st==null) {
					break;
				}
				//Tach du lieu
				String []tam = st.split("[;]");
				ds.add(new banHangBean(tam[0], tam[1], Long.parseLong(tam[2]), tam[3]));
			}
			in.close();
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
