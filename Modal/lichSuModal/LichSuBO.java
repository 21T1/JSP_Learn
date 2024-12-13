package lichSuModal;

import java.util.ArrayList;

public class LichSuBO {
	LichSuDAO lichSuDAO = new LichSuDAO();
	
	public ArrayList<LichSu> getChuaThanhToan() throws Exception {
		return lichSuDAO.getChuaThanhToan();
	}
	
	public ArrayList<LichSu> getLichSuTheoMaKH(int maKH) throws Exception {
		return lichSuDAO.getLichSuTheoMaKH(maKH);
	}
}
