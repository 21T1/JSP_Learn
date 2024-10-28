package loaiModal;

import java.util.ArrayList;

public class LoaiBO {
	LoaiDAO loaiDAO = new LoaiDAO();
	
	public ArrayList<Loai> getLoai() {
		return loaiDAO.getLoai();
	}
}
