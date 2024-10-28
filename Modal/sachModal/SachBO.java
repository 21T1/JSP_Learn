package sachModal;

import java.util.ArrayList;

public class SachBO {
	SachDAO sachDAO = new SachDAO();
	ArrayList<Sach> ds;

	public ArrayList<Sach> getSach() {
		ds = sachDAO.getSach();
		return ds;
	}
	
	public ArrayList<Sach> timMa(String maLoai) {
		ArrayList<Sach> kq = new ArrayList<Sach>();
		for (Sach sach : ds) {
			if (maLoai.trim().toLowerCase().equals(sach.getMaLoai().trim().toLowerCase())) {
				kq.add(sach);
			}
		}
		return kq;
	}
	
	public ArrayList<Sach> tim(String key) {
		ArrayList<Sach> kq = new ArrayList<Sach>();
		for (Sach sach : ds) {
			if (sach.getTenSach().trim().toLowerCase().contains(key.trim().toLowerCase())||
					sach.getTacGia().trim().toLowerCase().contains(key.trim().toLowerCase())) {
				kq.add(sach);
			}
		}
		return kq;
	}
}
