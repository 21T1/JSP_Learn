package hoaDonModal;

import java.util.ArrayList;
import java.util.Date;

public class HoaDonBO {
	
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	
	public int them(long maKH, Date ngayMua) throws Exception {
		return hoaDonDAO.them(maKH, ngayMua);
	}
	
	public long maxHoaDon() throws Exception {
		return hoaDonDAO.maxHoaDon();
	}

	public ArrayList<HoaDon> getChuaThanhToan() throws Exception {
		return hoaDonDAO.getChuaThanhToan();
	}
	
	public long xacNhan(long maHD) throws Exception {
		return hoaDonDAO.xacNhan(maHD);
	}
}
