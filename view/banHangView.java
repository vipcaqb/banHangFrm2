package view;

import bean.banHangBean;
import bo.banHangBo;

public class banHangView {

	public static void main(String[] args) {
		banHangBo bh = new banHangBo();
		for(banHangBean t: bh.getBanHang()) {
			t.xuat();
		}
	}

}
