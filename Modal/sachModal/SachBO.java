package sachModal;

import java.util.ArrayList;

public class SachBO {
	SachDAO sachDAO = new SachDAO();
	ArrayList<Sach> ds;
	
	public SachBO() throws Exception {
		ds = sachDAO.getSach();
	}
	
	public ArrayList<Sach> getSach() throws Exception {
		return ds;
	}
	
	public ArrayList<Sach> getSach(int p) throws Exception {
		ArrayList<Sach> lst = sachDAO.getSach(p);
		return lst;
	}
	
	public int them(Sach sach) throws Exception {
		return sachDAO.themSach(sach);
	}
	
	public Sach getThongTinSach(String maSach) throws Exception {
		for (Sach sach : ds) {
			if (maSach.trim().toLowerCase().equals(sach.getMaSach().trim().toLowerCase())) {
				return sach;
			}
		}
		return null;
	}
	
	public int sua(Sach sach, String maSachSua) throws Exception {
		return sachDAO.suaSach(sach, maSachSua);
	}
	
	public int xoa(String maSach) throws Exception {
		return sachDAO.xoaSach(maSach);
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