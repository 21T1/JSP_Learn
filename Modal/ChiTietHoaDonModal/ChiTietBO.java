package ChiTietHoaDonModal;

public class ChiTietBO {

	ChiTietDAO chiTietDAO = new ChiTietDAO();
	
	public int them(String maSach, long soLuongMua, long maHoaDon) throws Exception {
		return chiTietDAO.them(maSach, soLuongMua, maHoaDon);
	}
}
