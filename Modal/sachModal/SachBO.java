package sachModal;

import java.util.ArrayList;

public class SachBO {
	SachDAO sachDAO = new SachDAO();
	ArrayList<Sach> ds;

	public ArrayList<Sach> getSach(int p) throws Exception {
		ds = sachDAO.getSach(p);
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
	
	public int countSach() throws Exception {
		return sachDAO.countSach();
	}
	
	public int countP() throws Exception {
		int pnum = countSach() / 9;
		if (countSach() % 9 != 0) {
			pnum += 1;
		}
		return  pnum;
	}
}
