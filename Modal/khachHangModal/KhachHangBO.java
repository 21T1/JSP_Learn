package khachHangModal;

public class KhachHangBO {
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	
	public KhachHang kiemTraDangNhap(String tenDN, String pass) throws Exception {
		return khachHangDAO.kiemTraDangNhap(tenDN, pass);
	}
}
