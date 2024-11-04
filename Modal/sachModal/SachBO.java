package sachModal;

import java.util.ArrayList;

public class SachBO {
	SachDAO sachDAO = new SachDAO();
	
	public ArrayList<Sach> getSach(int p) throws Exception {
		return sachDAO.getSach(p);
	}
	
	public ArrayList<Sach> timMa(String maLoai) throws Exception {
		return sachDAO.getSachTheoMa(maLoai);
	}
	
	public ArrayList<Sach> tim(String tenSach) throws Exception {
		return sachDAO.getSachTheoTen(tenSach);
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
