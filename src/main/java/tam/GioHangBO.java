package tam;

import java.util.ArrayList;
import java.util.List;

public class GioHangBO {
	private List<Hang> ds = new ArrayList<Hang>() ;
	
	public List<Hang> getDs() {
		return this.ds;
	}
	
	public void them(String maSach, String tenSach, long gia, long sl) {
		for (Hang hang : ds) {
			if (hang.getMaSach().equals(maSach)) {
				hang.setSoLuong(hang.getSoLuong() + sl);
				hang.setThanhTien(hang.getSoLuong() * hang.getGia());
				return;
			}
		}
		ds.add(new Hang(maSach, tenSach, gia, sl));
	}
	
	public void capNhat(String maSach, long sl) {
		for (Hang hang : ds) {
			if (hang.getMaSach().equals(maSach)) {
				hang.setSoLuong(sl);
				return;
			}
		}
	}
	
	public void xoa(String maSach) {
		for (Hang hang : ds) {
			if (hang.getMaSach().equals(maSach)) {
				ds.remove(hang);
				return;
			}
		}
	}
	
	public long tong() {
		long s = 0;
		for (Hang hang : ds) {
			s += hang.getThanhTien();
		}
		return s;
	}
}
