package lichSuModal;

import java.util.ArrayList;

public class LichSuBO {
	LichSuDAO lichSuDAO = new LichSuDAO();
	
	public ArrayList<LichSu> getLichSu(int maKH) throws Exception {
		return lichSuDAO.getLichSu(maKH);
	}
}
