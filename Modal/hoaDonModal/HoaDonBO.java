package hoaDonModal;

import java.util.Date;

public class HoaDonBO {
	
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	
	public int them(long maKH, Date ngayMua) throws Exception {
		return hoaDonDAO.them(maKH, ngayMua);
	}
	
	public long maxHoaDon() throws Exception {
		return hoaDonDAO.maxHoaDon();
	}
}
