package loaiModal;

import java.util.ArrayList;

public class LoaiBO {
	LoaiDAO loaiDAO = new LoaiDAO();
	
	public ArrayList<Loai> getLoai() throws Exception {
		return loaiDAO.getLoai();
	}
}
