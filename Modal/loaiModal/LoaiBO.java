package loaiModal;

import java.util.ArrayList;

public class LoaiBO {
	LoaiDAO loaiDAO = new LoaiDAO();
	ArrayList<Loai> ds;
	
	public LoaiBO() throws Exception {
		ds = loaiDAO.getLoai();
	}
	
	public ArrayList<Loai> getLoai() throws Exception {
		return ds;
	}
	
	public int them(Loai loai) throws Exception {
		return loaiDAO.themLoai(loai);
	}
	
	public Loai getThongTinLoai(String maLoai) throws Exception {
		for (Loai loai : ds) {
			if (maLoai.trim().toLowerCase().equals(loai.getMaLoai().trim().toLowerCase())) {
				return loai;
			}
		}
		return null;
	}
	
	public int sua(Loai loai, String maLoai) throws Exception {
		return loaiDAO.suaLoai(loai, maLoai);
	}
	
	public int xoa(String maLoai) throws Exception {
		return loaiDAO.xoaLoai(maLoai);
	}
}
